package leetcode.editor.cn;

//给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4]
//输出：[2,1,4,3]
// 
//
// 示例 2： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 100] 内 
// 0 <= Node.val <= 100 
// 
//
// 
//
// 进阶：你能在不修改链表节点值的情况下解决这个问题吗?（也就是说，仅修改节点本身。） 
// Related Topics 递归 链表 
// 👍 845 👎 0

public class LC24两两交换链表中的节点 {
    public static void main(String[] args) {
        Solution solution = new LC24两两交换链表中的节点().new Solution();

        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ListNode reverse = solution.swapPairs(node);
        while (reverse != null){
            System.out.println(reverse.val);
            reverse = reverse.next;
        }
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
        public ListNode reverseN(ListNode head, int n) {
            if (n == 1) {
                return head;
            }
            ListNode after = head.next, reverse = reverseN(head.next, n - 1);
            head.next = after.next;
            after.next = head;
            return reverse;
        }

        public ListNode checkReverse(ListNode head, int n) {
            int cnt = n;
            ListNode p = head;
            while (--n > 0 && p != null) {
                p = p.next;
            }
            return p != null ? reverseN(head, cnt) : head;
        }

        public ListNode reverseKGroup(ListNode head, int k) {
            if (k == 0 || k == 1) {
                return head;
            }
            ListNode vhead = new ListNode(0, head), front = vhead, after = front.next;
            while (after != (front.next = checkReverse(after, k))) {
                front = after;
                after = after.next;
            }
            return vhead.next;
        }


        public ListNode swapPairs(ListNode head) {
            return reverseKGroup(head, 2);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}