package leetcode.editor.cn;
 
//输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [3,2,1], k = 2
//输出：[1,2] 或者 [2,1]
// 
//
// 示例 2： 
//
// 输入：arr = [0,1,2,1], k = 1
//输出：[0] 
//
// 
//
// 限制： 
//
// 
// 0 <= k <= arr.length <= 10000 
// 0 <= arr[i] <= 10000 
// 
// Related Topics 堆 分治算法 
// 👍 223 👎 0

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * LC剑指Offer40最小的k个数
 * 2021-04-08 22:43:52
 */
public class LC剑指Offer40最小的k个数{
    public static void main(String[] args) {
//          Solution solution = new LC剑指Offer40最小的k个数().new Solution();
            
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        // 构建小顶堆
        Queue<Integer> pq = new PriorityQueue(arr.length, (n1, n2)->{
            return (int)n2 - (int)n1;
        });
        for (int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);
            if(pq.size() > k){
                pq.poll();
            }
        }
        int[] ret = new int[k];
        for (int i = 0; i < k; i++) {
            ret[i] = pq.poll();
        }
        return ret;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}