package leetcode.editor.cn;

/**
 * TreeNode Class
 *
 * @author ganxf
 * @date 2021/3/24
 */
public class TreeNode {
 int val;
 TreeNode left;
 TreeNode right;
 TreeNode() {}
 TreeNode(int val) { this.val = val; }
 TreeNode(int val, TreeNode left, TreeNode right) {
     this.val = val;
     this.left = left;
     this.right = right;
 }
}
