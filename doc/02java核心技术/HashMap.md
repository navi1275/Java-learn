# 简介



```
Hash table based implementation of the <tt>Map</tt> interface.  This
implementation provides all of the optional map operations, and permits
<tt>null</tt> values and the <tt>null</tt> key.
```

基于哈希表的Map接口的。 此实现提供所有可选的`map`操作，并且允许null值和null键

```java
final Entry<K,V> getEntry(Object key) {
    // 判空
    if (size == 0) {
      return null;
    }
		// 求key的hash值，null key 的index是0
    int hash = (key == null) ? 0 : hash(key);
  	// 遍历table[index]链表
    for (Entry<K,V> e = table[indexFor(hash, table.length)];
         e != null;
         e = e.next) {
      Object k;
      // 比较hash值，hash值相等后比较引用相等或者值（equals方法）相等
      if (e.hash == hash &&
          ((k = e.key) == key || (key != null && key.equals(k))))
        return e;
    }
    return null;
}
```

