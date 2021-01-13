package com.navi;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution Class
 * 括号生成
 *
 * @author navi
 * @date 2019-04-04
 * @since 1.0.0
 */
public class 括号生成 {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        List<String> list = generateParenthesis(2);
        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - start) + " ms");

        for (String s:list){
            System.out.println(s);
        }
    }

    /**
     * 生成括号
     * @param n
     * @return
     */
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList();
        String cur = "";
        add(n, result, cur, 0, 0);
        return result;
    }

    /**
     * 递归生成括号
     * @param n 生成n对括号
     * @param result 结果
     * @param cur 当前添加
     * @param lnum 左括号数量
     * @param rnum 右括号数量
     */
    private static void add(int n, List<String> result, String cur, int lnum, int rnum) {

        // 左右括号都等于n，把cur加入result
        if (lnum == n && rnum == n) {
            result.add(cur);
        }

        // 左括号小于n，加一个左括号
        if (lnum < n) {
            add(n, result, cur + "(", lnum + 1, rnum);
        }

        // 右括号小于n，且右括号小于左括号，加一个右括号
        if (rnum < n && lnum > rnum) {
            add(n, result, cur + ")", lnum, rnum + 1);
        }
    }
}
