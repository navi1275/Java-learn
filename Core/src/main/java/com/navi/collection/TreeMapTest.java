package com.navi.collection;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * TreeMapTest Class
 *
 * @author ganxf
 * @date 2021/4/22
 */
@Slf4j
@RunWith(JUnit4.class)
public class TreeMapTest {

    @Test
    public void test1(){
        TreeMap<Integer, Object> treeMap = new TreeMap<>();
        treeMap.put(1, "aaa");
        treeMap.put(7, "ggg");
        treeMap.put(4, "ddd");
        treeMap.put(5, "eee");
        treeMap.put(2, "bbb");
        treeMap.put(6, "fff");
        treeMap.put(3, "ccc");
        treeMap.put(8, null);

        Set<Integer> keySet = treeMap.keySet();
        for(Integer key : keySet){
            log.info("key:{}, value:{}", key, treeMap.get(key));
        }
        log.info("*************************");
        SortedMap<Integer, Object> map = treeMap.subMap(1, 100);
        Set<Map.Entry<Integer, Object>> entries = map.entrySet();
        for (Map.Entry<Integer, Object> item : entries){
            log.info("key:{}, value:{}", item.getKey(), item.getValue());
        }

    }
}
