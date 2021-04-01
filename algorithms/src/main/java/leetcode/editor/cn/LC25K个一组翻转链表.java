package leetcode.editor.cn;
 
//给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。 
//
// k 是一个正整数，它的值小于或等于链表的长度。 
//
// 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。 
//
// 进阶： 
//
// 
// 你可以设计一个只使用常数额外空间的算法来解决此问题吗？ 
// 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], k = 2
//输出：[2,1,4,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,2,3,4,5], k = 3
//输出：[3,2,1,4,5]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2,3,4,5], k = 1
//输出：[1,2,3,4,5]
// 
//
// 示例 4： 
//
// 
//输入：head = [1], k = 1
//输出：[1]
// 
//
// 
// 
//
// 提示： 
//
// 
// 列表中节点的数量在范围 sz 内 
// 1 <= sz <= 5000 
// 0 <= Node.val <= 1000 
// 1 <= k <= sz 
// 
// Related Topics 链表 
// 👍 942 👎 0

public class LC25K个一组翻转链表 {
    public static void main(String[] args) {
        Solution solution = new LC25K个一组翻转链表().new Solution();

        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ListNode reverse = solution.reverseKGroup(node, 2);
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


    public ListNode reverseN(ListNode head, int n){
        if (n == 1) {
            return head;
        }
        ListNode after = head.next, reverse = reverseN(head.next, n -1);
        head.next = after.next;
        after.next = head;
        return reverse;
    }

    //判断够反转，不够反转则返回head
    // 注意n变化，添加p来移动
    public ListNode checkReverse(ListNode head, int n){
        ListNode p = head;
        int count = n;
        while (--n > 0 && p != null){
            p = p.next;
        }
        return p == null ? head : reverseN(head , count);
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if(k == 1){
            return head;
        }

        //虚拟头节点
        ListNode virtualHead = new ListNode(0, head);
        //头节点,始终指向反转链表的头一个节点
        ListNode front = virtualHead;
        //后一个节点,始终指向反转链表的开始的节点
        ListNode after = front.next;
        //after ！= checkReverse() 发生反转
        while (after != (front.next = checkReverse(after, k))){
            // 指向反转链表的头一个节点 应该是 after节点
            front = after;
            // after节点后移
            after = after.next;
        }
        return virtualHead.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}