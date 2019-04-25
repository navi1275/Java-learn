package com.navi.leetcode;

/**
 * Solution122 Class
 * 122. 买卖股票的最佳时机 II
 *
 * @author navi
 * @date 2019-04-09
 * @since 1.0.0
 */
public class Solution122 {

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int max = 0;
        int tmp = 0;
        // 倒序遍历
        for (int i = prices.length - 1; i > 0; i--) {
            // 大于前面的数，则股票涨
            if (prices[i] > prices[i - 1]) {
                tmp = tmp + prices[i] - prices[i - 1];

            // 小于前面的数，则股票跌了，结算收益
            } else if (prices[i] < prices[i - 1]) {
                max += tmp;
                tmp = 0;
            }
        }
        max += tmp;
        return max;
    }

    public static int maxProfit1(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if(prices[i] - prices[i - 1] > 0){
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
    }

    public static int maxProfit2(int[] prices) {
        int b1 = Integer.MIN_VALUE;
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            b1 = Math.max(b1, -prices[i]);
            if(b1 + prices[i] > 0){
                maxProfit += b1 + prices[i];
                b1 = -prices[i];
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] ps = {1,2,3,4,5};
        System.out.println(maxProfit2(ps));
    }
}
