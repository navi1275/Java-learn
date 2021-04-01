package leetcode.editor.cn;
 
//给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。 
//
// 示例 1: 
//
// 输入: 1->1->2
//输出: 1->2
// 
//
// 示例 2: 
//
// 输入: 1->1->2->3->3
//输出: 1->2->3 
// Related Topics 链表 
// 👍 486 👎 0

public class LC83删除排序链表中的重复元素 {
    public static void main(String[] args) {
        Solution solution = new LC83删除排序链表中的重复元素().new Solution();
         
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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        //定义一个指针即可
        ListNode p = head;
        while (p.next != null){
            if(p.next.val == p.val){
                p.next = p.next.next;
            }else{
                p = p.next;
            }
        }
        return head;
    }

    public ListNode deleteDuplicates1(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        //定义快慢指针，不相等同时后移，相等fast后移，slow.next=fast
        ListNode fast = head.next, slow = head;
        while (fast != null){
            if(fast.val != slow.val){
                fast = fast.next;
                slow = slow.next;
            }else{
                fast = fast.next;
                slow.next = fast;
            }
        }
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}