package com.navi.collection;

import java.util.*;

/**
 * TreeSetDemo Class
 *
 * @author ganxiongfeng@foresee.com.cn
 * @date 2019-03-25
 * @since 1.0.0
 */
public class TreeSetDemo {

    public static void main(String[] args) {
        TreeSet<String> treeSet = new TreeSet();
        treeSet.add("a");
        treeSet.add("b");
        treeSet.add("c");
        treeSet.add("d");
        treeSet.add("e");
        treeSet.add("f");
        treeSet.add("g");
        treeSet.add("h");
        treeSet.add("i");

        System.out.println(treeSet.size());
        System.out.println(treeSet.contains("b"));

        treeSet.add("b");
        treeSet.add("null");

        //不能够插入 null 元素
        // treeSet.add(null);
        System.out.println(treeSet.size());

        print(treeSet);


        Iterator<String> descendingIterator = treeSet.descendingIterator();
        while (descendingIterator.hasNext()){
            System.out.println(descendingIterator.next());
        }


        treeSet.add("x");
        // 获取大于等于w的元素，理想值是x
        String ceiling = treeSet.ceiling("w");
        System.out.println("ceiling：" + ceiling);

        // 获取小于等于y的元素，理想值是x
        String b = treeSet.floor("y");
        System.out.println("floor：" + b);

        String first = treeSet.first();
        System.out.println("第一个元素：" + first);

        // 返回大于i的最小值，没有就返回null
        String higher = treeSet.higher("i");
        System.out.println("higher：" + higher);

        String last = treeSet.last();
        System.out.println("last: "+ last);

        SortedSet<String> headSet = treeSet.headSet("b");
        System.out.println("headSet: ");
        print(headSet);

        SortedSet<String> tailSet = treeSet.tailSet("i");
        System.out.println("tailSet: ");
        print(tailSet);

        String pollFirst = treeSet.pollFirst();
        System.out.println("pollFirst: "+ pollFirst);

        String pollLast = treeSet.pollLast();
        System.out.println("pollLast: "+pollLast);
        print(treeSet);
    }

    private static void print(Collection collection){
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next());
            System.out.print(", ");
        }
        System.out.println();
    }
}
