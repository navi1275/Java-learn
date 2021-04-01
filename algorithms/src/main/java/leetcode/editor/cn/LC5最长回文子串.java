package leetcode.editor.cn;
 
//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 示例 3： 
//
// 
//输入：s = "a"
//输出："a"
// 
//
// 示例 4： 
//
// 
//输入：s = "ac"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母（大写和/或小写）组成 
// 
// Related Topics 字符串 动态规划 
// 👍 3320 👎 0

public class LC5最长回文子串 {
    public static void main(String[] args) {
        Solution solution = new LC5最长回文子串().new Solution();
        System.out.println(solution.longestPalindrome("bb"));
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPalindrome(int start, int end ,String s) {
        if(start > end) return false;
        while(s.charAt(start) == s.charAt(end) && end - start > 2){
            start++;
            end--;
        }
        return s.charAt(start) == s.charAt(end) && end - start < 2;
    }

    /*
        动态规划
        dp[i][j] 表示 i到j是否是回文字符串
        要dp[i][j] = true
        s[i] == s[j]
        s[i+1] == s[j-1]
        dp[i+1][j-1] == true
     */
    public String longestPalindrome(String s) {
        int maxlen = 1, begin = 0;
        int length = s.length();
        boolean[][] dp = new boolean[length][length];
        char[] chars = s.toCharArray();
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if(chars[j] != chars[i]){
                    dp[j][i] = false;
                }else{
                    // 临界点
                    if(i - j < 3){
                        dp[j][i] = true;
                    }else{
                        dp[j][i] = dp[j + 1][i - 1];
                    }
                }

                if(dp[j][i] && maxlen < i - j + 1){
                    begin = j;
                    maxlen = i - j + 1;
                }
            }
        }
        return s.substring(begin, begin + maxlen);
    }

    public String longestPalindrome1(String s) {
        int length = s.length();
        int start = 0;
        int end = 1;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if(isPalindrome(i, j, s) && end - start < (j - i + 1)){
                    start = i;
                    end = j + 1;
                }
            }
        }
        return s.substring(start, end);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}