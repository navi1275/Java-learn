package leetcode.editor.cn;

//给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。 
//
// 示例 1: 
//
// 输入: 1->2->3->3->4->4->5
//输出: 1->2->5
// 
//
// 示例 2: 
//
// 输入: 1->1->1->2->3
//输出: 2->3 
// Related Topics 链表 
// 👍 468 👎 0

public class LC82删除排序链表中的重复元素II {
    public static void main(String[] args) {
        Solution solution = new LC82删除排序链表中的重复元素II().new Solution();

    }
//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {

        public ListNode deleteDuplicates(ListNode head) {

            ListNode vhead = new ListNode(0, head), p = vhead, q = null;
            while (p.next != null) {
                if (p.next.next != null && p.next.val == p.next.next.val) {
                    q = p.next.next;
                    while (q.next != null && q.next.val == p.next.val) {
                        q = q.next;
                    }
                    p.next = q.next;
                } else {
                    p = p.next;
                }
            }
            return vhead.next;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}