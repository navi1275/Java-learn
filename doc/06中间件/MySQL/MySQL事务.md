# MySQL事务

## 事务介绍

在MySQL中的事务是由存储引擎实现的，而且支持事务的存储引擎不多，我们主要讲解InnoDB存储引擎中的事务。

事务处理可以用来维护数据库的完整性，保证成批的 SQL 语句要么全部执行，要么全部不执行。事务用来管理DDL、DML、DCL 操作，比如 insert,update,delete 语句，默认是自动提交的。
一般来说，事务是必须满足4个条件（ACID）：

- Atomicity（原子性）：构成事务的的所有操作必须是一个逻辑单元，要么全部执行，要么全部不执行
- Consistency（一致性）：数据库在事务执行前后状态都必须是稳定的或者是一致的
- Isolation（隔离性）：事务之间不会相互影响。由锁机制和MVCC机制来实现的。MVCC：优化读写性能（读不加锁、读写不冲突）
- Durability（持久性）：事务执行成功后必须全部写入磁盘

## 事务开启

在MySQL命令行的默认设置下，事务都是自动提交的，即执行SQL语句后就会马上执行COMMIT操作。因此要显式地开启一个事务务须使用命令`BEGIN`或`START TRANSACTION`，或者执行命令`SET AUTOCOMMIT=0`，用来禁止使用当前会话的自动提交。

常见的操作有以下三个：

- `BEGIN`或`START TRANSACTION`显式地开启一个事务
- `COMMIT`也可以使用`COMMIT WORK`提交事务，使已对数据库进行的所有修改变成为永久性的
- `ROLLBACK`也可以使用`ROLLBACK WORK`回滚事务，回滚会结束用户的事务，并撤销正在进行的所有未提交的修改

## 事务并发问题

在事务的并发操作中可能会出现一些问题：

- 丢失更新：一个事务更新之后，另一个事务也更新了，但是第二个事务回滚了，则第一个事务也被回滚了。

- 脏读：一个事务读取到另一个事务未提交的数据。

- 不可重复读：一个事务因读取到另一个事务已提交的update或者delete数据。导致对同一条记录读取两次以上的结果不一致。

- 幻读：一个事务因读取到另一个事务已提交的insert数据。导致对同一张表读取两次以上的结果不一致。

## 事务隔离级别

四种隔离级别（SQL92标准）：

1. Read Uncommitted (读未提交)：最低级别，任何情况都无法保证。
2. Read Committed (RC，读已提交)：可避免脏读的发生。
3. Repeatable Read (RR，可重复读)：可避免脏读、不可重复读的发生。（注意事项：InnoDB的RR还可以解决幻读，主要原因是Next-Key锁，只有RR才能使用Next-Key锁）
4. Serializable (串行化)：可避免脏读、不可重复读、幻读的发生。（由MVCC降级为Locking-Base CC）

大多数数据库的默认隔离级别是`Read Committed`，比如Oracle、DB2等。MySQL数据库的默认隔离级别是`Repeatable Read`。

在MySQL数据库中查看当前事务的隔离级别：

```mysql
select @@tx_isolation;
```

在MySQL数据库中设置事务的隔离级别：

```mysql
set [glogal | session] transaction isolation level 隔离级别名称;
set tx_isolation=’隔离级别名称;’
```

注意事项：

```
隔离级别越高，越能保证数据的完整性和一致性，但是对并发性能的影响也越大。
```

对于多数应用程序，可以优先考虑把数据库系统的隔离级别设为`Read Committed`。它能够避免脏读取，而且具有较好的并发性能。尽管它会导致不可重复读、幻读这些并发问题，在可能出现这类问题的个别场合，可以由应用程序采用悲观锁或乐观锁来控制。