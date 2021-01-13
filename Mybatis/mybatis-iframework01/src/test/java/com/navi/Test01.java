package com.navi;

import cn.hutool.core.util.ReUtil;
import cn.hutool.core.util.StrUtil;
import com.navi.entity.Dept;
import com.navi.ibatis.config.Configuration;
import com.navi.ibatis.config.MappedStatement;
import com.navi.ibatis.sqlnode.*;
import com.navi.ibatis.sqlsource.*;
import com.navi.ibatis.utils.OgnlUtils;
import com.navi.ibatis.utils.SimpleTypeRegistry;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.dom4j.*;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import javax.rmi.CORBA.Stub;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import com.mysql.jdbc.ResultSetMetaData;
import java.util.*;

/**
 * Test01 Class
 *
 * @author ganxf
 * @date 2019-11-04
 */
@Slf4j
public class Test01 {
    public static final String $Reg = "(?<=(?<!\\\\)\\$\\{)(.*?)(?=(?<!\\\\)\\})";
    Configuration configuration = new Configuration();
    private boolean isDynamic;

    @Test
    public void test1() throws IOException {

        // 第一步：加载XML配置文件，包括全局配置文件和映射文件
        loadConfiguration("mybatis-config.xml");

        String statementId = "com.navi.mapper.DeptMapper" + "." + "selectOne";
        Dept dept = new Dept();
        dept.setId(1);
        // 第二步：执行JDBC代码，并返回已经映射的结果
        List<Dept> result = null;
        try {
            result = (List<Dept>) queryByJDBC(configuration, statementId, dept);
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
        System.out.println(result);
    }

    private Object queryByJDBC(Configuration configuration, String statementId, Object param) throws Exception {
        Object result = null;
        Map<String, MappedStatement> mappedStatementMap = configuration.getMappedStatementMap();
        MappedStatement mappedStatement = mappedStatementMap.get(statementId);
        if(mappedStatement == null){
            log.error("不存在{}方法", statementId);
            return null;
        }
        SqlSource sqlSource = mappedStatement.getSqlSource();
        Boundsql boundSql = sqlSource.getBoundSql(param);
        String sql = boundSql.getSql();
        DataSource dataSource = configuration.getDataSource();
        Connection connection = dataSource.getConnection();
        String statementType = StrUtil.isBlank(mappedStatement.getStatementType())?"prepare":mappedStatement.getStatementType();
        if(StrUtil.equals("prepare", statementType)) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            Class paramClassType = mappedStatement.getParamClassType();
            if(SimpleTypeRegistry.isSimpleType(paramClassType)){
                preparedStatement.setObject(1, param);
            }else if(paramClassType == Map.class){

            }else{
                List<ParameterMapping> list = boundSql.getParameterMappings();
                for (int i = 0; i < list.size(); i++) {
                    ParameterMapping parameterMapping = list.get(i);
                    String filedName = parameterMapping.getName();
                    Field field = paramClassType.getDeclaredField(filedName);
                    field.setAccessible(true);
                    Object filedValue = field.get(param);
                    preparedStatement.setObject(i+1, filedValue);
                }
            }
            ResultSet resultSet = preparedStatement.executeQuery();
            Class resultClassType = mappedStatement.getResultClassType();
            ResultSetMetaData metaData = (ResultSetMetaData) resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            List list = new ArrayList();
            while (resultSet.next()){
                Object obj = resultClassType.newInstance();
                for (int i = 0; i < columnCount; i++) {
                    Object value = resultSet.getObject(i + 1);
                    String columnName = metaData.getColumnLabel(i + 1);
                    Field field = resultClassType.getDeclaredField(columnName);
                    field.setAccessible(true);
                    field.set(obj, value);
                }
                list.add(obj);
            }
            result = list;
        }

        return result;
    }

    private void loadConfiguration(String config) throws IOException {
        if (StrUtil.isBlank(config)) {
            return;
        }
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(config);
        SAXReader saxReader = new SAXReader();
        Document document = null;
        try {
            document = saxReader.read(inputStream);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        if (document == null) {
            log.error("加载mybatis配置文件异常");
            return;
        }
        InputStream inputStream2 = this.getClass().getClassLoader().getResourceAsStream("db.properties");
        Properties properties = new Properties();
        properties.load(inputStream2);

        Element rootElement = document.getRootElement();
        Element environments = rootElement.element("environments");
        Element mappers = rootElement.element("mappers");
        // 解析environments标签，获取数据库连接信息，
        pasreEnvironmentsElement(environments, properties);
        // 解析mappers标签，获取Mapper，
        pasreMappersElement(mappers);

    }

    private void pasreMappersElement(Element mappers) {
        List<Element> elements = mappers.elements();
        //遍历mapper数组
        for (Element element : elements) {
            //获取resource文件
            String resource = element.attributeValue("resource");
            Document document = readMapper(resource);
            if(document != null){
                pasreMapper(document);
            }
        }

    }

    private void pasreMapper(Document document) {
        Element rootElement = document.getRootElement();
        //拿到namespace值，statementId=namespace+"."+id
        String namespace = rootElement.attributeValue("namespace");

        List<Element> eSelectList = rootElement.elements("select");
        for (Element eSelect : eSelectList){
            MappedStatement mappedStatement = new MappedStatement();
            String id = eSelect.attributeValue("id");
            String statementId = namespace + "." + id;
            mappedStatement.setStatementId(statementId);
            String resultType = eSelect.attributeValue("resultType");
            try {
                Class<?> resultTypeClass = Class.forName(resultType);
                mappedStatement.setResultClassType(resultTypeClass);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            String paramType = eSelect.attributeValue("parameterType");
            try {
                Class<?> paramTypeClass = Class.forName(paramType);
                mappedStatement.setParamClassType(paramTypeClass);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            //创建sqlSource
            mappedStatement.setSqlSource(createSqlSource(eSelect));

            configuration.addMappedStatement(mappedStatement);
        }
    }

    private SqlSource createSqlSource(Element eSelect) {
        //解析脚本节点
        return parseScriptNode(eSelect);
    }

    private SqlSource parseScriptNode(Element eSelect) {
        // 解析动态标签，获取mixsqlNode
        MixSqlNode mixSqlNode = parseDynamicTags(eSelect);

        SqlSource sqlSource;
        if(isDynamic){
            sqlSource = new DynamicSqlSource(mixSqlNode);
        }else{
            sqlSource = new RawSqlSource(mixSqlNode);
        }

        return sqlSource;
    }

    private MixSqlNode parseDynamicTags(Element eSelect) {
        int count = eSelect.nodeCount();
        List<SqlNode> list = new ArrayList();
        for (int i = 0; i < count; i++) {
            Node node = eSelect.node(i);
            // 如果节点是文本
            if(node instanceof Text){
                String text = node.getText().trim();
                if(StrUtil.isBlank(text)){
                    continue;
                }
                //构建textsqlNode
                TextSqlNode sqlNode = new TextSqlNode(text);
                //判断是否动态
                if(sqlNode.isDynamic()){
                    isDynamic = true;
                    list.add(sqlNode);
                }else{
                    // 构建statictextsqlnode
                    StaticTextSqlNode staticTextSqlNode = new StaticTextSqlNode(text);
                    list.add(staticTextSqlNode);
                }
            //如果是element
            }else if(node instanceof Element){
                Element childrenElement = (Element) node;
                String name = childrenElement.getName();
                //判断是什么标签，if、where、forearch、and...
                if(StrUtil.equals("if", name)) {
                    // 获取test属性
                    String test = childrenElement.attributeValue("test");

                    MixSqlNode mixSqlNode = parseDynamicTags(childrenElement);
                    IfSqlNode ifSqlNode = new IfSqlNode(test, mixSqlNode);
                    list.add(ifSqlNode);
                }
                isDynamic = true;
            }
        }
        MixSqlNode mixSqlNode = new MixSqlNode(list);
        return mixSqlNode;
    }

    private Document readMapper(String resource) {
        Document document = null;
        if (StrUtil.isNotBlank(resource)) {
            InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(resource);
            SAXReader saxReader = new SAXReader();

            try {
                document = saxReader.read(inputStream);
            } catch (DocumentException e) {
                e.printStackTrace();
            }
        }
        return document;

    }



    private void pasreEnvironmentsElement(Element environments, Properties properties) {
        String defaultEnvironment = environments.attributeValue("default");
        List<Element> environment = environments.elements("environment");

        for (Element element : environment) {
            String environmentId = element.attributeValue("id");
            if (defaultEnvironment.equals(environmentId)) {
                Element eDataSource = element.element("dataSource");
                List<Element> property = eDataSource.elements("property");
                // TODO 使用配置的数据库连接池

                Map<String, String> map = new HashMap<>();
                Properties properties1 = new Properties();
                for (Element eProperty : property) {
                    String name = eProperty.attributeValue("name");
                    String value = eProperty.attributeValue("value");
                    String s = ReUtil.get($Reg, value, 0);
                    properties1.put(name, properties.get(s));
                }
                HikariConfig config = new HikariConfig(properties1);

                HikariDataSource hikariDataSource = new HikariDataSource(config);

                configuration.setDataSource(hikariDataSource);
                return;
            }
        }
    }

    @Test
    public void test() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        List<Dept> list = new ArrayList<>();

        try {
            InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("db.properties");
            Properties properties = new Properties();
            properties.load(inputStream);
            // 加载驱动
            Class.forName(properties.getProperty("jdbc.driver"));

            // 创建链接
            connection = DriverManager.getConnection(properties.getProperty("jdbc.url"), properties.getProperty("jdbc.username"), properties.getProperty("jdbc.password"));

            // simple statement
            // Statement statement = connection.createStatement();
            // boolean b = statement.execute("select * from dept");
            // resultSet = statement.getResultSet();

            // prepared statement
            // 获取预编译statement
            preparedStatement = connection.prepareStatement(properties.getProperty("db.sql1"));
            // 设置参数
            preparedStatement.setInt(1, 1);
            // 执行sql
            resultSet = preparedStatement.executeQuery();


            while (resultSet.next()) {
                Dept dept = new Dept();
                int anInt = resultSet.getInt(1);
                dept.setId(anInt);
                int anInt1 = resultSet.getInt(2);
                dept.setDeptNo(anInt1);
                String string = resultSet.getString(3);
                dept.setDeptName(string);
                String string1 = resultSet.getString(4);
                dept.setLocation(string1);

                list.add(dept);

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                    preparedStatement.close();
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();

                }
            }
        }

        for (Dept dept : list) {
            System.out.println(dept);
        }

    }
}
