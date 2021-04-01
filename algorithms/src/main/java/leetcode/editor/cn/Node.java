package leetcode.editor.cn;

/**
 * Node Class
 *
 * @author ganxf
 * @date 2021/3/12
 */
public class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
