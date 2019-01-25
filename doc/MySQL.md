# MySQL介绍篇

## 数据库概述

### 什么是数据库

数据库就是[存储数据的仓库]，其本质是一个[文件系统]，数据按照特定的格式将数据存储起来，用户可以通过SQL对数据库中的数据进行增加，修改，删除及查询操作。

### 什么是关系型数据库

数据库中的[记录是有行有列的数据库]就是关系型数据库，与之相反的就是NoSQL数据库了。

### 数据库和表

数据库管理系统（DataBase Management System，DBMS）：指一种[操作和管理数据库的大型软件，用于建立、使用和维护数据库，对数据库进行统一管理和控制，以保证数据库的安全性和完性。用户通过数据库管理系统访问数据库中表内的数据。(记录)

### 常见的数据库管理系统

\- MYSQL：开源免费的数据库，小型的数据库.已经被Oracle收购了。MySQL5.5版本之后都是由Oracle发布的版本。

\- Oracle：收费的大型数据库，Oracle公司的产品。Oracle收购SUN公司，收购MYSQL。

\- DB2：IBM公司的数据库产品,收费的。常应用在银行系统中。在中国的互联网公司，要求去IOE（IBM小型机、Oracle数据库、EMC存储设备）

\- SQLServer：MicroSoft公司收费的中型的数据库。C#、.net等语言常使用。

\- SyBase：已经淡出历史舞台。提供了一个非常专业数据建模的工具PowerDesigner。

\- SQLite : 嵌入式的小型数据库，应用在手机端。

我们要学习的数据库： MySQL

## MySQL介绍

### MySQL是什么

MySQL 是最流行的【关系型数据库管理系统】，在WEB应用方面MySQL是最好的RDBMS应用软件之一。

### MySQL发展历程

\- MySQL的历史可以追溯到1979年，一个名为Monty Widenius的程序员在为TcX的小公司打工，并且用BASIC设计了一个报表工具，使其可以在4MHz主频和16KB内存的计算机上运行。当时，这只是一个很底层的且仅面向报表的存储引擎，名叫Unireg。

\- 1990年，TcX公司的客户中开始有人要求为他的API提供SQL支持。Monty直接借助于mSQL的代码，将它集成到自己的存储引擎中。令人失望的是，效果并不太令人满意，决心自己重写一个SQL支持。

\- 1996年，MySQL 1.0发布，它只面向一小拨人，相当于内部发布。

\- 到了1996年10月，MySQL 3.11.1发布(MySQL没有2.x版本)，最开始只提供Solaris下的二进制版本。一个月后，Linux版本出现了。在接下来的两年里，MySQL被依次移植到各个平台。

\- 【1999～2000年】，【MySQL AB】公司在瑞典成立。Monty雇了几个人与Sleepycat合作，开发出了【Berkeley DB引擎】, 由于BDB支持事务处理，因此MySQL从此开始支持事务处理了。

\- 2000，MySQL不仅公布自己的源代码，并采用GPL(GNU General Public License)许可协议，正式进入开源世界。同年4月，MySQL对旧的存储引擎ISAM进行了整理，将其命名为MyISAM。

\- 2001年，集成Heikki Tuuri的存储引擎【InnoDB】，这个引擎不仅能【支持事务处理，并且支持行级锁】。后来该引擎被证明是最为成功的MySQL事务存储引擎。【MySQL与InnoDB的正式结合版本是4.0】

\- 2003年12月，【MySQL5.0】版本发布，提供了视图、存储过程等功能。

\- 【2008年1月】，【MySQL AB公司被Sun公司以10亿美金收购】，MySQL数据库进入Sun时代。在Sun时代，Sun公司对其进行了大量的推广、优化、Bug修复等工作。

\- 2008年11月，MySQL 5.1发布，它提供了分区、事件管理，以及基于行的复制和基于磁盘的NDB集群系统，同时修复了大量的Bug。

\- 【2009年4月】，Oracle公司以74亿美元收购Sun公司，自此MySQL数据库进入Oracle时代，而其第三方的存储引擎InnoDB早在2005年就被Oracle公司收购。

\- 2010年12月，【MySQL5.5发布】，其主要新特性包括半同步的复制及对SIGNAL/RESIGNAL的异常处理功能的支持，【最重要的是InnoDB存储引擎终于变为当前MySQL的默认存储引擎】。MySQL 5.5不是时隔两年后的一次简单的版本更新，而是加强了MySQL各个方面在企业级的特性。Oracle公司同时也承诺MySQL5.5和未来版本仍是采用GPL授权的开源产品。

## SQL介绍

### 什么是SQL

【SQL是Structured QueryLanguage的缩写】，它的前身是著名的关系数据库原型系统System R所采用的SEQUEL语言。作为一种访问【关系型数据库的标准语言】，SQL自问世以来得到了广泛的应用，不仅是著名的大型商用数据库产品Oracle、DB2、Sybase、SQL Server支持它，很多开源的数据库产品如PostgreSQL、MySQL也支持它，甚至一些小型的产品如Access也支持SQL。近些年蓬勃发展的NoSQL系统最初是宣称不再需要SQL的，后来也不得不修正为Not Only SQL，来拥抱SQL。

蓝色巨人IBM对关系数据库以及SQL语言的形成和规范化产生了重大的影响，第一个版本的SQL标准SQL86就是基于System R的手册而来的。Oracle在1979年率先推出了支持SQL的商用产品。随着数据库技术和应用的发展，为不同RDBMS提供一致的语言成了一种现实需要。

对SQL标准影响最大的机构自然是那些著名的数据库产商，而具体的制订者则是一些非营利机构，例如【国际标准化组织ISO、美国国家标准委员会ANSI】等。各国通常会按照ISO标准和ANSI标准（这两个机构的很多标准是差不多等同的）制定自己的国家标准。中国是ISO标准委员会的成员国，也经常翻译一些国际标准对应的中文版。标准为了避免采用具体产品的术语，往往会抽象出很多名词，从而增加了阅读和理解的难度，翻译成中文之后更容易词不达意。对于数据库系统实现者和用户而言，很多时候还不如直接读英文版本为好。虽然正式的标准不像RFC那样可以从网络上免费获得，标准草案还是比较容易找到的（例如：http://www.jtc1sc32.org/doc/）。待批准的标准草案和最终的标准也没有什么实质上的区别，能够满足日常工作的需要。

下面是SQL发展的简要历史：
1986年，ANSI X3.135-1986，ISO/IEC 9075:1986，SQL-86
1989年，ANSI X3.135-1989，ISO/IEC 9075:1989，SQL-89
1992年，ANSI X3.135-1992，ISO/IEC 9075:1992，SQL-92（SQL2）
1999年，ISO/IEC 9075:1999，SQL:1999（SQL3）
2003年，ISO/IEC 9075:2003，SQL:2003
2008年，ISO/IEC 9075:2008，SQL:2008
2011年，ISO/IEC 9075:2011，SQL:2011

如果要了解标准的内容，比较推荐的方法是【泛读SQL92】（因为它涉及了SQL最基础和最核心的一些内容），然后增量式的阅读其他标准。

不只是mysql还有其他数据库，在SQL92或者SQL99这些国际SQL标准基础之上，它们还扩展了自己的一些SQL语句，比如MySQL中的limit关键字


### SQL语言分类


\- 数据定义语言：简称【DDL】(Data Definition Language)，用来定义数据库对象：数据库，表，列等。关键字：create，alter，drop等

\- 数据操作语言：简称【DML】(Data Manipulation Language)，用来对数据库中表的记录进行更新。关键字：insert，delete，update等

\- 数据控制语言：简称【DCL】(Data Control Language)，用来定义数据库的访问权限和安全级别，及创建用户；关键字：grant等

\- 数据查询语言：简称【DQL】(Data Query Language)，用来查询数据库中表的记录。关键字：select，from，where等


# MySQL基础篇

## MySQL单机安装

操作系统：CentOS 7
MySQL：5.6

### MySQL的卸载

#### 查看MySQL是否安装

```
	rpm -qa|grep mysql
```

#### 卸载MySQL

```
yum remove -y mysql mysql-libs mysql-common
rm -rf /var/lib/mysql
rm /etc/my.cnf
```

查看是否还有MySQL软件，有的话继续删除。
软件卸载完毕后如果需要可以删除MySQL的数据库：/var/lib/mysql

### 安装MySQL

```
wget http://dev.mysql.com/get/mysql-community-release-el6-5.noarch.rpm
rpm -ivh mysql-community-release-el6-5.noarch.rpm
yum install -y mysql-community-server
```

### 配置MySQL

```
vim /etc/my.cnf
```

修改内容如下：

```
[mysqld]
\# MySQL设置大小写不敏感：默认：区分表名的大小写，不区分列名的大小写
\# 0：大小写敏感 1：大小写不敏感
lower_case_table_names=1
```

`/etc/my.cnf`是默认的配置文件，查看MySQL配置文件命令

```
# mysql --help | grep 'my.cnf'
                      order of preference, my.cnf, $MYSQL_TCP_PORT,
/etc/my.cnf /etc/mysql/my.cnf /usr/etc/my.cnf ~/.my.cnf 
```

### 启动MySQL

```
systemctl start mysqld
```

### 设置root用户密码

例如：为root账号设置密码为123456：

```
/usr/bin/mysqladmin -u root password 'root'
```

### 登录MySQL

 - 登录命令

 ```
 mysql -uroot -p123456
 ```

 - 命令说明：

 ```
-u：指定数据库用户名
-p：指定数据库密码
-h：mysql连接IP，默认127.0.0.1
-P：mysql连接端口，默认3306
```


### MySQL远程连接授权

 - 授权命令

 ```
 grant 权限 on 数据库对象 to 用户
 ```

 - 示例
 授予root用户对所有数据库对象的全部操作权限：

 ```
 mysql>GRANT ALL PRIVILEGES ON *.* TO 'root'@'%' IDENTIFIED BY 'root' WITH GRANT OPTION;
 ```

 - 命令说明：

	- ALL PRIVILEGES :表示授予所有的权限，此处可以指定具体的授权权限。

	- *.* :表示所有库中的所有表

	- 'root'@'%' ：myuser是数据库的用户名，%表示是任意ip地址，可以指定具体ip地址。
	- IDENTIFIED BY 'mypassword'：mypassword是数据库的密码。

#### 关闭linux的防火墙

```
systemctl stop firewalld（centos7默认firewall,以前版本是iptables）
systemctl disable firewalld.service（设置开启不启动）
```

## DDL语句

### 数据库操作：database

#### 创建数据库

```
create database 数据库名;
create database 数据库名 character set 字符集;
```
#### 查看数据库

查看数据库服务器中的所有的数据库:

```
show databases;
```
查看某个数据库的定义的信息:

```
show create database 数据库名;
```

#### 删除数据库（慎用）

```
drop database 数据库名称;
```

#### 其他数据库操作命令

切换数据库：

```
use 数据库名;
```
查看正在使用的数据库:

```
select database();
```

### 表操作：table

#### 字段类型

常用的类型有：

```
数字型：int
浮点型：double
字符型：varchar（可变长字符串）
日期类型：date（只有年月日，没有时分秒）
		 datetime（年月日，时分秒）

boolean类型：不支持，一般使用tinyint替代（值为0和1）
```

#### 创建表

```
create table 表名(
	字段名 类型(长度) 约束,
	字段名 类型(长度) 约束
);
```

单表约束：

\- 主键约束：primary key
\- 唯一约束：unique
\- 非空约束：not null
主键约束 = 唯一约束 + 非空约束

#### 查看表

查看数据库中的所有表：

```
show tables;
```

查看表结构：

```
desc 表名;
```

#### 删除表

```
drop 表名;
```

#### 修改表

| alter table 表名 add 列名 类型(长度) 约束;             | --修改表添加列.                 |
| ------------------------------------------------------ | ------------------------------- |
| alter table 表名 modify 列名 类型(长度) 约束;          | --修改表修改列的类型长度及约束. |
| alter table 表名 change 旧列名 新列名 类型(长度) 约束; | --修改表修改列名.               |
| alter table 表名 drop 列名;                            | --修改表删除列.                 |
| rename table 表名 to 新表名;                           | --修改表名                      |
| alter table 表名 character set 字符集;                 | --修改表的字符集  

### DML语句

#### 插入记录：insert

- 语法：

```
insert into 表 (列名1,列名2,列名3..) values (值1,值2,值3..);      \-- 向表中插入某些列
insert into 表 values (值1,值2,值3..); \--向表中插入所有列
insert into 表 (列名1,列名2,列名3..) values select (列名1,列名2,列名3..) from 表 insert into 表 values select \* from 表
```

- 注意：

1. 列名数与values后面的值的个数相等
2. 列的顺序与插入的值得顺序一致
3. 列名的类型与插入的值要一致.
4. 插入值得时候不能超过最大长度.
5. 值如果是字符串或者日期需要加引号’’ （一般是单引号）

- 例如：

```
INSERT INTO sort(sid,sname) VALUES('s001', '电器');
INSERT INTO sort(sid,sname) VALUES('s002', '服饰');
INSERT INTO sort VALUES('s003', '化妆品');
INSERT INTO sort VALUES('s004','书籍');
```

#### 更新记录：update

语法：

```
update 表名 set 字段名=值,字段名=值;
update 表名 set 字段名=值,字段名=值 where 条件;
```
注意：
\1. 列名的类型与修改的值要一致.
\2. 修改值得时候不能超过最大长度.
\3. 值如果是字符串或者日期需要加’’.

#### 删除记录：delete

语法：

```
delete from 表名 [where 条件];
```
面试题：

```
删除表中所有记录使用【delete from 表名】，还是用【truncate table 表名】？

删除方式：
\- delete ：一条一条删除，不清空auto_increment记录数。
\- truncate ：直接将表删除，重新建表，auto_increment将置为零，从新开始。
```

### DQL语句

#### 准备工作

创建商品表：

```
CREATE TABLE products (
	pid INT PRIMARY KEY AUTO_INCREMENT, \# 自增加 AUTO_INCREMENT
	pname VARCHAR(20),\#商品名称
	price DOUBLE, \#商品价格
	pdate DATE, \# 日期
	sid VARCHAR(20) \#分类ID
);

INSERT INTO products VALUES(NULL,'泰国大榴莲', 98, NULL, 's001');
INSERT INTO products VALUES(NULL,'新疆大枣', 38, NULL, 's002');
INSERT INTO products VALUES(NULL,'新疆切糕', 68, NULL, 's001');
INSERT INTO products VALUES(NULL,'十三香', 10, NULL, 's002');
INSERT INTO products VALUES(NULL,'老干妈', 20, NULL, 's002');
```

#### DQL语法顺序

完整DQL语法顺序：

```
SELECT DISTINCT
	< select_list >
FROM
	< left_table > < join_type >
JOIN < right_table > ON < join_condition >
WHERE
	< where_condition >
GROUP BY
	< group_by_list >
HAVING
	< having_condition >
ORDER BY
	< order_by_condition >
LIMIT 
	< limit_number >
```

##### 简单查询

SQL语法关键字：

```
SELECT
FROM
```

案例：

\1. 查询所有的商品.
```
select * from product;
```
\1. 查询商品名和商品价格.
```
select pname,price from product;
```
\1. 别名查询，使用的as关键字，as可以省略的.
表别名:
```
select * from product as p;
```


列别名：
```
select pname as pn from product;
```
\1. 去掉重复值.
```
select distinct price from product;
```
\1. 查询结果是表达式（运算查询）：将所有商品的价格+10元进行显示.
```
select pname,price+10 from product;
```

##### 条件查询

SQL语法关键字：
```
WHERE
```

案例：

\1. 查询商品名称为十三香的商品所有信息：
```
select * from product where pname = '十三香';
```
\1. 查询商品价格>60元的所有的商品信息:
```
select * from product where price > 60;
```

where后的条件写法：
```
\> ,<,=,>=,<=,<>
like 使用占位符 _ 和 % _代表一个字符 %代表任意个字符.
select * from product where pname like '%新%';
in在某个范围中获得值（exists）.
select * from product where pid in (2,5,8);
```


##### 排序

SQL语法关键字：
```
ORDER BY
ASC（升序） DESC（降序）
```
案例：

\1. 查询所有的商品，按价格进行排序.(asc-升序,desc-降序)
```
select * from product order by price;
```
\1. 查询名称有新的商品的信息并且按价格降序排序.
```
select * from product where pname like '%新%' order by price desc;
```

##### 聚合函数（组函数）


特点：只对单列进行操作
常用的聚合函数：
```
sum()：求某一列的和
avg()：求某一列的平均值
max()：求某一列的最大值
min()：求某一列的最小值
count()：求某一列的元素个数
```
案例：

\1. 获得所有商品的价格的总和：
```
select sum(price) from product;
```
\1. 获得所有商品的平均价格：
```
select avg(price) from product;
```
\1. 获得所有商品的个数：
```
select count(*) from product;
```

##### 分组

SQL语法关键字：
```
GROUP BY
HAVING
```
案例：

\1. 根据cno字段分组，分组后统计商品的个数.
```
select cid,count(*) from product group by cid;
```
\1. 根据cno分组，分组统计每组商品的平均价格，并且平均价格> 60;
```
select cid,avg(price) from product group by cid having avg(price)>60;
```
注意事项：

```
\1. select语句中的列（非聚合函数列），必须出现在group by子句中
\1. group by子句中的列，不一定要出现在select语句中
\1. 聚合函数只能出现select语句中或者having语句中，一定不能出现在where语句中。
```


#### 分页查询

关键字：
```
lIMIT [offset,] rows
```

lIMIT 关键字不是 SQL92 标准提出的关键字，它是 MySQL 独有的语法。通过 limit 关键字， MySQL 实现了物理分页。

分页分为逻辑分页和物理分页：
```
逻辑分页：将数据库中的数据查询到内存之后再进行分页。
物理分页：通过LIMIT关键字，直接在数据库中进行分页，最终返回的数据，只是分页后的数据。
```

格式：
```
SELECT * FROM table LIMIT [offset,] rows
```

offset ：编译量
rows ：每页多少行记录。

案例

```
分页查询商品表，每页3条记录，查第一页
```

#### 子查询

定义
```
子查询允许把一个查询嵌套在另一个查询当中。
子查询，又叫内部查询，相对于内部查询，包含内部查询的就称为外部查询。
子查询可以包含普通select可以包括的任何子句，比如：distinct、 group by、order by、limit、join和union等；
但是对应的外部查询必须是以下语句之一：select、insert、update、delete。
```

位置
```
select中、from 后、where 中.
group by 和order by 中无实用意义。
```
举例
```
查询“化妆品”分类下的商品信息
```

#### 其他查询语句

union 集合的并集（不包含重复记录）

unionall 集合的并集（包含重复记录）

### SQL解析顺序

接下来再走一步，让我们看看一条SQL语句的前世今生。
首先看一下示例语句：
```
SELECT DISTINCT
	< select_list >
FROM
	< left_table > < join_type >
JOIN < right_table > ON < join_condition >
WHERE
	< where_condition >
GROUP BY
	< group_by_list >
HAVING
	< having_condition >
ORDER BY
	< order_by_condition >
LIMIT < limit_number >
```

然而它的执行顺序是这样的：
```
FROM <left_table>
ON <join_condition>
<join_type> JOIN <right_table> 第二步和第三步会循环执行
WHERE <where_condition> 第四步会循环执行，多个条件的执行顺序是从左往右的。
GROUP BY <group_by_list>
HAVING <having_condition> 
SELECT 分组之后才会执行
DISTINCT <select_list>
ORDER BY <order_by_condition>
LIMIT <limit_number> 前9步都是SQL92标准语法。limit是MySQL的独有语法。
```


虽然自己没想到是这样的，不过一看还是很自然和谐的，从哪里获取，不断的过滤条件，要选择一样或不一样的，排好序，那才知道要取前几条呢。

既然如此了，那就让我们一步步来看看其中的细节吧。

#### 准备工作

1、创建测试数据库
```
create database testQuery
```

2、创建测试表
```
CREATE TABLE table1(
	uid VARCHAR(10) NOT NULL,
	name VARCHAR(10) NOT NULL,
	PRIMARY KEY(uid)
	)ENGINE=INNODB DEFAULT CHARSET=UTF8;

CREATE TABLE table2(
	oid INT NOT NULL auto_increment,
	uid VARCHAR(10),
	PRIMARY KEY(oid)
	)ENGINE=INNODB DEFAULT CHARSET=UTF8;
```

3、插入数据
```
INSERT INTO table1(uid,name) VALUES('aaa','mike'),('bbb','jack'),('ccc','mike'),('ddd','mike');
INSERT INTO table2(uid) VALUES('aaa'),('aaa'),('bbb'),('bbb'),('bbb'),('ccc'),(NULL);

```
4、最后需要的结果
```
SELECT
	a.uid,count(b.oid) AS total
FROM
	table1 AS a
LEFT JOIN table2 AS b ON a.uid = b.uid
WHERE
	a. NAME = 'mike'
GROUP BY
	a.uid
HAVING
	count(b.oid) < 2
ORDER BY
	total 
DESC
LIMIT 1;
```
现在开始SQL解析之旅吧！

#### 1.FROM

对FROM的左边的表和右边的表计算 笛卡尔积(CROSS JOIN) 。产生 虚表VT1


mysql> select \* from table1,table2;
+-----+------+-----+------+
| uid | name | oid | uid |
+-----+------+-----+------+
| aaa | mike |   1  | aaa |
| bbb | jack |   1  | aaa |
| ccc | mike |   1  | aaa |
| ddd | mike |   1  | aaa |
| aaa | mike |   2  | aaa |
| bbb | jack |   2  | aaa |
| ccc | mike |   2  | aaa |
| ddd | mike |   2  | aaa |
| aaa | mike |   3  | bbb |
| bbb | jack |   3  | bbb |
| ccc | mike |   3  | bbb |
| ddd | mike |   3  | bbb |
| aaa | mike |   4  | bbb |
| bbb | jack |   4  | bbb |
| ccc | mike |   4  | bbb |
| ddd | mike |   4  | bbb |
| aaa | mike |   5  | bbb |
| bbb | jack |   5  | bbb |
| ccc | mike |   5  | bbb |
| ddd | mike |   5  | bbb |
| aaa | mike |   6  | ccc |
| bbb | jack |   6  | ccc |
| ccc | mike |   6  | ccc |
| ddd | mike |   6  | ccc |
| aaa | mike |   7  | NULL|
| bbb | jack |   7  | NULL|
| ccc | mike |   7  | NULL|
| ddd | mike |   7  | NULL|
+-----+------+-----+------+
rows in set (0.00 sec)

#### 2.ON过滤

对 虚表VT1 进行ON筛选，只有那些符合的行才会被记录在虚表VT2中。

注意：这里因为语法限制，使用了'WHERE'代替，从中读者也可以感受到两者之间微妙的关系；
```
mysql> SELECT * FROM table1,table2 WHERE table1.uid = table2.uid;
+-----+------+-----+------+
| uid | name | oid | uid |
+-----+------+-----+------+
| aaa | mike | 1   | aaa |
| aaa | mike | 2   | aaa |
| bbb | jack | 3   | bbb |
| bbb | jack | 4   | bbb |
| bbb | jack | 5   | bbb |
| ccc | mike | 6   | ccc |
+-----+------+-----+------+
rows in set (0.00 sec)
```

#### 3.OUTER JOIN添加外部列

如果指定了 OUTER JOIN（比如left join、 right join） ，那么 保留表中未匹配的行 就会作为外部行 添加 到 虚拟表VT2 中，产生 虚拟表VT3 。

如果FROM子句中包含两个以上的表的话，那么就会对上一个join连接产生的结果VT3和下一个表重复执行步骤1-3这三个步骤，一直到处理完所有的表为止

```
mysql> SELECT * FROM table1 AS a LEFT OUTER JOIN table2 AS b ON a.uid = b.uid;
+-----+------+------+------+
| uid | name | oid | uid |
+-----+------+------+------+
| aaa | mike | 1    | aaa |
| aaa | mike | 2    | aaa |
| bbb | jack | 3    | bbb |
| bbb | jack | 4    | bbb |
| bbb | jack | 5    | bbb |
| ccc | mike | 6    | ccc |
| ddd | mike | NULL | NULL|
+-----+------+------+------+
rows in set (0.00 sec)
```

#### 4.WHERE

对 虚拟表VT3 进行WHERE条件过滤。只有符合的记录才会被插入到 虚拟表VT4 中。

注意：
此时因为分组，不能使用聚合运算；也不能使用SELECT中创建的别名；

与ON的区别：
	- 如果有外部列，ON针对过滤的是关联表，主表（保留表）会返回所有的列；
	- 如果没有添加外部列，两者的效果是一样的；

应用：

- 对主表的过滤应该放在WHERE；
- 对于关联表，先条件查询后连接则用ON，先连接后条件查询则用WHERE；

#### 5.GROUP BY

根据group by子句中的列，对VT4中的记录进行分组操作，产生 虚拟表VT5 。

注意：

其后处理过程的语句，如SELECT,HAVING，所用到的列必须包含在GROUP BY中。对于没有出现的，得用聚合函数；

原因：

GROUP BY改变了对表的引用，将其转换为新的引用方式，能够对其进行下一级逻辑操作的列会减少；



11
12
13
14
15
16
17

mysql> SELECT * FROM table1 AS a LEFT OUTER JOIN table2 AS b ON a.uid = b.uid WHERE a. NAME = 'mike';
+-----+------+------+------+
| uid | name | oid | uid |
+-----+------+------+------+
| aaa | mike | 1    | aaa |
| aaa | mike | 2    | aaa |
| ccc | mike | 6    | ccc |
| ddd | mike | NULL |NULL |
+-----+------+------+------+
rows in set (0.00 sec)

我的理解是：

根据分组字段，将具有相同分组字段的记录归并成一条记录，因为每一个分组只能返回一条记录，除非是被过滤掉
了，而不在分组字段里面的字段可能会有多个值，多个值是无法放进一条记录的，所以必须通过聚合函数将这些具有
多值的列转换成单值；

6.HAVING

对 

虚拟表

VT5 

应用having过滤，只有符合的记录才会被 插入到 

虚拟表

VT6 

中。

7.SELECT

mysql> 

SELECT

-> *
-> 

FROM

-> table1 

AS 

a
-> 

LEFT OUTER JOIN 

table2 

AS 

b 

ON 

a

.uid 

= b

.uid

-> 

WHERE

-> a. NAME = 

'mike'

-> 

GROUP BY

-> a

.uid

;
+-----+------+------+------+
| uid | name | oid | uid |
+-----+------+------+------+
| aaa | mike | 

1 

| aaa |
| ccc | mike | 

6 

| ccc |
| ddd | mike | 

NULL 

| 

NULL 

|
+-----+------+------+------+
rows 

in set 

(

0.00 

sec)

1 2 3 4 5 6 7 8 9
10
11
12
13
14
15
16
17

mysql> 

SELECT

-> *
-> 

FROM

-> table1 

AS 

a
-> 

LEFT OUTER JOIN 

table2 

AS 

b 

ON 

a

.uid 

= b

.uid

-> 

WHERE

-> a. NAME = 

'mike'

-> 

GROUP BY

-> a

.uid

-> 

HAVING

-> 

count

(b

.oid

) < 

2

;
+-----+------+------+------+
| uid | name | oid | uid |
+-----+------+------+------+
| ccc | mike | 

6 

| ccc |
| ddd | mike | 

NULL 

| 

NULL 

|
+-----+------+------+------+
rows 

in set 

(

0.00 

sec)

1 2 3 4 5 6 7 8 9
10
11
12
13
14
15
16
17
18

开课吧

java

高级架构师

这个子句对SELECT子句中的元素进行处理，生成VT5表。
(5-J1)计算表达式 计算SELECT 子句中的表达式，生成VT5-J1

8.DISTINCT

寻找VT5-1中的重复列，并删掉，生成VT5-J2
如果在查询中指定了DISTINCT子句，则会创建一张内存临时表（如果内存放不下，就需要存放在硬盘了）。这张临
时表的表结构和上一步产生的虚拟表VT5是一样的，不同的是对进行DISTINCT操作的列增加了一个唯一索引，以此来
除重复数据。

9.ORDER BY

从 

VT5

\-

J2 

中的表中，根据ORDER BY 子句的条件对结果进行排序，生成VT6表。

注意：

唯一可使用SELECT中别名的地方；

mysql> 

SELECT

-> a

.uid

,
-> 

count

(b

.oid

) 

AS 

total
-> 

FROM

-> table1 

AS 

a
-> 

LEFT OUTER JOIN 

table2 

AS 

b 

ON 

a

.uid 

= b

.uid

-> 

WHERE

-> a. NAME = 

'mike'

-> 

GROUP BY

-> a

.uid

-> 

HAVING

-> 

count

(b

.oid

) < 

2

;
+-----+-------+
| uid | total |
+-----+-------+
| ccc | 

1 

|
| ddd | 

0 

|
+-----+-------+
rows 

in set 

(

0.00 

sec)

1 2 3 4 5 6 7 8 9
10
11
12
13
14
15
16
17
18
19

mysql> 

SELECT

-> a

.uid

,
-> 

count

(b

.oid

) 

AS 

total
-> 

FROM

-> table1 

AS 

a
-> 

LEFT OUTER JOIN 

table2 

AS 

b 

ON 

a

.uid 

= b

.uid

-> 

WHERE

-> a. NAME = 

'mike'

-> 

GROUP BY

-> a

.uid

-> 

HAVING

-> 

count

(b

.oid

) < 

2

-> 

ORDER BY

1 2 3 4 5 6 7 8 9
10
11
12
13

开课吧

java

高级架构师

10.LIMIT（MySQL特有）

LIMIT子句从上一步得到的 

VT6

虚拟表 

中选出从指定位置开始的指定行数据。

注意：

offset 

和 

rows 

的正负带来的影响；

当偏移量很大时效率是很低的，可以这么做：

采用子查询的方式优化 

，在子查询里先从索引获取到最大id，然后倒序排，再取N行结果集

采用

INNER JOIN

优化 

，JOIN子句里也优先从索引获取ID列表，然后直接关联查询获得最终结果

解析顺序总结

图示

-> total 

DESC

;
+-----+-------+
| uid | total |
+-----+-------+
| ccc | 

1 

|
| ddd | 

0 

|
+-----+-------+
rows 

in set 

(

0.00 

sec)

14
15
16
17
18
19
20
21

mysql> 

SELECT

-> a

.uid

,
-> 

count

(b

.oid

) 

AS 

total
-> 

FROM

-> table1 

AS 

a
-> 

LEFT JOIN 

table2 

AS 

b 

ON 

a

.uid 

= b

.uid

-> 

WHERE

-> a. NAME = 

'mike'

-> 

GROUP BY

-> a

.uid

-> 

HAVING

-> 

count

(b

.oid

) < 

2

-> 

ORDER BY

-> total 

DESC

-> 

LIMIT 

1

;
+-----+-------+
| uid | total |
+-----+-------+
| ccc | 

1 

|
+-----+-------+

row in set 

(

0.00 

sec)

1 2 3 4 5 6 7 8 9
10
11
12
13
14
15
16
17
18
19
20
21

开课吧

java

高级架构师

流程分析

流程说明：
单表查询：

根据 

WHERE 

条件过滤表中的记录，形成中间表（这个中间表对用户是不可见的）；然后根据

SELECT 

的选择列选择相应的列进行返回最终结果。

两表连接查询：

对两表求积（笛卡尔积）并用 

ON 

条件和连接连接类型进行过滤形成中间表；然后根据WHERE条
件过滤中间表的记录，并根据 

SELECT 

指定的列返回查询结果。

多表连接查询：

先对第一个和第二个表按照两表连接做查询，然后用查询结果和第三个表做连接查询，以此类
推，直到所有的表都连接上为止，最终形成一个中间的结果表，然后根据WHERE条件过滤中间表的记录，并根据
SELECT指定的列返回查询结果。

WHERE条件解析顺序

\1. 

MySQL 

：从左往右去执行 

WHERE 

条件的。
\2. 

Oracle 

：从右往左去执行 

WHERE 

条件的。

\1. FROM

（将最近的两张表，进行笛卡尔积）

---VT1
\2. ON

（将

VT1

按照它的条件进行过滤）

---VT2
\3. LEFT JOIN

（保留左表的记录）

---VT3
\4. WHERE

（过滤

VT3

中的记录）

--VT4…VTn
\5. GROUP BY

（对

VT4

的记录进行分组）

---VT5
\6. HAVING

（对

VT5

中的记录进行过滤）

---VT6
\7. SELECT

（对

VT6

中的记录，选取指定的列）

--VT7
\8. ORDER BY

（对

VT7

的记录进行排序）

--VT8
\9. LIMIT

（对排序之后的值进行分页）

--MySQL

特有的语法

1 2 3 4 5 6 7 8 9
1 

笛卡尔积：行相乘、列相加。

1 

写

WHERE

条件的时候，优先级高的部分要去编写过滤力度最大的条件语句。

开课吧

java

高级架构师

多表之间的关系

如上图所示，实际业务数据库中的表之间都是有关系的，我们接下来主要要学习的就是如何分析表关系及建立表关
系。

1. 分类表
2. 商品表
3. 订单表
4. 订单项表

表与表之间的关系

create table category(
cid varchar(32) primary key,
cname varchar(100)
);

1 2 3 4

create table product(
pid varchar(32) primary key,
pname varchar(40),
price double
);

1 2 3 4 5

create table orders(
oid varchar(32) primary key,
totalprice double
);

1 2 3 4

create table orderitem(
oid varchar(50),
pid varchar(50)
);

1 2 3 4

开课吧

java

高级架构师

表与表之间的关系，说的就是表与表之间数据的关系。
一对一关系

常见实例：一夫一妻

一对多关系

常见实例：会员和订单

多对多关系（需要中间表实现）

常见实例：商品和订单

外键

如何表示表与表之间的关系呢？就是使用

外键约束

表示的。
要想理解外键，我们先去理解表的角色：

主表和从表

（需要建立关系才有了主从表的角色区分）
主从表的理解
现在我们有两张表“分类表”和“商品表”。
目前从表的声明上来说，没有关系，但是我们有个需求：

商品应该有所属的分类

，这个时候需要将分类表和商品表建立关系，如何建立？
按照以上需求分析：
主键外键的理解

主表是：商品表。主表中，应该有一个字段去关联从表，而这个关联字段就是外键。
从表是：分类表。从表中，应该有一个字段去关联主表，而这个关联字段就是主键。

1 2 3

开课吧

java

高级架构师

如何操作外键
主表添加外键的格式：
主表删除外键的格式：
使用外键目的：

一对一关系（了解）

在实际工作中，一对一在开发中应用不多，因为一对一完全可以创建成一张表

案例：一个丈夫只能有一个妻子

建表语句：

alter table 

表名 

add 

[

constraint

][

约束名称

] 

foreign key 

(

主表外键字段

) 

references 

从表

(

从表
主键

)

1
1 

alter table 

表名 

drop foreign key 

外键约束名称
保证数据完整性（数据保存在多张表中的时候）
在互联网项目中，一般情况下，不建议建立外键关系。

1 2 3

CREATE TABLE 

wife(
id 

INT 

PRIMARY KEY 

,
wname 

VARCHAR

(

20

),
sex 

CHAR

(

1

)
);

CREATE TABLE 

husband(
id 

INT 

PRIMARY KEY 

,
hname 

VARCHAR

(

20

),
sex 

CHAR

(

1

)
);

1 2 3 4 5 6 7 8 9
10
11

开课吧

java

高级架构师

一对一关系创建方式1之

外键唯一

：
添加外键列wid，指定该列的约束为唯一（

不加唯一约束就是一对多关系

）
添加外键约束
一对一关系创建方式2之

主键做外键

：（课后作业）
思路：使用主表的主键作为外键去关联从表的主键

一对多关系

案例：一个分类对应多个商品
总结：
注意事项：
一对多关系创建：

添加外键列
添加外键约束

案例：

\1. 在商品表中添加一条记录，该记录的cid在分类表中不存在
\2. 在分类表中，删除一条记录，这条记录在商品表中有外键关联

多对多关系

案例：同一个商品对应多个订单，一个订单对应多个商品

1 

ALTER TABLE husband ADD wid INT UNIQUE;

1 

alter table husband add foreign key (wid) references wife(id);

1 

有外键的就是多的一方。

1 

一对多关系和一对一关系的创建很类似，唯一区别就是外键不唯一。

开课吧

java

高级架构师

注意事项：
多对多关系创建：

多表关联查询

我们已经学会了如何在一张表中读取数据，这是相对简单的，但是在真正的应用中经常需要从多个数据表中读取数
据。
本章节我们将向大家介绍如何使用 

MySQL 

的 

JOIN 

在两个或多个表中查询数据。
你可以在 

SELECT 

, 

UPDATE 

和 

DELETE 

语句中使用 

MySQL 

的 

JOIN 

来联合多表查询。

JOIN 

按照

功能

大致分为如下三类：

CROSS JOIN 

（交叉连接）

INNER JOIN 

（内连接或等值连接）。

OUTER JOIN 

（外连接）

建表语句：

需要中间表去完成多对多关系的创建
多对多关系其实就是两个一对多关系的组合

1 2 3

创建中间表，并在其中创建多对多关系中两张表的外键列
在中间表中添加外键约束
在中间表中添加联合主键约束

1 2 3 4 5

insert into 

category (cid,cname) 

values 

(

'c001'

,

'

家电

'

);

insert into 

category (cid,cname) 

values 

(

'c002'

,

'

服饰

'

);

insert into 

category (cid,cname) 

values 

(

'c003'

,

'

化妆品

'

);

insert into 

product(pid,pname,price,cid) 

values 

(

'p001'

,

'

联想

'

,

5000

,

'c001'

);

insert into 

product(pid,pname,price,cid) 

values 

(

'p002'

,

'

海尔

'

,

3000

,

'c001'

);

insert into 

product(pid,pname,price,cid) 

values 

(

'p003'

,

'

雷神

'

,

5000

,

'c001'

);

insert into 

product(pid,pname,price,cid) 

values 

(

'p004'

,

'

阿迪

'

,

1000

,

'c002'

);

insert into 

product(pid,pname,price,cid) 

values 

(

'p005'

,

'

耐克

'

,

1200

,

'c002'

);

1 2 3 4 5 6 7 8 9
10
11
12
13
14
15
16
17
18
19

开课吧

java

高级架构师

交叉连接

关键字：

交叉连接也叫笛卡尔积连接。笛卡尔积

是指在数学中，两个集合 

X 

和 

Y 

的笛卡尓积（ 

Cartesian product 

），又称
直积，表示为 

X*Y 

，第一个对象是 

X 

的成员而第二个对象是 

Y 

的所有可能有序对的其中一个成员。

交叉连接的表现：

隐式交叉连接
显式交叉连接

案例：查询商品表和分类表的笛卡尔积。

insert into 

product(pid,pname,price,cid) 

values 

(

'p006'

,

'NB'

,

800

,

'c002'

);

insert into 

product(pid,pname,price,cid) 

values 

(

'p007'

,

'

彪马

'

,

600

,

'c002'

);

insert into 

product(pid,pname,price,cid) 

values 

(

'p008'

,

'

雪花秀

'

,

1500

,

'c003'

);

insert into 

product(pid,pname,price,cid) 

values 

(

'p009'

,

'

悦诗风吟

'

,

1100

,

'c003'

);

20
21
22
23
24
25
26
27
28
29
1 

CROSS JOIN

1 

行数相乘、列数相加

1 

SELECT * FROM A, B

1 

SELECT * FROM A CROSS JOIN B

开课吧

java

高级架构师

内连接

关键字：
内连接也叫

等值连接

，内联接使用比较运算符根据每个表共有的列的值匹配两个表中的行。
隐式内连接
显式内连接

外连接

外联接可以是左向外联接、右向外联接或完整外部联接。也就是说外连接又分为：
外连接需要有

主表或者保留表

的概念。
在 

FROM 

子句中指定外联接时，可以由下列几组关键字中的一组指定：
左外连接：

1 

INNER JOIN

1 

SELECT * FROM A,B WHERE A.id = B.id

1 

SELECT * FROM A INNER JOIN B ON A.id = B.id

1 

左外连接、右外连接、全外连接

开课吧

java

高级架构师

案例：
右外连接:
全外连接（

MySQL不支持

）：

外连接总结

：
通过业务需求，分析主从表
如果使用 

LEFT JOIN 

，则主表在它左边
如果使用 

RIGHT JOIN 

，则主表在它右边
查询结果以主表为主，从表记录匹配不到，则补 

null

MySQL锁

MySQL锁介绍

按照锁的粒度来说，MySQL主要包含三种类型（级别）的锁定机制：
按照锁的功能来说分为：

共享读锁

和

排他写锁

。
按照锁的实现方式分为：

悲观锁

和

乐观锁

（使用某一版本列或者唯一列进行逻辑控制）
表级锁和行级锁的区别：

1 

LEFT JOIN 

或者 

LEFT OUTER JOIN

1 

SELECT * FROM A LEFT JOIN B ON A.id = B.id

1 

查询分类信息，关联查询商品信息

1 

RIGHT JOIN 

或者 

RIGHT OUTER JOIN

1 

SELECT * FROM A RIGHT JOIN B ON A.id = B.id

1 

FULL JOIN 

或 

FULL OUTER JOIN

1 

SELECT * FROM A FULL JOIN B ON A.id = B.id
\- 

全局锁：锁的是整个

database

。由

MySQL

的

SQL layer

层实现的

\- 

表级锁：锁的是某个

table

。由

MySQL

的

SQL layer

层实现的

\- 

行级锁：锁的是某行数据，也可能锁定行之间的间隙。由某些存储引擎实现，比如

InnoDB

。

1 2 3 4 5

开课吧

java

高级架构师

MySQL表级锁

表级锁介绍

由MySQL SQL layer层实现

MySQL的表级锁有两种：
MySQL 实现的表级锁定的争用状态变量：

表锁介绍

表锁有两种表现形式：
手动增加表锁
查看表锁情况

表级锁：开销小，加锁快；不会出现死锁；锁定粒度大，发生锁冲突的概率最高，并发度最低；
行级锁：开销大，加锁慢；会出现死锁；锁定粒度最小，发生锁冲突的概率最低，并发度也最高；

1 2 3

一种是表锁。
一种是元数据锁（

meta data lock

，

MDL)

。

1 2
1 

mysql> show status like 'table%';
\- table_locks_immediate

：产生表级锁定的次数；

\- table_locks_waited

：出现表级锁定争用而发生等待的次数；

1 2

表共享读锁（

Table Read Lock

）
表独占写锁（

Table Write Lock

）

1 2
1 

lock table 

表名称 

read

(

write

),

表名称

2 

read

(

write

)

，其他

;

1 

show open tables

;

开课吧

java

高级架构师

删除表锁

表锁演示

环境准备
读锁演示

1 

unlock tables

;

CREATE TABLE 

mylock (
id 

int

(

11

) 

NOT 

NULL 

AUTO_INCREMENT

,
NAME 

varchar

(

20

) 

DEFAULT 

NULL

,

PRIMARY KEY 

(id)
);

INSERT INTO 

mylock (id,NAME) 

VALUES 

(

1

, 

'a'

);

INSERT INTO 

mylock (id,NAME) 

VALUES 

(

2

, 

'b'

);

INSERT INTO 

mylock (id,NAME) 

VALUES 

(

3

, 

'c'

);

INSERT INTO 

mylock (id,NAME) 

VALUES 

(

4

, 

'd'

);

1 2 3 4 5 6 7 8 9
10

开课吧

java

高级架构师

写锁演示

元数据锁介绍

MDL不需要显式使用，在访问一个表的时候会被自动加上。MDL的作用是，保证读写的正确性。你可以想象一下，如
果一个查询正在遍历一个表中的数据，而执行期间另一个线程对这个表结构做变更，删了一列，那么查询线程拿到的
结果跟表结构对不上，肯定是不行的。
因此，

在 MySQL 5.5 版本中引入了 MDL

，当对一个表做增删改查操作的时候，加 MDL 读锁；当要对表做结构变
更操作的时候，加 MDL 写锁。
读锁之间不互斥，因此你可以有多个线程同时对一张表增删改查。
读写锁之间、写锁之间是互斥的，用来保证变更表结构操作的安全性。因此，如果有两个线程要同时给一个表
加字段，其中一个要等另一个执行完才能开始执行。

元数据锁演示

开课吧

java

高级架构师

我们可以看到 session A 先启动，这时候会对表 t 加一个 MDL 读锁。由于 session B 需要的也是 MDL 读
锁，因此可以正常执行。
之后 session C 会被 blocked，是因为 session A 的 MDL 读锁还没有释放，而 session C 需要 MDL 写锁，
因此只能被阻塞。
如果只有 session C 自己被阻塞还没什么关系，但是之后所有要在表 t 上新申请 MDL 读锁的请求也会被
session C 阻塞。前面我们说了，所有对表的增删改查操作都需要先申请 MDL 读锁，就都被锁住，等于这个表现
在完全不可读写了。
你现在应该知道了，事务中的 MDL 锁，在语句执行开始时申请，但是语句结束后并不会马上释放，而会等到整个事
务提交后再释放。

MySQL行级锁

行级锁介绍

MySQL的行级锁，是由存储引擎来实现的，这里我们主要讲解InnoDB的行级锁。
InnoDB的行级锁，按照锁定范围来说，分为三种：

开课吧

java

高级架构师

| 共享锁（S）      | 排他锁（X） | 意向共享锁（IS） | 意向排他锁（IX） |      |
| ---------------- | ----------- | ---------------- | ---------------- | ---- |
| 共享锁（S）      | 兼容        | 冲突             | 兼容             | 冲突 |
| 排他锁（X）      | 冲突        | 冲突             | 冲突             | 冲突 |
| 意向共享锁（IS） | 兼容        | 冲突             | 兼容             | 兼容 |
| 意向排他锁（IX） | 冲突        | 冲突             | 兼容             | 兼容 |

InnoDB的行级锁，按照功能来说，分为两种：
对于UPDATE、DELETE和INSERT语句，InnoDB会自动给涉及数据集加排他锁（X)；
对于普通SELECT语句，InnoDB不会加任何锁，事务可以通过以下语句显示给记录集加共享锁或排他锁。 

手动添加
共享锁（S）：
手动添加排他锁（x）：

InnoDB也实现了表级锁，也就是意向锁，意向锁是mysql内部使用的，不需要用户干预。
意向锁和行锁可以共存，意向锁的主要作用是为了【全表更新数据】时的性能提升。否则在全表更新数据时，
需要先检索该范是否某些记录上面有行锁。

InnoDB行锁

是通过给索引上的

索引项加锁来实现的

，因此InnoDB这种行锁实现特点意味着：只有通过索引条
件检索的数据，InnoDB才使用行级锁，否则，InnoDB将使用表锁！

\- 

记录锁（

Record Locks

）

:

锁定索引中一条记录。

\- 

间隙锁（

Gap Locks

）

:

要么锁住索引记录中间的值，要么锁住第一个索引记录前面的值或者最后一个索引记录后面
的值。

\- Next-Key Locks:

是索引记录上的记录锁和在索引记录之前的间隙锁的组合。

1 2 3 4 5

\- 

共享锁（

S

）：允许一个事务去读一行，阻止其他事务获得相同数据集的排他锁。

\- 

排他锁（

X

）：允许获得排他锁的事务更新数据，阻止其他事务取得相同数据集的共享读锁和排他写锁。

1 2
1 

SELECT 

\* 

FROM table_name WHERE 

... 

LOCK IN SHARE MODE

1 

SELECT 

\* 

FROM table_name WHERE 

... 

FOR UPDATE

\- 

意向共享锁（

IS

）：事务打算给数据行加行共享锁，事务在给一个数据行加共享锁前必须先取得该表的

IS

锁。

\- 

意向排他锁（

IX

）：事务打算给数据行加行排他锁，事务在给一个数据行加排他锁前必须先取得该表的

IX

锁。

1 2

开课吧

java

高级架构师

Innodb所使用的

行级锁定

争用状态查看：
对于这5个状态变量，比较重要的主要是：
尤其是当等待次数很高，而且每次等待时长也不小的时候，我们就需要分析系统中为什么会有如此多的等待，然后根
据分析结果着手指定优化计划。

InnoDB行锁演示

创建表及索引
行锁定基本演示

1 

mysql> 

show status like 

'innodb_row_lock%'

;
\- Innodb_row_lock_current_waits

：当前正在等待锁定的数量；

\- Innodb_row_lock_time

：从系统启动到现在锁定总时间长度；

\- Innodb_row_lock_time_avg

：每次等待所花平均时间；

\- Innodb_row_lock_time_max

：从系统启动到现在等待最常的一次所花的时间；

\- Innodb_row_lock_waits

：系统启动后到现在总共等待的次数；

1 2 3 4 5 6 7 8 9

\- Innodb_row_lock_time_avg

（等待平均时长）

\- Innodb_row_lock_waits

（等待总次数）

\- Innodb_row_lock_time

（等待总时长）这三项。

1 2 3 4 5

create table 

test_innodb_lock (a 

int

(

11

),b 

varchar

(

16

)) 

engine

=

innodb

;

create index 

test_innodb_a_idx 

on 

test_innodb_lock(a);

create index 

test_innodb_lock_b_idx 

on 

test_innodb_lock(b);

1 2 3

开课吧

java

高级架构师

| Session a | Session b                                                    |                                                              |
| --------- | ------------------------------------------------------------ | ------------------------------------------------------------ |
| 1         | mysql> set autocommit=0; Query OK, 0 rows affected (0.00 sec) | mysql> set autocommit=0; Query OK, 0 rows affected (0.00 sec) |
| 2         | mysql> update test_innodb_lock set b = 'b1' where a = 1; Query OK, 1 row affected (0.00 sec) Rows matched: 1 Changed: 1 Warnings: 0 更新，但是不提交 |                                                              |
| 3         | mysql> update test_innodb_lock set b = 'b2' where a = 1; 被阻塞，等待 |                                                              |
| 4         | mysql> commit; Query OK, 0 rows affected (0.05 sec) 提交     |                                                              |
| 5         | mysql> update test_innodb_lock set b = 'b2' where a = 1; Query OK, 0 rows affected (36.14 sec) Rows matched: 1 Changed: 0 Warnings: 0 解除阻塞，更新正常进 行 |                                                              |

| Session a | Session b                                                    |                                                              |
| --------- | ------------------------------------------------------------ | ------------------------------------------------------------ |
| 1         | mysql> set autocommit=0; Query OK, 0 rows affected (0.00 sec) | mysql> set autocommit=0; Query OK, 0 rows affected (0.00 sec) |
| 2         | mysql> update test_innodb_lock set b = '2' where b = 2000; Query OK, 1 row affected (0.02 sec) Rows matched: 1 Changed: 1 Warnings: 0 | mysql> update test_innodb_lock set b = '3' where b = 3000; 被阻塞，等待 |
| 3         | mysql> commit; Query OK, 0 rows affected (0.10 sec)          |                                                              |
| 4         | mysql> update test_innodb_lock set b = '3' where b = 3000; Query OK, 1 row affected (1 min 3.41 sec) Rows matched: 1 Changed: 1 Warnings: 0 阻塞解除，完成更新 |                                                              |

无索引升级为表锁演示
间隙锁带来的插入问题演示

开课吧

java

高级架构师

| Session a | Session b                                                    |                                                              |
| --------- | ------------------------------------------------------------ | ------------------------------------------------------------ |
| 1         | mysql> set autocommit=0; Query OK, 0 rows affected (0.00 sec) | mysql> set autocommit=0; Query OK, 0 rows affected (0.00 sec) |
| 2         | mysql> select * from test_innodb_lock; a b 1 b2 3 3 4 4000 5 5000 6 6000 7 7000 8 8000 9 9000 1 b1 9 rows in set (0.00 sec) |                                                              |
| 3         | mysql> update test_innodb_lock set b = a * 100 where a < 4 and a > 1; Query OK, 1 row affected (0.02 sec) Rows matched: 1 Changed: 1 Warnings: 0 |                                                              |
| 4         | mysql> insert into test_innodb_lock values(2,'200'); 被阻塞，等待 |                                                              |
| 5         | mysql> commit; Query OK, 0 rows affected (0.02 sec)          |                                                              |
| 6         | mysql> insert into test_innodb_lock values(2,'200'); Query OK, 1 row affected (38.68 sec) 阻塞 解除，完成插入 |                                                              |

| Session a | Session b                                                    |                                                              |
| --------- | ------------------------------------------------------------ | ------------------------------------------------------------ |
| 1         | mysql> set autocommit=0; Query OK, 0 rows affected (0.00 sec) | mysql> set autocommit=0; Query OK, 0 rows affected (0.00 sec) |
| 2         | mysql> update test_innodb_lock set b = 'bbbbb' where a = 1 and b = 'b2'; Query OK, 1 row affected (0.00 sec) Rows matched: 1 Changed: 1 Warnings: 0 |                                                              |
| 3         | mysql> update test_innodb_lock set b = 'bbbbb' where a = 1 and b = 'b1'; 被阻塞 |                                                              |
| 4         | mysql> commit; Query OK, 0 rows affected (0.02 sec)          |                                                              |
| 5         | mysql> update test_innodb_lock set b = 'bbbbb' where a = 1 and b = 'b1'; Query OK, 1 row affected (42.89 sec) Rows matched: 1 Changed: 1 Warnings: 0 session 提交事务，阻塞 去除，更新完成 |                                                              |

使用共同索引不同数据的阻塞示例

开课吧

java

高级架构师

| Session a                                                    | Session b                                                    |                                                              |
| ------------------------------------------------------------ | ------------------------------------------------------------ | ------------------------------------------------------------ |
| 1                                                            | mysql> set autocommit=0; Query OK, 0 rows affected (0.00 sec) | mysql> set autocommit=0; Query OK, 0 rows affected (0.00 sec) |
| 2                                                            | mysql> update t1 set id = 110 where id = 11; Query OK, 0 rows affected (0.00 sec) Rows matched: 0 Changed: 0 Warnings: 0 |                                                              |
| 3                                                            | mysql> update t2 set id = 210 where id = 21; Query OK, 1 row affected (0.00 sec) Rows matched: 1 Changed: 1 Warnings: 0 |                                                              |
| 4                                                            | mysql>update t2 set id=2100 where id=21; 等待sessionb释放资源，被阻塞 |                                                              |
| 5                                                            | mysql>update t1 set id=1100 where id=11; Query OK,0 rows affected (0.39sec) Rows matched: 0 Changed: 0 Warnings:0 等待 sessiona释放资源，被阻塞 |                                                              |
| 两个 session 互相等等待对方的资源释放之 后才能释放自己的资源,造成了死锁 |                                                              |                                                              |

死锁演示

MySQL事务

事务介绍

在MySQL中的事务是由存储引擎实现的，而且支持事务的存储引擎不多，我们主要讲解

InnoDB

存储引擎中的事务。
事务处理可以用来维护数据库的完整性，保证成批的 SQL 语句要么全部执行，要么全部不执行。
事务用来管理 

DDL

、

DML

、

DCL 

操作，比如 insert,update,delete 语句，默认是自动提交的。
一般来说，事务是必须满足4个条件（ACID）：
Atomicity（原子性）：构成事务的的所有操作必须是一个逻辑单元，要么全部执行，要么全部不执行。
Consistency（一致性）：数据库在事务执行前后状态都必须是稳定的或者是一致的。

Isolation（隔离性）：事务之间不会相互影响。
由锁机制和MVCC机制来实现的
MVCC：优化读写性能（读不加锁、读写不冲突）

Durability（持久性）：事务执行成功后必须全部写入磁盘。

事务开启

开课吧

java

高级架构师

在MySQL命令行的默认设置下，事务都是自动提交的，即执行SQL语句后就会马上执行COMMIT操作。因此要显式地开
启一个事务务须使用命令 

BEGIN 

或 

START TRANSACTION 

，或者执行命令 

SET AUTOCOMMIT=0 

，用来禁止使用当前会
话的自动提交。
常见的操作有以下三个：

BEGIN 

或 

START TRANSACTION 

；显式地开启一个事务；

COMMIT 

也可以使用 

COMMIT WORK 

，不过二者是等价的。COMMIT会提交事务，并使已对数据库进行的所有修改
称为永久性的；

ROLLBACK 

有可以使用 

ROLLBACK WORK 

，不过二者是等价的。回滚会结束用户的事务，并撤销正在进行的所有
未提交的修改；

事务并发问题

在事务的

并发操作

中可能会出现一些问题：

丢失更新

：一个事务更新之后，另一个事务也更新了，但是第二个事务回滚了，则第一个事务也被回滚了。

脏读

：一个事务读取到另一个事务未提交的数据。

不可重复读

：一个事务因读取到另一个事务

已提交的update或者delete数据

。导致对同一条记录读取两次以
上的结果不一致。

幻读

：一个事务因读取到另一个事务

已提交的insert数据

。导致

对同一张表读取

两次以上的结果不一致。

事务隔离级别

四种隔离级别（SQL92标准）：

现在来看看MySQL数据库为我们提供的四种隔离级别（

由低到高

）：
① Read uncommitted (读未提交)：最低级别，任何情况都无法保证。
② Read committed (RC，读已提交)：可避免脏读的发生。
③ 

Repeatable read 

(RR，可重复读)：可避免脏读、不可重复读的发生。
（

注意事项：InnoDB的RR还可以解决幻读，主要原因是Next-Key锁，只有RR才能使用Next-Key锁

）
④ Serializable (串行化)：可避免脏读、不可重复读、幻读的发生。
（

由MVCC降级为Locking-Base CC

）

默认隔离级别

大多数数据库的默认隔离级别是Read Committed，比如Oracle、DB2等。

MySQL数据库的默认隔离级别是Repeatable Read

。

如何查看和设置隔离级别：

在MySQL数据库中查看当前事务的隔离级别：
在MySQL数据库中设置事务的隔离级别：

1 

select 

@@tx_isolation

;

开课吧

java

高级架构师

注意事项：

对于多数应用程序，可以优先考虑把数据库系统的隔离级别设为 

Read Committed 

。它能够避免脏读取，而且
具有较好的并发性能。尽管它会导致不可重复读、幻读这些并发问题，在可能出现这类问题的个别场合，可以
由应用程序采用悲观锁或乐观锁来控制。

MySQL索引

索引介绍

索引是什么

官方介绍索引是帮助MySQL

高效获取数据

的

数据结构

。
更通俗的说，数据库索引好比是一本书前面的目录，能

加快数据库的查询速度

。
一般来说索引本身也很大，不可能全部存储在内存中，因此索引往往是存储在磁盘上的文件中的（可能存储在
单独的索引文件中，也可能和数据一起存储在数据文件中）。

我们通常所说的索引，没有特别说明，都是指的B树（多路搜索树，并不一定是二叉的）结构组织的索引。
其中聚集索引、覆盖索引、组合索引、前缀索引、唯一索引默认都是使用B+树索引，统称索引

。

索引的优势和劣势

优势：

类似于书的目录，可以提高数据检索的效率，降低数据库的IO成本。
通过

索引列对数据进行排序

，降低数据排序的成本，降低了CPU的消耗。
被索引的列会自动进行排序，包括单列索引和组合索引，只是组合索引的排序要复杂一些。
如果按照索引列的顺序进行排序，对应order by语句来说，效率就会提高很多。

劣势：

索引会占据磁盘空间
索引会提高查询效率，但是会降低更新表的效率。比如每次对表进行增删改操作，MySQL不仅要保存数据，还有
保存或者更新对应的索引文件。

索引的分类

单列索引

普通索引：MySQL中基本索引类型，没有什么限制，允许在定义索引的列中插入重复值和空值，纯粹为了查询数
据更快一点。
唯一索引：索引列中的值必须是唯一的，但是允许为空值。
主键索引：是一种特殊的唯一索引，不允许有空值。

set 

[glogal | 

session

] 

transaction isolation level 

隔离级别名称

;

set 

tx_isolation=’

隔离级别名称

;’

1 2
1 

隔离级别越高，越能保证数据的完整性和一致性，但是对并发性能的影响也越大。

开课吧

java

高级架构师

组合索引

在表中的

多个字段组合上创建的索引

只有在查询条件中使用了这些字段的左边字段时，索引才会被使用，遵循

最左前缀原则（最左匹配原则）

。
一般情况下，建议使用组合索引代替单列索引（主键索引除外，具体原因后面知识点讲解）。

全文索引

只有在

MyISAM引擎

上才能使用，只能在CHAR,VARCHAR,TEXT类型字段上使用全文索引。

空间索引

不做介绍，一般使用不到。

索引的使用

创建索引

单列索引之普通索引
单列索引之唯一索引
单列索引之全文索引
组合索引

删除索引
查看索引

MySQL架构篇

CREATE INDEX 

index_name 

ON table

(

column

(length))

ALTER TABLE table_name ADD INDEX 

index_name 

ON 

(

column

(length))

1 2
1 

CREATE UNIQUE INDEX 

index_name 

ON table

(

column

(length))

1 

CREATE FULLTEXT INDEX 

index_name 

ON table

(

column

(length))

1 

ALTER TABLE 

article 

ADD INDEX 

index_titme_time (title(

50

),

time

(

10

))

1 

DROP INDEX 

index_name 

ON table

1 

SHOW INDEX FROM table_name 

\G

开课吧

java

高级架构师

逻辑架构图

Connectors

指的是不同语言中与SQL的交互

Management Serveices & Utilities

系统管理和控制工具

Connection Pool: 连接池

管理缓冲用户连接，线程处理等需要缓存的需求。
负责监听对 MySQL Server 的各种请求，接收连接请求，转发所有连接请求到线程管理模块。每一个连接上
MySQL Server 的客户端请求都会被分配（或创建）一个连接线程为其单独服务。
而连接线程的主要工作就是负责 MySQL Server 与客户端的通信，接受客户端的命令请求，传递 Server 端
的结果信息等。线程管理模块则负责管理维护这些连接线程。包括线程的创建，线程的 cache 等。

SQL Interface: SQL接口

接受用户的SQL命令，并且返回用户需要查询的结果。比如select from就是调用SQL Interface

Parser: 解析器

SQL命令传递到解析器的时候会被解析器

验证和解析

。
主要功能：

开课吧

java

高级架构师

| a . 将SQL语句进行语义和语法的分析，分解成数据结构，然后按照不同的操作类型进行分类，然后做出针对性的转 发到后续步骤，以后SQL语句的传递和处理就是基于这个结构的。 b. 如果在分解构成中遇到错误，那么就说明这个sql语句是不合理的 Optimizer: 查询优化器 |
| ------------------------------------------------------------ |
| SQL语句在查询之前会使用查询优化器对查询进行优化。 Cache和Buffer： 查询缓存 |

他的主要功能是将客户端提交给MySQL的 select请求的返回结果集 cache 到内存中，与该 query 的一个 hash
值 做一个对应。该 Query 所取数据的基表发生任何数据的变化之后， MySQL 会自动使该 query 的Cache 失
效。在读写比例非常高的应用系统中， Query Cache 对性能的提高是非常显著的。当然它对内存的消耗也是非常大
的。
如果查询缓存有命中的查询结果，查询语句就可以直接去查询缓存中取数据。这个缓存机制是由一系列小缓存组成
的。比如表缓存，记录缓存，key缓存，权限缓存等

Pluggable Storage Engines

存储引擎接口模块可以说是 MySQL 数据库中最有特色的一点了。目前各种数据库产品中，基本上只有 MySQL 可以
实现其底层数据存储引擎的插件式管理。这个模块实际上只是 一个抽象类，但正是因为它成功地将各种数据处理高
度抽象化，才成就了今天 MySQL 可插拔存储引擎的特色。
从图还可以看出，MySQL区别于其他数据库的最重要的特点就是

其插件式的表存储引擎

。MySQL插件式的存储引擎架
构提供了一系列标准的管理和服务支持，这些标准与存储引擎本身无关，可能是每个数据库系统本身都必需的，如
SQL分析器和优化器等，而存储引擎是底层物理结构的实现，每个存储引擎开发者都可以按照自己的意愿来进行开
发。

MySQL存储引擎种类

与其他数据库例如

Oracle 

和

SQL Server

等数据库中只有一种存储引擎不同的是，

MySQL

有一个被称
为

“Pluggable Storage Engine Architecture”(

可插拔的存储引擎架构

)

的特性，也就意味着

MySQL

数据库提
供了多种存储引擎。
而且存储引擎是针对表的，用户可以根据不同的需求为数据表选择不同的存储引擎，用户也可以根据自己的需要编写自
己的存储引擎。也就是说，同一数据库不同的表可以选择不同的存储引擎

creat table xxx()engine=InnoDB/Memory/MyISAM

简而言之，存储引擎就是如何存储数据、如何为存储的数据建立索引和如何更新、查询数据等技术的实现方法。

1 2 3 4 5 6

开课吧

java

高级架构师

| 存储引擎            | 说明                                                         |
| ------------------- | ------------------------------------------------------------ |
| MyISAM              | 高速引擎，拥有较高的插入，查询速度，但不支持事务             |
| InnoDB              | 5.5版本后MySQL的默认数据库，支持事务和行级锁定，比MyISAM处理速度稍慢 |
| ISAM                | MyISAM的前身，MySQL5.0以后不再默认安装                       |
| MRG_MyISAM（MERGE） | 将多个表联合成一个表使用，在超大规模数据存储时很有用         |
| Memory              | 内存存储引擎，拥有极高的插入，更新和查询效率。但是会占用和数据量成正比的 内存空间。只在内存上保存数据，意味着数据可能会丢失 |
| Falcon              | 一种新的存储引擎，支持事物处理，传言可能是InnoDB的替代者     |
| Archive             | 将数据压缩后进行存储，非常适合存储大量的独立的，作为历史记录的数据，但是 只能进行插入和查询操作 |
| CSV                 | CSV 存储引擎是基于 CSV 格式文件存储数据(应用于跨平台的数据交换) |

| Innodb    | Myisam                                   |                                              |
| --------- | ---------------------------------------- | -------------------------------------------- |
| 存储文 件 | .frm 表定义文件 .ibd 数据文件和索引文 件 | .frm 表定义文件 .myd 数据文件 .myi 索引文 件 |
| 锁        | 表锁、行锁                               | 表锁                                         |
| 事务      | 支持                                     | 不支持                                       |
| CRDU      | 读、写                                   | 读多                                         |
| count     | 扫表                                     | 专门存储的地方                               |
| 索引结 构 | B+ Tree                                  | B+ Tree                                      |

查看存储引擎：
InnoDB和MyISAM存储引擎区别：

xtraDB存储引擎是由Percona公司提供的存储引擎，该公司还出品了Percona Server这个产品，它是基于MySQL开
源代码进行修改之后的产品。
阿里对于Percona Server服务器进行修改，衍生了自己的数据库（alisql）。

简版执行流程图

1 

mysql> show engines;

开课吧

java

高级架构师

待分析查询语句如下：
我们看到的只是输入一条语句，返回一个结果，却不知道这条语句在 MySQL 内部的执行过程。
所以今天我想和你一起把 MySQL 拆解一下，看看里面都有哪些“零件”，希望借由这个拆解过程，让你对 MySQL
有更深入的理解。这样当我们碰到 MySQL 的一些异常或者问题时，就能够直戳本质，更为快速地定位并解决问题。
上面给出的是 MySQL 的基本架构示意图，从中你可以清楚地看到 SQL 语句在 MySQL 的各个功能模块中的执行过
程。
大体来说，MySQL 可以分为 

Server 层

和

存储引擎层

两部分。

Server 层

包括连接器、查询缓存、分析器、优化器、执行器等，涵盖 MySQL 的大多数核心服务功能，以及所有的
内置函数（如日期、时间、数学和加密函数等），所有跨存储引擎的功能都在这一层实现，比如存储过程、触发器、
视图等。
而

存储引擎层

负责数据的存储和提取。其架构模式是插件式的，支持 InnoDB、MyISAM、Memory 等多个存储引擎。
现在最常用的存储引擎是 InnoDB，它从 MySQL 5.5.5 版本开始成为了默认存储引擎。

1 

mysql> 

select 

\* 

from 

T 

where 

ID=

10

；

开课吧

java

高级架构师

也就是说，你执行 create table 建表的时候，如果不指定引擎类型，默认使用的就是 InnoDB。不过，你也可以
通过指定存储引擎的类型来选择别的引擎，比如在 create table 语句中使用 engine=memory, 来指定使用内存
引擎创建表。不同存储引擎的表数据存取方式不同，支持的功能也不同，在后面的文章中，我们会讨论到引擎的选
择。
从图中不难看出，不同的存储引擎共用一个

Server 层

，也就是从连接器到执行器的部分。你可以先对每个组件的名
字有个印象，接下来我会结合开头提到的那条 SQL 语句，带你走一遍整个执行流程，依次看下每个组件的作用。

连接器

第一步，你会先连接到这个数据库上，这时候接待你的就是连接器。连接器负责跟客户端建立连接、获取权限、维持
和管理连接。连接命令一般是这么写的：
输完命令之后，你就需要在交互对话里面输入密码。虽然密码也可以直接跟在 -p 后面写在命令行中，但这样可能
会导致你的密码泄露。如果你连的是生产服务器，强烈建议你不要这么做。
连接命令中的 mysql 是客户端工具，用来跟服务端建立连接。在完成经典的 TCP 握手后，连接器就要开始认证你
的身份，这个时候用的就是你输入的用户名和密码。
如果用户名或密码不对，你就会收到一个"Access denied for user"的错误，然后客户端程序结束执行。
如果用户名密码认证通过，连接器会到权限表里面查出你拥有的权限。之后，这个连接里面的权限判断逻辑，
都将依赖于此时读到的权限。
这就意味着，一个用户成功建立连接后，即使你用管理员账号对这个用户的权限做了修改，也不会影响已经存在连接
的权限。修改完成后，只有再新建的连接才会使用新的权限设置。
连接完成后，如果你没有后续的动作，这个连接就处于空闲状态，你可以在 show processlist 命令中看到它。文
本中这个图是 show processlist 的结果，其中的 Command 列显示为“Sleep”的这一行，就表示现在系统里面
有一个空闲连接。
客户端如果太长时间没动静，连接器就会自动将它断开。这个时间是由参数 wait_timeout 控制的，默认值是 8
小时。
如果在连接被断开之后，客户端再次发送请求的话，就会收到一个错误提醒： Lost connection to MySQL
server during query。这时候如果你要继续，就需要重连，然后再执行请求了。
数据库里面，长连接是指连接成功后，如果客户端持续有请求，则一直使用同一个连接。短连接则是指每次执行完很
少的几次查询就断开连接，下次查询再重新建立一个。
建立连接的过程通常是比较复杂的，所以我建议你在使用中要尽量减少建立连接的动作，也就是尽量使用长连接。
但是全部使用长连接后，你可能会发现，有些时候 MySQL 占用内存涨得特别快，这是因为 MySQL 在执行过程中临
时使用的内存是管理在连接对象里面的。这些资源会在连接断开的时候才释放。所以如果长连接累积下来，可能导致
内存占用太大，被系统强行杀掉（OOM），从现象看就是 MySQL 异常重启了。

1 

mysql 

-h

$ip 

-P

$port 

-u

$user 

-p

开课吧

java

高级架构师

怎么解决这个问题呢？你可以考虑以下两种方案。
\1. 定期断开长连接。使用一段时间，或者程序里面判断执行过一个占用内存的大查询后，断开连接，之后要查询
再重连。
\2. 如果你用的是 MySQL 5.7 或更新版本，可以在每次执行一个比较大的操作后，通过执行
mysql_reset_connection 来重新初始化连接资源。这个过程不需要重连和重新做权限验证，但是会将连接恢
复到刚刚创建完时的状态。

查询缓存

连接建立完成后，你就可以执行 select 语句了。执行逻辑就会来到第二步：查询缓存。
MySQL 拿到一个查询请求后，会先到查询缓存看看，之前是不是执行过这条语句。之前执行过的语句及其结果可能
会以 key-value 对的形式，被直接缓存在内存中。key 是查询的语句，value 是查询的结果。如果你的查询能够
直接在这个缓存中找到 key，那么这个 value 就会被直接返回给客户端。
如果语句不在查询缓存中，就会继续后面的执行阶段。执行完成后，执行结果会被存入查询缓存中。你可以看到，如
果查询命中缓存，MySQL 不需要执行后面的复杂操作，就可以直接返回结果，这个效率会很高。

但是大多数情况下我会建议你不要使用查询缓存，为什么呢？因为查询缓存往往弊大于利。

查询缓存的失效非常频繁，只要有对一个表的更新，这个表上所有的查询缓存都会被清空。因此很可能你费劲地把结
果存起来，还没使用呢，就被一个更新全清空了。对于更新压力大的数据库来说，查询缓存的命中率会非常低。除非
你的业务就是有一张静态表，很长时间才会更新一次。比如，一个系统配置表，那这张表上的查询才适合使用查询缓
存。
好在 MySQL 也提供了这种“按需使用”的方式。你可以将参数 query_cache_type 设置成 DEMAND，这样对于默
认的 SQL 语句都不使用查询缓存。而对于你确定要使用查询缓存的语句，可以用 SQL_CACHE 显式指定，像下面这
个语句一样：
需要注意的是，MySQL 8.0 版本直接将查询缓存的整块功能删掉了，也就是说 8.0 开始彻底没有这个功能了。

分析器

如果没有命中查询缓存，就要开始真正执行语句了。首先，MySQL 需要知道你要做什么，因此需要对 SQL 语句做解
析。
分析器先会做“词法分析”。你输入的是由多个字符串和空格组成的一条 SQL 语句，MySQL 需要识别出里面的字符
串分别是什么，代表什么。
MySQL 从你输入的"select"这个关键字识别出来，这是一个查询语句。它也要把字符串“T”识别成“表名 T”，
把字符串“ID”识别成“列 ID”。
做完了这些识别以后，就要做“语法分析”。根据词法分析的结果，语法分析器会根据语法规则，判断你输入的这个
SQL 语句是否满足 MySQL 语法。
如果你的语句不对，就会收到“You have an error in your SQL syntax”的错误提醒，比如下面这个语句
select 少打了开头的字母“s”。

1 

mysql> select SQL_CACHE * from T where ID=10

；

开课吧

java

高级架构师

一般语法错误会提示第一个出现错误的位置，所以你要关注的是紧接“use near”的内容。

优化器

经过了分析器，MySQL 就知道你要做什么了。在开始执行之前，还要先经过优化器的处理。
优化器是在表里面有多个索引的时候，决定使用哪个索引；或者在一个语句有多表关联（join）的时候，决定各个
表的连接顺序。比如你执行下面这样的语句，这个语句是执行两个表的 join：
既可以先从表 t1 里面取出 c=10 的记录的 ID 值，再根据 ID 值关联到表 t2，再判断 t2 里面 d 的值是
否等于 20。
也可以先从表 t2 里面取出 d=20 的记录的 ID 值，再根据 ID 值关联到 t1，再判断 t1 里面 c 的值是否
等于 10。
这两种执行方法的逻辑结果是一样的，但是执行的效率会有不同，而优化器的作用就是决定选择使用哪一个方案。
优化器阶段完成后，这个语句的执行方案就确定下来了，然后进入执行器阶段。如果你还有一些疑问，比如优化器是
怎么选择索引的，有没有可能选择错等等，没关系，我会在后面的文章中单独展开说明优化器的内容。

执行器

MySQL 通过分析器知道了你要做什么，通过优化器知道了该怎么做，于是就进入了执行器阶段，开始执行语句。
开始执行的时候，要先判断一下你对这个表 T 有没有执行查询的权限，如果没有，就会返回没有权限的错误，如下
所示 (在工程实现上，如果命中查询缓存，会在查询缓存返回结果的时候，做权限验证。查询也会在优化器之前调用
precheck 验证权限)。
如果有权限，就打开表继续执行。打开表的时候，执行器就会根据表的引擎定义，去使用这个引擎提供的接口。
比如我们这个例子中的表 T 中，ID 字段没有索引，那么执行器的执行流程是这样的：
\1. 调用 InnoDB 引擎接口取这个表的第一行，判断 ID 值是不是 10，如果不是则跳过，如果是则将这行存在结
果集中；
\2. 调用引擎接口取“下一行”，重复相同的判断逻辑，直到取到这个表的最后一行。
\3. 执行器将上述遍历过程中所有满足条件的行组成的记录集作为结果集返回给客户端。
至此，这个语句就执行完成了。

详细执行流程图

mysql> elect * 

from 

t 

where 

ID=

1

;
ERROR 

1064 

(

42000

): You have an error 

in 

your 

SQL 

syntax; 

check 

the manual that
corresponds 

to 

your MySQL 

server 

version 

for 

the 

right 

syntax 

to use 

near 

'elect *
from t where ID=1' 

at 

line 

1

1 2 3
1 

mysql> 

select 

\* 

from 

t1 

join 

t2 

using

(ID) 

where 

t1

.c

=

10 

and 

t2

.d

=

20

;
mysql> 

select 

\* 

from 

T 

where 

ID=

10

;
ERROR 

1142 

(

42000

): 

SELECT 

command denied 

to user 

'b'

@'localhost' for table 'T'

1 2 3

开课吧

java

高级架构师

物理结构

MySQL是通过文件系统对数据和索引进行存储的。
MySQL从物理结构上可以分为日志文件和数据索引文件。
MySQL在Linux中的数据索引文件和日志文件都在

/var/lib/mysql

目录下。

日志文件（顺序IO）

开课吧

java

高级架构师

MySQL通过日志记录了数据库操作信息和错误信息。常用的日志文件包括

错误日志、二进制日志、查询日志、慢查询
日志和事务Redo 日志、中继日志

等。
可以通过命令查看当前数据库中的日志使用信息：

错误日志（err log）

默认是开启的，而且从5.5.7以后无法关闭错误日志，

错误日志记录了运行过程中

遇到的所有严重的错误信息

,以及
MySQL

每次启动和关闭的详细信息

。
默认的错误日志名称：hostname.err。
错误日志所记录的信息是可以通过

log-error和log-warnings

来定义的，其中log-err是定义是否启用错误日志的
功能和错误日志的存储位置，log-warnings是定义是否将警告信息也定义至错误日志中。

二进制日志（bin log）

默认是关闭的，需要通过配置：
进行开启。其中mysql-bin是binlog日志文件的basename，binlog日志文件的名称：mysql-bin-000001.log
binlog记录了

数据库所有的ddl语句和dml语句

，但不包括select语句内容，语句以事件的形式保存，描述了数据
的变更顺序，binlog还包括了每个更新语句的执行时间信息，binlog主要作用是用于恢复数据，因此binlog对于灾
难恢复和备份恢复来说至关重要。
如果是DDL语句，则直接记录到binlog日志，而

DML语句，必须通过事务提交才能记录到binlog日志中

。
binlog主要用于

实现mysql主从复制、数据备份、数据恢复。

通用查询日志（general query log）

默认情况下通用查询日志是关闭的。

由于通用查询日志会记录用户的所有操作，其中还包含增删查改等信息，在并发操作大的环境下会产生大量的信息从
而导致不必要的磁盘IO，会影响mysql的性能的。如若不是为了调试数据库的目的

建议不要开启查询日志。

慢查询日志（slow query log）

1 

mysql> show variables like 'log_%';
log_error

可以直接定义为文件路径，也可以为

ON|OFF

；

log_warings

只能使用

1|0

来定义开关启动

1 2 3
1 

log-bin=mysql-bin

开课吧

java

高级架构师

默认是关闭的。

需要通过以下设置进行开启：
记录执行时间超过

long_query_time

秒的所有查询，便于收集查询时间比较长的SQL语句

事务日志（redo /undo log）

\* 事务日志（InnoDB特有的日志）也叫redo日志。
\* 文件名为"ib_logfile0"和“ib_logfile1”，默认存放在表空间所在目录。
\* 还有一个日志文件叫undo 日志，默认存储在ib_data目录下。

中继日志（relay log）

\* 是在主从复制环境中产生的日志。
\* 主要作用是为了从机可以从中继日志中获取到主机同步过来的SQL语句，然后执行到从机中。

数据文件（随机IO）

查看MySQL数据文件：

InnoDB数据文件

.frm文件：

主要存放与表相关的数据信息,主要包括

表结构的定义信息
.ibd：

使用

独享表空间

存储

表数据和索引

信息，一张表对应一个ibd文件。

ibdata文件：

使用

共享表空间

存储

表数据和索引

信息，所有表共同使用一个或者多个ibdata文件。

MyIsam数据文件

.frm文件：

主要存放与表相关的数据信息,主要包括

表结构的定义信息
.myd文件：

主要用来存储

表数据信息

。

.myi文件：

主要用来存储

表数据文件中任何索引的数据树。

MySQL高级篇

相关术语介绍

多版本并发控制

slow_query_log=ON
long_query_time=10

1 2
1 

SHOW VARIABLES LIKE ‘%datadir%’;

开课吧

java

高级架构师

MySQL InnoDB存储引擎，实现的是基于多版本的并发控制协议——

MVCC 

( 

Multi

\-

Version Concurrency
Control 

)(注：与MVCC相对的，是基于锁的并发控制， 

Lock

\-

Based Concurrency Control 

)。MVCC最大的好处，
相信也是耳熟能详：

读不加锁，读写不冲突

。在读多写少的OLTP应用中，读写不冲突是非常重要的，极大的增加了
系统的并发性能，这也是为什么现阶段，几乎所有的RDBMS，都支持了MVCC。

当前读和快照读

在MVCC并发控制中，读操作可以分成两类：

快照读 (snapshot read)与当前读 (current read)。

快照读，读取的是记录的可见版本 (有可能是历史版本)，不用加锁。
当前读，读取的是记录的最新版本，并且，当前读返回的记录，都会加上锁，保证其他事务不会再并发修改这
条记录。
在一个支持MVCC并发控制的系统中，哪些读操作是快照读？哪些操作又是当前读呢？以MySQL InnoDB为例：

快照读：

简单的select操作，属于快照读，不加锁。(当然，也有例外，下面会分析)

当前读：

特殊的读操作，插入/更新/删除操作，

属于当前读，需要加锁

。
所有以上的语句，都属于当前读，读取记录的最新版本。并且，读取之后，还需要保证其他并发事务不能修改当前记
录，对读取记录加锁。
为什么将 插入/更新/删除 操作，都归为当前读？可以看看下面这个 更新 操作，在数据库中的执行流程：

1 

select 

\* 

from table where 

?;

select 

\* 

from table where 

? 

lock in share mode

;//

共享锁（

S

）

select 

\* 

from table where 

? 

for update

;//

排他锁

(X)

insert into table values 

(…) ; //

排他锁

(X)

update table set 

? 

where 

? 

; //

排他锁

(X)

delete from table where 

? 

; //

排他锁

(X)

1 2 3 4 5

开课吧

java

高级架构师

从图中，可以看到，一个Update操作的具体流程。当Update SQL被发给MySQL后，MySQL Server会根据where条
件，读取第一条满足条件的记录，然后InnoDB引擎会将第一条记录返回，并加锁 (current read)。待MySQL
Server收到这条加锁的记录之后，会再发起一个Update请求，更新这条记录。一条记录操作完成，再读取下一条记
录，直至没有满足条件的记录为止。因此，Update操作内部，就包含了一个当前读。同理，Delete操作也一样。
Insert操作会稍微有些不同，简单来说，就是Insert操作可能会触发Unique Key的冲突检查，也会进行一个当前
读。

注

：

聚集索引

Cluster Index：聚簇索引。
InnoDB存储引擎的数据组织方式，是聚簇索引表：完整的记录，存储在主键索引中，通过主键索引，就可以获取记
录所有的列。关于聚簇索引表的组织方式，可以参考MySQL的官方文档：

Clustered and Secondary Indexes 

。
本课程就不再做具体的介绍。接下来的部分，主键索引/聚簇索引 两个名称，会有一些混用，望读者知晓。

最左前缀原则

顾名思义，就是最左优先，这个最左是针对于组合索引和前缀索引，理解如下：

根据上图的交互，针对一条当前读的

SQL

语句，

InnoDB

与

MySQL Server

的交互，是一条一条进行的，因此，加锁也
是一条一条进行的。先对一条满足条件的记录加锁，返回给

MySQL Server

，做一些

DML

操作；然后在读取下一条加
锁，直至读取完毕。

1

开课吧

java

高级架构师

\1. 最左前缀匹配原则，非常重要的原则，mysql会一直向右匹配直到遇到范围查询(>、<、between、like)就停
止匹配，比如a = 1 and b = 2 and c > 3 and d = 4 如果建立(a,b,c,d)顺序的索引，d是用不到索引
的，如果建立(a,b,d,c)的索引则都可以用到，a,b,d的顺序可以任意调整。
\2. =和in可以乱序，比如a = 1 and b = 2 and c = 3 建立(a,b,c)索引可以任意顺序，mysql的查询优化器会
帮你优化成索引可以识别的形式

两阶段锁

传统RDBMS加锁的一个原则，就是2PL (Two-Phase Locking，二阶段锁)。相对而言，2PL比较容易理解，说的是锁
操作分为两个阶段：加锁阶段与解锁阶段，并且保证加锁阶段与解锁阶段不相交。下面，仍旧以MySQL为例，来简单
看看2PL在MySQL中的实现。
从上图可以看出，2PL就是将加锁/解锁分为两个完全不相交的阶段。

隔离级别

MySQL/InnoDB定义的4种隔离级别：

加锁阶段：只加锁，不放锁。
解锁阶段：只放锁，不加锁。

1 2 3

开课吧

java

高级架构师

Read Uncommited
Read Committed (RC)
Repeatable Read (RR)
Serializable

Gap锁和Next-Key锁

InnoDB中的完整行锁包含三部分：记录锁（Record Lock）、间隙锁（Gap Lock）、Next-Key Lock。
以下定义摘自MySQL官方文档

记录锁（Record Locks）:记录锁锁定索引中一条记录。
间隙锁（Gap Locks）:间隙锁要么锁住索引记录中间的值，要么锁住第一个索引记录前面的值或者最后
一个索引记录后面的值。
Next-Key Locks:Next-Key锁是索引记录上的记录锁和在索引记录之前的间隙锁的组合。

行锁原理分析

一条简单SQL的加锁分析

在介绍完一些背景知识之后，接下来将选择几个有代表性的例子，来详细分析MySQL的加锁处理。当然，还是从最简
单的例子说起。经常有朋友发给我一个SQL，然后问我，这个SQL加什么锁？就如同下面两条简单的SQL，他们加什么
锁？
SQL1：
SQL2：

1 

可以读取未提交记录。此隔离级别，不会使用，忽略。
快照读忽略，本文不考虑。
针对当前读，

RC

隔离级别保证对读取到的记录加锁 

(

记录锁

)

，存在幻读现象。

1 2 3

快照读忽略，本文不考虑。
针对当前读，

RR

隔离级别保证对读取到的记录加锁 

(

记录锁

)

，同时保证对读取的范围加锁，新的满足查询条件
的记录不能够插入 

(

间隙锁

)

，不存在幻读现象。

1 2 3

从

MVCC

并发控制退化为基于锁的并发控制。不区别快照读与当前读，所有的读操作均为当前读，读加读锁 

(S

锁

)

，写加写锁 

(X

锁

)

。

Serializable

隔离级别下，读写冲突，因此并发度急剧下降，在

MySQL/InnoDB

下不建议使用。

1 2 3
1 

select 

\* 

from 

t1 

where 

id = 

10

;

开课吧

java

高级架构师

针对这个问题，该怎么回答？能想象到的一个答案是：
SQL1：

不加锁

。因为MySQL是使用多版本并发控制的，读不加锁。
SQL2：对id = 10的记录

加写锁 

(走主键索引)。
这个答案对吗？说不上来。即可能是正确的，也有可能是错误的，已知条件不足，这个问题没有答案。必须还要知道
以下的一些前提，前提不同，能给出的答案也就不同。要回答这个问题，还缺少哪些前提条件？

前提一：

id列是不是主键？

前提二：

当前系统的隔离级别是什么？

前提三：

id列如果不是主键，那么id列上有索引吗？

前提四：

id列上如果有二级索引，那么这个索引是唯一索引吗？

前提五：

两个SQL的执行计划是什么？索引扫描？全表扫描？
没有这些前提，直接就给定一条SQL，然后问这个SQL会加什么锁，都是很业余的表现。而当这些问题有了明确的答
案之后，给定的SQL会加什么锁，也就一目了然。下面，我们将这些问题的答案进行组合，然后按照从易到难的顺
序，逐个分析每种组合下，对应的SQL会加哪些锁？

注：

下面的这些组合，需要做一个前提假设，也就是有索引时，执行计划一定会选择使用索引进行过滤 (索引扫
描)。但实际情况会复杂很多，真正的执行计划，还是需要根据MySQL输出的为准。
排列组合还没有列举完全，但是看起来，已经很多了。真的有必要这么复杂吗？事实上，要分析加锁，就是需要这么
复杂。但是从另一个角度来说，只要你选定了一种组合，SQL需要加哪些锁，其实也就确定了。接下来，就让我们来
逐个分析这9种组合下的SQL加锁策略。
注：在前面八种组合下，也就是RC，RR隔离级别下SQL1：select操作均不加锁，采用的是快照读，因此在下面的讨
论中就忽略了，

主要讨论SQL2：delete操作的加锁

。

1 

delete from 

t1 

where 

id = 

10

;

组合一：

id

列是主键，

RC

隔离级别
组合二：

id

列是二级唯一索引，

RC

隔离级别
组合三：

id

列是二级非唯一索引，

RC

隔离级别
组合四：

id

列上没有索引，

RC

隔离级别
组合五：

id

列是主键，

RR

隔离级别
组合六：

id

列是二级唯一索引，

RR

隔离级别
组合七：

id

列是二级非唯一索引，

RR

隔离级别
组合八：

id

列上没有索引，

RR

隔离级别
组合九：

Serializable

隔离级别

1 2 3 4 5 6 7 8 9
10
11
12
13
14
15
16
17

开课吧

java

高级架构师

组合一：id主键+RC

这个组合，是最简单，最容易分析的组合。id是主键，Read Committed隔离级别，给定SQL：delete from t1
where id = 10; 只需要将主键上id = 10的记录加上X锁即可。如下图所示：

结论：

组合二：id唯一索引+RC

这个组合，id不是主键，而是一个Unique的二级索引键值。那么在RC隔离级别下，delete from t1 where id =
10; 需要加什么锁呢？见下图：

1 

id

是主键时，此

SQL

只需要在

id=10

这条记录上加

X

锁即可。

开课吧

java

高级架构师

开课吧

java

高级架构师

此组合中，id是unique索引，而主键是name列。此时，加锁的情况由于组合一有所不同。由于id是unique索引，因
此delete语句会选择走id列的索引进行where条件的过滤，在找到id=10的记录后，首先会将unique索引上的id=10
索引记录加上X锁，同时，会根据读取到的name列，回主键索引(聚簇索引)，然后将聚簇索引上的name = ‘d’ 对
应的主键索引项加X锁。为什么聚簇索引上的记录也要加锁？试想一下，如果并发的一个SQL，是通过主键索引来更
新：update t1 set id = 100 where name = ‘d’; 此时，如果delete语句没有将主键索引上的记录加锁，那
么并发的update就会感知不到delete语句的存在，违背了同一记录上的更新/删除需要串行执行的约束。

结论

：

组合三：id非唯一索引+RC

相对于组合一、二，组合三又发生了变化，隔离级别仍旧是RC不变，但是id列上的约束又降低了，id列不再唯一，
只有一个普通的索引。假设delete from t1 where id = 10; 语句，仍旧选择id列上的索引进行过滤where条
件，那么此时会持有哪些锁？同样见下图：

若

id

列是

unique

列，其上有

unique

索引。那么

SQL

需要加两个

X

锁，一个对应于

id unique

索引上的

id = 10

的记
录，另一把锁对应于聚簇索引上的【

name=’d’,id=10

】的记录。

1

开课吧

java

高级架构师

根据此图，可以看到，首先，id列索引上，满足id = 10查询条件的记录，均已加锁。同时，这些记录对应的主键索
引上的记录也都加上了锁。与组合二唯一的区别在于，组合二最多只有一个满足等值查询的记录，而组合三会将所有
满足查询条件的记录都加锁。

结论

：

组合四：id无索引+RC

相对于前面三个组合，这是一个比较特殊的情况。id列上没有索引，where id = 10;这个过滤条件，没法通过索引
进行过滤，那么

只能走全表扫描做过滤

。对应于这个组合，SQL会加什么锁？或者是换句话说，全表扫描时，会加什
么锁？这个答案也有很多：有人说会在表上加X锁；有人说会将聚簇索引上，选择出来的id = 10;的记录加上X锁。
那么实际情况呢？请看下图：

若

id

列上有非唯一索引，那么对应的所有满足

SQL

查询条件的记录，都会被加锁。同时，这些记录在主键索引上的记
录，也会被加锁。

1

开课吧

java

高级架构师

由于id列上没有索引，因此只能走聚簇索引，进行全部扫描。从图中可以看到，满足删除条件的记录有两条，但是，
聚簇索引上所有的记录，都被加上了X锁。无论记录是否满足条件，全部被加上X锁。既不是加表锁，也不是在满足条
件的记录上加行锁。
有人可能会问？为什么不是只在满足条件的记录上加锁呢？这是由于MySQL的实现决定的。如果一个条件无法通过索
引快速过滤，那么存储引擎层面就会将所有记录加锁后返回，然后由MySQL Server层进行过滤。因此也就把所有的
记录，都锁上了。

注：

在实际的实现中，MySQL有一些改进，在MySQL Server过滤条件，发现不满足后，会调用unlock_row方法，把
不满足条件的记录放锁 (违背了2PL的约束)。这样做，保证了最后只会持有满足条件记录上的锁，但是每条记录的
加锁操作还是不能省略的。

结论：

组合五：id主键+RR

若

id

列上没有索引，

SQL

会走聚簇索引的全扫描进行过滤，由于过滤是由

MySQL Server

层面进行的。因此每条记录，
无论是否满足条件，都会被加上

X

锁。但是，为了效率考量，

MySQL

做了优化，对于不满足条件的记录，会在判断后放
锁，最终持有的，是满足条件的记录上的锁，但是不满足条件的记录上的加锁

/

放锁动作不会省略。同时，优化也违背
了

2PL

的约束。

1

开课吧

java

高级架构师

上面的四个组合，都是在Read Committed隔离级别下的加锁行为，接下来的四个组合，是在Repeatable Read隔离
级别下的加锁行为。
组合五，id列是主键列，Repeatable Read隔离级别，针对delete from t1 where id = 10; 这条SQL，加锁与
组合一：[

id主键，Read Committed

]一致。

组合六：id唯一索引+RR

与组合五类似，组合六的加锁，与组合二：[

id唯一索引，Read Committed

]一致。两个X锁，id唯一索引满足条件
的记录上一个，对应的聚簇索引上的记录一个。

组合七：id非唯一索引+RR

还记得前面提到的MySQL的四种隔离级别的区别吗？

RC隔离级别允许幻读，而RR隔离级别，不允许存在幻读。

但是
在组合五、组合六中，加锁行为又是与RC下的加锁行为完全一致。那么RR隔离级别下，如何防止幻读呢？问题的答
案，就在组合七中揭晓。
组合七，Repeatable Read隔离级别，id上有一个非唯一索引，执行delete from t1 where id = 10; 假设选择
id列上的索引进行条件过滤，最后的加锁行为，是怎么样的呢？同样看下面这幅图：

开课吧

java

高级架构师

开课吧

java

高级架构师

此图，相对于组合三：[

id列上非唯一锁，Read Committed

]看似相同，其实却有很大的区别。最大的区别在于，这
幅图中多了一个GAP锁，而且GAP锁看起来也不是加在记录上的，倒像是加载两条记录之间的位置，GAP锁有何用？
其实这个多出来的GAP锁，就是RR隔离级别，相对于RC隔离级别，不会出现幻读的关键。确实，GAP锁锁住的位置，
也不是记录本身，而是两条记录之间的GAP。所谓幻读，就是同一个事务，连续做两次当前读 (例如：select *
from t1 where id = 10 for update;)，那么这两次当前读返回的是完全相同的记录 (记录数量一致，记录本身
也一致)，第二次的当前读，不会比第一次返回更多的记录 (幻象)。
如何保证两次当前读返回一致的记录，那就需要在第一次当前读与第二次当前读之间，其他的事务不会插入新的满足
条件的记录并提交。为了实现这个功能，GAP锁应运而生。
如图中所示，有哪些位置可以插入新的满足条件的项 (id = 10)，考虑到B+树索引的有序性，满足条件的项一定是
连续存放的。记录[6,c]之前，不会插入id=10的记录；[6,c]与[10,b]间可以插入[10, aa]；[10,b]与[10,d]
间，可以插入新的[10,bb],[10,c]等；[10,d]与[11,f]间可以插入满足条件的[10,e],[10,z]等；而[11,f]之后
也不会插入满足条件的记录。因此，为了保证[6,c]与[10,b]间，[10,b]与[10,d]间，[10,d]与[11,f]不会插入
新的满足条件的记录，MySQL选择了用GAP锁，将这三个GAP给锁起来。

开课吧

java

高级架构师

Insert操作，如insert [10,aa]，首先会定位到[6,c]与[10,b]间，然后在插入前，会检查这个GAP是否已经被锁
上，如果被锁上，则Insert不能插入记录。因此，通过第一遍的当前读，不仅将满足条件的记录锁上 (X锁)，与组
合三类似。同时还是增加3把GAP锁，将可能插入满足条件记录的3个GAP给锁上，保证后续的Insert不能插入新的
id=10的记录，也就杜绝了同一事务的第二次当前读，出现幻象的情况。
有心的朋友看到这儿，可以会问：既然防止幻读，需要靠GAP锁的保护，为什么组合五、组合六，也是RR隔离级别，
却不需要加GAP锁呢？
首先，这是一个好问题。其次，回答这个问题，也很简单。GAP锁的目的，是为了防止同一事务的两次当前读，出现
幻读的情况。而组合五，id是主键；组合六，id是unique键，都能够保证唯一性。一个等值查询，最多只能返回一
条记录，而且新的相同取值的记录，一定不会在新插入进来，因此也就避免了GAP锁的使用。其实，针对此问题，还
有一个更深入的问题：如果组合五、组合六下，针对SQL：select * from t1 where id = 10 for update; 第
一次查询，没有找到满足查询条件的记录，那么GAP锁是否还能够省略？此问题留给大家思考。

结论：

组合八：id无索引+RR

组合八，Repeatable Read隔离级别下的最后一种情况，id列上没有索引。此时SQL：delete from t1 where id
= 10; 没有其他的路径可以选择，只能进行全表扫描。最终的加锁情况，如下图所示：

Repeatable Read

隔离级别下，

id

列上有一个非唯一索引，对应

SQL

：

delete from t1 where id = 10; 

首
先，通过

id

索引定位到第一条满足查询条件的记录，加记录上的

X

锁，加

GAP

上的

GAP

锁，然后加主键聚簇索引上的记
录

X

锁，然后返回；然后读取下一条，重复进行。直至进行到第一条不满足条件的记录

[11,f]

，此时，不需要加记录

X

锁，但是仍旧需要加

GAP

锁，最后返回结束。

1

开课吧

java

高级架构师

如图，这是一个很恐怖的现象。首先，聚簇索引上的所有记录，都被加上了X锁。其次，聚簇索引每条记录间的间隙
(GAP)，也同时被加上了GAP锁。这个示例表，只有6条记录，一共需要6个记录锁，7个GAP锁。试想，如果表上有
1000万条记录呢？
在这种情况下，这个表上，除了不加锁的快照度，其他任何加锁的并发SQL，均不能执行，不能更新，不能删除，不
能插入，全表被锁死。
当然，跟组合四：[

id无索引, Read Committed

]类似，这个情况下，MySQL也做了一些优化，就是所谓的semiconsistent read。semi-consistent read开启的情况下，对于不满足查询条件的记录，MySQL会提前放锁。针对
上面的这个用例，就是除了记录[d,10]，[g,10]之外，所有的记录锁都会被释放，同时不加GAP锁。semiconsistent read如何触发：要么是read committed隔离级别；要么是Repeatable Read隔离级别，同时设置了

innodb_locks_unsafe_for_binlog 

参数。

结论：

组合九：Serializable

在

Repeatable Read

隔离级别下，如果进行全表扫描的当前读，那么会锁上表中的所有记录，同时会锁上聚簇索引内
的所有

GAP

，杜绝所有的并发 更新

/

删除

/

插入 操作。当然，也可以通过触发

semi-consistent read

，来缓解加
锁开销与并发影响，但是

semi-consistent read

本身也会带来其他问题，不建议使用。

1

开课吧

java

高级架构师

针对前面提到的简单的SQL，最后一个情况：Serializable隔离级别。对于SQL2： 

delete from t1 where id =
10 

; 来说，Serializable隔离级别与Repeatable Read隔离级别完全一致，因此不做介绍。
Serializable隔离级别，影响的是SQL1： 

select * from t1 where id = 10 

; 这条SQL，在RC，RR隔离级别
下，都是快照读，不加锁。但是在Serializable隔离级别，SQL1会加读锁，也就是说快照读不复存在，

MVCC并发控
制降级为Lock-Based CC

。

结论：

一条复杂SQL的加锁分析

写到这里，其实MySQL的加锁实现也已经介绍的八八九九。只要将本文上面的分析思路，大部分的SQL，都能分析出
其会加哪些锁。而这里，再来看一个稍微复杂点的SQL，用于说明MySQL加锁的另外一个逻辑。SQL用例如下：
如图中的SQL，会加什么锁？假定在Repeatable Read隔离级别下 (Read Committed隔离级别下的加锁情况，留给
学生们分析)，同时，假设SQL走的是idx_t1_pu索引。

在

MySQL/InnoDB

中，所谓的读不加锁，并不适用于所有的情况，而是隔离级别相关的。

Serializable

隔离级别，
读不加锁就不再成立，所有的读操作，都是当前读。

1

开课吧

java

高级架构师

在详细分析这条SQL的加锁情况前，还需要有一个知识储备，那就是一个SQL中的where条件如何拆分？在这里，我直
接给出分析后的结果：

Index key：

pubtime > 1 and puptime < 20。此条件，用于确定SQL在idx_t1_pu索引上的查询范围。

Index Filter：

userid = ‘hdc’ 。此条件，可以在idx_t1_pu索引上进行过滤，但不属于Index Key。

Table Filter：

comment is not NULL。此条件，在idx_t1_pu索引上无法过滤，只能在聚簇索引上过滤。
在分析出SQL where条件的构成之后，再来看看这条SQL的加锁情况 (RR隔离级别)，如下图所示：
从图中可以看出，在Repeatable Read隔离级别下，由Index Key所确定的范围，被加上了GAP锁；Index Filter
锁给定的条件 (userid = ‘hdc’)何时过滤，视MySQL的版本而定，在MySQL 5.6版本之前，不支持

Index
Condition Pushdown

(ICP)，因此Index Filter在MySQL Server层过滤，在5.6后支持了Index Condition
Pushdown，则在index上过滤。若不支持ICP，不满足Index Filter的记录，也需要加上记录X锁，若支持ICP，则
不满足Index Filter的记录，无需加记录X锁 (图中，用红色箭头标出的X锁，是否要加，视是否支持ICP而定)；而
Table Filter对应的过滤条件，则在聚簇索引中读取后，在MySQL Server层面过滤，因此聚簇索引上也需要X锁。
最后，选取出了一条满足条件的记录[8,hdc,d,5,good]，但是加锁的数量，要远远大于满足条件的记录数量。

结论：

开课吧

java

高级架构师

死锁原理与分析

本文前面的部分，基本上已经涵盖了MySQL/InnoDB所有的加锁规则。深入理解MySQL如何加锁，有两个比较重要的
作用：
可以根据MySQL的加锁规则，写出不会发生死锁的SQL；
可以根据MySQL的加锁规则，定位出线上产生死锁的原因；
下面，来看看两个死锁的例子 (一个是两个Session的两条SQL产生死锁；另一个是两个Session的一条SQL，产生死
锁)：

在

Repeatable Read

隔离级别下，针对一个复杂的

SQL

，首先需要提取其

where

条件。

\- Index Key

确定的范围，需要加上

GAP

锁；

\- Index Filter

过滤条件，视

MySQL

版本是否支持

ICP

，若支持

ICP

，则不满足

Index Filter

的记录，不加

X

锁，否则需要

X

锁；

\- Table Filter

过滤条件，无论是否满足，都需要加

X

锁。

1 2 3 4

开课吧

java

高级架构师

上面的两个死锁用例。第一个非常好理解，也是最常见的死锁，每个事务执行两条SQL，分别持有了一把锁，然后加
另一把锁，产生死锁。
第二个用例，虽然每个Session都只有一条语句，仍旧会产生死锁。要分析这个死锁，首先必须用到本文前面提到的
MySQL加锁的规则。针对Session 1，从name索引出发，读到的[hdc, 1]，[hdc, 6]均满足条件，不仅会加name索
引上的记录X锁，而且会加聚簇索引上的记录X锁，加锁顺序为先[1,hdc,100]，后[6,hdc,10]。而Session 2，从
pubtime索引出发，[10,6],[100,1]均满足过滤条件，同样也会加聚簇索引上的记录X锁，加锁顺序为
[6,hdc,10]，后[1,hdc,100]。发现没有，跟Session 1的加锁顺序正好相反，如果两个Session恰好都持有了第
一把锁，请求加第二把锁，死锁就发生了。

结论：
如何解决死锁呢？

MySQL默认会主动探知死锁，并回滚某一个影响最小的事务。等另一事务执行完成之后，再重新执行该事务。

原理分析总结

要做到完全掌握MySQL/InnoDB的加锁规则，甚至是其他任何数据库的加锁规则，需要具备以下的一些知识点：
了解数据库的一些基本理论知识：数据的存储格式 (堆组织表 vs 聚簇索引表)；并发控制协议 (MVCC vs
Lock-Based CC)；Two-Phase Locking；数据库的隔离级别定义 (Isolation Level)；
了解SQL本身的执行计划 (主键扫描 vs 唯一键扫描 vs 范围扫描 vs 全表扫描)；

死锁的发生与否，并不在于事务中有多少条

SQL

语句，【死锁的关键在于】：两个

(

或以上

)

的

Session

【加锁的顺序】
不一致。而使用本文上面提到的，分析

MySQL

每条

SQL

语句的加锁规则，分析出每条语句的加锁顺序，然后检查多个并
发

SQL

间是否存在以相反的顺序加锁的情况，就可以分析出各种潜在的死锁情况，也可以分析出线上死锁发生的原因。

1

开课吧

java

高级架构师

了解数据库本身的一些实现细节 (过滤条件提取；Index Condition Pushdown；Semi-Consistent Read)；
了解死锁产生的原因及分析的方法 (加锁顺序不一致；分析每个SQL的加锁顺序)

事务流程分析

接下来我就以update为例，讲解下MySQL5.6的innodb的事务流程，总结起来就是：
SQL语句如下：

1 

update user set 

name=

'zhange' 

where 

id=

2

;

开课吧

java

高级架构师

深色步骤是在MySQL的SQL Layer层实现
浅色步骤是在MySQL的存储引擎层实现

开课吧

java

高级架构师

事务日志文件redo和undo

总起来概述可以认为：
undo用来保存数据更改之前的数据；保证一致性
redo用来保存数据更改之后的数据（注意是物理的修改信息），保证原子性、持久性
1）首先介绍Undo Log
Undo Log 主要是为了实现事务的一致性，在MySQL数据库InnoDB存储引擎中，还用Undo Log来实现多版本并发控
制(简称：MVCC)，之后的文章将会介绍MVCC；
Undo Log的原理很简单，为了满足事务的一致性，在操作任何数据之前，首先将数据备份到一个地方，也就是 Undo
Log，然后进行数据的修改。如果出现了错误或者用户执行了ROLLBACK语句，系统可以利用Undo Log中的备份将数
据恢复到事务开始之前的状态。
需要注意在MySQL 5.6之前，undo log是放在了共享表空间 ibdata1中的，MySQL5.6中开始支持把undo log分离
到独立的表空间，并放到单独的文件目录下；采用独立undo表空间，再也不用担心undo会把 ibdata1 文件搞大。
undo log是为回滚而用，具体内容就是copy事务前的数据库内容（行）到innodb_buffer_pool中的undo
buffer（或者叫undo page)，在适合的时间把undo buffer中的内容刷新到磁盘。undo buffer与redo buffer一
样，也是环形缓冲，但当缓冲满的时候，undo buffer中的内容也会被刷新到磁盘；并且innodb_purge_threads后
台线程会清空undo页、清理“deleted”page，InnoDB将Undo Log看作数据，因此记录Undo Log的操作也会记录
到redo log中。这样undo log就可以象数据一样缓存起来
2）接下来介绍 Redo Log,注意是先写redo,然后才修改buffer cache中的页，因为修改是以页为单位的，所以先
写redo才能保证一个大事务commit的时候，redo已经刷新的差不多了。反过来说假如是先改buffer cache中的
页，然后再写redo，就可能会有很多的redo需要写，因为一个页可能有很多数据行；而很多数据行产生的redo也可
能比较多，那么commit的时候，就可能会有很多redo需要写；
和Undo Log相反，Redo Log记录的是新数据的备份。在事务提交前，只要将Redo Log持久化即可，
不需要将数据持久化。当系统崩溃时，虽然数据没有持久化，但是Redo Log已经持久化。系统可以根据Redo Log的
内容，将所有数据恢复到最新的状态。需要注意的是，事务过程中，先把redo写进redo log buffer中，然后
MySQL后台进程page cleaner thread适当的去刷新redo到低层磁盘永久保存；

索引分析

索引的存储结构

索引存储结构

索引是在

存储引擎中实现

的，也就是说不同的存储引擎，会使用不同的索引

MyISAM和InnoDB存储引擎

：只支持

BTREE索引

， 也就是说

默认使用BTREE，不能够更换

MEMORY/HEAP存储引擎：支持HASH和BTREE索引

B树和B+树

数据结构示例网站：

https://www.cs.usfca.edu/~galles/visualization/Algorithms.html

B树图示

开课吧

java

高级架构师

B树是为了磁盘或其它存储设备而设计的一种多叉（下面你会看到，相对于二叉，B树每个内结点有多个分支，即多
叉）平衡查找树。
B树的高度一般都是在2-4这个高度，树的高度直接影响IO读写的次数。
如果是三层树结构---支撑的数据可以达到20G，如果是四层树结构---支撑的数据可以达到几十T

B树和B+树的区别

B树和B+树的最大区别在于

非叶子节点是否存储数据

的问题。

非聚集索引（MyISAM）

B+树叶子节点只会存储数据行（数据文件）的指针，简单来说

数据和索引不在一起

，就是非聚集索引。

非聚集索引包含主键索引和辅助索引都会存储指针的值
主键索引

\- B

树是非叶子节点和叶子节点都会存储数据。

\- B+

树只有叶子节点才会存储数据，而且存储的数据都是在一行上，而且这些数据都是有指针指向的，也就是有顺序
的。

1 2

开课吧

java

高级架构师

这里设表一共有三列,假设我们以 Col1 为主键,则上图是一个 MyISAM 表的主索引(Primary key)示意。可以看出
MyISAM 的索引文件仅仅保存数据记录的地址。

辅助索引（次要索引）

在 MyISAM 中,主索引和辅助索引(Secondary key)在结构上没有任何区别,只是主索引要求 key 是唯一的,而辅助
索引的 key 可以重复。如果我们在 Col2 上建立一个辅助索引,则此索引的结构如下图所示

开课吧

java

高级架构师

同样也是一颗 B+Tree,data 域保存数据记录的地址。

因此,MyISAM 中索引检索的算法为首先按照 B+Tree 搜索
算法搜索索引,如果指定的 Key 存在,则取出其data 域的值,然后以 data 域的值为地址,读取相应数据记录。

聚集索引（InnoDB）

主键索引（聚集索引）的叶子节点会存储数据行，

也就是说数据和索引是在一起，这就是聚集索引。

辅助索引只会存储主键值
如果没有没有主键，则使用唯一索引建立聚集索引；如果没有唯一索引，MySQL会按照一定规则创建聚集索引。

主键索引

1.InnoDB 要求表必须有主键(MyISAM 可以没有),如果没有显式指定,则 MySQL系统会自动选择一个可以唯一标识
数据记录的列作为主键,如果不存在这种列,则MySQL 自动为 InnoDB 表生成一个隐含字段作为主键,类型为长整
形。

开课吧

java

高级架构师

上图是 InnoDB 主索引(同时也是数据文件)的示意图,可以看到叶节点包含了完整的数据记录。这种索引叫做聚集索
引。因为 InnoDB 的数据文件本身要按主键聚集,

辅助索引（次要索引）

2.第二个与 MyISAM 索引的不同是 InnoDB 的辅助索引 data 域存储相应记录主键的值而不是地址。换句话
说,InnoDB 的所有辅助索引都引用主键作为 data 域。
聚集索引这种实现方式使得按主键的搜索十分高效,但是辅助索引搜索需要检索两遍索引:首先检索辅助索引获得主
键,然后用主键到主索引中检索获得记录。

开课吧

java

高级架构师

引申:为什么不建议使用过长的字段作为主键?

因为所有辅助索引都引用主索引,过长的主索引会令辅助索引变得过大。

同时,请尽量在 InnoDB 上采用自增字段做表的主键。

| MyISAM和InnoDB的存储结构图示                                 |
| ------------------------------------------------------------ |
| 为了更形象说明这两种索引的区别, 我们假想一个表如下图存储了 4 行数据。 其中Id 作为主索引, Name 作为辅 |
| 助索引。 图示清晰的显示了聚簇索引和非聚簇索引的差异：        |

开课吧

java

高级架构师

为什么使用组合索引

为了节省mysql索引存储空间以及提升搜索性能

，可建立组合索引（

能使用组合索引就不使用单列索引

）

例如：

开课吧

java

高级架构师

创建组合索引（相当于建立了col1,col1 col2,col1 col2 col3三个索引）：

哪些情况需要创建索引

1. 主键自动建立唯一索引
2. 频繁作为查询条件的字段应该创建索引
3. 多表关联查询中，关联字段应该创建索引
4. 查询中排序的字段，应该创建索引
5. 查询中统计或者分组字段，应该创建索引

哪些情况不需要创建索引

\1. 表记录太少
\2. 经常进行增删改操作的表
\3. 频繁更新的字段
\4. where条件里使用频率不高的字段

索引失效分析

案例环境

1 

ALTER TABLE 

'table_name' 

ADD INDEX 

index_name(

'col1'

,

'col2'

,

'col3'

）

mysql

创建组合索引的规则是首先会对组合索引的最左边的，也就是第一个

name

字段的数据进行排序，在第一个字段
的排序基础上，然后再对后面第二个的

cid

字段进行排序。其实就相当于实现了类似 

order by name cid

这样一种
排序规则。

1

开课吧

java

高级架构师

案例演示

1.全值匹配我最爱

开课吧

java

高级架构师

2.最佳左前缀法则

如果索引了多个列，要遵守最佳左前缀法则。指的是查询从索引的最左前列开始 并且不跳过索引中的列。 正确的示
例参考上图。

错误的示例：

带头索引死：
中间索引断（带头索引生效，其他索引失效）：

3.不要在索引上做计算

1 

带头索引不能死，中间索引不能断

1 

不要进行这些操作：计算、函数、自动

/

手动类型转换，不然会导致索引失效而转向全表扫描

开课吧

java

高级架构师

4.范围条件右边的列失效
5.尽量使用覆盖索引
6.索引字段上不要使用不等

1 

不能继续使用索引中范围条件（

bettween

、

<

、

\>

、

in

等）右边的列

1 

尽量使用覆盖索引（只查询索引的列），也就是索引列和查询列一致，减少

select *

1 

索引字段上使用（！

= 

或者 

< >

）判断时，会导致索引失效而转向全表扫描

开课吧

java

高级架构师

7.索引字段上不要判断null
8.索引字段使用like不以通配符开头

由结果可知，like以通配符结束相当于范围查找，索引不会失效。与范围条件（bettween、<、>、in等）不同的
是：不会导致右边的索引失效。

1 

索引字段上使用 

is null / is not null 

判断时，会导致索引失效而转向全表扫描

1 

索引字段使用

like

以通配符开头（

‘%

字符串

’

）时，会导致索引失效而转向全表扫描

开课吧

java

高级架构师

问题：解决like ‘%字符串%’时，索引失效问题的方法？ 

使用覆盖索引可以解决。

9.索引字段字符串要加单引号
10.索引字段不要使用or

总结

1 

索引字段是字符串，但查询时不加单引号，会导致索引失效而转向全表扫描

1 

索引字段使用 

or 

时，会导致索引失效而转向全表扫描

开课吧

java

高级架构师

InnoDB一致性非锁定读

一致性非锁定读(consistent nonlocking read)是指InnoDB存储引擎通过多版本控制(MVVC)读取当前数据库中
行数据的方式。如果读取的行正在执行DELETE或UPDATE操作，这时读取操作不会因此去等待行上锁的释放。相反
地，InnoDB会去读取行的一个快照。

开课吧

java

高级架构师

上图直观地展现了InnoDB一致性非锁定读的机制。之所以称其为非锁定读，是因为不需要等待行上排他锁的释
放。快照数据是指该行的之前版本的数据，每行记录可能有多个版本，一般称这种技术为行多版本技术。
由此带来的并发控制，称之为多版本并发控制(Multi Version Concurrency Control, MVVC)。InnoDB是通过
undo log来实现MVVC。undo log本身用来在事务中回滚数据，因此快照数据本身是没有额外开销。此外，读取快照
数据是不需要上锁的，因为没有事务需要对历史的数据进行修改操作。
一致性非锁定读是InnoDB默认的读取方式，即读取不会占用和等待行上的锁。但是并不是在每个事务隔离级别下
都是采用此种方式。此外，即使都是使用一致性非锁定读，但是对于快照数据的定义也各不相同。
在事务隔离级别READ COMMITTED和REPEATABLE READ下，InnoDB使用一致性非锁定读。然而，对于快照数据的
定义却不同。在READ COMMITTED事务隔离级别下，一致性非锁定读总是读取被锁定行的最新一份快照数据。而在
REPEATABLE READ事务隔离级别下，则读取事务开始时的行数据版本。
我们下面举个例子来详细说明一下上述的情况。
我们首先在会话A中显示地开启一个事务，然后读取test表中的id为1的数据，但是事务并没有结束。于此同时，
用户在开启另一个会话B，这样可以模拟并发的操作，然后对会话B做出如下的操作：
在会话B的事务中，将test表中id为1的记录修改为id=3，但是事务同样也没有提交，这样id=1的行其实加了一个
排他锁。由于InnoDB在READ COMMITTED和REPEATABLE READ事务隔离级别下使用一致性非锁定读，这时如果会话A
再次读取id为1的记录，仍然能够读取到相同的数据。此时，READ COMMITTED和REPEATABLE READ事务隔离级别没
有任何区别。

\# session A
mysql> BEGIN;
mysql> SELECT * FROM test WHERE id = 1;

1 2 3

\# session B
mysql> BEGIN;
mysql> UPDATE test SET id = 3 WHERE id = 1;

1 2 3

开课吧

java

高级架构师

会话A和会话B示意图
如上图所示，当会话B提交事务后，会话A再次运行 

SELECT * FROM test WHERE id = 1 

的SQL语句时，两个事务
隔离级别下得到的结果就不一样了。 对于READ COMMITTED的事务隔离级别，它总是读取行的最新版本，如果行
被锁定了，则读取该行版本的最新一个快照。因为会话B的事务已经提交，所以在该隔离级别下上述SQL语句的结果
集是空的。 对于REPEATABLE READ的事务隔离级别，总是读取事务开始时的行数据，因此，在该隔离级别下，上
述SQL语句仍然会获得相同的数据。

MVCC

我们首先来看一下wiki上对MVCC的定义：

Multiversion concurrency control (MCC or MVCC), is a concurrency control method commonly
used by database management systems to provide concurrent access to the database and in
programming languages to implement transactional memory.

由定义可知，MVVC是用于数据库提供并发访问控制的并发控制技术。 数据库的并发控制机制有很多，最为常见的
就是锁机制。锁机制一般会给竞争资源加锁，阻塞读或者写操作来解决事务之间的竞争条件，最终保证事务的可串行
化。
而MVVC则引入了另外一种并发控制，它让读写操作互不阻塞，每一个写操作都会创建一个新版本的数据，读操作会
从有限多个版本的数据中挑选一个最合适的结果直接返回，由此解决了事务的竞争条件。
考虑一个现实场景。管理者要查询所有用户的存款总额，假设除了用户A和用户B之外，其他用户的存款总额都为
0，A、B用户各有存款1000，所以所有用户的存款总额为2000。但是在查询过程中，用户A会向用户B进行转账操作。
转账操作和查询总额操作的时序图如下图所示。

开课吧

java

高级架构师

转账和查询的时序图
如果没有任何的并发控制机制，查询总额事务先读取了用户A的账户存款，然后转账事务改变了用户A和用户B的账
户存款，最后查询总额事务继续读取了转账后的用户B的账号存款，导致最终统计的存款总额多了100元，发生错
误。
使用锁机制可以解决上述的问题。查询总额事务会对读取的行加锁，等到操作结束后再释放所有行上的锁。因为用
户A的存款被锁，导致转账操作被阻塞，直到查询总额事务提交并将所有锁都释放。

开课吧

java

高级架构师

使用锁机制
但是这时可能会引入新的问题，当转账操作是从用户B向用户A进行转账时会导致死锁。转账事务会先锁住用户B的
数据，等待用户A数据上的锁，但是查询总额的事务却先锁住了用户A数据，等待用户B的数据上的锁。
使用MVVC机制也可以解决这个问题。查询总额事务先读取了用户A的账户存款，然后转账事务会修改用户A和用户B账
户存款，查询总额事务读取用户B存款时不会读取转账事务修改后的数据，而是读取本事务开始时的数据副本(在
REPEATABLE READ隔离等级下)。

开课吧

java

高级架构师

使用MVVC机制
MVCC使得数据库读不会对数据加锁，普通的SELECT请求不会加锁，提高了数据库的并发处理能力。借助MVCC，数
据库可以实现READ COMMITTED，REPEATABLE READ等隔离级别，用户可以查看当前数据的前一个或者前几个历史版
本，保证了ACID中的I特性（隔离性)

InnoDB的MVCC实现

多版本并发控制仅仅是一种技术概念，并没有统一的实现标准， 其的核心理念就是数据快照，不同的事务访问不
同版本的数据快照，从而实现不同的事务隔离级别。虽然字面上是说具有多个版本的数据快照，但这并不意味着数据
库必须拷贝数据，保存多份数据文件，这样会浪费大量的存储空间。InnoDB通过事务的undo日志巧妙地实现了多版
本的数据快照。 数据库的事务有时需要进行回滚操作，这时就需要对之前的操作进行undo。因此，在对数据进行
修改时，InnoDB会产生undo log。当事务需要进行回滚时，InnoDB可以利用这些undo log将数据回滚到修改之前
的样子。 根据行为的不同 undo log 分为两种 insert undo log和update undo log。 insert undo log
是在 insert 操作中产生的 undo log。因为 insert 操作的记录只对事务本身可见，对于其它事务此记录是不可
见的，所以 insert undo log 可以在事务提交后直接删除而不需要进行 purge 操作。 update undo log 是
update 或 delete 操作中产生的 undo log，因为会对已经存在的记录产生影响，为了提供 MVCC机制，因此
update undo log 不能在事务提交时就进行删除，而是将事务提交时放到入 history list 上，等待 purge 线
程进行最后的删除操作。 为了保证事务并发操作时，在写各自的undo log时不产生冲突，InnoDB采用回滚段的
方式来维护undo log的并发写入和持久化。回滚段实际上是一种 Undo 文件组织方式。 InnoDB行记录有三个隐
藏字段：分别对应该行的rowid、事务号db_trx_id和回滚指针db_roll_ptr，其中db_trx_id表示最近修改的事务
的id，db_roll_ptr指向回滚段中的undo log。如下图所示。

开课吧

java

高级架构师

初始状态
当事务2使用UPDATE语句修改该行数据时，会首先使用排他锁锁定改行，将该行当前的值复制到undo log中，然
后再真正地修改当前行的值，最后填写事务ID，使用回滚指针指向undo log中修改前的行。如下图所示。
第一次修改
当事务3进行修改与事务2的处理过程类似，如下图所示。

开课吧

java

高级架构师

第二次修改
REPEATABLE READ隔离级别下事务开始后使用MVVC机制进行读取时，会将当时活动的事务id记录下来，记录到
Read View中。READ COMMITTED隔离级别下则是每次读取时都创建一个新的Read View。 Read View是InnoDB
中用于判断记录可见性的数据结构，记录了一些用于判断可见性的属性。
low_limit_id：某行记录的db_trx_id < 该值，则该行对于当前Read View是一定可见的
up_limit_id：某行记录的db_trx_id >= 该值，则该行对于当前read view是一定不可见的
low_limit_no：用于purge操作的判断
rw_trx_ids：读写事务数组
Read View创建后，事务再次进行读操作时比较记录的db_trx_id和Read View中的low_limit_id，
up_limit_id和读写事务数组来判断可见性。
如果该行中的db_trx_id等于当前事务id，说明是事务内部发生的更改，直接返回该行数据。否则的话，如果
db_trx_id小于up_limit_id，说明是事务开始前的修改，则该记录对当前Read View是可见的，直接返回该行数
据。
如果db_trx_id大于或者等于low_limit_id，则该记录对于该Read View一定是不可见的。如果db_trx_id位于
[up_limit_id, low_limit_id)范围内，需要在活跃读写事务数组(rw_trx_ids)中查找db_trx_id是否存在，如
果存在，记录对于当前Read View是不可见的。 如果记录对于Read View不可见，需要通过记录的DB_ROLL_PTR
指针遍历undo log，构造对当前Read View可见版本数据。 简单来说，Read View记录读开始时及其之后，所有
的活动事务，这些事务所做的修改对于Read View是不可见的。除此之外，所有其他的小于创建Read View的事务号
的所有记录均可见。

InnoDB的事务

事务是数据库最为重要的机制之一，凡是使用过数据库的人，都了解数据库的事务机制，也对ACID四个基本特性
如数家珍。但是聊起事务或者ACID的底层实现原理，往往言之不详，不明所以。所以，今天我们就一起来分析和探
讨InnoDB的事务机制，希望能建立起对事务底层实现原理的具体了解。

开课吧

java

高级架构师

事务的四大特性
数据库事务具有ACID四大特性。ACID是以下4个词的缩写：
原子性(atomicity) ：事务最小工作单元，要么全成功，要么全失败 。
一致性(consistency)： 事务开始和结束后，数据库的完整性不会被破坏 。
隔离性(isolation) ：不同事务之间互不影响，四种隔离级别为RU（读未提交）、RC（读已提交）、RR（可
重复读）、SERIALIZABLE （串行化）。
持久性(durability) ：事务提交后，对数据的修改是永久性的，即使系统故障也不会丢失 。
下面，我们就以一个具体实例来介绍数据库事务的原理，并介绍InnoDB是如何实现ACID四大特性的。

示例介绍

我们首先来看一下具体的示例。大家可以自己亲自试验一下，这样理解和记忆都会更加深刻。 首先，使用如下
的SQL语句创建两张表，分别是goods和trade，代表货物和交易。并向goods表中插入一条记录，id为1的货物数量
为10。
然后打开终端，连接数据库，开启会话一，先用BEGIN显示开启一个事务。会话一先将goods表中id为1的货物的数
量减一，然后向trade表中添加一笔交易的记录，最后使用COMMIT显示提交事务。 而会话二则先查询goods表中
id为1的货物数量，然后向trade表中添加一笔交易记录，接着更新goods表中id为1的货物的数量，最后使用
ROLLBACK进行事务的回滚。其中，两个会话中执行的具体语句和先后顺序如下图所示。

CREATE TABLE goods (id INT, num INT, PRIMARY KEY(id));
CREATE TABLE trade (id INT, goods_id INT, user_id INT, PRIMARY KEY(id));
INSERT INTO goods VALUES(1, 10);

1 2 3

开课吧

java

高级架构师

示例具体语句和执行顺序
这个示例可以体现数据库事务的很多特性，我们一一来介绍。首先会话一的操作2更新了id为1的货物的数量，但
是会话二的操作5读出来的数量仍然是10，这体现了事务的隔离性，使用InnoDB的

多版本控制机制

实现。 会话二
的操作7也要更新同种货物的数量，此时因为会话一的操作2已经更新了该货物的数量，InnoDB已经锁住了该记录的
行锁，所以操作7会被阻塞，直到会话一COMMIT。但是会话一的操作4和会话二的操作7都是向trade表中插入记录，
后者却不会因为前者而阻塞，因为二者插入的不是同一行记录。锁机制是一种常见的并发控制机制，它和多版本控制
机制一起实现了InnoDB事务的隔离性，关于InnoDB锁相关的具体内容可以参考

InnoDB锁的类型和状态查询

和

InnoDB行锁算法

。
会话一事务最终使用COMMIT提交了事务而会话二事务则使用ROLLBACK回滚了整个事务，这体现了事务的原子性。
即事务的一系列操作要么全部执行(COMMIT)，要么就全部不执行(ROLLBACK)，不存在只执行一部分的情况。
InnoDB使用事务日志系统来实现事务的原子性。这里有的同学就会问了，如果中途连接断开或者Server Crash会怎
么样。能怎么样，直接自动回滚呗。
一旦会话一使用COMMIT操作提交事务成功后，那么数据一定会被写入到数据库中并持久的存储起来，这体现了事
务的持久性。InnoDB使用

redo log机制

来实现事务的持久性。
而事务的一致性比较难以理解，简单的讲在事务开始时，此时数据库有一种状态，这个状态是所有的MySQL对象处
于一致的状态，例如数据库完整性约束正确，日志状态一致等。当事务提交后，这时数据库又有了一个新的状态，不
同的数据，不同的索引，不同的日志等。但此时，约束，数据，索引，日志等MySQL各种状态还是要保持一致性。
也就是说数据库从一个一致性的状态，变到另一个一致性的状态。事务执行后，并没有破坏数据库的完整性约束。
下面我们就来详细讲解一下上述示例涉及的事务的ACID特性的具体实现原理。

总结来说，事务的隔离性由多版本
控制机制和锁实现，而原子性、一致性和持久性通过InnoDB的redo log、undo log和Force Log at Commit机
制来实现

。

原子性，持久性和一致性

原子性，持久性和一致性主要是通过redo log、undo log和Force Log at Commit机制机制来完成的。redo
log用于在崩溃时恢复数据，undo log用于对事务的影响进行撤销，也可以用于多版本控制。而Force Log at
Commit机制保证事务提交后redo log日志都已经持久化。 开启一个事务后，用户可以使用COMMIT来提交，也可
以用ROLLBACK来回滚。其中COMMIT或者ROLLBACK执行成功之后，数据一定是会被全部保存或者全部回滚到最初状态

开课吧

java

高级架构师

的，这也体现了事务的原子性。但是也会有很多的异常情况，比如说事务执行中途连接断开，或者是执行COMMIT或
者ROLLBACK时发生错误，Server Crash等，此时数据库会自动进行回滚或者重启之后进行恢复。
我们先来看一下redo log的原理，redo log顾名思义，就是重做日志，每次数据库的SQL操作导致的数据变化它
都会记录一下，

具体来说，redo log是物理日志，记录的是数据库页的物理修改操作

。如果数据发生了丢失，数据
库可以根据redo log进行数据恢复。
InnoDB通过Force Log at Commit机制实现事务的持久性，即当事务COMMIT时，必须先将该事务的所有日志都写
入到redo log文件进行持久化之后，COMMIT操作才算完成。 当事务的各种SQL操作执行时，即会在缓冲区中修改
数据，也会将对应的redo log写入它所属的缓存。当事务执行COMMIT时，与该事务相关的redo log缓冲必须都全部
刷新到磁盘中之后COMMIT才算执行成功。
数据库日志和数据落盘机制
redo log写入磁盘时，必须进行一次操作系统的fsync操作，防止redo log只是写入了操作系统的磁盘缓存中。
参数innodb_flush_log_at_trx_commit可以控制redo log日志刷新到磁盘的策略，它的具体作用可以查阅

InnoDB的磁盘文件及落盘机制

redo log全部写入磁盘后事务就算COMMIT成功了，但是此时事务修改的数据还在内存的缓冲区中，称其为脏页，
这些数据会依据检查点(CheckPoint)机制择时刷新到磁盘中，然后删除相应的redo log，但是如果在这个过程中数
据库Crash了，那么数据库重启时，会依据redo log file将那些还在内存中未更新到磁盘上的数据进行恢复。
数据库为了提高性能，数据页在内存修改后并不是每次都会刷到磁盘上。而是引入checkpoint机制，择时将数据
页落盘，checkpoint记录之前的数据页保证一定落盘了，这样相关的redo log就没有用了(由于InnoDB redo log
file循环使用，这时这部分日志就可以被覆盖)，checkpoint之后的数据页有可能落盘，也有可能没有落盘，所以
checkpoint之后的redo log file在崩溃恢复的时候还是需要被使用的。InnoDB会依据脏页的刷新情况，定期推进
checkpoint，从而减少数据库崩溃恢复的时间。检查点的信息在第一个日志文件的头部。
数据库崩溃重启后需要从redo log中把未落盘的脏页数据恢复出来，重新写入磁盘，保证用户的数据不丢失。当
然，在崩溃恢复中还需要回滚没有提交的事务。由于回滚操作需要undo日志的支持，undo日志的完整性和可靠性需
要redo日志来保证，所以崩溃恢复先做redo恢复数据，然后做undo回滚。

开课吧

java

高级架构师

在事务执行的过程中，除了记录redo log，还会记录一定量的undo log。undo log记录了数据在每个操作前的
状态，如果事务执行过程中需要回滚，就可以根据undo log进行回滚操作。
数据和回滚日志的逻辑存储结构.jpg
undo log的存储不同于redo log，它存放在数据库内部的一个特殊的段(segment)中，这个段称为回滚段。回滚
段位于共享表空间中。undo段中的以undo page为更小的组织单位。undo page和存储数据库数据和索引的页类似。
因为redo log是物理日志，记录的是数据库页的物理修改操作。所以undo log的写入也会产生redo log，也就是
undo log的产生会伴随着redo log的产生，这是因为undo log也需要持久性的保护。如上图所示，表空间中有回
滚段和叶节点段和非叶节点段，而三者都有对应的页结构。
我们再来总结一下数据库事务的整个流程，如下图所示。

开课吧

java

高级架构师

事务的相关流程
事务进行过程中，每次sql语句执行，都会记录undo log和redo log，然后更新数据形成脏页，然后redo log按
照时间或者空间等条件进行落盘，undo log和脏页按照checkpoint进行落盘，落盘后相应的redo log就可以删除
了。此时，事务还未COMMIT，如果发生崩溃，则首先检查checkpoint记录，使用相应的redo log进行数据和undo
log的恢复，然后查看undo log的状态发现事务尚未提交，然后就使用undo log进行事务回滚。事务执行COMMIT操
作时，会将本事务相关的所有redo log都进行落盘，只有所有redo log落盘成功，才算COMMIT成功。然后内存中的
数据脏页继续按照checkpoint进行落盘。如果此时发生了崩溃，则只使用redo log恢复数据。

隔离性

InnoDB事务的隔离性主要通过多版本控制机制和锁机制实现，具体可以参考

多版本控制

，

InnoDB锁的类型和状态
查询

和

InnoDB行锁算法

三篇文章。

后记

本来想一篇文章将MySQL的事务机制讲明白，写完自己读了一遍，还是发现内容有些晦涩难懂，复杂的知识本来就
是很难讲明白的，夫夷以近，则游者众；险以远，则至者少，希望读者以本文作为一篇指引性的文章，自己再去更加
深入的地方去探秘。不过，能将复杂知识讲解的通俗简单也是一项很大的本领，文字和讲解能力还是需要提示的。

MySQL性能分析篇

开课吧

java

高级架构师

慢查询日志

性能优化的思路

\1. 首先需要使用慢查询功能，去获取所有查询时间比较长的SQL语句
\2. 其次使用explain命令去查看有问题的SQL的执行计划
\3. 最后可以使用show profile[s] 查看有问题的SQL的性能使用情况
\4. 优化改造SQL语句（需要对于需求有很好的理解，比如查询某个人最近半年的银行流水，银行只会提供最近一年
内的流水，还有的只提供最近半年的查询）

慢查询日志介绍

数据库查询快慢是影响项目性能的一大因素，对于数据库，我们除了要优化 SQL，更重要的是得

先找到需要优化的
SQL

。
MySQL 数据库有一个

“慢查询日志”

功能，用来

记录

查询时间

超过某个设定值的SQL

，这将极大程度帮助我们

快速
定位到症结所在

，以便对症下药。
至于查询时间的多少才算慢，每个项目、业务都有不同的要求。
比如说传统企业的软件允许查询时间高于某个值，但是把这个标准放在互联网项目或者访问量大的网站上，估计就是
一个bug，甚至可能升级为一个功能性缺陷。
MySQL的慢查询日志功能，

默认是关闭的，需要手动开启

。

开启慢查询功能

查看是否开启慢查询功能
参数说明：

开课吧

java

高级架构师

临时开启慢查询功能

在 MySQL 执行 SQL 语句设置，但是如果重启 MySQL 的话将失效

永久开启慢查询功能

修改/etc/my.cnf配置文件，重启 MySQL, 这种永久生效.

慢查询日志格式

\- slow_query_log 

：是否开启慢查询日志，

ON 

为开启，

OFF 

为关闭，如果为关闭可以开启。

\- log-slow-queries 

：旧版（

5.6

以下版本）

MySQL

数据库慢查询日志存储路径。可以不设置该参数，系统则会
默认给一个缺省的文件

host_name-slow.log
\- slow-query-log-file

：新版（

5.6

及以上版本）

MySQL

数据库慢查询日志存储路径。可以不设置该参数，系统
则会默认给一个缺省的文件

host_name-slow.log
\- long_query_time 

：慢查询阈值，当查询时间多于设定的阈值时，记录日志，单位为秒。

1 2 3 4 5 6 7

set global 

slow_query_log = 

ON

;

set global 

long_query_time = 

1

;

1 2 3

[mysqld]

slow_query_log 

= 

ON

slow_query_log_file 

= 

/var/log/mysql/slow.log

long_query_time 

= 

1

1 2 3 4

开课吧

java

高级架构师

格式说明：

第一行,SQL查询执行的具体时间
第二行,执行SQL查询的连接信息，用户和连接IP
第三行,记录了一些我们比较有用的信息，如下解析
第四行,设置时间戳，没有实际意义，只是和第一行对应执行时间。
第五行及后面所有行（第二个# Time:之前）,执行的sql语句记录信息，因为sql可能会很长。

分析慢查询日志

MySQL自带的mysqldumpslow

得到按照时间排序的前10条里面含有左连接的查询语句：

常用参数说明：

-s：是表示按照何种方式排序

Query_time,

这条

SQL

执行的时间

,

越长则越慢

Lock_time,

在

MySQL

服务器阶段

(

不是在存储引擎阶段

)

等待表锁时间

Rows_sent,

查询返回的行数

Rows_examined,

查询检查的行数，越长就当然越费时间

1 2 3 4 5 6 7

[root@localhost mysql]# mysqldumpslow -s t -t 10 -g “left join”
/var/log/mysql/slow.log

1

开课吧

java

高级架构师

-t：是top n的意思，即为返回前面多少条的数据
-g：后边可以写一个正则匹配模式，大小写不敏感的

使用mysqlsla 工具

mysqlsla工具，功能非常强大。数据报表，非常有利于分析慢查询的原因，包括执行频率，数据量，查询消耗等。
不过此工具已停止维护，项目 github 介绍页面推荐使用 percona-toolkit，下面有介绍。

使用percona-toolkit工具

percona-toolkit是一组高级命令行工具的集合，可以查看当前服务的摘要信息，磁盘检测，分析慢查询日志，查
找重复索引，实现表同步等等。
下载

https://www.percona.com/downloads/percona-toolkit/3.0.11/binary/tarball/percona-toolkit-3.0.1
1_x86_64.tar.gz

安装
调错
Can't locate ExtUtils/MakeMaker.pm in @INC 错误的解决方式:
Can't locate Time/HiRes.pm in @INC

1 

mysqlsla -lt /var/log/mysql/slow.log
tar 

-xf 

percona-toolkit-3.0.11_x86_64.tar.gz

cd 

percona-toolkit-3.0.11
perl Makefile.PL

make
make 

install

1 2 3 4 5
1 

yum install -y perl-ExtUtils-CBuilder perl-ExtUtils-MakeMaker

开课吧

java

高级架构师

使用pt-query-digest查看慢查询日志

查看执行计划

介绍

MySQL 提供了一个 

EXPLAIN 命令

, 它可以

对 SELECT 语句进行分析

, 并输出 SELECT 执行的详细信息, 以供开
发人员针对性优化.
使用explain这个命令来查看一个这些SQL语句的执行计划，查看该SQL语句有没有使用上了索引，有没有做全表扫
描，这都可以通过explain命令来查看。
可以通过explain命令深入了解MySQL的基于开销的优化器，还可以获得很多可能被优化器考虑到的访问策略的细
节，以及当运行SQL语句时哪种策略预计会被优化器采用。
EXPLAIN 命令用法十分简单, 在 SELECT 语句前加上 explain 就可以了, 例如:

参数说明

expain出来的信息有10列，分别是

id

每个 SELECT语句都会自动分配的一个唯一标识符.
表示查询中操作表的顺序，有三种情况：
id相同：执行顺序由上到下
id不同：如果是子查询，id号会自增，

id越大，优先级越高

。
id相同的不同的同时存在
id列为null的就表示这是一个结果集，不需要使用它来进行查询。

select_type（重要）

查询类型

，主要用于区别

普通查询、联合查询(union、union all)、子查询等复杂查询

。

1 

yum install -y perl-Time-HiRes

1 

pt-query-digest /var/lib/mysql/localhost-slow.log

1 

id

、

select_type

、

table

、

type

、

possible_keys

、

key

、

key_len

、

ref

、

rows

、

Extra

开课吧

java

高级架构师

simple

表示不需要union操作或者不包含子查询的简单select查询。有连接查询时，外层的查询为simple，且只有一个

primary

一个需要union操作或者含有子查询的select，位于最外层的单位查询的select_type即为primary。且只有一个

union

union连接的两个select查询，第一个查询是dervied派生表，除了第一个表外，第二个以后的表select_type都是
union

dependent union

与union一样，出现在union 或union all语句中，但是这个查询要受到外部查询的影响

union result

包含union的结果集，在union和union all语句中,因为它不需要参与查询，所以id字段为null

subquery

除了from字句中包含的子查询外，其他地方出现的子查询都可能是subquery

dependent subquery

与dependent union类似，表示这个subquery的查询要受到外部表查询的影响

derived

from字句中出现的子查询，也叫做派生表，其他数据库中可能叫做内联视图或嵌套select

table

显示的查询表名，如果查询使用了别名，那么这里显示的是别名
如果不涉及对数据表的操作，那么这显示为null
如果显示为尖括号括起来的就表示这个是临时表，后边的N就是执行计划中的id，表示结果来自于这个查询产
生。
如果是尖括号括起来的

<union M,N>

，与类似，也是一个临时表，表示这个结果来自于union查询的id为M,N的
结果集。

type（重要）

依次从好到差：

除了all之外，其他的type都可以使用到索引，除了index_merge之外，其他的type只可以用到一个索引
注意事项：

system

，

const

，

eq_ref

，

ref

，

fulltext

，

ref_or_null

，

unique_subquery

，

index_subquery

，

range

，

index_merge

，

index

，

ALL

1
1 

最少要索引使用到

range

级别。

开课吧

java

高级架构师

system

表中只有一行数据或者是空表。

const（重要）

使用

唯一索引或者主键

，返回记录一定是1行记录的等值where条件时，通常type是const。其他数据库也叫做唯一
索引扫描

eq_ref（重要）

关键字:连接字段

主键或者唯一性索引

。
此类型通常出现在多表的 join 查询, 表示对于前表的每一个结果, 

都只能匹配到后表的一行结果

. 并且查询的比
较操作通常是 

= 

, 查询效率较高.
示例：
orders表
user表（

eq_ref

）
演示SQL

ref（重要）

1 

EXPLAIN SELECT 

\* 

FROM 

orders o 

LEFT JOIN user 

u 

ON 

o

.user_id 

= u

.id 

；

开课吧

java

高级架构师

针对非唯一性索引

，使用

等值（=）查询

。或者是使用了

最左前缀规则索引的查询

。
非唯一性索引ref示例：
orders表（

ref

）
user表
演示SQL
组合索引最左前缀ref示例：

fulltext

全文索引检索，要注意，全文索引的优先级很高，若全文索引和普通索引同时存在时，mysql不管代价，优先选择使
用全文索引

ref_or_null

与ref方法类似，只是增加了null值的比较。实际用的不多。

unique_subquery

用于where中的in形式子查询，子查询返回不重复值唯一值

index_subquery

用于in形式子查询使用到了辅助索引或者in常数列表，子查询可能返回重复值，可以使用索引将子查询去重。

range（重要）
索引范围扫描

，常见于使用>,<,is null,between ,in ,like等运算符的查询中。

1 

EXPLAIN SELECT 

\* 

FROM user 

u 

LEFT JOIN 

orders o 

ON 

o

.user_id 

= u

.id 

；

开课吧

java

高级架构师

| index_merge                                                  |
| ------------------------------------------------------------ |
| 表示查询使用了两个以上的索引，最后取交集或者并集，常见and ，or的条件使用了不同的索引，官方排序这个在 ref_or_null之后，但是实际上由于要读取所个索引，性能可能大部分时间都不如range index（重要） |

关键字：条件是出现在索引树中的节点的。可能没有完全匹配索引。
索引全表扫描

，把索引从头到尾扫一遍，常见于使用索引列就可以处理不需要读取数据文件的查询、可以使用索引排
序或者分组的查询。

all（重要）

这个就是全表扫描数据文件，然后再

在server层进行过滤

返回符合要求的记录。

| possible_keys                            |
| ---------------------------------------- |
| 此次查询中可能选用的索引，一个或多个 key |

查询真正使用到的索引，select_type为index_merge时，这里可能出现两个以上的索引，其他的select_type这里
只会出现一个。

key_len

开课吧

java

高级架构师

用于处理查询的索引长度，如果是单列索引，那就整个索引长度算进去，如果是多列索引，那么查询不一定都
能使用到所有的列，具体使用到了多少个列的索引，这里就会计算进去，没有使用到的列，这里不会计算进
去。
留意下这个列的值，算一下你的多列索引总长度就知道有没有使用到所有的列了。
另外，

key_len只计算where条件用到的索引长度，而排序和分组就算用到了索引，也不会计算到key_len中。

ref

如果是使用的常数等值查询，这里会显示const
如果是连接查询，被驱动表的执行计划这里会显示驱动表的关联字段
如果是条件使用了表达式或者函数，或者条件列发生了内部隐式转换，这里可能显示为func

rows

这里是执行计划中估算的扫描行数，不是精确值（InnoDB不是精确的值，MyISAM是精确的值，主要原因是InnoDB里
面使用了MVCC并发机制）

extra（重要）

这个列包含不适合在其他列中显示单十分重要的额外的信息，这个列可以显示的信息非常多，有几十种，常用的有

distinct

在select部分使用了distinct关键字

no tables used

不带from字句的查询或者From dual查询

使用not in()形式子查询或not exists运算符的连接查询，这种叫做反连接

即，一般连接查询是先查询内表，再查询外表，反连接就是先查询外表，再查询内表。

using filesort（重要）

排序时无法使用到索引时，就会出现这个。常见于order by和group by语句中
说明MySQL会使用一个外部的索引排序，而不是按照索引顺序进行读取。
MySQL中无法利用索引完成的排序操作称为“文件排序”

using index（重要）

查询时

不需要回表查询

，直接通过索引就可以获取查询的数据。
表示相应的SELECT查询中使用到了

覆盖索引（Covering Index）

，避免访问表的数据行，效率不错！
如果同时出现Using Where ，说明索引被用来执行查找索引键值
如果没有同时出现Using Where ，表明索引用来读取数据而非执行查找动作。

开课吧

java

高级架构师

using join buffer（block nested loop），using join buffer（batched key accss）

5.6.x之后的版本优化关联查询的BNL，BKA特性。主要是减少内表的循环数量以及比较顺序地扫描查询。

using sort_union，using_union，using intersect，using sort_intersection

using intersect：表示使用and的各个索引的条件时，该信息表示是从处理结果获取交集
using union：表示使用or连接各个使用索引的条件时，该信息表示从处理结果获取并集
using sort_union和using sort_intersection：与前面两个对应的类似，只是他们是出现在用and和or查
询信息量大时，先查询主键，然后进行排序合并后，才能读取记录并返回。

using temporary（重要）

表示使用了临时表存储中间结果。
MySQL在对查询结果

order by和group by

时使用临时表
临时表可以是内存临时表和磁盘临时表，执行计划中看不出来，需要查看status变量，used_tmp_table，
used_tmp_disk_table才能看出来。

using where（重要）

表示存储引擎返回的记录并不是所有的都满足查询条件，需要在server层进行过滤。
查询条件中分为限制条件和检查条件，5.6之前，存储引擎只能根据限制条件扫描数据并返回，然后server层
根据检查条件进行过滤再返回真正符合查询的数据。5.6.x之后支持

ICP

特性，可以把检查条件也下推到存储引
擎层，不符合检查条件和限制条件的数据，直接不读取，这样就大大减少了存储引擎扫描的记录数量。extra列
显示using index condition

开课吧

java

高级架构师

firstmatch(tb_name)

5.6.x开始引入的优化子查询的新特性之一，常见于where字句含有in()类型的子查询。如果内表的数据量比较大，
就可能出现这个

loosescan(m..n)

5.6.x之后引入的优化子查询的新特性之一，在in()类型的子查询中，子查询返回的可能有重复记录时，就可能出现
这个
除了这些之外，还有很多查询数据字典库，执行计划过程中就发现不可能存在结果的一些提示信息

filtered

使用explain extended时会出现这个列，5.7之后的版本默认就有这个字段，不需要使用explain extended了。
这个字段表示存储引擎返回的数据在server层过滤后，剩下多少满足查询的记录数量的比例，注意是百分比，不是
具体记录数。

参考网站

https://segmentfault.com/a/1190000008131735
https://blog.csdn.net/rewiner120/article/details/70598797

profile分析语句

介绍

Query Profiler是MYSQL自带的一种

query诊断分析工具

，通过它可以分析出一条SQL语句的

硬件性能瓶颈

在什么
地方。

通常我们是使用的explain,以及slow query log都无法做到精确分析，但是Query Profiler却可以定位出一条
SQL语句执行的各种资源消耗情况，比如CPU，IO等，以及该SQL执行所耗费的时间等。

不过该工具只有在MYSQL
5.0.37以及以上版本中才有实现。

默认的情况下，MYSQL的该功能没有打开，需要自己手动启动

。

语句使用

show profile 

和 

show profiles 

语句可以展示

当前会话

(退出session后,profiling重置为0) 中执行语
句的资源使用情况.

show profiles 

:以列表形式显示最近发送到服务器上执行的语句的

资源使用情况

.显示的记录数由变
量:

profiling_history_size 

控制,默认15条

show profile

: 展示最近一条语句执行的详细资源占用信息,默认显示 

Status和Duratio

n两列

开课吧

java

高级架构师

show profile 

还可根据 show profiles 列表中的 

Query_ID 

,选择显示某条记录的性能分析信息

开启Profile功能

Profile 功能由MySQL会话变量 : 

profiling

控制,默认是

OFF

关闭状态。
查看是否开启了Profile功能:

select 

@@profiling

;

show variables like 

‘%profil%’;

1 2 3

开课吧

java

高级架构师

开启profile功能

示例

查看是否打开了性能分析功能
打开 profiling 功能
执行sql语句

1 

set 

profiling=

1

; --

1

是开启、

0

是关闭

1 

select 

@@profiling

;

1 

set 

profiling=

1

;

开课吧

java

高级架构师

执行 show profiles 查看分析列表
查询第二条语句的执行情况
可指定资源类型查询

1 

show profile for query 

2

;

1 

show profile 

cpu,swaps 

for query 

2

;

开课吧

java

高级架构师

MySQL性能优化篇

服务器层面优化（了解）

将数据保存在内存中，保证从内存读取数据

设置足够大的 

innodb_buffer_pool_size 

，将数据读取到内存中。
怎样确定 innodb_buffer_pool_size 足够大。数据是从内存读取而不是硬盘？

内存预热

将磁盘数据在MySQL Server启动的时候，读取到内存中。

1 

建议

innodb_buffer_pool_size

设置为总内存大小的

3/4

或者

4/5.

开课吧

java

高级架构师

降低磁盘写入次数

对于生产环境来说，很多日志是不需要开启的，比如：通用查询日志、慢查询日志、错误日志
使用足够大的写入缓存 innodb_log_file_size
设置合适的innodb_flush_log_at_trx_commit，和日志落盘有关系。

提高磁盘读写

可以考虑使用SSD硬盘，不过得考虑成本是否合适。

SQL设计优化（了解需求的人并懂技术的人）

设计中间表

，一般针对于

统计分析

功能，或者实时性不高的需求（OLTP、OLAP）
为减少关联查询，创建合理的

冗余字段

（考虑数据库的三范式和查询性能的取舍，创建冗余字段还需要注意

数
据一致性问题

）
对于字段太多的大表，考虑

拆表

（比如一个表有100多个字段）
对于表中经常不被使用的字段或者存储数据比较多的字段，考虑拆表（比如商品表中会存储商品介绍，此时可
以将商品介绍字段单独拆解到另一个表中，使用商品ID关联）
每张表建议都要有一个主键（

主键索引

），而且主键类型最好是

int类型

，建议自增主键（

不考虑分布式系统
的情况下

）。

SQL语句优化（开发人员）

索引优化

为搜索字段（

where中的条件

）创建索引（考虑数据的业务场景：查询多还是增删多？）
尽量建立

组合索引

并注意组合索引的创建顺序，按照顺序组织查询条件、尽量将筛选粒度大的查询条件放到最
左边

使用覆盖索引

，SELECT语句中尽量不要使用*
order by、group by语句要尽量使用到索引

LIMIT优化

如果预计SELECT语句的查询结果是一条，最好使用 

LIMIT 1

，可以停止全表扫描。
处理分页会使用到 

LIMIT 

，当翻页到非常靠后的页面的时候，偏移量会非常大，这时LIMIT的效率会非常差。
LIMIT OFFSET , SIZE；
LIMIT的优化问题，其实是 

OFFSET 

的问题，它会导致MySql扫描大量不需要的行然后再抛弃掉。
解决方案：

使用order by 和索引覆盖

1 

推荐 

innodb_log_file_size 

设置为 

0.25 * innodb_buffer_pool_size
SELECT * FROM user WHERE username=’

全力詹

’; -- username

没有建立唯一索引

SELECT * FROM user WHERE username=’

全力詹

’ LIMIT 1;

1 2 3

开课吧

java

高级架构师

原SQL（如果 

film 

表中的记录有10020条）：
优化的SQL：

其他优化

尽量不使用count(*)、尽量使用count（主键）
JOIN两张表的关联字段最好都建立索引，而且最好字段类型是一样的。
WHERE条件中尽量不要使用1=1、not in语句（建议使用not exists）、
不用 MYSQL 内置的函数，因为内置函数不会建立查询缓存。
合理利用慢查询日志、explain执行计划查询、show profile查看SQL执行时的资源使用情况。

MySQL集群篇

集群搭建之主从复制

主从复制原理

1 

SELECT film_id, description FROM film LIMIT 10000, 20;

1 

SELECT film_id, description FROM film ORDER BY title LIMIT 20;
COUNT(*)

：查询行数，是会遍历所有的行、所有的列。

COUNT

（列）：查询指定列不为

null

的行数（过滤

null

），如果列可以为空，则

COUNT

（

*

）不等于

COUNT(

列

)

，除非指定的列是非空的列才会让

COUNT

（

*

）等于

COUNT(

列

)
COUNT

（伪列）：比如

COUNT

（

1

）

1 2 3 4 5

SELECT * FROM orders o LEFT JOIN user u on o.user_id = u.id
orders

表中的

user_id

和

user

表中的

id

，类型要一致

1 2 3

SQL

查询语句和查询结果都会在第一次查询只会存储到

MySQL

的查询缓存中，如果需要获取到查询缓存中的查询
结果，查询的

SQL

语句必须和第一次的查询

SQL

语句一致。

SELECT * FROM user where birthday = now();

1 2 3

开课吧

java

高级架构师

binlog介绍和relay日志

查看bin log和relay log日志：

主从复制实践

关闭主从机器的防火墙

1 

mysqlbinlog --base64-output=decode-rows -v -v mysql-bin

.000058 

\> 

binlog

开课吧

java

高级架构师

主服务器配置

第一步：修改my.conf文件

在[mysqld]段下添加：

第二步：重启mysql服务
第三步：主机给从机授备份权限

注意：先要登录到MySQL命令客户端

示例：
注意事项：
第四步：刷新权限
第五步：查询master的状态

systemctl 

stop 

iptables

（需要安装

iptables

服务）

systemctl 

stop 

firewalld

（默认）

systemctl disable firewalld.service

（设置开启不启动）

1 2 3

\#

启用二进制日志

log-bin

=

mysql-bin

\#

服务器唯一

ID

，一般取

IP

最后一段

server-id

=

133

1 2 3 4
1 

systemctl 

restart 

mysqld
mysql>

GRANT 

REPLICATION 

SLAVE ON 

*.* 

TO 

'

从机

MySQL

用户名

'

@'

从机

IP' identified by '

从机

MySQL

密码

'

;

1
1 

GRANT 

REPLICATION 

SLAVE ON 

*.* 

TO 

'root'

@'%' identified by 'root'

;

一般不用

root

帐号，

“%”

表示所有客户端都可能连，只要帐号，密码正确，此处可用具体客户端

IP

代替，如

192.168.145.226

，加强安全。

1
1 

mysql> 

FLUSH PRIVILEGES

;

开课吧

java

高级架构师

从服务器配置

第一步：修改my.conf文件
第二步：删除UUID文件

如果出现此错误：
原因：
解决方法：

第三步：重启并登录到MySQL进行配置从服务器
注意：

mysql> 

show master status

;
+------------------+-- -------+--------------+------------------+
| File | Position | Binlog_Do_DB | Binlog_Ignore_DB |
+------------------+----------+--------------+------------------+
| mysql-bin

.000001 

| 

410 

| db1 | mysql |
+------------------+----------+--------------+------------------+

1 

row in set

1 2 3 4 5 6 7 8 9

[mysqld]

server-id

=

135

1 2

Fatal error: The slave I/O thread stops because master and slave have equal MySQL
server UUIDs; these UUIDs must be different for replication to work.

1
1 

因为是

mysql

是克隆的系统所以

mysql

的

uuid

是一样的，所以需要修改。

1 

删除

/var/lib/mysql/auto.cnf

文件，重新启动

MySQL

服务。

mysql>change master to master_host='192.168.10.135',master_port=3306,master_user='root',master_password='root',master_log_file='mysql-bin.000005',master_log_pos=397

1 2 3 4 5 6 7

开课吧

java

高级架构师

语句中间不要断开， 

master_port 

为mysql服务器端口号(

无引号

)， 

master_user 

为执行同步操作的数据库账
户， 

“410” 

无单引号(此处的 

410 

就是 

show master status 

中看到的 

position 

的值，这里的 

mysqlbin.000001 

就是 

file 

对应的值)。

第四步：启动从服务器复制功能
第五步：检查从服务器复制功能状态
注：Slave_IO及Slave_SQL进程必须正常运行，即YES状态，否则都是错误的状态(如：其中一个NO均属错误)。

以上操作过程，从服务器配置完成。

测试

搭建成功之后，往主机中插入数据，看看从机中是否有数据

集群搭建之读写分离

读写分离的理解

1 

mysql>

start slave

;
mysql> 

show slave status 

\G

；

……………………(

省略部分

)
Slave_IO_Running: Yes //

此状态必须

YES
Slave_SQL_Running: Yes //

此状态必须

YES
……………………(

省略部分

)

1 2 3 4 5 6

开课吧

java

高级架构师

名词解释：
注意事项：

读写分离演示需求

1 

HAC

：

High Availability Cluster

，高可用集群

1 

MySQL

的主从复制，只会保证主机对外提供服务，而从机是不对外提供服务的，只是在后台为主机进行备份。

开课吧

java

高级架构师

MySQL-Proxy安装

下载
解压缩

MySQL-Proxy配置

创建mysql-proxy.cnf文件
修改mysql-proxy.cnf文件的权限
修改rw-splitting.lua脚本

MySQL master

：

135
MySQL slave 

：

136
MySQL proxy 

：

137

1 2 3 4 5

wget 

https://downloads.mysql.com/archives/get/file/mysql-proxy-0.8.5-linux-el6-x86-
64bit.tar.gz

1
1 

tar 

-xf 

mysql-proxy-0.8.5-linux-el6-x86-64bit.tar.gz 

-C 

/kkb

[mysql-proxy]

user

=

root

admin-username

=

root

admin-password

=

root

proxy-address

=

192.168.10.137

:

4040

proxy-backend-addresses

=

192.168.10.135

:

3306

proxy-read-only-backend-addresses

=

192.168.10.136

:

3306

proxy-lua-script

=

/root/mysql-proxy/share/doc/mysql-proxy/rw-splitting.lua

log-file

=

/root/mysql-proxy/logs/mysql-proxy.log

log-level

=

debug

keepalive

=

true

daemon

=

true

1 2 3 4 5 6 7 8 9
10
11
12
1 

chmod 

660 

mysql-proxy.cnf

开课吧

java

高级架构师

MySQL-Proxy启动域测试

启动命令

注意事项：

在其他客户端，通过mysql命令去连接MySQL Proxy机器

MySQL分库分表篇

分库分表介绍

使用背景

当【表的数量】达到了几百上千张表时，众多的业务模块都访问这个数据库，压力会比较大，考虑对其进行分
库。
当【表的数据】达到了几千万级别，在做很多操作都比较吃力,.所以，考虑对其进行分库或者分表

数据切分（sharding）方案

数据的切分（Sharding）根据其切分规则的类型，可以分为两种切分模式：

垂直切分：

按照业务模块进行切分，将不同模块的表切分到不同的数据库中。

水平切分：

将一张大表按照一定的切分规则，按照行切分成不同的表或者切分到不同的库中。

切分规则

按照ID取模：对ID进行取模，余数决定该行数据切分到哪个表或者库中

1 

./mysql-proxy 

--defaults-file

=

mysql-proxy.cnf

配置文件的地址

1 

如果没有配置

profile

文件的环境变量，则需要去拥有

mysql-proxy

命令的目录通过

./mysql-proxy

进行启动。

1 

mysql -uroot -proot -h192

.168.10.134 

-P4040

开课吧

java

高级架构师

按照日期：按照年月日，将数据切分到不同的表或者库中
按照范围：可以对某一列按照范围进行切分，不同的范围切分到不同的表或者数据库中。

切分原则

第一原则：能不切分尽量不要切分。
第二原则：如果要切分一定要选择合适的切分规则，提前规划好。
第三原则：数据切分尽量通过数据冗余或表分组（Table Group）来降低跨库 Join 的可能。
第四原则：由于数据库中间件对数据 Join 实现的优劣难以把握，而且实现高性能难度极大，业务读取尽量少
使用多表 Join。

分库分表需要解决的问题

分布式事务问题

强一致性事务（同步）
最终一致性事务（异步思想）

分布式主键ID问题

redis incr命令
数据库（生成主键）
UUID
snowflake算法

跨库join问题

通过业务分析，将不同库的join查询拆分成多个select
建立全局表（每个库都有一个相同的表）
冗余字段（不符合数据库三范式）
E-R分片（将有ER关系的记录都存储到一个库中）
最多支持跨两张表跨库的join

跨库count、order by、group by问题

分库分表实现技术

阿里的TDDL、Cobar
基于阿里Cobar开发的Mycat
当当网的sharding-jdbc

Mycat介绍

什么是Mycat？

官方网站：

http://www.mycat.org.cn/

Mycat架构

开课吧

java

高级架构师

Mycat核心概念

Schema

：由它指定逻辑数据库（相当于MySQL的database数据库）

Table

：逻辑表（相当于MySQL的table表）

DataNode

：真正存储数据的物理节点

DataHost

：存储节点所在的数据库主机（指定MySQL数据库的连接信息）

User

：MyCat的用户（类似于MySQL的用户，支持多用户）

Mycat主要解决的问题

海量数据存储
查询优化

Mycat对多数据库的支持

开课吧

java

高级架构师

Mycat分片策略

MyCAT支持水平分片与垂直分片：
水平分片：一个表格的数据分割到多个节点上，按照行分隔。
垂直分片：一个数据库中多个表格A，B，C，A存储到节点1上，B存储到节点2上，C存储到节点3上。

开课吧

java

高级架构师

MyCAT通过定义表的分片规则来实现分片，每个表格可以捆绑一个分片规则，每个分片规则指定一个分片字段并绑定
一个函数，来实现动态分片算法。
1.

Schema

：逻辑库，与MySQL中的Database（数据库）对应，一个逻辑库中定义了所包括的Table。
2.

Table

：表，即物理数据库中存储的某一张表，与传统数据库不同，这里的表格需要声明其所存储的逻辑数据节点
DataNode。

在此可以指定表的分片规则。

3.

DataNode

：MyCAT的逻辑数据节点，是存放table的具体物理节点，也称之为分片节点，通过DataHost来关联到
后端某个具体数据库上
4.

DataHost

：定义某个物理库的访问地址，用于捆绑到Datanode上

Mycat安装

注意：需要先安装jdk（操作系统如果是64位，必须按照64位的JDK）

第一步：下载MyCat
第二步：解压缩，得到mycat目录
第三步：进入mycat/bin，启动MyCat
第四步：访问Mycat

wget 

http://dl.mycat.io/1.6-RELEASE/Mycat-server-1.6-RELEASE-20161028204710-
linux.tar.gz

1
1 

tar 

-zxvf 

Mycat-server-1.6-RELEASE-20161028204710-linux.tar.gz
\- 

启动命令：

./mycat start
\- 

停止命令：

./mycat stop
\- 

重启命令：

./mycat restart
\- 

查看状态：

./mycat status

1 2 3 4

开课吧

java

高级架构师

Mycat分片

配置schema.xml

schema.xml介绍

schema.xml作为Mycat中重要的配置文件之一，

管理着Mycat的逻辑库、表、分片规则、DataNode以及DataHost
之间的映射关系。

弄懂这些配置，是正确使用Mycat的前提。
schema 标签用于定义MyCat实例中的逻辑库
Table 标签定义了MyCat中的逻辑表
dataNode 标签定义了MyCat中的数据节点，也就是我们通常说所的数据分片。
dataHost标签在mycat逻辑库中也是作为最底层的标签存在，直接定义了具体的数据库实例、读写分离配置和
心跳语句。

schema.xml配置

配置server.xml

server.xml介绍

server.xml几乎保存了所有mycat需要的系统配置信息。最常用的是在此配置用户名、密码及权限。

1 

使用

mysql

的客户端直接连接

mycat

服务。默认服务端口为【

8066

】

<?xml version="1.0"?>
<!DOCTYPE mycat:schema SYSTEM "schema.dtd">

<mycat:schema 

xmlns:mycat

=

"http://io.mycat/"

\>
<schema 

name

=

"TESTDB" 

checkSQLschema

=

"false" 

sqlMaxLimit

=

"100"

\>

<!-- auto sharding by id (long) -->

<table 

name

=

"item" 

dataNode

=

"dn1,dn2,dn3" 

rule

=

"mod-long" 

/>
</schema>

<!-- <dataNode name="dn1$0-743" dataHost="localhost1" database="db$0-743"
/> -->

<dataNode 

name

=

"dn1" 

dataHost

=

"localhost1" 

database

=

"db1" 

/>
<dataNode 

name

=

"dn2" 

dataHost

=

"localhost1" 

database

=

"db2" 

/>
<dataNode 

name

=

"dn3" 

dataHost

=

"localhost1" 

database

=

"db3" 

/>
<dataHost 

name

=

"localhost1" 

maxCon

=

"1000" 

minCon

=

"10" 

balance

=

"0"

writeType

=

"0" 

dbType

=

"mysql" 

dbDriver

=

"native" 

switchType

=

"1"

slaveThreshold

=

"100"

\>
<heartbeat>

select user()

</heartbeat>
<writeHost 

host

=

"hostM1" 

url

=

"192.168.10.133:3306" 

user

=

"root"

password

=

"root" 

\>
</writeHost>
</dataHost>
</mycat:schema>

1 2 3 4 5 6 7 8 9
10
11
12
13
14
15
16
17
18
19
20
21
22
23
24
25

开课吧

java

高级架构师

server.xml配置

配置rule.xml

rule.xml里面就定义了我们对表进行拆分所涉及到的规则定义。我们可以灵活的对表使用不同的分片算法，或者对
表使用相同的算法但具体的参数不同。这个文件里面主要有tableRule和function这两个标签。在具体使用过程中
可以按照需求添加tableRule和function。
此配置文件可以不用修改，使用默认即可。
tableRule 标签配置说明：

name 

属性指定唯一的名字，用于标识不同的表规则

rule 

标签则指定对物理表中的哪一列进行拆分和使用什么路由算法。

columns 

内指定要拆分的列名字。

algorithm 

使用 function 标签中的 name 属性。连接表规则和具体路由算法。当然，多个表规则可以连接
到同一个路由算法上。 table 标签内使用。让逻辑表使用这个规则进行分片。
function 标签配置说明：

name 

指定算法的名字。

class 

制定路由算法具体的类名字。

<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mycat:server SYSTEM "server.dtd">

<mycat:server 

xmlns:mycat

=

"http://io.mycat/"

\>
<system>
<property 

name

=

"defaultSqlParser"

\>

druidparser

</property>
</system>
<user 

name

=

"mycat"

\>
<property 

name

=

"password"

\>

mycat

</property>
<property 

name

=

"schemas"

\>

TESTDB

</property>
</user>
</mycat:server>

1 2 3 4 5 6 7 8 9
10
11

<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mycat:rule SYSTEM "rule.dtd">

<mycat:rule 

xmlns:mycat

=

”http://io.mycat/“ 

\>
<tableRule 

name

=

"sharding-by-intfile"

\>
<rule>
<columns>

sharding_id

</columns>
<algorithm>

hash-int

</algorithm>
</rule>
</tableRule>
<function 

name

=

"hash-int" 

class

=

"io.mycat.route.function.PartitionByFileMap"

\>
<property 

name

=

"mapFile"

\>

partition-hash-int.txt

</property>
</function>
</mycat:rule>

1 2 3 4 5 6 7 8 9
10
11
12
13
14

开课吧

java

高级架构师

property 

为具体算法需要用到的一些属性。
路由算法的配置可以查看算法章节。

十个常用的分片规则

一、枚举法

配置说明：

tableRule标签：

columns 

：标识将要分片的表字段

algorithm 

：指定分片函数
function标签：

mapFile 

：指定分片函数需要的配置文件名称

type 

：默认值为0，0表示Integer，非零表示String

defaultNode 

：指定默认节点，小于0表示不设置默认节点，大于等于0表示设置默认节点，0代表节点1。

默认节点的作用：枚举分片时，如果碰到不识别的枚举值，就让它路由到默认节点。
如果不配置默认节点（defaultNode值小于0表示不配置默认节点），碰到不识别的枚举值就会报错：
can't find datanode for sharding column:column_name val:ffffffff

partition-hash-int.txt 配置：

二、固定分片hash算法

<tableRule 

name

=

"sharding-by-intfile"

\>
<rule>
<columns>

user_id

</columns>
<algorithm>

hash-int

</algorithm>
</rule>
</tableRule>
<function 

name

=

"hash-int"

class

=

"io.mycat.route.function.PartitionByFileMap"

\>
<property 

name

=

"mapFile"

\>

partition-hash-int.txt

</property>
<property 

name

=

"type"

\>

0

</property>
<property 

name

=

"defaultNode"

\>

0

</property>
</function>

1 2 3 4 5 6 7 8 9
10
11
12
13

10000=0
10010=1

1 2

开课吧

java

高级架构师

配置说明：

tableRule标签：

columns 

：标识将要分片的表字段

algorithm 

：指定分片函数
function标签：

partitionCount 

：指定分片个数列表

partitionLength 

： 分片范围列表，分区长度:默认为最大2^n=1024 ,即最大支持1024分区
约束 ：

count,length 

两个数组的长度必须是一致的。 

1024 = sum((count[i]*length[i]))
用法例子：

<tableRule 

name

=

"rule1"

\>
<rule>
<columns>

user_id

</columns>
<algorithm>

func1

</algorithm>
</rule>
</tableRule>
<function 

name

=

"func1"

class

=

"io.mycat.route.function.PartitionByLong"

\>
<property 

name

=

"partitionCount"

\>

2,1

</property>
<property 

name

=

"partitionLength"

\>

256,512

</property>
</function>

1 2 3 4 5 6 7 8 9
10
11
12

@Test

public 

void 

testPartition

() {

// 

本例的分区策略：希望将数据水平分成

3

份，前两份各占

25%

，第三份占

50%

。（故本例非均匀分区）

// |<---------------------1024------------------------>|
// |<----256--->|<----256--->|<----------512---------->|
// | partition0 | partition1 | partition2 |
// | 

共

2

份

,

故

count[0]=2 | 

共

1

份，故

count[1]=1 |

int

[] 

count 

= 

new 

int

[] { 

2

, 

1 

};

int

[] 

length 

= 

new 

int

[] { 

256

, 

512 

};

PartitionUtil pu 

= 

new 

PartitionUtil

(

count

, 

length

);

// 

下面代码演示分别以

offerId

字段或

memberId

字段根据上述分区策略拆分的分配结果

int 

DEFAULT_STR_HEAD_LEN 

= 

8

; 

// cobar

默认会配置为此值

long 

offerId 

= 

12345

;

String 

memberId 

= 

"qiushuo"

;

// 

若根据

offerId

分配，

partNo1

将等于

0

，即按照上述分区策略，

offerId

为

12345

时将会被分配到

partition0

中

int 

partNo1 

= 

pu

.

partition

(

offerId

);

1 2 3 4 5 6 7 8 9
10
11
12
13
14
15
16
17
18
19

开课吧

java

高级架构师

如果需要平均分配设置：平均分为4分片，partitionCount*partitionLength=1024

三、范围约定

配置说明：

tableRule标签：

columns 

：标识将要分片的表字段

algorithm 

：指定分片函数
function标签：

mapFile 

：指定分片函数需要的配置文件名称

autopartition-long.txt文件内容：

所有的节点配置都是从0开始，及0代表节点1，此配置非常简单，即预先制定可能的id范围对应某个分片

// 

若根据

memberId

分配，

partNo2

将等于

2

，即按照上述分区策略，

memberId

为

qiushuo

时将会被分到

partition2

中

int 

partNo2 

= 

pu

.

partition

(

memberId

, 

0

, 

DEFAULT_STR_HEAD_LEN

);

Assert

.

assertEquals

(

0

, 

partNo1

);

Assert

.

assertEquals

(

2

, 

partNo2

);
}

20
21
22
23
24
25

<function 

name

=

"func1"

class

=

"org.opencloudb.route.function.PartitionByLong"

\>
<property 

name

=

"partitionCount"

\>

4

</property>
<property 

name

=

"partitionLength"

\>

256

</property>
</function>

1 2 3 4 5

<tableRule 

name

=

"auto-sharding-long"

\>
<rule>
<columns>

user_id

</columns>
<algorithm>

rang-long

</algorithm>
</rule>
</tableRule>
<function 

name

=

"rang-long"

class

=

"io.mycat.route.function.AutoPartitionByLong"

\>
<property 

name

=

"mapFile"

\>

autopartition-long.txt

</property>
</function>

1 2 3 4 5 6 7 8 9
10
11

开课吧

java

高级架构师

四、求模法

此种配置非常明确，即根据id与count（你的结点数）进行求模运算，相比方式1，此种在批量插入时需要切换数据
源，id不连续

配置说明：

tableRule标签：

columns 

：标识将要分片的表字段

algorithm 

：指定分片函数
function标签：

count 

：节点数量

五、日期列分区法

\# range start-end ,data node index
\# K=1000,M=10000.
0-500M=0
500M-1000M=1
1000M-1500M=2
\# 

或以下写法

\# 0-10000000=0
\# 10000001-20000000=1

1 2 3 4 5 6 7 8

<tableRule 

name

=

"mod-long"

\>
<rule>
<columns>

user_id

</columns>
<algorithm>

mod-long

</algorithm>
</rule>
</tableRule>
<function 

name

=

"mod-long"

class

=

"io.mycat.route.function.PartitionByMod"

\>

<!-- how many data nodes -->

<property 

name

=

"count"

\>

3

</property>
</function>

1 2 3 4 5 6 7 8 9
10
11

开课吧

java

高级架构师

配置说明：

tableRule标签：

columns 

：标识将要分片的表字段

algorithm 

：指定分片函数
function标签：

dateFormat 

：日期格式

sBeginDate 

：开始日期

sPartionDay 

：分区天数，即默认从开始日期算起，分隔10天一个分区

六、通配取模

配置说明：

tableRule标签：

columns 

：标识将要分片的表字段

algorithm 

：指定分片函数
function标签：

<tableRule 

name

=

"sharding-by-date"

\>
<rule>
<columns>

create_time

</columns>
<algorithm>

sharding-by-date

</algorithm>
</rule>
</tableRule>
<function 

name

=

"sharding-by-date"

class

=

"io.mycat.route.function..PartitionByDate"

\>
<property 

name

=

"dateFormat"

\>

yyyy-MM-dd

</property>
<property 

name

=

"sBeginDate"

\>

2014-01-01

</property>
<property 

name

=

"sPartionDay"

\>

10

</property>
</function>

1 2 3 4 5 6 7 8 9
10
11
12

<tableRule 

name

=

"sharding-by-pattern"

\>
<rule>
<columns>

user_id

</columns>
<algorithm>

sharding-by-pattern

</algorithm>
</rule>
</tableRule>
<function 

name

=

"sharding-by-pattern"

class

=

"io.mycat.route.function.PartitionByPattern"

\>
<property 

name

=

"patternValue"

\>

256

</property>
<property 

name

=

"defaultNode"

\>

2

</property>
<property 

name

=

"mapFile"

\>

partition-pattern.txt

</property>
</function>

1 2 3 4 5 6 7 8 9
10
11
12

开课吧

java

高级架构师

patternValue 

：求模基数

defaultNode 

：默认节点，如果不配置了默认，则默认是0即第一个结点

mapFile 

：配置文件路径

partition-pattern.txt文件内容:

配置文件中， 

1

\-

32 

即代表 

id%256 

后分布的范围，如果在1-32则在分区1，其他类推，如果id非数字数据，则会分
配在defaultNode 默认节点

七、ASCII码求模通配

配置说明：

tableRule标签：

columns 

：标识将要分片的表字段

algorithm 

：指定分片函数
function标签：

patternValue 

：求模基数

\# id partition range start-end ,data node index
\###### first host configuration
1-32=0
33-64=1
65-96=2
97-128=3
\######## second host configuration
129-160=4
161-192=5
193-224=6
225-256=7
0-0=7

1 2 3 4 5 6 7 8 9
10
11
12

<tableRule 

name

=

"sharding-by-prefixpattern"

\>
<rule>
<columns>

user_id

</columns>
<algorithm>

sharding-by-prefixpattern

</algorithm>
</rule>
</tableRule>
<function 

name

=

"sharding-by-pattern"

class

=

"io.mycat.route.function.PartitionByPrefixPattern"

\>
<property 

name

=

"patternValue"

\>

256

</property>
<property 

name

=

"prefixLength"

\>

5

</property>
<property 

name

=

"mapFile"

\>

partition-pattern.txt

</property>
</function>

1 2 3 4 5 6 7 8 9
10
11
12

开课吧

java

高级架构师

prefixLength 

：ASCII 截取的位数

mapFile 

：配置文件路径

partition-pattern.txt文件内容：

配置文件中， 

1

\-

32 

即代表 

id%256 

后分布的范围，如果在1-32则在分区1，其他类推
此种方式类似方式6，只不过采取的是将列中前prefixLength位所有ASCII码的和与patternValue 进行求模，即

sum%patternValue 

,获取的值在通配范围内的，即分片数。

ASCII编码：
48-57=0-9阿拉伯数字
64、65-90=@、A-Z
97-122=a-z

八、编程指定

\# range start-end ,data node index
\# ASCII
\# 48-57=0-9
\# 64

、

65-90=@

、

A-Z
\# 97-122=a-z
\###### first host configuration
1-4=0
5-8=1
9-12=2
13-16=3
\###### second host configuration
17-20=4
21-24=5
25-28=6
29-32=7
0-0=7

1 2 3 4 5 6 7 8 9
10
11
12
13
14
15
16

开课吧

java

高级架构师

配置说明：

tableRule标签：

columns 

：标识将要分片的表字段

algorithm 

：指定分片函数
function标签：

startIndex 

：字符串截取的起始索引位置

size 

：截取的位数

partitionCount 

：分区数量

defaultPartition 

：默认分区
此方法为直接根据字符子串（必须是数字）计算分区号（由应用传递参数，显式指定分区号）。
例如id=05-100000002
在此配置中代表根据id中从startIndex=0，开始，截取siz=2位数字即05，05就是获取的分区，如果没传默认分配
到defaultPartition

九、字符串拆分hash解析

<tableRule 

name

=

"sharding-by-substring"

\>
<rule>
<columns>

user_id

</columns>
<algorithm>

sharding-by-substring

</algorithm>
</rule>
</tableRule>
<function 

name

=

"sharding-by-substring"

class

=

"io.mycat.route.function.PartitionDirectBySubString"

\>
<property 

name

=

"startIndex"

\>

0

</property> 

<!-- zero-based -->

<property 

name

=

"size"

\>

2

</property>
<property 

name

=

"partitionCount"

\>

8

</property>
<property 

name

=

"defaultPartition"

\>

0

</property>
</function>

1 2 3 4 5 6 7 8 9
10
11
12
13

开课吧

java

高级架构师

配置说明：

tableRule标签：

columns 

：标识将要分片的表字段

algorithm 

：指定分片函数
function标签：

length 

：代表字符串hash求模基数

count 

：分区数

hashSlice 

： hash预算位，即根据子字符串 hash运算

"2" -> (0,2)
"1:2" -> (1,2
"1:" -> (1,0)
"-1:" -> (-1,0)
":-1" -> (0,-1)
":" -> (0,0)

<tableRule 

name

=

"sharding-by-stringhash"

\>
<rule>
<columns>

user_id

</columns>
<algorithm>

sharding-by-stringhash

</algorithm>
</rule>
</tableRule>
<function 

name

=

"sharding-by-substring"

class

=

"io.mycat.route.function.PartitionByString"

\>
<property 

name

=

"length"

\>

512

</property> 

<!-- zero-based -->

<property 

name

=

"count"

\>

2

</property>
<property 

name

=

"hashSlice"

\>

0:2

</property>
</function>

1 2 3 4 5 6 7 8 9
10
11
12

public class 

PartitionByStringTest 

{

@Test

public 

void 

test

() {

PartitionByString rule 

= 

new 

PartitionByString

();

String 

idVal

=

null

;

rule

.

setPartitionLength

(

"512"

);

rule

.

setPartitionCount

(

"2"

);

rule

.

init

();

rule

.

setHashSlice

(

"0:2"

);

// idVal = "0";
// Assert.assertEquals(true, 0 == rule.calculate(idVal));

1 2 3 4 5 6 7 8 9
10
11
12

开课吧

java

高级架构师

十、一致性hash

一致性hash预算有效解决了分布式数据的扩容问题，前1-9中id规则都多少存在数据扩容难题，而10规则解决了数
据扩容难点

测试分片

需求

// idVal = "45a";
// Assert.assertEquals(true, 1 == rule.calculate(idVal));
//last 4

rule 

= 

new 

PartitionByString

();

rule

.

setPartitionLength

(

"512"

);

rule

.

setPartitionCount

(

"2"

);

rule

.

init

();

//last 4 characters

rule

.

setHashSlice

(

"-4:0"

);

idVal 

= 

"aaaabbb0000"

;

Assert

.

assertEquals

(

true

, 

0 

== 

rule

.

calculate

(

idVal

));

idVal 

= 

"aaaabbb2359"

;

Assert

.

assertEquals

(

true

, 

0 

== 

rule

.

calculate

(

idVal

));
}

13
14
15
16
17
18
19
20
21
22
23
24
25
26
27
28
29

<tableRule 

name

=

"sharding-by-murmur"

\>
<rule>
<columns>

user_id

</columns>
<algorithm>

murmur

</algorithm>
</rule>
</tableRule>
<function 

name

=

"murmur"

class

=

"io.mycat.route.function.PartitionByMurmurHash"

\>

<!-- 

默认是

0 -->

<property 

name

=

"seed"

\>

0

</property>

<!-- 

要分片的数据库节点数量，必须指定，否则没法分片 

-->

<property 

name

=

"count"

\>

2

</property>

<!-- 

一个实际的数据库节点被映射为这么多虚拟节点，默认是

160

倍，也就是虚拟节点数是物理节点数的

160

倍 

-->

<property 

name

=

"virtualBucketTimes"

\>

160

</property>

<!-- <property name="weightMapFile">weightMapFile</property> 

节点的权重，没有指定权重
的节点默认是

1

。以

properties

文件的格式填写，以从

0

开始到

count-1

的整数值也就是节点索引为

key

，以节点权
重值为值。所有权重值必须是正整数，否则以

1

代替 

-->
<!-- <property name="bucketMapPath">/etc/mycat/bucketMapPath</property>

用于测试时观察各物理节点与虚拟节点的分布情况，如果指定了这个属性，会把虚拟节点的

murmur hash

值与物理节点的映射按行输出到这个文件，没有默认值，如果不指定，就不会输出任何东西 

-->

</function>

1 2 3 4 5 6 7 8 9
10
11
12
13
14
15
16
17
18

开课吧

java

高级架构师

把商品表分片存储到三个数据节点上。

创建表

配置完毕后，重新启动mycat。使用mysql客户端连接mycat，创建表。

分片测试

分片策略指定为“auto-sharding-long”
分片规则指定为“mod-long”

用户购物下单实践

需求

需求：把订单信息分片，商家要查询出售的订单，用户要查询自己的订单。
表设计：用户、商家订单、订单明细、用户订单
分片规则：
“用户表”---user_id 取模，“商家订单”----seller_user_id 取模
“订单明细”----“商家订单”ER 分片，“买家订单”----buyer_user_id 取模

CREATE TABLE 

`item` 

(

`id` 

int

(

11

) 

NOT 

NULL

,

`name` 

varchar

(

20

) 

DEFAULT 

NULL

,

PRIMARY KEY 

(

`id`

)
) 

ENGINE

=

InnoDB DEFAULT 

CHARSET

=utf8;

1 2 3 4 5 6

开课吧

java

高级架构师

业务表
服务器分配

mysql：

CREATE TABLE 

tb_user (
login_name 

VARCHAR 

(

32

) 

comment 

'

登录名

'

,
user_id 

BIGINT 

comment 

'

用户标识

'

,
TYPE 

INT 

comment 

'

用户类型 

1 

商家，

2

买家

'

,
passwd 

VARCHAR 

(

128

) 

comment 

'

密码

'

,

primary key 

(user_id)
) ;

alter table 

tb_user 

comment 

'

用户表

'

;

CREATE TABLE 

tb_seller_order (
seller_user_id 

BIGINT 

comment 

'

商家标识

'

,
buyer_user_id 

BIGINT 

comment 

'

用户标识

'

,
order_id 

BIGINT 

comment 

'

订单标识

'

,
price 

BIGINT 

comment 

'

价格

'

,

STATUS 

INT 

comment 

'

状态

'

,

primary key 

(order_id)
);

alter table 

tb_seller_order 

comment 

'

商家订单表

'

;

CREATE TABLE 

tb_order_detail(
seller_user_id 

BIGINT 

comment 

'

商家标识

'

,
order_detail_id 

BIGINT 

comment 

'

订单明细标识

'

,
order_id 

BIGINT 

comment 

'

订单标识

'

,
goods_id 

BIGINT 

comment 

'

标识

'

,
goods_name 

VARCHAR

(

32

) 

comment 

'

商品名称

'

,
cnt 

INT 

comment 

'

数量

'

,
unit_price 

INT 

comment 

'

单价

'

,

primary key 

(order_detail_id)
);

alter table 

tb_order_detail 

comment 

'

订单明细

'

;

CREATE TABLE 

tb_buyer_order (
buyer_user_id 

BIGINT 

comment 

'

用户标识

'

,
seller_user_id 

BIGINT 

comment 

'

商家标识

'

,
order_id 

BIGINT 

comment 

'

订单标识

'

,
price 

BIGINT 

comment 

'

价格

'

,

STATUS 

INT 

comment 

'

状态

'

,

primary key 

(order_id)
);

alter table 

tb_buyer_order 

comment 

'

买家订单

'

;

1 2 3 4 5 6 7 8 9
10
11
12
13
14
15
16
17
18
19
20
21
22
23
24
25
26
27
28
29
30
31
32
33
34
35
36
37
38
39
40
41
42
43

开课吧

java

高级架构师

mycat：

表主键生成策略

使用mycat全局序列生成（mycat 全局序列号：

http://blog.csdn.net/convict_eva/article/details/51917
499

）
添加mycat全局序列号：
在dn_master结点执行：
重启mycat测试：

rule.xml配置

配置function 标签

找到function 标签name="mod-long" 的function 配置，修改总结点数为3（和使用的mysql 结点数一致）。

主 

192.168.10.135

主 

192.168.10.136

主 

192.168.10.137

1 2 3
1 

192.168.10.137
USER_ID_SQUE=dn_master
ORDER_ID_SQUE=dn_master
DETAIL_ID_SQUE=dn_master

1 2 3

insert into 

MYCAT_SEQUENCE(NAME,current_value,increment)

values

(

'USER_ID_SQUE'

,

1

,

100

),(

'ORDER_ID_SQUE'

,

1

,

100

),(

'DETAIL_ID_SQUE'

,

1

,

100

);

1 2

SELECT NEXT VALUE FOR 

MYCATSEQ_USER_ID_SQUE;

SELECT NEXT VALUE FOR 

MYCATSEQ_ORDER_ID_SQUE;

SELECT NEXT VALUE FOR 

MYCATSEQ_DETAIL_ID_SQUE;

1 2 3

开课吧

java

高级架构师

配置tableRule标签
注意事项：name 要全局唯一

rule.xml 配置添加如下配置

schema.xml 配置

<function 

name

=

"mod-long" 

class

=

"org.opencloudb.route.function.PartitionByMod"

\>

<!-- how many data nodes -->

<property 

name

=

"count"

\>

3

</property>
</function>

1 2 3 4

<!-- user

分片规则 

-->

<tableRule 

name

=

"tb_user_mod-long"

\>
<rule>

<!-- 

分片使用的字段 

-->

<columns>

user_id

</columns>

<!-- 

分片使用的方法，对应

function 

名称 

-->

<algorithm>

mod-long

</algorithm>
</rule>
</tableRule>

<!-- 

卖家订单分片规则 

-->

<tableRule 

name

=

"seller_order_mod-long"

\>
<rule>
<columns>

seller_user_id

</columns>
<algorithm>

mod-long

</algorithm>
</rule>
</tableRule>

<!-- 

买家订单分片规则 

-->

<tableRule 

name

=

"buyer_order_mod-long"

\>
<rule>
<columns>

buyer_user_id

</columns>
<algorithm>

mod-long

</algorithm>
</rule>
</tableRule>

1 2 3 4 5 6 7 8 9
10
11
12
13
14
15
16
17
18
19
20
21
22
23
24

<?xml version="1.0"?>
<!DOCTYPE mycat:schema SYSTEM "schema.dtd">

<mycat:schema 

xmlns:mycat

=

"http://org.opencloudb/"

\>
<schema 

name

=

"TESTDB" 

checkSQLschema

=

"false" 

sqlMaxLimit

=

"100"

\>

<!-- auto sharding by id (long) -->

<table 

name

=

"tb_a" 

dataNode

=

"dn_master" 

/>

<!-- 

全局表，使用

type

属性指定，多个结点要都执行建表语句。所有结点的数据一致。 

-->

<table 

name

=

"tb_global_test"

1 2 3 4 5 6 7 8 9

开课吧

java

高级架构师

dataNode

=

"dn_master,dn_master2,dn_master3" 

type

=

"global" 

/>

<!-- 

配置表所在的分片结点，指定主键和分片规则。指定主键是为了使用主键查询时

mycat

什么缓存主
键对应的

dn

，提高查询效率。 

-->

<table 

name

=

"tb_user" 

rule

=

"tb_user_mod-long"

primaryKey

=

"user_id" 

dataNode

=

"dn_master,dn_master2,dn_master3" 

/>
<table 

name

=

"tb_seller_order" 

rule

=

"seller_order_mod-long"

primaryKey

=

"order_id" 

dataNode

=

"dn_master,dn_master2,dn_master3"

\>

<!-- 

配置

ER 

分片，子表的存储依赖于主表，并且物理上紧邻存放。 

-->

<childTable 

name

=

"tb_order_detail"

primaryKey

=

"order_detail_id" 

joinKey

=

"order_id" 

parentKey

=

"order_id"

/>
</table>
<table 

name

=

"tb_buyer_order" 

rule

=

"buyer_order_mod-long"

primaryKey

=

"order_id" 

dataNode

=

"dn_master,dn_master2,dn_master3" 

/>
</schema>

<!-- 

配置数据结点 

-->

<dataNode 

name

=

"dn_master" 

dataHost

=

"master"

database

=

"test_db" 

/>
<dataNode 

name

=

"dn_master2" 

dataHost

=

"master2"

database

=

"test_db" 

/>
<dataNode 

name

=

"dn_master3" 

dataHost

=

"master3"

database

=

"test_db" 

/>

<!-- ddata node host 

配置 

-->

<dataHost 

name

=

"master" 

maxCon

=

"1000" 

minCon

=

"10" 

balance

=

"3"

writeType

=

"0" 

dbType

=

"mysql" 

dbDriver

=

"native" 

switchType

=

"1"

slaveThreshold

=

"100"

\>

<!-- 

主从心跳语句配置 

-->

<heartbeat>

show slave status

</heartbeat>
<writeHost 

host

=

"hostM1" 

url

=

"192.168.109.128:3306"

user

=

"root" 

password

=

"Abc123!@#"

\>

<!-- 

从库 

-->

<readHost 

host

=

"hostS2" 

url

=

"192.168.109.130:3306"

user

=

"root" 

password

=

"Abc123!@#" 

/>
</writeHost>
</dataHost>
<dataHost 

name

=

"master2" 

maxCon

=

"1000" 

minCon

=

"10" 

balance

=

"0"

writeType

=

"0" 

dbType

=

"mysql" 

dbDriver

=

"native" 

switchType

=

"1"

slaveThreshold

=

"100"

\>
<heartbeat>

select user()

</heartbeat>
<writeHost 

host

=

"hostM2" 

url

=

"192.168.109.131:3306"

user

=

"root" 

password

=

"Abc123!@#"

\></writeHost>
</dataHost>
<dataHost 

name

=

"master3" 

maxCon

=

"1000" 

minCon

=

"10" 

balance

=

"0"

writeType

=

"0" 

dbType

=

"mysql" 

dbDriver

=

"native" 

switchType

=

"1"

slaveThreshold

=

"100"

\>
<heartbeat>

select user()

</heartbeat>
<writeHost 

host

=

"hostM3" 

url

=

"192.168.109.132:3306"

10
11
12
13
14
15
16
17
18
19
20
21
22
23
24
25
26
27
28
29
30
31
32
33
34
35
36
37
38
39
40
41
42
43
44
45
46
47
48
49
50
51
52
53
54
55
56
57
58
59
60

开课吧

java

高级架构师

重启mycat，使用SQLyog连接到mycat，并执行建表语句。

测试

插入user

user

=

"root" 

password

=

"Abc123!@#"

\></writeHost>
</dataHost>
</mycat:schema>

61
62
63

INSERT INTO 

`tb_user`

(

`login_name`

,

`user_id`

,

`TYPE`

,

`passwd`

)

VALUES 

(

'name-1'

,

NEXT VALUE FOR 

MYCATSEQ_USER_ID_SQUE,

1

,

'passwd-A'

);

INSERT INTO 

`tb_user`

(

`login_name`

,

`user_id`

,

`TYPE`

,

`passwd`

)

VALUES 

(

'name-2'

,

NEXT VALUE FOR 

MYCATSEQ_USER_ID_SQUE,

1

,

'passwd-A'

);

INSERT INTO 

`tb_user`

(

`login_name`

,

`user_id`

,

`TYPE`

,

`passwd`

)

VALUES 

(

'name-3'

,

NEXT VALUE FOR 

MYCATSEQ_USER_ID_SQUE,

1

,

'passwd-A'

);

INSERT INTO 

`tb_user`

(

`login_name`

,

`user_id`

,

`TYPE`

,

`passwd`

)

VALUES 

(

'name-4'

,

NEXT VALUE FOR 

MYCATSEQ_USER_ID_SQUE,

1

,

'passwd-A'

);

INSERT INTO 

`tb_user`

(

`login_name`

,

`user_id`

,

`TYPE`

,

`passwd`

)

VALUES 

(

'name-5'

,

NEXT VALUE FOR 

MYCATSEQ_USER_ID_SQUE,

1

,

'passwd-A'

);

INSERT INTO 

`tb_user`

(

`login_name`

,

`user_id`

,

`TYPE`

,

`passwd`

)

VALUES 

(

'name-6'

,

NEXT VALUE FOR 

MYCATSEQ_USER_ID_SQUE,

1

,

'passwd-A'

);

INSERT INTO 

`tb_user`

(

`login_name`

,

`user_id`

,

`TYPE`

,

`passwd`

)

VALUES 

(

'name-7'

,

NEXT VALUE FOR 

MYCATSEQ_USER_ID_SQUE,

1

,

'passwd-A'

);

INSERT INTO 

`tb_user`

(

`login_name`

,

`user_id`

,

`TYPE`

,

`passwd`

)

VALUES 

(

'name-8'

,

NEXT VALUE FOR 

MYCATSEQ_USER_ID_SQUE,

1

,

'passwd-A'

);

INSERT INTO 

`tb_user`

(

`login_name`

,

`user_id`

,

`TYPE`

,

`passwd`

)

VALUES 

(

'name-9'

,

NEXT VALUE FOR 

MYCATSEQ_USER_ID_SQUE,

1

,

'passwd-A'

);

INSERT INTO 

`tb_user`

(

`login_name`

,

`user_id`

,

`TYPE`

,

`passwd`

)

VALUES 

(

'name-10'

,

NEXT VALUE FOR 

MYCATSEQ_USER_ID_SQUE,

1

,

'passwd-A'

);

INSERT INTO 

`tb_user`

(

`login_name`

,

`user_id`

,

`TYPE`

,

`passwd`

)

VALUES 

(

'name-11'

,

NEXT VALUE FOR 

MYCATSEQ_USER_ID_SQUE,

1

,

'passwd-A'

);

INSERT INTO 

`tb_user`

(

`login_name`

,

`user_id`

,

`TYPE`

,

`passwd`

)

VALUES 

(

'name-12'

,

NEXT VALUE FOR 

MYCATSEQ_USER_ID_SQUE,

1

,

'passwd-A'

);

INSERT INTO 

`tb_user`

(

`login_name`

,

`user_id`

,

`TYPE`

,

`passwd`

)

VALUES 

(

'name-13'

,

NEXT VALUE FOR 

MYCATSEQ_USER_ID_SQUE,

1

,

'passwd-A'

);

INSERT INTO 

`tb_user`

(

`login_name`

,

`user_id`

,

`TYPE`

,

`passwd`

)

VALUES 

(

'name-14'

,

NEXT VALUE FOR 

MYCATSEQ_USER_ID_SQUE,

1

,

'passwd-A'

);

INSERT INTO 

`tb_user`

(

`login_name`

,

`user_id`

,

`TYPE`

,

`passwd`

)

VALUES 

(

'name-15'

,

NEXT VALUE FOR 

MYCATSEQ_USER_ID_SQUE,

1

,

'passwd-A'

);

INSERT INTO 

`tb_user`

(

`login_name`

,

`user_id`

,

`TYPE`

,

`passwd`

)

VALUES 

(

'name-16'

,

NEXT VALUE FOR 

MYCATSEQ_USER_ID_SQUE,

1

,

'passwd-A'

);

INSERT INTO 

`tb_user`

(

`login_name`

,

`user_id`

,

`TYPE`

,

`passwd`

)

VALUES 

(

'name-17'

,

NEXT VALUE FOR 

MYCATSEQ_USER_ID_SQUE,

1

,

'passwd-A'

);

INSERT INTO 

`tb_user`

(

`login_name`

,

`user_id`

,

`TYPE`

,

`passwd`

)

VALUES 

(

'name-18'

,

NEXT VALUE FOR 

MYCATSEQ_USER_ID_SQUE,

1

,

'passwd-A'

);

INSERT INTO 

`tb_user`

(

`login_name`

,

`user_id`

,

`TYPE`

,

`passwd`

)

VALUES 

(

'name-19'

,

NEXT VALUE FOR 

MYCATSEQ_USER_ID_SQUE,

1

,

'passwd-A'

);

INSERT INTO 

`tb_user`

(

`login_name`

,

`user_id`

,

`TYPE`

,

`passwd`

)

VALUES 

(

'name-20'

,

NEXT VALUE FOR 

MYCATSEQ_USER_ID_SQUE,

1

,

'passwd-A'

);

INSERT INTO 

`tb_user`

(

`login_name`

,

`user_id`

,

`TYPE`

,

`passwd`

)

1 2 3 4 5 6 7 8 9
10
11
12
13
14
15
16
17
18
19
20
21
22
23
24
25
26
27
28
29
30
31
32
33
34
35
36
37
38
39
40
41

开课吧

java

高级架构师

查看插入的数据是否按照id取模分片。

下单测试

上面创建的是商家用户，下面创建买家用户。
所有的用户如下： mysql> select * from tb_user order by login_name; +------------+---------+---
---+----------+ | login_name | user_id | TYPE | passwd | +------------+---------+------+---
-------+ | buyer-1 | 248 | 2 | passwd-A | | buyer-2 | 249 | 2 | passwd-A
| | buyer-3 | 250 | 2 | passwd-A | | name-1 | 225 | 1 | passwd-A | |
name-10 | 234 | 1 | passwd-A | | name-11 | 235 | 1 | passwd-A | | name-12
| 236 | 1 | passwd-A | | name-13 | 237 | 1 | passwd-A | | name-14 |
238 | 1 | passwd-A | | name-15 | 239 | 1 | passwd-A | | name-16 | 240 |
1 | passwd-A | | name-17 | 241 | 1 | passwd-A | | name-18 | 242 | 1 |
passwd-A | | name-19 | 243 | 1 | passwd-A | | name-2 | 226 | 1 | passwdA | | name-20 | 244 | 1 | passwd-A | | name-21 | 245 | 1 | passwd-A | |
name-22 | 246 | 1 | passwd-A | | name-23 | 247 | 1 | passwd-A | | name-3
| 227 | 1 | passwd-A | | name-4 | 228 | 1 | passwd-A | | name-5 |
229 | 1 | passwd-A | | name-6 | 230 | 1 | passwd-A | | name-7 | 231 |
1 | passwd-A | | name-8 | 232 | 1 | passwd-A | | name-9 | 233 | 1 |
passwd-A | +------------+---------+------+----------+
下单：

VALUES 

(

'name-21'

,

NEXT VALUE FOR 

MYCATSEQ_USER_ID_SQUE,

1

,

'passwd-A'

);

INSERT INTO 

`tb_user`

(

`login_name`

,

`user_id`

,

`TYPE`

,

`passwd`

)

VALUES 

(

'name-22'

,

NEXT VALUE FOR 

MYCATSEQ_USER_ID_SQUE,

1

,

'passwd-A'

);

INSERT INTO 

`tb_user`

(

`login_name`

,

`user_id`

,

`TYPE`

,

`passwd`

)

VALUES 

(

'name-23'

,

NEXT VALUE FOR 

MYCATSEQ_USER_ID_SQUE,

1

,

'passwd-A'

);

42
43
44
45
46

INSERT INTO 

`tb_user`

(

`login_name`

,

`user_id`

,

`TYPE`

,

`passwd`

)

VALUES 

(

'buyer-1'

,

NEXT VALUE FOR 

MYCATSEQ_USER_ID_SQUE,

2

,

'passwd-A'

);

INSERT INTO 

`tb_user`

(

`login_name`

,

`user_id`

,

`TYPE`

,

`passwd`

)

VALUES 

(

'buyer-2'

,

NEXT VALUE FOR 

MYCATSEQ_USER_ID_SQUE,

2

,

'passwd-A'

);

INSERT INTO 

`tb_user`

(

`login_name`

,

`user_id`

,

`TYPE`

,

`passwd`

)

VALUES 

(

'buyer-3'

,

NEXT VALUE FOR 

MYCATSEQ_USER_ID_SQUE,

2

,

'passwd-A'

);

1 2 3 4 5 6 7 8

开课吧

java

高级架构师

说明：商家225 在109.128 上，tb_seller_order表根据seller_user_id 取模分片，所有此订单数据存储在与
user id为225 的商家同一分片 tb_order_detail 表使用的是与tb_seller_order ER 分片，使用order_id 关
联，所以tb_order_detail 存储的分片与相同的order_id 的tb_seller_order 的数据在同一分片。
再测试一条数据：user_id为238 的用户存储在109.131 分片上。
测试结果： 109.128数据为： mysql> select * from tb_user; +------------+---------+------+------
----+ | login_name | user_id | TYPE | passwd | +------------+---------+------+----------+ |
name-1 | 225 | 1 | passwd-A | | name-4 | 228 | 1 | passwd-A | | name-7
| 231 | 1 | passwd-A | | name-10 | 234 | 1 | passwd-A | | name-13 |
237 | 1 | passwd-A | | name-16 | 240 | 1 | passwd-A | | name-19 | 243 |
1 | passwd-A | | name-22 | 246 | 1 | passwd-A | | buyer-2 | 249 | 2 |
passwd-A | +------------+---------+------+----------+ 9 rows in set (0.00 sec)
mysql> select * from tb_seller_order; +----------------+---------------+----------+-------+--
------+ | seller_user_id | buyer_user_id | order_id | price | STATUS | +----------------+----
-----------+----------+-------+--------+ | 225 | 248 | 201 | 1222
| NULL | +----------------+---------------+----------+-------+--------+ 1 row in set (0.00
sec)

SELECT NEXT VALUE FOR 

MYCATSEQ_ORDER_ID_SQUE;

INSERT INTO 

`tb_seller_order`

(

`seller_user_id`

,

`buyer_user_id`

,

`order_id`

,

`price`

)

VALUES 

(

225

,

248

,

201

,

1222

);

INSERT INTO 

`tb_order_detail`

(

`seller_user_id`

,

`order_detail_id`

,

`order_id`

,

`goods_id`

,

`goods_name`

,

`cnt`

,

`unit_pr
ice`

)

VALUES 

(

225

, 

NEXT VALUE FOR 

MYCATSEQ_DETAIL_ID_SQUE,

201

,

11

,

'goods_name'

,

1

,

1220

);

INSERT INTO 

`tb_order_detail`

(

`seller_user_id`

,

`order_detail_id`

,

`order_id`

,

`goods_id`

,

`goods_name`

,

`cnt`

,

`unit_pr
ice`

)

VALUES 

(

225

, 

NEXT VALUE FOR 

MYCATSEQ_DETAIL_ID_SQUE,

201

,

11

,

'goods_name2'

,

1

,

2

);

1 2 3 4 5 6 7 8 9
10
11
12

INSERT INTO 

`tb_seller_order`

(

`seller_user_id`

,

`buyer_user_id`

,

`order_id`

,

`price`

)

VALUES 

(

238

,

248

,

203

,

1222

);

INSERT INTO 

`tb_order_detail`

(

`seller_user_id`

,

`order_detail_id`

,

`order_id`

,

`goods_id`

,

`goods_name`

,

`cnt`

,

`unit_pri
ce`

)

VALUES 

(

238

, 

NEXT VALUE FOR 

MYCATSEQ_DETAIL_ID_SQUE,

203

,

11

,

'goods_name'

,

1

,

1220

);

INSERT INTO 

`tb_order_detail`

(

`seller_user_id`

,

`order_detail_id`

,

`order_id`

,

`goods_id`

,

`goods_name`

,

`cnt`

,

`unit_pri
ce`

)

VALUES 

(

238

, 

NEXT VALUE FOR 

MYCATSEQ_DETAIL_ID_SQUE,

203

,

11

,

'goods_name2'

,

1

,

2

);

1 2 3 4 5 6 7 8 9

开课吧

java

高级架构师

mysql> select * from tb_order_detail; +----------------+-----------------+----------+--------
--+-------------+------+------------+ | seller_user_id | order_detail_id | order_id |
goods_id | goods_name | cnt | unit_price | +----------------+-----------------+----------+-
---------+-------------+------+------------+ | 225 | 201 | 201 |
11 | goods_name | 1 | 1220 | | 225 | 202 | 201 |
11 | goods_name2 | 1 | 2 | +----------------+-----------------+----------+-
---------+-------------+------+------------+ 2 rows in set (0.00 sec)
109.131数据为： mysql> select * from tb_user; +------------+---------+------+----------+ |
login_name | user_id | TYPE | passwd | +------------+---------+------+----------+ | name-2
| 226 | 1 | passwd-A | | name-5 | 229 | 1 | passwd-A | | name-8 |
232 | 1 | passwd-A | | name-11 | 235 | 1 | passwd-A | | name-14 | 238 |
1 | passwd-A | | name-17 | 241 | 1 | passwd-A | | name-20 | 244 | 1 |
passwd-A | | name-23 | 247 | 1 | passwd-A | | buyer-3 | 250 | 2 | passwdA | +------------+---------+------+----------+ 9 rows in set (0.00 sec)
mysql> select * from tb_seller_order; +----------------+---------------+----------+-------+--
------+ | seller_user_id | buyer_user_id | order_id | price | STATUS | +----------------+----
-----------+----------+-------+--------+ | 238 | 248 | 203 | 1222
| NULL | +----------------+---------------+----------+-------+--------+ 1 row in set (0.00
sec)
mysql> select * from tb_order_detail; +----------------+-----------------+----------+--------
--+-------------+------+------------+ | seller_user_id | order_detail_id | order_id |
goods_id | goods_name | cnt | unit_price | +----------------+-----------------+----------+-
---------+-------------+------+------------+ | 238 | 203 | 203 |
11 | goods_name | 1 | 1220 | | 238 | 204 | 203 |
11 | goods_name2 | 1 | 2 | +----------------+-----------------+----------+-
---------+-------------+------+------------+ 2 rows in set (0.00 sec)

Mycat读写分离

MyCat的读写分离是建立在MySQL主从复制基础之上实现的，所以必须先搭建MySQL的主从复制。
数据库读写分离对于大型系统或者访问量很高的互联网应用来说，是必不可少的一个重要功能。对于MySQL来说，标
准的读写分离是主从模式，一个写节点Master后面跟着多个读节点，读节点的数量取决于系统的压力，通常是1-3个
读节点的配置

开课吧

java

高级架构师

Mycat实现的读写分离和自动切换机制，需要mysql的主从复制机制配合。

Mycat配置

Mycat 1.4 支持MySQL主从复制状态绑定的读写分离机制，让读更加安全可靠，配置如下：

(1) 设置 balance="1"与writeType="0"

Balance参数设置：

1. balance=“0”, 所有读操作都发送到当前可用的writeHost上。
2. balance=“1”，所有读操作都随机的发送到readHost。
3. balance=“2”，所有读操作都随机的在writeHost、readhost上分发
   WriteType参数设置：
4. writeType=“0”, 所有写操作都发送到可用的writeHost上。
5. writeType=“1”，所有写操作都随机的发送到readHost。
6. writeType=“2”，所有写操作都随机的在writeHost、readhost分上发。

<dataNode 

name

=

"dn1" 

dataHost

=

"localhost1" 

database

=

"db1" 

/>
<dataNode 

name

=

"dn2" 

dataHost

=

"localhost1" 

database

=

"db2" 

/>
<dataNode 

name

=

"dn3" 

dataHost

=

"localhost1" 

database

=

"db3" 

/>
<dataHost 

name

=

"localhost1" 

maxCon

=

"1000" 

minCon

=

"10" 

balance

=

"1"

writeType

=

"0" 

dbType

=

"mysql" 

dbDriver

=

"native" 

switchType

=

"2"

slaveThreshold

=

"100"

\>
<heartbeat>

show slave status

</heartbeat>
<writeHost 

host

=

"hostM" 

url

=

"192.168.25.134:3306" 

user

=

"root"

password

=

"root"

\>
<readHost 

host

=

"hostS" 

url

=

"192.168.25.166:3306" 

user

=

"root"

password

=

"root" 

/>
</writeHost>
</dataHost>

1 2 3 4 5 6 7 8 9
10
11
12

开课吧

java

高级架构师

“readHost是从属于writeHost的，即意味着它从那个writeHost获取同步数据，因此，当它所属的writeHost宕
机了，则它也不会再参与到读写分离中来，即“不工作了”，这是因为此时，它的数据已经“不可靠”了。基于这个
考虑，目前mycat 1.3和1.4版本中，若想支持MySQL一主一从的标准配置，并且在主节点宕机的情况下，从节点还
能读取数据，则需要在Mycat里配置为两个writeHost并设置banlance=1。”

(2) 设置 switchType="2" 与slaveThreshold="100"
switchType 目前有三种选择：
-1：表示不自动切换
1：默认值，自动切换
2：基于MySQL主从同步的状态决定是否切换

Mycat心跳检查语句配置为 show slave status ，dataHost 上定义两个新属性： switchType="2" 与
slaveThreshold="100"，此时意味着开启MySQL主从复制状态绑定的读写分离与切换机制。Mycat心跳机制通过检
测 show slave status 中的 

"Seconds_Behind_Master", "Slave_IO_Running", "Slave_SQL_Running"

三个字段来确定当前主从同步的状态以及Seconds_Behind_Master主从复制时延。

总结
作业

开课吧

java

高级架构师