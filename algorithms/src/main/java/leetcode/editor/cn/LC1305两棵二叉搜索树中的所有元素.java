package leetcode.editor.cn;
 
//给你 root1 和 root2 这两棵二叉搜索树。 
//
// 请你返回一个列表，其中包含 两棵树 中的所有整数并按 升序 排序。. 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：root1 = [2,1,4], root2 = [1,0,3]
//输出：[0,1,1,2,3,4]
// 
//
// 示例 2： 
//
// 输入：root1 = [0,-10,10], root2 = [5,1,7,0,2]
//输出：[-10,0,0,1,2,5,7,10]
// 
//
// 示例 3： 
//
// 输入：root1 = [], root2 = [5,1,7,0,2]
//输出：[0,1,2,5,7]
// 
//
// 示例 4： 
//
// 输入：root1 = [0,-10,10], root2 = []
//输出：[-10,0,10]
// 
//
// 示例 5： 
//
// 
//
// 输入：root1 = [1,null,8], root2 = [8,1]
//输出：[1,1,8,8]
// 
//
// 
//
// 提示： 
//
// 
// 每棵树最多有 5000 个节点。 
// 每个节点的值在 [-10^5, 10^5] 之间。 
// 
// Related Topics 排序 树 
// 👍 57 👎 0

import java.util.ArrayList;
import java.util.List;

/**
 * LC1305两棵二叉搜索树中的所有元素
 * 2021-05-19 16:22:48
 */
public class LC1305两棵二叉搜索树中的所有元素{
    public static void main(String[] args) {
//          Solution solution = new LC1305两棵二叉搜索树中的所有元素().new Solution();
            
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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> lnums = new ArrayList<>(), rnums = new ArrayList<>(), ret = new ArrayList<>();
        getMidNums(root1, lnums);
        getMidNums(root2, rnums);
        int n1 = 0, n2 = 0;
        while (n1 < lnums.size() || n2 < rnums.size()){
            if(n2 == rnums.size() || (n1 < lnums.size() && lnums.get(n1) < rnums.get(n2))){
                ret.add(lnums.get(n1++));
            }else{
                ret.add(rnums.get(n2++));
            }
        }
        return ret;
    }

    private void getMidNums(TreeNode root, List<Integer> nums) {
        if(root == null) {
            return;
        }
        getMidNums(root.left, nums);
        nums.add(root.val);
        getMidNums(root.right, nums);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}