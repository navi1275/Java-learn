package leetcode.editor.cn;
 
//给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。 
//
// 请你将两个数相加，并以相同形式返回一个表示和的链表。 
//
// 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 
//
// 示例 1： 
//
// 
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[7,0,8]
//解释：342 + 465 = 807.
// 
//
// 示例 2： 
//
// 
//输入：l1 = [0], l2 = [0]
//输出：[0]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//输出：[8,9,9,9,0,0,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 每个链表中的节点数在范围 [1, 100] 内 
// 0 <= Node.val <= 9 
// 题目数据保证列表表示的数字不含前导零 
// 
// Related Topics 递归 链表 数学 
// 👍 5767 👎 0

public class LC2两数相加 {
    public static void main(String[] args) {
        Solution solution = new LC2两数相加().new Solution();

        ListNode node = new ListNode(2);
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(3);

        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(6);
        ListNode node5 = new ListNode(4);
        node.next = node1;
        node1.next = node2;

        node3.next = node4;
        node4.next = node5;
        ListNode reverse = solution.addTwoNumbers(node, node3);
        while (reverse != null){
            System.out.println(reverse.val);
            reverse = reverse.next;
        }
    }
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverse(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode after = head.next, reverse = reverse(head.next);
        head.next = after.next;
        after.next = head;
        return reverse;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        ListNode nextSum = addTwoNumbers(l1.next, l2.next);
        int val = l1.val + l2.val;
        if(val >= 10){
            l1.val = val - 10;
            if(nextSum == null){
                nextSum = new ListNode(1);
            }else{
                ListNode p = nextSum;
                p.val += 1;
                while (p.val == 10){
                    p.val = 0;
                    if(p.next == null){
                        p.next = new ListNode(1);
                    }else{
                        p.next.val += 1;
                    }
                    p = p.next;
                }
            }
        }else{
            l1.val = val;
        }
        l1.next = nextSum;

        return l1;
    }
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode vhead = new ListNode(0), p = vhead;
        int jw = 0;
        while (l1 != null || l2 != null){
            if(l1 == null){
                p.next = l2;
                break;
            }
            if(l2 == null){
                p.next = l1;
                break;
            }
            int val = l1.val + l2.val + jw;
            if(val >= 10){
                jw = 1;
                val -= 10;
            }else{
                jw = 0;
            }
            p.next = new ListNode(val);
            p = p.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        if(jw > 0){
            if(p.next == null){
                p.next = new ListNode(1);
            }else {
                p.next.val += 1;

                while (p.next.val == 10) {
                    p.next.val = 0;
                    if (p.next.next == null) {
                        p.next.next = new ListNode(1);
                    } else {
                        p.next.next.val += 1;
                    }
                    p = p.next;
                }
            }
        }
        return vhead.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}