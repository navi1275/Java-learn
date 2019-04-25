package com.navi.leetcode;

/**
 * Solution122 Class
 * 121. 买卖股票的最佳时机
 *
 * @author navi
 * @date 2019-04-09
 * @since 1.0.0
 */
public class Solution121 {

    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minNum = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (Integer.MAX_VALUE != minNum && prices[i] - minNum > maxProfit) {
                maxProfit = prices[i] - minNum;
            }

            if (prices[i] < minNum) {
                minNum = prices[i];

            }
        }
        return maxProfit;
    }

    public static int maxProfit1(int[] prices) {
        int b1 = Integer.MIN_VALUE;
        int s1 = 0;

        for (int i = 0; i < prices.length; i++) {
            b1 = Math.max(b1, -prices[i]);
            s1 = Math.max(s1, b1 + prices[i]);
        }
        return s1;
    }

    public static void main(String[] args) {
        int[] ps = {1,6,2,8,5};
        System.out.println(maxProfit1(ps));
    }
}
