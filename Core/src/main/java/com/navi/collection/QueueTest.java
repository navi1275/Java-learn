package com.navi.collection;

import java.util.ArrayDeque;

/**
 * QueueTest Class
 *
 * @author ganxiongfeng@foresee.com.cn
 * @date 2019-03-18
 * @since 1.0.0
 */
public class QueueTest {

    public static void main(String[] args) {

        ArrayDeque deque = new ArrayDeque();

        for (int i = 0; i < 100; i++){
            deque.addFirst(i);
        }

        deque.add(1);
        deque.addFirst(0);
        deque.addLast(9);

        // ArrayDeque clone = deque.clone();
        // System.out.println(clone == deque);

        System.out.println(deque.contains(4));


        deque.offer(2);
        deque.offerFirst(-1);
        deque.offerLast(10);

        System.out.println("element: " + deque.element());
        System.out.println(deque.toString());


        Integer p1 = (Integer) deque.peek();
        System.out.println("peek: " + p1);
        System.out.println(deque.toString());

        Integer r1 = (Integer) deque.remove();
        System.out.println("remove: " + r1);
        System.out.println(deque.toString());

        Integer poll1 =  (Integer) deque.poll();
        System.out.println("poll: " + poll1);
        System.out.println(deque.toString());

        Integer pop =  (Integer) deque.pop();
        System.out.println("pop: " + pop);
        System.out.println(deque.toString());


        deque.push(11);
        System.out.println(deque.toString());

    }

}
