package leetcode.editor.cn;
 
//反转一个单链表。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 进阶: 
//你可以迭代或递归地反转链表。你能否用两种方法解决这道题？ 
// Related Topics 链表 
// 👍 1555 👎 0

public class LC206反转链表 {
    public static void main(String[] args) {
        Solution solution = new LC206反转链表().new Solution();
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ListNode reverse = solution.reverseList(node);
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
    public ListNode reverseList1(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode front = null, after = head.next;
        while (after != null){
            //head节点指向前节点
            head.next = front;
            //front后移
            front = head;
            //head后移
            head = after;
            //after后移
            after = after.next;
        }

        head.next = front;
        return head;
    }
    //递归解法
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        //记录head的下一个节点，
        ListNode after = head.next, reverse = reverseList(after);

        //head.next 指向null
        head.next = after.next;
        // 反转后q节点是新链表的尾节点
        after.next = head;
        return reverse;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}