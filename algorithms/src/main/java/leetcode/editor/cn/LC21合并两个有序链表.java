package leetcode.editor.cn;
 
//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 
//
// 示例 1： 
//
// 
//输入：l1 = [1,2,4], l2 = [1,3,4]
//输出：[1,1,2,3,4,4]
// 
//
// 示例 2： 
//
// 
//输入：l1 = [], l2 = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [], l2 = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 两个链表的节点数目范围是 [0, 50] 
// -100 <= Node.val <= 100 
// l1 和 l2 均按 非递减顺序 排列 
// 
// Related Topics 递归 链表 
// 👍 1585 👎 0

public class LC21合并两个有序链表 {
    public static void main(String[] args) {
        Solution solution = new LC21合并两个有序链表().new Solution();
         
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

    //递归解法
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        ListNode vhead;
        if(l1.val > l2.val){
            vhead = l2;
            vhead.next = mergeTwoLists(l1, l2.next);
        }else {
            vhead = l1;
            vhead.next = mergeTwoLists(l1.next, l2);
        }
        return vhead;
    }
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        ListNode vhead = new ListNode(0), p = vhead;
        if(l1 == null) {
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        while (l1 != null || l2 != null){
            if(l1 == null) {
                p.next = l2;
                break;
            }
            if(l2 == null){
                p.next = l1;
                break;
            }
            if(l1.val > l2.val){
                p.next = new ListNode(l2.val);
                l2 = l2.next;
                p = p.next;
            }else if(l1.val < l2.val){
                p.next = new ListNode(l1.val);
                l1 = l1.next;
                p = p.next;
            }else{
                p.next = new ListNode(l1.val);
                p = p.next;
                p.next = new ListNode(l2.val);
                p = p.next;
                l2 = l2.next;
                l1 = l1.next;
            }
        }
        return vhead.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}