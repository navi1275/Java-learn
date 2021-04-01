package leetcode.editor.cn;

/**
 * ListNode Class
 *
 * @author ganxf
 * @date 2021/3/5
 */
public class ListNode {

    int val;
    ListNode next;
    ListNode pre;

    public ListNode(int val) {
        this.val = val;
        next = null;
        pre = null;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
