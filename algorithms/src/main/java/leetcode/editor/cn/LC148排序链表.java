package leetcode.editor.cn;
 
//给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。 
//
// 进阶： 
//
// 
// 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [4,2,1,3]
//输出：[1,2,3,4]
// 
//
// 示例 2： 
//
// 
//输入：head = [-1,5,3,4,0]
//输出：[-1,0,3,4,5]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 5 * 104] 内 
// -105 <= Node.val <= 105 
// 
// Related Topics 排序 链表 
// 👍 1136 👎 0

/**
 * LC148排序链表
 * 2021-05-17 17:57:29
 */
public class LC148排序链表{
    public static void main(String[] args) {
         Solution solution = new LC148排序链表().new Solution();
        ListNode node = new ListNode(-1);
        ListNode node1 = new ListNode(5);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(0);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ListNode reverse = solution.sortList(node);
            
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
    public ListNode mergeSortList(ListNode head, int n) {
        if(head == null || head.next == null){
            return head;
        }
        int mid = n >> 1;
        ListNode lh = head, rh = null, p = lh;
        for (int i = 1; i < mid; i++, p = p.next) {};
        rh = p.next;
        p.next = null;
        lh = mergeSortList(lh, mid);
        rh = mergeSortList(rh, n - mid);

        ListNode ret = new ListNode(0);
        p = ret;
        while (lh != null || rh != null){
            if (rh == null || (lh != null && lh.val < rh.val)){
                p.next = lh;
                lh = lh.next;
                p = p.next;
            }else{
                p.next = rh;
                rh = rh.next;
                p = p.next;
            }
        }
        return ret.next;
    }
    public ListNode sortList(ListNode head) {
        ListNode p = head;
        int n = 0;
        while (p != null) {
            p = p.next;
            n++;
        }
        // 二路归并排序
        return mergeSortList(head, n);

    }
    public ListNode sortList1(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode vh = new ListNode(0);
        vh.next = head;
        ListNode p = vh, q = p.next, fmin = null, ph = null;
        int min;
        //插入排序， O(n2)
        while (p.next != null) {
            fmin = p;
            min = q.val;
            while (q.next != null) {
                if (q.next.val < min) {
                    fmin = q;
                    min = q.next.val;
                }
                q = q.next;
            }

            if(p != fmin){
                ph = p.next;
                p.next = fmin.next;
                fmin.next = fmin.next.next;
                p.next.next = ph;
            }
            p = p.next;
            q = p.next;
        }
        return vh.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}