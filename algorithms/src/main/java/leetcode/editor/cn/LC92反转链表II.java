package leetcode.editor.cn;
 
//反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。 
//
// 说明: 
//1 ≤ m ≤ n ≤ 链表长度。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL, m = 2, n = 4
//输出: 1->4->3->2->5->NULL 
// Related Topics 链表 
// 👍 704 👎 0

public class LC92反转链表II {
    public static void main(String[] args) {
        Solution solution = new LC92反转链表II().new Solution();
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ListNode reverse = solution.reverseBetween(node, 2, 4);
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

    //反转链表前n位
    public ListNode reverseN(ListNode head, int n) {
        if(n == 1) {
            return head;
        }

        //记录head的下一个节点，
        ListNode after = head.next, reverse = reverseN(after, n-1);

        //head.next 指向null
        head.next = after.next;
        // 反转后q节点是新链表的尾节点
        after.next = head;
        return reverse;
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {

        if(head == null) {
            return head;
        }

        ListNode virtualHead = new ListNode(-1, head);
        ListNode front = virtualHead;
        int count = right - left + 1;
        // 找到left的前1位节点，这个节点不能丢了
        while (--left > 0){
            front = front.next;
        }
        front.next = reverseN(front.next, count);
        return virtualHead.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}