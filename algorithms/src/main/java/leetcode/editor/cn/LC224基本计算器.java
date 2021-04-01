package leetcode.editor.cn;

//给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "1 + 1"
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：s = " 2-1 + 2 "
//输出：3
// 
//
// 示例 3： 
//
// 
//输入：s = "(1+(4+5+2)-3)+(6+8)"
//输出：23
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 3 * 105 
// s 由数字、'+'、'-'、'('、')'、和 ' ' 组成 
// s 表示一个有效的表达式 
// 
// Related Topics 栈 数学 
// 👍 518 👎 0

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LC224基本计算器
 * 2021-03-19 10:19:33
 */
public class LC224基本计算器 {
    public static void main(String[] args) {
        Solution solution = new LC224基本计算器().new Solution();
        // System.out.println((int)'0');
        System.out.println(solution.calculate("(3)+1"));
        // System.out.println(Integer.valueOf('0' + ""));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private boolean isNum(char c) {
            return c >= '0' && c <= '9';
        }

        private int cal(char c, int num1, int num2) {
            switch (c) {
                case '+':
                    return num1 + num2;
                case '-':
                    return num1 - num2;
                case '*':
                    return num1 * num2;
                case '/':
                    return num1 / num2;
            }
            return 0;
        }

        private int getPriority(char c) {
            switch (c) {
                case '@':
                case ')':
                    return 0;
                case '+':
                case '-':
                    return 1;
                case '*':
                case '/':
                    return 2;
                case '(':
                    return 100;
            }
            return -1;
        }

        public int calculate1(String s) {
            Deque<Integer> numStack = new ArrayDeque<>();
            Deque<Character> optStack = new ArrayDeque<>();
            s = s + '@';
            char[] chars = s.replaceAll(" ", "").toCharArray();
            int num = 0;
            for (int i = 0; i < chars.length; i++) {
                char c = chars[i];
                if (isNum(c)) {
                    num = 10 * num + Integer.valueOf(c + "");
                    continue;
                }
                numStack.push(num);
                num = 0;
                Character optChar;
                while (!optStack.isEmpty() && getPriority(c) < getPriority(optChar = optStack.peek())){
                    Integer num1 = numStack.pop();
                    Integer num2 = numStack.pop();
                    num = cal(optChar, num2, num1);
                    numStack.push(num);
                    optStack.pop();
                }
                optStack.push(c);
            }
            return numStack.pop();
        }
        public int calculate(String s) {
            Deque<Integer> numStack = new ArrayDeque<>();
            Deque<Character> optStack = new ArrayDeque<>();
            // if (getPriority(s.charAt(0)) == 1) {
            //     s = 0 + s;
            // }
            s = s + '@';
            char[] chars = s.replaceAll(" ", "").toCharArray();
            int num = 0;
            for (int i = 0; i < chars.length; i++) {
                char c = chars[i];
                if (isNum(c)) {
                    num = 10 * num + Integer.valueOf(c + "");
                    continue;
                }

                // if (i > 0 && isNum(chars[i - 1])) {
                if (i == 0 || isNum(chars[i - 1])) {
                    numStack.push(num);
                    num = 0;
                }
                if (getPriority(c) != 100 && !optStack.isEmpty()) {
                    Character optChar = optStack.peek();
                    if (optChar == ')') {
                        optStack.pop();
                        optStack.pop();
                        if (optStack.isEmpty()) {
                            optStack.push(c);
                            continue;
                        } else {
                            optChar = optStack.peek();
                        }
                    }

                    int priority = getPriority(optChar);
                    if (priority != 100) {
                        optStack.pop();
                        Integer num1 = numStack.pop();
                        Integer num2 = numStack.pop();
                        num = cal(optChar, num2, num1);
                        numStack.push(num);
                        num = 0;
                        if (c == ')') {
                            optStack.pop();
                        } else {
                            optStack.push(chars[i]);
                        }
                        continue;
                    } else {
                        if (chars[i - 1] == '(') {
                            numStack.push(0);
                        }
                    }
                }
                optStack.push(c);
            }
            return numStack.pop();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}