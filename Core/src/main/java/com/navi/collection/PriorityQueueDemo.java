package com.navi.collection;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * PriorityQueueDemo Class
 *
 * @author ganxf
 * @date 2021/4/19
 */
public class PriorityQueueDemo {

    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        priorityQueue.add(3);
        priorityQueue.add(4);
        priorityQueue.add(10);
        priorityQueue.add(7);
        priorityQueue.add(5);
        priorityQueue.add(15);
        priorityQueue.add(11);
        priorityQueue.add(13);
        priorityQueue.add(20);
        priorityQueue.add(12);
        priorityQueue.add(9);

        Integer poll = priorityQueue.poll();

        System.out.println(poll);

    }
}
