package com.navi;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.*;

/**
 * CodeGenerator Class
 *
 * @author navi
 * @date 2019-06-18
 * @since 1.0.0
 */
public class CodeGeneratorFX {


    private static final String[] CREATE_TABLES = new String[]{"hsqj_znxb","hsqj_znxb_cfg","hsqj_fb","hsqj_nsr_jcsz"};

    private static final Boolean CREATE_ENTITY = true;

    private static final Boolean CREATE_MAPPER = true;
    private static final Boolean CREATE_DAO = true;

    private static final Boolean CREATE_SERVICE = false;
    private static final Boolean CREATE_SERVICEIMPL = true;

    private static final Boolean CREATE_CONTROLLER = false;

    private static final Boolean CREATE_SVC = false;
    private static final Boolean CREATE_ISVC = false;

    //文件复写
    private static final Boolean FILE_OVERRIDE = true;

    private static final String DATABASE_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:mysql://10.10.0.103:3306/hsqj?useUnicode=true&useSSL=false&characterEncoding=utf8";
    // "jdbc:oracle:thin:@dbOs:1521:orcl";

    private static final String DATABASE_USERNAME = "root";
    private static final String DATABASE_PASSWORD = "888888";


    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        final GlobalConfig gc = new GlobalConfig();
        final String projectPath = System.getProperty("user.dir") + "/Mybatis/mybatis-plus";
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor("ganxf");
        gc.setOpen(false);
        gc.setBaseResultMap(true);
        gc.setBaseColumnList(true);
        //覆盖生成，谨慎使用
        gc.setFileOverride(false);
        // gc.setSwagger2(true); 实体属性 Swagger2 注解
        gc.setControllerName("%sCtl");
        gc.setMapperName("%sDao");
        gc.setFileOverride(FILE_OVERRIDE);
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(DATABASE_URL);
        dsc.setDriverName(DATABASE_DRIVER);
        dsc.setUsername(DATABASE_USERNAME);
        dsc.setPassword(DATABASE_PASSWORD);
        mpg.setDataSource(dsc);

        // 包配置
        final PackageConfig pc = new PackageConfig();
        pc.setModuleName("hsqj");
        pc.setParent("com.foresee.dzswj");
        // pc.setEntity("");
        // pc.setMapper("");
        // pc.setService("");
        // pc.setServiceImpl("");
        pc.setController("web");
        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<>();
                map.put("aaa", "aaaa");
                map.put("bbb", "bbb");
                setMap(map);
            }
        };

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();

        //不要生成可以屏蔽
        //mapper.xml
        if(CREATE_MAPPER) {
            focList.add(getMapperOutConfig(projectPath));
        }
        //dao.java
        if(CREATE_DAO) {
            focList.add(getDaoOutConfig(projectPath));
        }
        //vo.java
        if(CREATE_ENTITY) {
            focList.add(getEntityOutConfig(projectPath));
        }
        //iservice.java
        if(CREATE_SERVICE) {
            focList.add(getIServieOutConfig(projectPath));
        }
        //serviceimpl.java
        if(CREATE_SERVICEIMPL) {
            focList.add(getServieImplOutConfig(projectPath));
        }
        //controller.java
        if(CREATE_CONTROLLER) {
            focList.add(getControllerOutConfig(projectPath));
        }
        //isvc.java
        if(CREATE_ISVC) {
            focList.add(getISvcOutConfig(projectPath));
        }
        //svc.java
        if(CREATE_SVC) {
            focList.add(getSvcOutConfig(projectPath));
        }

        /*
        cfg.setFileCreate(new IFileCreate() {
            @Override
            public boolean isCreate(ConfigBuilder configBuilder, FileType fileType, String filePath) {
                // 判断自定义文件夹是否需要创建
                checkDir("调用默认方法创建的目录");
                return false;
            }
        });
        */
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();

        // 配置自定义输出模板
        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
        templateConfig.setMapper(null);
        templateConfig.setService(null);
        templateConfig.setController(null);
        templateConfig.setEntity(null);
        templateConfig.setXml(null);
        templateConfig.setServiceImpl(null);
        mpg.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();

        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        // strategy.setSuperEntityClass("com.baomidou.ant.common.BaseEntity");
        strategy.setEntityLombokModel(true);
        // strategy.setRestControllerStyle(true);
        // strategy.setSuperControllerClass("com.baomidou.ant.common.BaseController");
        strategy.setInclude(CREATE_TABLES);
        // strategy.setInclude(scanner("表名，多个英文逗号分割").split(","));
        // strategy.setSuperEntityColumns("id");
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix(pc.getModuleName() + "_");
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }

    private static FileOutConfig getMapperOutConfig(final String projectPath) {
        String mapperPath = "/templates/mapper.xml.ftl";
        return new FileOutConfig(mapperPath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/src/main/resources/mybatis/create/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        };
    }

    private static FileOutConfig getEntityOutConfig(final String projectPath) {
        String entityPath = "/templates/entity.java.ftl";
        return new FileOutConfig(entityPath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return projectPath + "/src/main/java/vo/" + tableInfo.getEntityName() + "Vo" + StringPool.DOT_JAVA;
            }
        };
    }

    private static FileOutConfig getDaoOutConfig(final String projectPath) {
        String mapperPath = "/templates/mapper.java.ftl";
        return new FileOutConfig(mapperPath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return projectPath + "/src/main/java/dao/" + tableInfo.getEntityName() + "Dao" + StringPool.DOT_JAVA;
            }
        };
    }

    private static FileOutConfig getIServieOutConfig(final String projectPath) {
        String mapperPath = "/templates/service.java.ftl";
        return new FileOutConfig(mapperPath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return projectPath + "/src/main/java/service/I" + tableInfo.getEntityName() + "Service" + StringPool.DOT_JAVA;
            }
        };
    }

    private static FileOutConfig getServieImplOutConfig(final String projectPath) {
        String mapperPath = "/templates/serviceImpl.java.ftl";
        return new FileOutConfig(mapperPath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return projectPath + "/src/main/java/service/impl/" + tableInfo.getEntityName() + "Service" + StringPool.DOT_JAVA;
            }
        };
    }

    private static FileOutConfig getControllerOutConfig(final String projectPath) {
        String controllerPath = "/templates/controller.java.ftl";
        return new FileOutConfig(controllerPath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return projectPath + "/src/main/java/controller/" + tableInfo.getEntityName() + "Ctl" + StringPool.DOT_JAVA;
            }
        };
    }

    private static FileOutConfig getISvcOutConfig(final String projectPath) {
        String isvcPath = "/templates/isvc.java.ftl";
        return new FileOutConfig(isvcPath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return projectPath + "/src/main/java/service/I" + tableInfo.getEntityName() + "Svc" + StringPool.DOT_JAVA;
            }
        };
    }

    private static FileOutConfig getSvcOutConfig(final String projectPath) {
        String svcPath = "/templates/svc.java.ftl";
        return new FileOutConfig(svcPath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return projectPath + "/src/main/java/service/impl/" + tableInfo.getEntityName() + "Svc" + StringPool.DOT_JAVA;
            }
        };
    }



    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }


}
