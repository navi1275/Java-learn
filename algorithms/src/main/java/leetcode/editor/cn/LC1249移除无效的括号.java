package leetcode.editor.cn;
 
//给你一个由 '('、')' 和小写字母组成的字符串 s。 
//
// 你需要从字符串中删除最少数目的 '(' 或者 ')' （可以删除任意位置的括号)，使得剩下的「括号字符串」有效。 
//
// 请返回任意一个合法字符串。 
//
// 有效「括号字符串」应当符合以下 任意一条 要求： 
//
// 
// 空字符串或只包含小写字母的字符串 
// 可以被写作 AB（A 连接 B）的字符串，其中 A 和 B 都是有效「括号字符串」 
// 可以被写作 (A) 的字符串，其中 A 是一个有效的「括号字符串」 
// 
//
// 
//
// 示例 1： 
//
// 输入：s = "lee(t(c)o)de)"
//输出："lee(t(c)o)de"
//解释："lee(t(co)de)" , "lee(t(c)ode)" 也是一个可行答案。
// 
//
// 示例 2： 
//
// 输入：s = "a)b(c)d"
//输出："ab(c)d"
// 
//
// 示例 3： 
//
// 输入：s = "))(("
//输出：""
//解释：空字符串也是有效的
// 
//
// 示例 4： 
//
// 输入：s = "(a(b(c)d)"
//输出："a(b(c)d)"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10^5 
// s[i] 可能是 '('、')' 或英文小写字母 
// 
// Related Topics 栈 字符串 
// 👍 102 👎 0

/**
 * LC1249移除无效的括号
 * 2021-03-26 18:01:48
 */
public class LC1249移除无效的括号{
    public static void main(String[] args) {
         Solution solution = new LC1249移除无效的括号().new Solution();
        System.out.println(solution.minRemoveToMakeValid("lee(t(c)o)de)"));
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String minRemoveToMakeValid(String s) {
        int length = s.length(), arrlength = 0;
        char[] arr = new char[length];
        for (int i = 0, cnt = 0; i < length; i++) {
            char c = s.charAt(i);
            if(c != ')'){
                cnt += (c == '(' ? 1 : 0);
            }else{
                if (cnt == 0){
                    continue;
                }
                cnt--;
            }
            arr[arrlength++] = c;
        }
        char[] arr1 = new char[arrlength];
        int offset = arrlength - 1;
        for (int i = arrlength - 1, cnt = 0; i >= 0; i--) {
            char c = arr[i];
            if(c != '('){
                cnt += (c == ')' ? 1 : 0);
            }else{
                if(cnt == 0){
                    continue;
                }
                cnt--;
            }
            arr1[offset--] = c;
        }
        return String.valueOf(arr1, offset + 1, arrlength - offset - 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}