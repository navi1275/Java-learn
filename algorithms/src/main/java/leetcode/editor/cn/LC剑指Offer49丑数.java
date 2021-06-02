package leetcode.editor.cn;
 
//我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。 
//
// 
//
// 示例: 
//
// 输入: n = 10
//输出: 12
//解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。 
//
// 说明: 
//
// 
// 1 是丑数。 
// n 不超过1690。 
// 
//
// 注意：本题与主站 264 题相同：https://leetcode-cn.com/problems/ugly-number-ii/ 
// Related Topics 数学 
// 👍 164 👎 0

import java.util.ArrayList;

/**
 * LC剑指Offer49丑数
 * 2021-05-23 21:08:37
 */
public class LC剑指Offer49丑数{
    public static void main(String[] args) {
//          Solution solution = new LC剑指Offer49丑数().new Solution();
            
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int nthUglyNumber(int n) {
        ArrayList<Integer> list = new ArrayList<>(n);
        list.add(1);
        int p2 = 0, p3 = 0, p5 = 0;
        while (list.size() < n) {
            int min = list.get(p2) * 2;
            min = Math.min(list.get(p3) * 3, min);
            min = Math.min(list.get(p5) * 5, min);
            if (min == 2 * list.get(p2)){
                p2++;
            }
            if(min == 3 * list.get(p3)){
                p3++;
            }
            if(min == 5 * list.get(p5)){
                p5++;
            }
            list.add(min);

        }

        return list.get(n - 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}