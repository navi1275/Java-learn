package leetcode.editor.cn;
 
//给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。 
//
// 注意：如果对空文本输入退格字符，文本继续为空。 
//
// 
//
// 示例 1： 
//
// 
//输入：S = "ab#c", T = "ad#c"
//输出：true
//解释：S 和 T 都会变成 “ac”。
// 
//
// 示例 2： 
//
// 
//输入：S = "ab##", T = "c#d#"
//输出：true
//解释：S 和 T 都会变成 “”。
// 
//
// 示例 3： 
//
// 
//输入：S = "a##c", T = "#a#c"
//输出：true
//解释：S 和 T 都会变成 “c”。
// 
//
// 示例 4： 
//
// 
//输入：S = "a#c", T = "b"
//输出：false
//解释：S 会变成 “c”，但 T 仍然是 “b”。 
//
// 
//
// 提示： 
//
// 
// 1 <= S.length <= 200 
// 1 <= T.length <= 200 
// S 和 T 只含有小写字母以及字符 '#'。 
// 
//
// 
//
// 进阶： 
//
// 
// 你可以用 O(N) 的时间复杂度和 O(1) 的空间复杂度解决该问题吗？ 
// 
//
// 
// Related Topics 栈 双指针 
// 👍 273 👎 0

import java.util.Stack;

/**
 * LC844比较含退格的字符串
 * 2021-03-24 15:07:36
 */
public class LC844比较含退格的字符串{
    public static void main(String[] args) {
         Solution solution = new LC844比较含退格的字符串().new Solution();
            solution.backspaceCompare("ab#c", "ad#c");
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> ss = new Stack<>();
        Stack<Character> st = new Stack<>();
        changeToStack(S, ss);
        changeToStack(T, st);
        while (!ss.empty() && !st.empty()){
            if(!ss.pop().equals(st.pop())){
                return false;
            }
        }
        return ss.empty() && st.empty();
    }

    private void changeToStack(String s, Stack<Character> stack) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(stack.empty() && c == '#'){
                continue;
            }
            if(c != '#'){
                stack.push(c);
            }else{
                stack.pop();
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}