package leetcode.editor.cn;
 
//给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。 
//
// 你应当 保留 两个分区中每个节点的初始相对位置。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,4,3,2,5,2], x = 3
//输出：[1,2,2,4,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [2,1], x = 2
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 200] 内 
// -100 <= Node.val <= 100 
// -200 <= x <= 200 
// 
// Related Topics 链表 双指针 
// 👍 373 👎 0

public class LC86分隔链表 {
    public static void main(String[] args) {
        Solution solution = new LC86分隔链表().new Solution();
         ListNode node = new ListNode(1);
        ListNode head = solution.partition(node, 2);

        while (head != null){
            System.out.println(head.val);
            head = head.next;
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
    public ListNode partition(ListNode head, int x) {
        ListNode h1 = new ListNode(0), h2 = new ListNode(0), p = head, p1 = h1, p2 = h2, q;
        while (p != null){
            q = p.next;
            p.next = null;
            int val = p.val;
            if(val < x){
                p1.next = p;
                p1 = p1.next;
            }else{
                p2.next = p;
                p2 = p2.next;
            }
            p = q;
        }
        p1.next = h2.next;
        return h1.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}