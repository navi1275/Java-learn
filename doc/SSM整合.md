# 整合思路

Spring容器初始化，项目中的对象交给Spring容器管理

分析有哪些对象需要被spring管理（确定是XML方式还是纯注解方式来管理，本文采用XML和注解混合的方式）

- 业务层

  - 实现类（多个）
  - 事务相关的对象
    - 事务管理器
    - 通知类
    - 切面类

- 持久层（mybatis）

  - 数据源（一个）
  - SqlSessionFactory对象（一个）
  - Mapper代理对象（多个）

# 新建web项目

# Spring容器初始化

# 整合MyBatis

