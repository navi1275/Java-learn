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

import java.util.*;

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
    public List<Integer> postorderTraversal1(TreeNode root, List<Integer> list) {
        if (root == null) {
            return null;
        }
        postorderTraversal1(root.left, list);
        postorderTraversal1(root.right, list);
        list.add(root.val);
        return list;
    }

    public List<Integer> postorderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            return null;
        }
        Deque<TreeNode> stack1 = new ArrayDeque<>();
        Deque<TreeNode> stack2 = new ArrayDeque<>();
        stack1.push(root);
        while (!stack1.isEmpty()){
            TreeNode pop = stack1.pop();
            stack2.push(pop);
            if(pop.left != null){
                stack1.push(pop.left);
            }
            if(pop.right != null){
                stack1.push(pop.right);
            }
        }
        while (!stack2.isEmpty()){
            TreeNode pop = stack2.pop();
            list.add(pop.val);
        }
        return list;
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        postorderTraversal(root, list);
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}