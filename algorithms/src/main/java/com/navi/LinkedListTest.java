package com.navi;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution Class
 * 92. 反转链表 II
 *
 * @author navi
 * @date 2019-04-04
 * @since 1.0.0
 */
public class LinkedListTest {

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     *  单链表反转（循环）
     * @param head
     * @return
     */
    public static ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode next = null;

        while (head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    /**
     * 单链表反转（循环）
     * @param head
     * @return
     */
    public static ListNode reverse2(ListNode head) {

        if(head == null || head.next == null){
            return head;
        }

        ListNode newList = reverse2(head.next);
        head.next.next = head;
        head.next = null;
        return newList;
    }

    public static ListNode reverseGroup(ListNode head, int k) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode preNode = head;

        int n = 1;
        for (int i = 0; i < k - 1 && preNode.next != null; i++){
            preNode = preNode.next;
            n++;
        }

        if(n < k || preNode == null){
            return head;
        }

        ListNode nextGroup = preNode.next;
        preNode.next = null;

        ListNode newHead = reverse(head);
        ListNode listNode = reverseGroup(nextGroup, k);

        head.next = listNode;

        return newHead;
    }


    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || m >= n) {
            return head;
        }
        ListNode listNode = new ListNode(0);
        listNode.next = head;
        ListNode preNode = listNode;
        int x = 1;
        while (preNode != null && x < m) {
            preNode = preNode.next;
            x++;
        }

        ListNode next1 = preNode.next;
        ListNode next2 = preNode.next.next;

        for (int i = m; i < n; i++) {
            next1.next = next2.next;
            next2.next = preNode.next;
            preNode.next = next2;
            next2 = next1.next;
        }
        return listNode.next;
    }

    public static ListNode add(ListNode ln1, ListNode ln2){
        if(ln1 == null) return ln2;
        if(ln2 == null) return ln1;

        ListNode re1 = reverse(ln1);
        ListNode re2 = reverse(ln2);
        boolean flag = false;

        ListNode longer = null;
        ListNode p1 = re1;
        ListNode p2 = re2;
        while (p1 != null && p2 != null){
            p1 = p1.next;
            p2 = p2.next;
            if(p1 == null) longer = re2;
            if(p2 == null) longer = re1;
        }
        ListNode head = longer;

        while (longer != null){
            int val1 = re1 == null ? 0 : re1.val;
            int val2 = re2 == null ? 0 : re2.val;
            int val = val1 + val2;
            if(flag){
                val++;
            }

            flag = val > 9;
            longer.val = val % 10;

            if(re1 != null) re1 = re1.next;
            if(re2 != null) re2 = re2.next;

            if(longer.next == null && flag){
                ListNode listNode = new ListNode(1);
                longer.next = listNode;
            }
            longer = longer.next;
        }
        return reverse(head);
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(6);
        ListNode listNode7 = new ListNode(7);
        ListNode listNode8 = new ListNode(8);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = listNode7;
        listNode7.next = listNode8;

        // ListNode listNode = reverse2(listNode1);
        // ListNode listNode = reverse(listNode1);
        // ListNode listNode = reverseBetween(listNode4, 1, 2);
        ListNode listNode = reverseGroup(listNode1, 3);

        // print(listNode);

        ListNode listNode11 = new ListNode(9);
        ListNode listNode12 = new ListNode(9);
        ListNode listNode13 = new ListNode(3);
        ListNode listNode14 = new ListNode(4);
        listNode11.next = listNode12;
        listNode12.next = listNode13;
        listNode13.next = listNode14;
        ListNode listNode21 = new ListNode(6);
        ListNode listNode22 = new ListNode(6);

        listNode21.next = listNode22;

        ListNode add = add(listNode11, listNode21);
        print(add);

    }

    private static void print(ListNode listNode) {
        ListNode next = listNode;
        while (next != null) {
            System.out.println(next.val);
            next = next.next;
        }
    }
}
