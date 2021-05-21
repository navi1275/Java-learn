package leetcode.editor.cn;
 
//从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。 
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
// 返回： 
//
// [3,9,20,15,7]
// 
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 1000 
// 
// Related Topics 树 广度优先搜索 
// 👍 79 👎 0

import java.util.*;

/**
 * LC剑指Offer32I从上到下打印二叉树
 * 2021-04-08 14:14:50
 */
public class LC剑指Offer32I从上到下打印二叉树{
    public static void main(String[] args) {
//          Solution solution = new LC剑指Offer32I从上到下打印二叉树().new Solution();
            
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
    public int[] levelOrder(TreeNode root) {
        if(root == null){
            return new int[0];
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        deque.push(root);
        while (!deque.isEmpty()){
            TreeNode pop = deque.pollLast();
            list.add(pop.val);
            if (pop.left != null){
                deque.push(pop.left);
            }
            if(pop.right != null){
                deque.push(pop.right);
            }
        }
        int[] ret = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            ret[i] = list.get(i);
        }
        return ret;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}