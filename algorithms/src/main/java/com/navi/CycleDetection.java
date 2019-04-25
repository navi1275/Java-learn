package com.navi;

/**
 * CycleDetection Class
 * 链表环形检测
 *
 * @author navi
 * @date 2019-03-22
 * @since 1.0.0
 */
public class CycleDetection {

    //内部静态类定义结点类
    static class Node{
        int val;
        Node next;
        public Node(int val){
            this.val = val;
        }
    }
    //判断单链表是否有环的方法
    public static boolean hasLoop(Node head){
        //定义一个引用指向头结点
        Node p1 = head;

        //定义另一个引用指向头结点的下一个结点
        Node p2 = head.next;

        /**
         * 因为引用p2要比p1走的快，所以要用它作为循环的结束标志，为了防止当链表中个数为
         * 偶数时出现p2.next=null空指针异常，这时可以在循环中进行一下判断，如果这种情况
         * 出现一定是无环的。
         */
        while(p2 != null && p2.next != null){
            p1 = p1.next;
            p2 = p2.next.next;
            if(p2 == null) {
                return false;
            }
            //为了防止p2.val出现空指针异常，需要对p2进行判断
            int val1 = p1.val;
            int val2 = p2.val;
            if(val1 == val2)
                return true;
        }
        return false;
    }


}
