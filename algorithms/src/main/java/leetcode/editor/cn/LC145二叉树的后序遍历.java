package leetcode.editor.cn;
 
//给定一个二叉树，返回它的 后序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]  
//   1
//    \
//     2
//    /
//   3 
//
//输出: [3,2,1] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 
// 👍 548 👎 0

import java.util.List;

/**
 * LC145二叉树的后序遍历
 * 2021-03-24 14:41:26
 */
public class LC145二叉树的后序遍历{
    public static void main(String[] args) {
//          Solution solution = new LC145二叉树的后序遍历().new Solution();
            
    }
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root == null){
            return null;
        }
        if(root.left != null){
            postorderTraversal(root.left);
        }
        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}