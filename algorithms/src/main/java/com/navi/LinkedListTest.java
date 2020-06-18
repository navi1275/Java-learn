package com.navi.leetcode;

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

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;

        ListNode listNode = reverseBetween(listNode4, 1, 2);

        ListNode next = listNode;
        while (next != null) {
            System.out.println(next.val);
            next = next.next;
        }

    }
}
