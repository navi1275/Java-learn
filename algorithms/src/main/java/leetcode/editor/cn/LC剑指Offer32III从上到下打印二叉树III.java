package leetcode.editor.cn;
 
//请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。 
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
//  [20,9],
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
// Related Topics 树 广度优先搜索 
// 👍 90 👎 0

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * LC剑指Offer32III从上到下打印二叉树III
 * 2021-04-08 14:41:26
 */
public class LC剑指Offer32III从上到下打印二叉树III{
    public static void main(String[] args) {
//          Solution solution = new LC剑指Offer32III从上到下打印二叉树III().new Solution();
            
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
        if(root == null){
            return ret;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.push(root);
        int col = 0;
        while (!deque.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.pollLast();
                if(col % 2 == 0) {
                    list.add(node.val);
                }else{
                    list.add(0, node.val);
                }

                if(node.left != null){
                    deque.push(node.left);
                }
                if(node.right != null){
                    deque.push(node.right);
                }

            }
            col++;
            ret.add(list);
        }
        return ret;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}