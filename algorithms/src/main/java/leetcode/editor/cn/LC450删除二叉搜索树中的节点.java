// package leetcode.editor.cn;
//
// //给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的
// //根节点的引用。
// //
// // 一般来说，删除节点可分为两个步骤：
// //
// //
// // 首先找到需要删除的节点；
// // 如果找到了，删除它。
// //
// //
// // 说明： 要求算法时间复杂度为 O(h)，h 为树的高度。
// //
// // 示例:
// //
// //
// //root = [5,3,6,2,4,null,7]
// //key = 3
// //
// //    5
// //   / \
// //  3   6
// // / \   \
// //2   4   7
// //
// //给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。
// //
// //一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
// //
// //    5
// //   / \
// //  4   6
// // /     \
// //2       7
// //
// //另一个正确答案是 [5,2,6,null,4,null,7]。
// //
// //    5
// //   / \
// //  2   6
// //   \   \
// //    4   7
// //
// // Related Topics 树
// // 👍 454 👎 0
//
// /**
//  * LC450删除二叉搜索树中的节点
//  * 2021-05-26 16:17:04
//  */
// public class LC450删除二叉搜索树中的节点{
//     public static void main(String[] args) {
// //          Solution solution = new LC450删除二叉搜索树中的节点().new Solution();
//
//     }
// //leetcode submit region begin(Prohibit modification and deletion)
// /**
//  * Definition for a binary tree node.
//  * public class TreeNode {
//  *     int val;
//  *     TreeNode left;
//  *     TreeNode right;
//  *     TreeNode() {}
//  *     TreeNode(int val) { this.val = val; }
//  *     TreeNode(int val, TreeNode left, TreeNode right) {
//  *         this.val = val;
//  *         this.left = left;
//  *         this.right = right;
//  *     }
//  * }
//  */
// class Solution {
//     public TreeNode deleteNode(TreeNode root, int key) {
//         if(root == null) {
//             return null;
//         }
//         TreeNode node = new TreeNode(Integer.MAX_VALUE), cur = root, parent = node;
//         node.left = root;
//         boolean isleft = true;
//         while (cur != null){
//             if(cur.val < key){
//                 parent = cur;
//                 isleft = true;
//                 cur = cur.left;
//             }else if (root.val>key) {
//                 parent = cur;
//                 isleft = false;
//                 cur = cur.right;
//             }else{
//                 if(cur.left == null && cur.right == null){
//                     if(isleft){
//                         parent.left = null;
//                     }else{
//                         parent.right = null;
//                     }
//                 }else if(cur.left == null){
//                     if(isleft){
//                         parent.left = cur.right;
//                     }else{
//                         parent.right = cur.right;
//                     }
//                 }else if(cur.right == null){
//                     if(isleft){
//                         parent.left = cur.left;
//                     }else{
//                         parent.right = cur.left;
//                     }
//                 }else{
//                     TreeNode left = cur.left;
//                     TreeNode right = cur.right, rightRoot = right;
//                     TreeNode successor = null;
//                     while (rightRoot.left != null) {
//                         successor = rightRoot.left;
//                         rightRoot = rightRoot.left;
//                     }
//                 }
//             }
//         }
//
//
//     }
// }
// //leetcode submit region end(Prohibit modification and deletion)
//
// }