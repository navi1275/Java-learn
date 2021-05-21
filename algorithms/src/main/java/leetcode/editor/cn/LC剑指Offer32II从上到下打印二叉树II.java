package leetcode.editor.cn;
 
//从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。 
//
// 
//
// 例如: 
//给定二叉树: [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [9,20],
//  [15,7]
//]
// 
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 1000 
// 
//
// 注意：本题与主站 102 题相同：https://leetcode-cn.com/problems/binary-tree-level-order-tra
//versal/ 
// Related Topics 树 广度优先搜索 
// 👍 95 👎 0

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * LC剑指Offer32II从上到下打印二叉树II
 * 2021-04-08 14:26:51
 */
public class LC剑指Offer32II从上到下打印二叉树II{
    public static void main(String[] args) {
//          Solution solution = new LC剑指Offer32II从上到下打印二叉树II().new Solution();
            
    }
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if(root == null) {
            return ret;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.push(root);
        while (!deque.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.pollLast();
                list.add(node.val);
                if(node.left != null){
                    deque.push(node.left);
                }
                if(node.right != null){
                    deque.push(node.right);
                }
            }

            ret.add(list);
        }

        return ret;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}