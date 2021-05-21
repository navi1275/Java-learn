package leetcode.editor.cn;
 
//给定一个二叉树，判断它是否是高度平衡的二叉树。 
//
// 本题中，一棵高度平衡二叉树定义为： 
//
// 
// 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：root = [1,2,2,3,3,null,null,4,4]
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：root = []
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数在范围 [0, 5000] 内 
// -104 <= Node.val <= 104 
// 
// Related Topics 树 深度优先搜索 递归 
// 👍 655 👎 0

/**
 * LC110平衡二叉树
 * 2021-04-08 15:10:12
 */
public class LC110平衡二叉树{
    public static void main(String[] args) {
//          Solution solution = new LC110平衡二叉树().new Solution();
            
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
    //它是否是高度平衡的二叉树。
    //一个二叉树【每个】节点 的左右两个子树的高度差的绝对值不超过 1
    public boolean isBalanced(TreeNode root) {
        if(root == null) {
            return true;
        }
        return Math.abs(hight(root.left) - hight(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }
    private int hight(TreeNode root){
        if(root == null){
            return 0;
        }
        return Math.max(hight(root.left), hight(root.right)) + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}