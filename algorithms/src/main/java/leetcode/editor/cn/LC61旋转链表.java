package leetcode.editor.cn;
 
//给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。 
//
// 示例 1: 
//
// 输入: 1->2->3->4->5->NULL, k = 2
//输出: 4->5->1->2->3->NULL
//解释:
//向右旋转 1 步: 5->1->2->3->4->NULL
//向右旋转 2 步: 4->5->1->2->3->NULL
// 
//
// 示例 2: 
//
// 输入: 0->1->2->NULL, k = 4
//输出: 2->0->1->NULL
//解释:
//向右旋转 1 步: 2->0->1->NULL
//向右旋转 2 步: 1->2->0->NULL
//向右旋转 3 步: 0->1->2->NULL
//向右旋转 4 步: 2->0->1->NULL 
// Related Topics 链表 双指针 
// 👍 438 👎 0

public class LC61旋转链表 {
    public static void main(String[] args) {
        Solution solution = new LC61旋转链表().new Solution();
         
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
    // 找到尾节点，记录链表长度n，尾节点链接头节点
    // k>n时，k = k%n
    // 注意右移左移
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k == 0){
            return head;
        }
        ListNode p = head;
        int n = 1;
        while (p.next != null){
            n++;
            p = p.next;
        }
        // 将链表结成环，后面将p指针移动到位置后断开，head指向p.next
        p.next = head;
        k %= n;
        k = n - k;
        while (--k >= 0) {
            p = p.next;
        }
        head = p.next;
        p.next = null;
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}