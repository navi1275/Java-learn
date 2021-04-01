package leetcode.editor.cn;
 
//给你一个链表数组，每个链表都已经按升序排列。 
//
// 请你将所有链表合并到一个升序链表中，返回合并后的链表。 
//
// 
//
// 示例 1： 
//
// 输入：lists = [[1,4,5],[1,3,4],[2,6]]
//输出：[1,1,2,3,4,4,5,6]
//解释：链表数组如下：
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//将它们合并到一个有序链表中得到。
//1->1->2->3->4->4->5->6
// 
//
// 示例 2： 
//
// 输入：lists = []
//输出：[]
// 
//
// 示例 3： 
//
// 输入：lists = [[]]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// k == lists.length 
// 0 <= k <= 10^4 
// 0 <= lists[i].length <= 500 
// -10^4 <= lists[i][j] <= 10^4 
// lists[i] 按 升序 排列 
// lists[i].length 的总和不超过 10^4 
// 
// Related Topics 堆 链表 分治算法 
// 👍 1210 👎 0

public class LC23合并K个升序链表20210317{
    public static void main(String[] args) {
//          Solution solution = new LC23合并K个升序链表20210317().new Solution();
            
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
    public ListNode mergeTwoLists(ListNode head1, ListNode head2) {
        ListNode p1 = head1, p2 = head2, vhead = new ListNode(0), p = vhead;
        if(head1 == null){
            return head2;
        }
        if(head2 == null){
            return head1;
        }
        while (p1 != null && p2 != null){
            if(p1.val >= p2.val){
                p.next = p2;
                p2 = p2.next;
            }else{
                p.next = p1;
                p1 = p1.next;
            }
            p = p.next;
        }
        if(p2 == null){
            p.next = p1;
        }
        if(p1 == null){
            p.next = p2;
        }
        return vhead.next;
    }

    public ListNode mergeNMLists(ListNode[] lists, int n, int m) {
        if(m > n){
            int mid = (n + m) / 2;
            ListNode l1 = mergeNMLists(lists, n, mid);
            ListNode l2 = mergeNMLists(lists, mid + 1, m);
            return mergeTwoLists(l1, l2);
        } else if(n == m){
            return lists[n];
        } else{
            return null;
        }
    }
    // 分而治之，先两两合并
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0){
            return null;
        }
        if(lists.length == 1){
            return lists[0];
        }
        return mergeNMLists(lists, 0, lists.length - 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}