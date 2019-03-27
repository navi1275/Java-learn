package com.navi.collection;

import java.util.HashSet;
import java.util.Iterator;

/**
 * HashSetDemo Class
 *
 * @author ganxiongfeng@foresee.com.cn
 * @date 2019-03-25
 * @since 1.0.0
 */
public class HashSetDemo {

    public static void main(String[] args) {
        HashSet<String> hs = new HashSet();
        hs.add("a");
        hs.add("b");
        hs.add("c");
        hs.add("d");
        hs.add("e");
        hs.add("f");
        hs.add("g");
        hs.add("h");
        hs.add("i");

        System.out.println(hs.size());
        System.out.println(hs.contains("b"));

        hs.add("b");
        hs.add("null");
        hs.add(null);
        hs.add(null);
        System.out.println(hs.size());

        Iterator<String> iterator = hs.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
