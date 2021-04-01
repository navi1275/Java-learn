package leetcode.editor.cn;
 
//有些数的素因子只有 3，5，7，请设计一个算法找出第 k 个数。注意，不是必须有这些素因子，而是必须不包含其他的素因子。例如，前几个数按顺序应该是 1，3，
//5，7，9，15，21。 
//
// 示例 1: 
//
// 输入: k = 5
//
//输出: 9
// 
// Related Topics 堆 队列 数学 
// 👍 47 👎 0

import java.util.ArrayList;
import java.util.List;

public class LC面试题1709第k个数20210315{
    public static void main(String[] args) {
//          Solution solution = new LC面试题1709第k个数20210315().new Solution();
            
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //    1  3  5  7  9  15  21
    public int getKthMagicNumber(int k) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        int p3 = 0, p5 = 0, p7 = 0;
        while (list.size() < k){
            int num = 3 * list.get(p3);
            num = Math.min(5 * list.get(p5), num);
            num = Math.min(7 * list.get(p7), num);
            if(num == 3 * list.get(p3)){
                p3++;
            }
            if(num == 5 * list.get(p5)){
                p5++;
            }
            if(num == 7 * list.get(p7)){
                p7++;
            }
            list.add(num);
        }
        return list.get(k - 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}