package leetcode.editor.cn;
 
//给你二叉树的根节点 root ，返回它节点值的 前序 遍历。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,null,2,3]
//输出：[1,2,3]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：[1]
// 
//
// 示例 4： 
//
// 
//输入：root = [1,2]
//输出：[1,2]
// 
//
// 示例 5： 
//
// 
//输入：root = [1,null,2]
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 
// 👍 571 👎 0

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * LC144二叉树的前序遍历
 * 2021-05-26 15:56:42
 */
public class LC144二叉树的前序遍历{
    public static void main(String[] args) {
//          Solution solution = new LC144二叉树的前序遍历().new Solution();
            
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
    // 递归调用
    public void preorderTraversal1(TreeNode root, List<Integer> list) {
        if(root == null){
            return;
        }
        list.add(root.val);
        preorderTraversal(root.left, list);
        preorderTraversal(root.right, list);

    }
    //循环遍历
    public void preorderTraversal(TreeNode root, List<Integer> list) {
        if(root == null){
            return;
        }
        if(list == null){
            list = new ArrayList<>();
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode pop = stack.pop();
            list.add(pop.val);

            if(pop.right != null){
                stack.push(pop.right);
            }
            if(pop.left != null) {
                stack.push(pop.left);
            }
        }


    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preorderTraversal(root, list);
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}