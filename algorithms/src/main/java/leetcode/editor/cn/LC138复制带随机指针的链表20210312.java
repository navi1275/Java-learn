package leetcode.editor.cn;
 
//给你一个长度为 n 的链表，每个节点包含一个额外增加的随机指针 random ，该指针可以指向链表中的任何节点或空节点。 
//
// 构造这个链表的 深拷贝。 深拷贝应该正好由 n 个 全新 节点组成，其中每个新节点的值都设为其对应的原节点的值。新节点的 next 指针和 random 
//指针也都应指向复制链表中的新节点，并使原链表和复制链表中的这些指针能够表示相同的链表状态。复制链表中的指针都不应指向原链表中的节点 。 
//
// 例如，如果原链表中有 X 和 Y 两个节点，其中 X.random --> Y 。那么在复制链表中对应的两个节点 x 和 y ，同样有 x.random 
//--> y 。 
//
// 返回复制链表的头节点。 
//
// 用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示： 
//
// 
// val：一个表示 Node.val 的整数。 
// random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为 null 。 
// 
//
// 你的代码 只 接受原链表的头节点 head 作为传入参数。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
//输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [[1,1],[2,1]]
//输出：[[1,1],[2,1]]
// 
//
// 示例 3： 
//
// 
//
// 
//输入：head = [[3,null],[3,0],[3,null]]
//输出：[[3,null],[3,0],[3,null]]
// 
//
// 示例 4： 
//
// 
//输入：head = []
//输出：[]
//解释：给定的链表为空（空指针），因此返回 null。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 1000 
// -10000 <= Node.val <= 10000 
// Node.random 为空（null）或指向链表中的节点。 
// 
// Related Topics 哈希表 链表 
// 👍 513 👎 0

public class LC138复制带随机指针的链表20210312{
    public static void main(String[] args) {
        Solution solution = new LC138复制带随机指针的链表20210312().new Solution();
        Node node = new Node(7);
        Node node1 = new Node(13);
        Node node2 = new Node(11);
        Node node3 = new Node(10);
        Node node4 = new Node(1);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node.random = null;
        node1.random = node;
        node2.random = node4;
        node3.random = node2;
        node4.random = node;
        Node node5 = solution.copyRandomList(node);

    }
//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    // 解法 复制当前链表的每一个节点，接到原节点后面
    // 7 - 13 - 11 - 10 - 1
    // 7 - 7a - 13 - 13a - 11 - 11a - 10 - 10a - 1 - 1a
    public Node copyRandomList(Node head) {
        if(head == null) {
            return head;
        }
        Node p = head, q, node, vhead = new Node(0);
        while (p != null){
            q = p.next;
            //复制p节点
            node = new Node(p.val);
            node.random = p.random;
            p.next = node;
            node.next = q;
            p = q;
        }
        // 新链表每隔一个节点，取一个节点，得到的就是克隆的链表
        p = head.next;
        while (p != null) {
            if (p.random != null) {
                p.random = p.random.next;
            }
            if(p.next == null){
                break;
            }
            p = p.next.next;
        }
        p = head.next;
        q = head;
        vhead.next = p;
        while (p != null){
            q.next = p.next;
            q = q.next;
            if(p.next != null) {
                p.next = p.next.next;
            }
            p = p.next;
        }
        return vhead.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}