

# MySQL索引

## 索引介绍

索引是什么

- 官方介绍索引是帮助MySQL高效获取数据的数据结构
- 更通俗的说，数据库索引好比是一本书前面的目录，能加快数据库的查询速度
- 一般来说索引本身也很大，不可能全部存储在内存中，因此索引往往是存储在磁盘上的文件中的（可能存储在单独的索引文件中，也可能和数据一起存储在数据文件中）
- 我们通常所说的索引，没有特别说明，都是指的B树（多路搜索树，并不一定是二叉的）结构组织的索引。
- 其中聚集索引、覆盖索引、组合索引、前缀索引、唯一索引默认都是使用B+树索引，统称索引

索引的优势和劣势

**优势**：
- 类似于书的目录，可以提高数据检索的效率，降低数据库的IO成本。
- 通过索引列对数据进行排序，降低数据排序的成本，降低了CPU的消耗。
	- 被索引的列会自动进行排序，包括单列索引和组合索引，只是组合索引的排序要复杂一些。
	- 如果按照索引列的顺序进行排序，对应`order by`语句来说，效率就会提高很多。

**劣势**：

- 索引会占据磁盘空间
- 索引会提高查询效率，但是会降低更新表的效率。比如每次对表进行增删改操作，MySQL不仅要保存数据，还保存或者更新对应的索引文件。

## 索引的分类

- 单列索引

	- 普通索引：MySQL中基本索引类型，没有什么限制，允许在定义索引的列中插入重复值和空值，纯粹为了查询数据更快一点。
	- 唯一索引：索引列中的值必须是唯一的，但是允许为空值。
	- 主键索引：是一种特殊的唯一索引，不允许有空值。

- 组合索引

	- 在表中的多个字段组合上创建的索引
	- 只有在查询条件中使用了这些字段的左边字段时，索引才会被使用，遵循最左前缀原则（最左匹配原则）
	- 一般情况下，建议使用组合索引代替单列索引，主键索引除外

- 全文索引
只有在MyISAM引擎上才能使用，只能在CHAR,VARCHAR,TEXT类型字段上使用全文索引。

- 空间索引
一般使用不到。

## 索引的使用

创建索引

- 单列索引之普通索引

```mysql
CREATE INDEX index_name ON table_name(column_name(length));

ALTER TABLE table_name ADD INDEX index_name ON (column_name(length));
```
- 单列索引之唯一索引

```mysql
CREATE UNIQUE INDEX index_name ON table_name(column_name(length));
```

- 单列索引之全文索引

```mysql
CREATE FULLTEXT INDEX index_name ON table_name(column_name(length));
```

- 组合索引

```mysql
ALTER TABLE table_name ADD INDEX index_name(column1_name(50),column2_name(10));
```

删除索引

```mysql
DROP INDEX index_name ON table_name;
```

查看索引

```mysql
SHOW INDEX FROM table_name \G;
```

