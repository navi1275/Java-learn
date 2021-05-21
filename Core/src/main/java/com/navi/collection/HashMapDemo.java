package com.navi.collection;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * HashMapDemo Class
 *
 * @author navi
 * @date 2019-04-02
 * @since 1.0.0
 */
@Slf4j
@RunWith(JUnit4.class)
public class HashMapDemo {

    HashMap createMap(){
        HashMap<String, Object> map = new HashMap();
        map.put("1", "a");
        map.put("2", "b");
        map.put("3", "c");
        map.put("4", "d");
        map.put("5", "e");
        map.put("6", "f");
        map.put("7", "g");
        map.put("8", "h");
        map.put("9", "i");
        map.put("10", "j");
        map.put("11", "k");
        map.put("12", "l");
        map.put("13", "m");
        return map;
    }

    @Test
    public void test() {
        // 遍历集合，如果有删除要使用iterator，iterator.remove()方法会同步 modcount 和 expectedModCount
        // map.remove()和keyset.remove()都不会同步
        // modcount 表示集合结构被修改（新增和删除）的次数
        // expectedModCount 集合遍历器的预设值，防止集合结构被修改，快速失败的处理，如果和modcount不一致会抛出 ConcurrentModificationException
        // 只修改值不会改变集合结构，不会抛出 ConcurrentModificationException
        // 新增会改变集合结构，同时遍历会抛出 ConcurrentModificationException
        HashMap<String, Object> map = createMap();

        // for (Map.Entry<String, Object> entry : map.entrySet()){
        //     String key = entry.getKey();
        //     String value = (String) entry.getValue();
        //     log.info("{}={}", key, value);
        //     if(Integer.valueOf(key) % 2 == 0){
        //         map.remove(key);
        //     }
        // }

        // for (String key : map.keySet()){
        //     String value = (String) map.get(key);
        //     log.info("{}={}", key, value);
        //     if(Integer.valueOf(key) % 2 == 0){
        //         map.remove(key);
        //     }
        // }

        Set<Map.Entry<String, Object>> entries = map.entrySet();
        Iterator<Map.Entry<String, Object>> iterator = entries.iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Object> next = iterator.next();
            String key = next.getKey();
            String value = (String) next.getValue();
            log.info("{}={}", key, value);
            if(Integer.valueOf(key) % 2 == 0){
                iterator.remove();
            }
        }

        for (Map.Entry<String, Object> entry : map.entrySet()){
            String key = entry.getKey();
            String value = (String) entry.getValue();
            log.info("after delete {}={}", key, value);
        }
    }

    @Test
    public void test1(){

    }
}
