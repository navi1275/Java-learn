package leetcode.editor.cn;
 
//给定 pushed 和 popped 两个序列，每个序列中的 值都不重复，只有当它们可能是在最初空栈上进行的推入 push 和弹出 pop 操作序列的结果时
//，返回 true；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
//输出：true
//解释：我们可以按以下顺序执行：
//push(1), push(2), push(3), push(4), pop() -> 4,
//push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
// 
//
// 示例 2： 
//
// 输入：pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
//输出：false
//解释：1 不能在 2 之前弹出。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= pushed.length == popped.length <= 1000 
// 0 <= pushed[i], popped[i] < 1000 
// pushed 是 popped 的排列。 
// 
// Related Topics 栈 
// 👍 165 👎 0

import java.util.Stack;

/**
 * LC946验证栈序列
 * 2021-03-24 15:35:39
 */
public class LC946验证栈序列{
    public static void main(String[] args) {
         Solution solution = new LC946验证栈序列().new Solution();
            solution.validateStackSequences(new int[]{1,0}, new int[]{1,0});
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int pushedLength = pushed.length;
        int popedLength = popped.length;
        if(pushedLength != popedLength){
            return false;
        }
        if (pushedLength == 0){
            return true;
        }
        Stack<Integer> stack = new Stack<>();

        for (int i = 0, j = 0;i < popedLength; i++) {
            while (j < pushedLength && (stack.empty() || popped[i] != stack.peek())){
                stack.push(pushed[j]);
                j++;
            }
            if(stack.empty() || popped[i] != stack.peek()){
                return false;
            }
            stack.pop();
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}