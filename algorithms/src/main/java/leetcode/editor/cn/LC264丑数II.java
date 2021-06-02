package leetcode.editor.cn;
 
//给你一个整数 n ，请你找出并返回第 n 个 丑数 。 
//
// 丑数 就是只包含质因数 2、3 和/或 5 的正整数。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 10
//输出：12
//解释：[1, 2, 3, 4, 5, 6, 8, 9, 10, 12] 是由前 10 个丑数组成的序列。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：1
//解释：1 通常被视为丑数。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 1690 
// 
// Related Topics 堆 数学 动态规划 
// 👍 664 👎 0

import java.util.PriorityQueue;

/**
 * LC264丑数II
 * 2021-05-23 21:49:48
 */
public class LC264丑数II{
    public static void main(String[] args) {
//          Solution solution = new LC264丑数II().new Solution();
            
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> pq = new PriorityQueue<>((n1, n2) -> {
            return n1.compareTo(n2);
        });
        pq.add(1L);
        long ans = 0;
        while (n-- > 0) {
            ans = pq.poll();
            if(ans % 5 == 0){
                pq.add(ans * 5);
            }else if (ans % 3 == 0) {
                pq.add(ans * 3);
                pq.add(ans * 5);
            }else {
                pq.add(ans * 2);
                pq.add(ans * 3);
                pq.add(ans * 5);
            }
        }
        return (int)ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}