# Spring

> Spring是一个开放源代码的设计层面框架，他解决的是业务逻辑层和其他各层的松耦合问题，因此它将面向接口的编程思想贯穿整个系统应用。Spring是于2003年兴起的一个轻量级的Java 开发框架，由Rod Johnson创建。简单来说，Spring是一个分层的JavaSE/EE **full-stack(一站式)** 轻量级开源框架。

# 如何学习Spring

- spring理论（技术介绍）
- **spring基础**（IoC、DI、AOP）
- **spring应用**（JDBC支持、事务支持、mybatis整合）
- **spring源码**（深入理解spring应用、源码学习、设计思想学习）
- 解决spring框架中暴露的问题

# Spring介绍

- spring framework

![](https://docs.spring.io/spring/docs/4.3.21.RELEASE/spring-framework-reference/htmlsingle/images/spring-overview.png)

- spring容器其实就是IoC容器，IoC容器其实就是指的BeanFactory工厂（DefaultListableBeanFactory）。BeanFactory有的一个子接口ApplicationContext（spring应用的上下文接口）
- 了解spring容器的初始化过程
- IoC：控制反转，创建Bean对象的角色发生了反转，反转为spring容器去创建
- DI：基于IoC容器，在Bean对象的创建过程中，需要注入属性
- AOP：
  - 面向切面编程，一种编程思想。AspectJ、spring-aop、spring整合AspectJ
  - AOP的主要作用：横向抽取重复的代码，实现代码的重用（事务控制，日志监控等）、AOP是为了弥补OOP（纵向抽取）的一些不足

