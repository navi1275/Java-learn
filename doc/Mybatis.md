# MyBatis整体介绍

## 什么是MyBatis

MyBatis 是一款优秀的**持久层**框架，它支持定制化 SQL、存储过程以及高级映射。MyBatis **避免了几乎所有的 JDBC 代码和手动设置参数以及获取结果集**。MyBatis 可以使用简单的 XML 或注解来配置和映射原生信息，将接口和 Java 的 POJOs(Plain Old Java Objects,普通的 Java对象)映射成数据库中的记录。

[MyBatis文档教程](http://www.mybatis.org/mybatis-3/zh/project-info.html)

## Mybatis架构

![mybatis-jiagou](images\mybatis-jiagou.png)

### 接口层

接口层是MyBatis提供给开发人员的一套API，主要使用SqlSession接口。通过SqlSession接口和Mapper接口，开发人员可以通知MyBatis框架调用哪一条SQL命令以及SQL命令关联参数。

SqlSession接口使用方式

```java
InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
SqlSessionFactory factory = builder.build(is);
SqlSession sqlSession = factory.openSession();

Dept d = sqlSession.selectOne("com.navi.mvc.mapper.DeptMapper.selectByNo", 111);
```

Mapper接口使用方式

```java
DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
Dept d1 = mapper.selectByNo(111);
```



### 数据处理层

数据处理层是MyBatis框架内部实现，来完成对数据库具体操作。主要负责：

1. 参数与SQL命令绑定
2. SQL命令发送方式
3. 查询结果类型转换

### 基础支撑层

支撑层用来完成MyBaits与数据库基本连接方式以及SQL命令与配置文件对应。主要负责：

1. MyBatis与数据库连接方式管理
2. MyBatis对事务管理方式
3. SQL命令与XML配置对应
4. MyBatis查询缓存管理

## MyBatis调用流程

![](F:\kkb\Java-learn\doc\images\mybatis调用流程.png)

1. SqlSession
   接收开发人员提供`Statement Id`和参数，并返回操作结果
2. Executor
   MyBatis执行器，是MyBatis 调度的核心，负责SQL语句的生成和查询缓存的维护
3. StatementHandler
   封装了`JDBC Statement`操作，负责对`JDBC statement`的操作，如设置参数、将Statement结果集转换成List集合
4. ParameterHandler
   负责对用户传递的参数转换成`JDBC Statement`所需要的参数
5. ResultSetHandler
   负责将JDBC返回的ResultSet结果集对象转换成List类型的集合
6. TypeHandler:
   负责java数据类型和jdbc数据类型之间的映射和转换
7. MappedStatement:
   维护了一条<`select`|`update`|`delete`|`insert`>节点的封装
8. SqlSource:
   负责根据用户传递的parameterObject，动态地生成SQL语句，将信息封装到BoundSql对象中，并返回BoundSql表示动态生成的SQL语句以及相应的参数信息
9. Configuration:
   MyBatis所有的配置信息都维持在Configuration对象之中

## MyBatis使用方式
基于XML配置文件，SQL命令声明在XML配置文件中

Mapper.java

```java
Dept selectByNo(Integer no);
```

Mapper.xml

```xml
<select id="selectByNo" resultType="com.navi.mvc.entity.Dept">
    select * from dept where deptno = #{no};
</select>
```



基于注解方式，SQL命令声明在注解中

Mapper.java

```java
@Select("select * from dept where deptno = #{id}")
Dept selectById(Integer no);
```

# SqlSessionFactory

## 基本介绍

每个基于 MyBatis 的应用都是以一个 SqlSessionFactory 的实例为中心的。SqlSessionFactory 的实例可以通过 SqlSessionFactoryBuilder 获得。而 SqlSessionFactoryBuilder 则可以从 XML 配置文件或一个预先定制的 Configuration 的实例构建出 SqlSessionFactory 的实例。