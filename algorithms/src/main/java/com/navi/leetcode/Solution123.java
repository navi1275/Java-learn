package com.navi.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

/**
 * Solution122 Class
 * 123. 买卖股票的最佳时机 III
 *
 * @author navi
 * @date 2019-04-09
 * @since 1.0.0
 */
public class Solution123 {

    public static int maxProfit(int[] prices) {
        int b1 = Integer.MIN_VALUE;
        int b2 = Integer.MIN_VALUE;
        int s1 = 0;
        int s2 = 0;

        for (int i = 0; i < prices.length; i++) {
            b1 = Math.max(b1, -prices[i]);
            s1 = Math.max(s1, b1 + prices[i]);
            b2 = Math.max(b2, s1 - prices[i]);
            s2 = Math.max(s2, b2 + prices[i]);
        }
        return s2;
    }

    public static void main(String[] args) {
        int[] ps = {1,2,4,2,5,7,2,4,9,0};
        System.out.println(maxProfit(ps));
    }
}
