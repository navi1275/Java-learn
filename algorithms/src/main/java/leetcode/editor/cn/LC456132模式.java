package leetcode.editor.cn;
 
//给定一个整数序列：a1, a2, ..., an，一个132模式的子序列 ai, aj, ak 被定义为：当 i < j < k 时，ai < ak < a
//j。设计一个算法，当给定有 n 个数字的序列时，验证这个序列中是否含有132模式的子序列。 
//
// 注意：n 的值小于15000。 
//
// 示例1: 
//
// 
//输入: [1, 2, 3, 4]
//
//输出: False
//
//解释: 序列中不存在132模式的子序列。
// 
//
// 示例 2: 
//
// 
//输入: [3, 1, 4, 2]
//
//输出: True
//
//解释: 序列中有 1 个132模式的子序列： [1, 4, 2].
// 
//
// 示例 3: 
//
// 
//输入: [-1, 3, 2, 0]
//
//输出: True
//
//解释: 序列中有 3 个132模式的的子序列: [-1, 3, 2], [-1, 3, 0] 和 [-1, 2, 0].
// 
// Related Topics 栈 
// 👍 312 👎 0

import java.util.Stack;

/**
 * LC456132模式
 * 2021-03-24 09:15:01
 */
public class LC456132模式{
    public static void main(String[] args) {
//          Solution solution = new LC456132模式().new Solution();
            
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean find132pattern(int[] nums) {
        int length = nums.length;
        if(length < 3){
            return false;
        }
        // 记录第二大数字
        int secondLargest = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();
        // 从队尾遍历
        for (int i = length - 1; i >= 0; i--) {
            //如果小于第二大，返回true
            if(nums[i] < secondLargest){
                return true;
            }
            //栈底元素是之前遍历过的序列的最大数字
            //遍历到比栈顶数字大的，出栈数字为第二大数字，把大数入栈
            //遍历后，栈顶元素是最大数，之前的最大数为第二大数字
            while (!stack.empty() && nums[i] > stack.peek()){
                secondLargest = stack.peek();
                stack.pop();
            }
            //入栈
            stack.push(nums[i]);
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}