package leetcode.editor.cn;
 
//根据一棵树的前序遍历与中序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics 树 深度优先搜索 数组 
// 👍 975 👎 0

import apple.laf.JRSUIUtils;

/**
 * LC105从前序与中序遍历序列构造二叉树
 * 2021-04-08 15:29:40
 */
public class LC105从前序与中序遍历序列构造二叉树{
    public static void main(String[] args) {
         Solution solution = new LC105从前序与中序遍历序列构造二叉树().new Solution();
            solution.buildTree(new int[]{1,2,3},new int[]{3,2,1});
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return  buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    //传下标定位子树，注意计算节点要用length，不能直接用rootIndex
    private TreeNode buildTree(int[] preorder, int prebegin, int preend, int[] inorder, int inbegin, int inend){

        int root = preorder[prebegin], inRootIndex = inbegin;
        for (; inRootIndex <= inend; inRootIndex++) {
            if(root == inorder[inRootIndex]){
                break;
            }
        }
        int llength = inRootIndex - inbegin;
        int rlength = inend - inRootIndex;
        TreeNode tree = new TreeNode(root);
        if(llength > 0) {
            tree.left = buildTree(preorder, prebegin + 1, prebegin + llength, inorder, inbegin, inbegin + llength - 1);
        }
        if(rlength > 0 ) {
            tree.right = buildTree(preorder, prebegin + 1 + llength , prebegin + llength + rlength, inorder, inRootIndex + 1, inRootIndex + rlength);
        }
        return tree;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}