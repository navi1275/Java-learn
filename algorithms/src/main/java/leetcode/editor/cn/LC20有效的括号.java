package leetcode.editor.cn;
 
//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 示例 4： 
//
// 
//输入：s = "([)]"
//输出：false
// 
//
// 示例 5： 
//
// 
//输入：s = "{[]}"
//输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 仅由括号 '()[]{}' 组成 
// 
// Related Topics 栈 字符串 
// 👍 2222 👎 0

import java.util.Stack;

public class LC20有效的括号 {
    public static void main(String[] args) {
        Solution solution = new LC20有效的括号().new Solution();
         
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {
        if(s == null || s.length() < 1 || s.length() % 2 == 1){
            return false;
        }
        Stack<Character> stack = new Stack<>();
        char c;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            }else{
                if(stack.empty()){
                    return false;
                }
                Character first = stack.peek();
                if((c == ']' && first == '[') || (c == ')' && first == '(') || (c == '}' && first == '{')){
                    stack.pop();
                }else{
                    return false;
                }
            }
        }
        return stack.empty();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}