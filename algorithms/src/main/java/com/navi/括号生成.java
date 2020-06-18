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
        List<String> list = generateParenthesis(10);
        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - start) + " ms");

        for (String s:list){
            System.out.println(s);
        }
    }
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList();
        String cur = "";
        add(n, result, cur, 0, 0);
        return result;
    }

    private static void add(int n, List<String> result, String cur, int lnum, int rnum) {

        if (lnum == n && rnum == n) {
            result.add(cur);
        }

        if (lnum < n) {
            add(n, result, cur + "(", lnum + 1, rnum);
        }

        if (rnum < n && lnum > rnum) {
            add(n, result, cur + ")", lnum, rnum + 1);
        }
    }
}
