# MySQL锁

## MySQL锁介绍

- 按照锁的粒度来说，MySQL主要包含三种类型（级别）的锁定机制：
  - 全局锁：对整个数据库实例加锁。命令是`Flush tables with read lock(FTWRL)` ，做全库逻辑备份的时候使用
  - 表级锁：锁的是某个table。表级锁有两种：一种是表锁；一种是元数据锁（meta data lock，MDL)。表级锁的特点是开销小，加锁快；不会出现死锁；锁定粒度大，发生锁冲突的概率最高，并发度最低；
  - 行级锁：锁的是某行数据，也可能锁定行之间的间隙。由某些存储引擎实现，比如InnoDB。行级锁的特点是开销大，加锁慢；会出现死锁；锁定粒度最小，发生锁冲突的概率最低，并发度也最高；

- 按照锁的功能来说分为：共享读锁(S)和排他写锁(X)。
- 按照锁的实现方式分为：悲观锁和乐观锁（乐观锁：使用某一版本列或者唯一列进行逻辑控制）

## MySQL表级锁

查看表级锁定的争用状态变量：

```
mysql> show status like 'table_locks%';
+-----------------------+-------+
| Variable_name         | Value |
+-----------------------+-------+
| Table_locks_immediate | 70    |
| Table_locks_waited    | 0     |
+-----------------------+-------+
2 rows in set (0.03 sec)

table_locks_immediate：产生表级锁定的次数；
table_locks_waited：出现表级锁定争用而发生等待的次数；
```



### 表锁介绍

- 表锁有两种表现形式

```
表共享读锁（Table Read Lock）
表独占写锁（Table Write Lock）
```

- 手动增加表锁

```
lock table table_name read(write)[,table_name2 read(write)];
```

- 查看表锁情况

```
show open tables;
```


- 删除表锁

```
unlock tables;
```

### 表锁演示

#### 环境准备

```mysql
create table tb_lock (
id int(11) not null auto_increment,
name varchar(20) default null,
primary key (id)
);
insert into tb_lock (id,name) values (1, 'a');
insert into tb_lock (id,name) values (2, 'b');
insert into tb_lock (id,name) values (3, 'c');
insert into tb_lock (id,name) values (4, 'd');
```
#### 读锁演示

读操作阻塞写的例子

|      | session a                                                    | session b                                                    |
| ---- | ------------------------------------------------------------ | ------------------------------------------------------------ |
| 1    | **为tb_lock表加read锁**<br>mysql> lock table tb_lock read;<br>Query OK, 0 rows affected (0.00 sec) |                                                              |
| 2    | **当前会话可以查询该表记录**<br>mysql> select * from tb_lock;<br>4 rows in set (0.01 sec) | **其他会话，session b也可以查询该表记录**<br>mysql> select * from tb_lock;<br>4 rows in set (0.01 sec) |
|  3	 | **当前会话不能查询其他没有锁定的表**<br>mysql> select * from student;<br>ERROR 1100 (HY000): Table 'student' was not locked with LOCK TABLES |  **其他会话，session b可以查询其他没有锁定的表**<br>mysql> select * from student;<br>9 rows in set (0.00 sec)  |
| 4	|  **当前会话插入、修改或者删除锁定的表数据会提示错误**<br>mysql> delete from tb_lock where id=1;<br>ERROR 1099 (HY000): Table 'tb_lock' was locked with a READ lock and can't be updated | **其他会话，session b插入、修改或者删除锁定的表数据会进入等待**<br>mysql> delete from tb_lock where id=1;<br>**(blocked)** |
| 5	| **释放锁**<br>mysql> unlock table;<br>Query OK, 0 rows affected (0.01 sec) | **session b获得锁，删除操作成功**<br>mysql> delete from tb_lock where id=1;<br>Query OK, 1 row affected (**3 min 33.13 sec**) |



#### 写锁演示

写操作阻塞读的例子

|      | session a                                                    | session b                                                    |
| ---- | ------------------------------------------------------------ | ------------------------------------------------------------ |
| 1    | **为tb_lock表加write锁**<br>mysql> lock table tb_lock write;<br>Query OK, 0 rows affected (0.00 sec) |                                                              |
| 2    | **当前会话可以增删改查该表记录**<br>mysql> select * from tb_lock;<br>3 rows in set (0.01 sec)<br>mysql> insert into tb_lock (id,name) values (1, 'a');<br>Query OK, 1 row affected (0.03 sec)<br> | **其他会话，session b查询被阻塞**<br>mysql> select * from tb_lock;<br>**(blocked)** |
| 5    | **释放锁**<br>mysql> unlock table;<br>Query OK, 0 rows affected (0.01 sec) | **session b获得锁，查询操作成功**<br>mysql> select * from tb_lock;<br>4 rows in set(**33.77 sec**) |






### 元数据锁介绍

`MDL`不需要显式使用，在访问一个表的时候会被自动加上。`MDL`的作用是，保证读写的正确性。举个例子，如果一个查询正在遍历一个表中的数据，而执行期间另一个线程对这个表结构做变更，删除了一列，那么查询线程拿到的结果跟表结构对不上，这肯定是不行的。
因此，在`MySQL 5.5`版本中引入了`MDL`，当对一个表做增删改查操作的时候，加`MDL`读锁；当要对表做结构变更操作的时候，加`MDL`写锁。

- 读锁之间不互斥，可以有多个线程同时对一张表增删改查。
- 读写锁之间、写锁之间是互斥的，用来保证变更表结构操作的安全性。因此，如果有两个线程要同时给一个表加字段，其中一个要等另一个执行完才能开始执行。

### 元数据锁演示

| session a                                                    | session b                                                 | session c                                                | session d                                      |
| ------------------------------------------------------------ | --------------------------------------------------------- | -------------------------------------------------------- | ---------------------------------------------- |
| mysql> begin;<br/>Query OK, 0 rows affected (0.00 sec)<br>mysql> select * from tb_lock;<br>4 rows in set (0.00 sec) |                                                           |                                                          |                                                |
|                                                              | mysql> select * from tb_lock;<br>4 rows in set (0.00 sec) |                                                          |                                                |
|                                                              |                                                           | mysql> alter table tb_lock add age int;<br>**(blocked)** |                                                |
|                                                              |                                                           |                                                          | mysql> select * from tb_lock;<br>**(blocked)** |

1. 先启动`session a`，这时候会对表`tb_lock `加一个` MDL`读锁。由于读锁之间不互斥,`session b`需要的也是`MDL`读锁，因此可以正常执行。

2. `session c`修改`tb_lock`的表结构，会被`blocked`，是因为`session a`的`MDL`读锁还没有释放，而`session c`需要`MDL`写锁，因此只能被阻塞。

3. `session c`会阻塞后面的读写操作，像`session d`查询操作被阻塞。之前说了，所有对表的增删改查操作都需要先申请`MDL`读锁，所以现在这个表已经不可读写了。事务中的`MDL`锁，在语句执行开始时申请，但是语句结束后并不会马上释放，而会等到整个事务提交后再释放。

## MySQL行级锁

### 行级锁介绍

MySQL的行级锁，是由存储引擎来实现的，这里我们主要讲解InnoDB的行级锁。
- InnoDB的行级锁，按照锁定范围来说，分为三种：

  * 记录锁（Record Locks）：锁定索引中一条记录。
  * 间隙锁（Gap Locks）：要么锁住索引记录中间的值，要么锁住第一个索引记录前面的值或者最后一个索引记录后面的值。
  * Next-Key Locks：是索引记录上的记录锁和在索引记录之前的间隙锁的组合。
- InnoDB的行级锁，按照功能来说，分为两种：
  - 共享锁（S）：允许一个事务去读一行，阻止其他事务获得相同数据集的排他锁。
  - 排他锁（X）：允许获得排他锁的事务更新数据，阻止其他事务取得相同数据集的共享读锁和排他写锁。

对于UPDATE、DELETE和INSERT语句，InnoDB会自动给涉及数据集加排他锁（X)；

对于普通SELECT语句，InnoDB不会加任何锁，事务可以通过以下语句显示给记录集加共享锁或排他锁。 手动添加共享锁（S）：

```
SELECT * FROM table_name WHERE ... LOCK IN SHARE MODE;
```

手动添加排他锁（x）：

```
SELECT * FROM table_name WHERE ... FOR UPDATE;
```

- InnoDB也实现了表级锁，也就是意向锁，意向锁是mysql内部使用的，不需要用户干预。
  - 意向共享锁（IS）：事务打算给数据行加行共享锁，事务在给一个数据行加共享锁前必须先取得该表的IS锁。
  - 意向排他锁（IX）：事务打算给数据行加行排他锁，事务在给一个数据行加排他锁前必须先取得该表的IX锁。 

- 意向锁和行锁可以共存，意向锁的主要作用是为了【全表更新数据】时的性能提升。否则在全表更新数据时，需要先检索该范是否某些记录上面有行锁。

| 共享锁（S）      | 排他锁（X） | 意向共享锁（IS） | 意向排他锁（IX） |      |
| ---------------- | ----------- | ---------------- | ---------------- | ---- |
| 共享锁（S）      | 兼容        | 冲突             | 兼容             | 冲突 |
| 排他锁（X）      | 冲突        | 冲突             | 冲突             | 冲突 |
| 意向共享锁（IS） | 兼容        | 冲突             | 兼容             | 兼容 |
| 意向排他锁（IX） | 冲突        | 冲突             | 兼容             | 兼容 |

- InnoDB行锁是通过给索引上的索引项加锁来实现的，因此InnoDB这种行锁实现特点意味着：只有通过索引条件检索的数据，InnoDB才使用行级锁，否则，InnoDB将使用表锁！

- Innodb所使用的行级锁定争用状态查看：

```
mysql> show status like 'innodb_row_lock%';
+-------------------------------+-------+
| Variable_name                 | Value |
+-------------------------------+-------+
| Innodb_row_lock_current_waits | 0     |
| Innodb_row_lock_time          | 0     |
| Innodb_row_lock_time_avg      | 0     |
| Innodb_row_lock_time_max      | 0     |
| Innodb_row_lock_waits         | 0     |
+-------------------------------+-------+
5 rows in set (0.00 sec)

- Innodb_row_lock_current_waits：当前正在等待锁定的数量；
- Innodb_row_lock_time：从系统启动到现在锁定总时间长度；
- Innodb_row_lock_time_avg：每次等待所花平均时间（等待平均时长）；
- Innodb_row_lock_time_max：从系统启动到现在等待最常的一次所花的时间（等待总时长）；
- Innodb_row_lock_waits：系统启动后到现在总共等待的次数（等待总次数）；
```


当等待次数很高，而且每次等待时长也不小的时候，我们就需要分析系统中为什么会有如此多的等待，然后根据分析结果着手指定优化计划。

### InnoDB行锁演示

#### 创建表及索引

```
create table test_innodb_lock (a int(11),b varchar(16)) engine=innodb;
create index test_innodb_a_idx on test_innodb_lock(a);
create index test_innodb_lock_b_idx on test_innodb_lock(b);
```

#### 行锁定基本演示

|      | session a                                                    | session b                                                    |
| :--: | :----------------------------------------------------------- | ------------------------------------------------------------ |
|  1   | mysql> set autocommit=0; <br>Query OK, 0 rows affected (0.00 sec) | mysql> set autocommit=0; <br> Query OK, 0 rows affected (0.00 sec) |
|  2   | mysql> update test_innodb_lock set b = 'b1' where a = 1;<br>Query OK, 1 row affected (0.00 sec) Rows matched: 1 Changed: 1 Warnings: 0 <br>更新，但是不提交 |                                                              |
|  3   |                                                              | mysql> update test_innodb_lock set b = 'b2' where a = 1; <br>**(blocked)** |
|  4   | mysql> commit;<br>Query OK, 0 rows affected (0.05 sec)       |                                                              |
|  5   |                                                              | mysql> update test_innodb_lock set b = 'b2' where a = 1;<br/>Query OK, 0 rows affected (36.14 sec) Rows matched: 1 Changed: 0 Warnings: 0 |

#### 无索引升级为表锁演示

|      | Session a                                                    | Session b                                                    |
| ---- | ------------------------------------------------------------ | ------------------------------------------------------------ |
| 1    | mysql> set autocommit=0; <br/>Query OK, 0 rows affected (0.00 sec) | mysql> set autocommit=0;<br/> Query OK, 0 rows affected (0.00 sec) |
| 2    | mysql> update test_innodb_lock set b = '2' where b = 2000;<br/>Query OK, 1 row affected (0.02 sec) Rows matched: 1 Changed: 1 Warnings: 0 | mysql> update test_innodb_lock set b = '3' where b = 3000;<br/> **(blocked)** |
| 3    | mysql> commit; <br/>Query OK, 0 rows affected (0.10 sec)     |                                                              |
| 4    |                                                              |   mysql> update test_innodb_lock set b = '3' where b = 3000; <br/>Query OK, 1 row affected (36.41 sec) Rows matched: 1 Changed: 1 Warnings: 0                                                           |

#### 间隙锁带来的插入问题演示

|      | Session a                                                    | Session b                                                    |
| ---- | ------------------------------------------------------------ | ------------------------------------------------------------ |
| 1    | mysql> set autocommit=0; <br>Query OK, 0 rows affected (0.00 sec) | mysql> set autocommit=0; Query OK, 0 rows affected (0.00 sec) |
| 2    | ![](F:\kkb\Java-learn\doc\images\微信截图_20190211170832.png)mysql> update test_innodb_lock set b = a * 100 where a < 4 and a > 1; <br>Query OK, 1 row affected (0.02 sec) <br>Rows matched: 2 Changed: 2 Warnings: 0 |                                                              |
| 3    |                                                              | mysql> insert into test_innodb_lock(a,b) values(2,'500'); <br>**(blocked)** |
| 4    | mysql> commit; Query OK, 0 rows affected (0.02 sec)          |                                                              |
| 5    |                                                              | mysql> insert into test_innodb_lock values(2,'500'); <br>Query OK, 1 row affected (38.68 sec) |


#### 使用共同索引不同数据的阻塞示例
|      | session a                                                    | session b                                                    |
| ---- | ------------------------------------------------------------ | ------------------------------------------------------------ |
| 1    | mysql> set autocommit=0;<br>Query OK, 0 rows affected (0.00 sec) | mysql> set autocommit=0; <br>Query OK, 0 rows affected (0.00 sec) |
| 2    | mysql> update test_innodb_lock set b = 'bbbbb' where a = 1 and b = 'b2';<br>Query OK, 1 row affected (0.00 sec) <br/>Rows matched: 1 Changed: 1 Warnings: 0 |                                                              |
| 3    |                                                              | mysql> update test_innodb_lock set b = 'bbbbb' where a = 1 and b = 'b1'; <br>**(blocked)** |
| 4    | mysql> commit; Query OK, 0 rows affected (0.02 sec)          |                                                              |
| 5    |                                                              | mysql> update test_innodb_lock set b = 'bbbbb' where a = 1 and b = 'b1';<br>Query OK, 1 row affected (42.89 sec) <br/>Rows matched: 1 Changed: 1 Warnings: 0 session |

#### 死锁演示

两个 session 互相等等待对方的资源释放之 后才能释放自己的资源,造成了死锁

|      | session a                                                    | session b                                                    |
| ---- | ------------------------------------------------------------ | ------------------------------------------------------------ |
| 1    | mysql> set autocommit=0;<br/>Query OK, 0 rows affected (0.00 sec) | mysql> set autocommit=0; <br/>Query OK, 0 rows affected (0.00 sec) |
| 2    | mysql> update t1 set id = 110 where id = 11; <br/>Query OK, 0 rows affected (0.00 sec) <br/>Rows matched: 0 Changed: 0 Warnings: 0 |                                                              |
| 3    |                                                              | mysql> update t2 set id = 210 where id = 21;<br>Query OK, 1 row affected (0.00 sec) <br/>Rows matched: 1 Changed: 1 Warnings: 0 |
| 4    | mysql>update t2 set id=2100 where id=21; <br>等待sessionb释放资源，被阻塞 |                                                              |
| 5    |                                                              | mysql>update t1 set id=1100 where id=11;<br>Query OK,0 rows affected (0.39sec) <br/>Rows matched: 0 Changed: 0 Warnings:0 <br>等待 sessiona释放资源，被阻塞 |

