# Redis介绍

## 什么是Redis

* `Redis`是一个开源的、使用C语言编写的、可基于内存亦可持久化的、Key-Value键值对的数据库，并提供多种语言的API。
* 它是一种`NoSQL数据库`

## 什么是NoSQL

* `NoSQL`（`Not-Only SQL`，即不仅仅是SQL），泛指非关系型数据库。
* 关系型数据库，是建立在关系模型基础上的数据库。简单说，就是二维行（集合）列（关系）表格组成的数据库。
* `NoSQL`数据库是为了解决高并发、高可用、高可扩展、大数据存储的问题而产生的解决方案。
* `NoSQL`可以作为关系型数据库的良好补充，但是不能替代关系型数据库。

### NoSQL数据库分类

* **键值(Key-Value)存储数据库**
相关产品： `Tokyo Cabinet/Tyrant`、**`Redis`**、`Voldemort`、`Berkeley DB`
典型应用： 内容缓存，主要用于处理大量数据的高访问负载。
数据模型： Key-Value键值对
优势： **快速查询**
劣势： 存储的数据缺少结构化

* **列存储数据库**
相关产品：`Cassandra`, **`HBase`**, `Riak`
典型应用：分布式的文件系统
数据模型：以列簇式存储，将同一列数据存在一起
优势：查找速度快，可扩展性强，更容易进行分布式扩展
劣势：功能相对局限

* **文档型数据库**
相关产品：`CouchDB`、**`MongoDB`**
典型应用：`Web`应用（与`Key-Value`类似，`Value`是结构化的）
数据模型： Key-Value键值对,Value为结构化数据
优势：数据结构要求不严格，表结构可变，不需要预先定义表结构
劣势：缺乏统一的查询语法

* 图形(`Graph`)数据库
相关数据库：`Neo4J`、`InfoGrid`、`Infinite Graph`
典型应用：社交网络
数据模型：图结构
优势：利用图结构相关算法。
劣势：需要对整个图做计算才能得出结果，不容易做分布式的集群方案。

## Redis应用场景

* **内存数据库**（登录信息、购物车信息、用户浏览信息等）
* **缓存服务器**（商品数据、广告数据等）
* 解决分布式集群架构中的session分离问题（session共享）
* 任务队列（秒杀、抢购等）
* 支持发布订阅的消息模式
* 应用排行榜
* 网站访问统计
* 数据过期处理（精确到毫秒）



## Redis安装配置

去[Redis官网](http://redis.io/)下载

### Redis安装

1. 安装`C`语言需要的`GCC`环境

```bash
yum install -y gcc-c++   
yum install -y wget
```

2. 下载并解压缩`Redis`源码压缩包

```bash
cd /gdata
wget http://download.redis.io/releases/redis-3.2.12.tar.gz
tar -zxf redis-3.2.12.tar.gz   
```

3. 编译`Redis`源码，进入`redis-3.2.12`目录，执行编译命令

```bash
cd redis-3.2.12
make   
```

3. 安装`Redis`，需要通过`PREFIX`指定安装路径

```bash
make install PREFIX=/gdata/redis-3.2.12   
```

### Redis启动

- 启动，直接运行`bin/redis-server`

  ```
  ./redis-server
  ```

- 启动图例：

![1545818750862](/Java-Learn/doc/images/redis-start.png)           

客户端窗口关闭或`ctrl+c`，`redis-server`程序就会结束

#### 守护进程启动

- 第一步：拷贝`redis-3.2.12/redis.conf`配置文件到`Redis`安装目录的`bin`目录

  ```bash
  cp  redis.conf /gdata/redis-3.2.12/bin/ 
  ```

- 第二步：修改`redis.conf`

  ```bash
  vim redis.conf
  ```

​		

```properties
  # 将`daemonize`由`no`改为`yes`
  daemonize yes
  
  # 默认绑定的是回环地址，默认不能被其他机器访问
  # bind 127.0.0.1
  
  # 是否开启保护模式，由yes该为no
  protected-mode no  
```

- 第三步：启动服务

  ```bash
  ./redis-server redis.conf
  ```

#### 关闭方式

- 使用redis客户端命令关闭

```bash
./redis-cli shutdown
```

- 杀进程关闭

```
ps -ef | grep redis
kill pid
```



### Redis命令说明

- `redis-server` ：启动`redis`服务
- `redis-cli` ：进入`redis`命令客户端
- `redis-benchmark`： 性能测试的工具
- `redis-check-aof` ： `aof`文件进行检查的工具
- `redis-check-dump` ：  `rdb`文件进行检查的工具
- `redis-sentinel` ：  启动哨兵监控服务

## Redis命令行客户端​                                                  

- 命令格式

```bash
./redis-cli [-h 127.0.0.1 ] [-p 6379]
```

- 参数说明

```
默认主机地址是127.0.0.1，默认端口是6379
-h：redis服务器的ip地址
-p：redis实例的端口号
```

# Redis数据类型

[官方命令大全网址](http://www.redis.cn/commands.html)

Redis中定义了五种数据类型：字符串类型（String Object）、散列类型(Hash Object)、列表类型(List Object)、集合类型Set Object)、有序集合类型(Zset Object)

Redis存储数据是用Key-Value键值对的形式来存储的，其中key总是String类型，value是上述的几种

在Redis的命令语句中，命令是忽略大小写的，而key和value不忽略

## String Object（字符串类型）

- get、set、setnx、incr、incrby、decr、decrby
- incr、incrby、decr、decrby：只能够针对整数类型的数据进行使用，是原子操作，用incr生产数据库表的自增主键，非常安全和高效，一般用于分布式数据库的订单ID的生成

- set命令

  ```
  set key value [EX seconds] [PX milliseconds] [NX|XX]
  
  - EX seconds，设置指定的到期时间（单位：秒）
  - PX milliseconds，设置指定的到期时间（单位：毫秒）
  - NX，仅在键不存在，才设置键
  - XX，仅当键存在，才设置键
  
  例：set aa 22 ex 2 nx
  ```

- append、strlen、mset、mget

## Hash Object(散列类型)

提供了字段和字段值的映射。字段值只能是字符串类型，不支持散列类型、集合类型等其它类型。

- hset、hget、hdel、hmget、hmset、hincrby、hexists、hkeys、hvals、hlen、hgetall
- 用来存储对象数据，特别是对象属性经常修改的数据。key命令经常使用`名称+':'+ID`

## List Object(列表类型)







、集合类型Set Object)、有序集合类型(Zset Object)

