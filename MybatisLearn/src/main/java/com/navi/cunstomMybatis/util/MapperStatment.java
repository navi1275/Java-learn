package com.navi.cunstomMybatis.util;

import org.dom4j.*;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * MapperStatment Class
 *
 * @author ganxf
 * @date 2018/11/12
 */
public class MapperStatment {

    private Class clazz;

    private Map sqlMap = new HashMap();
    private Map rtMap = new HashMap();

    public MapperStatment(Class clazz) {
        this.clazz = clazz;

    }

    public Map getSqlMap() {
        return sqlMap;
    }

    public Map getRtMap() {
        return rtMap;
    }

    public void init() throws DocumentException {
    //    1.获得当前要操作的dao接口的类名 DeptDao
        String name = clazz.getName();

        int size = name.lastIndexOf(".");

        name = name.substring(size + 1);
        //    2.接口DeptDao关联的mapper文件加载到内存 dom4j

        SAXReader saxReader = new SAXReader();
        InputStream is = this.getClass().getResourceAsStream("/" + name + ".xml");

        Document document = saxReader.read(is);

        //    3.找到接口中的所有方法关联的sql语句，形成映射关系
        Method[] methods = clazz.getMethods();
        for (int i = 0; i < methods.length; i++){
            Method method = methods[i];
            String methodName = method.getName();

            String xPath = "//*[@id='" + methodName + "']";

            List nodeList = document.selectNodes(xPath);

            Element element = (Element) nodeList.get(0);


            String sql = element.getStringValue();
            System.out.println("sql:  " + sql);


            String resultType = element.attributeValue("resultType");

            if(resultType != null && resultType != ""){
                rtMap.put(methodName, resultType);
            }
            sqlMap.put(methodName, sql);
        }




    }
}
