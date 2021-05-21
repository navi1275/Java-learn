package leetcode.editor.cn;
 
//在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 示例 1: 
//
// 输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4 
//
// 说明: 
//
// 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。 
// Related Topics 堆 分治算法 
// 👍 1078 👎 0

import java.util.PriorityQueue;

/**
 * LC215数组中的第K个最大元素
 * 2021-05-19 14:10:10
 */
public class LC215数组中的第K个最大元素{
    public static void main(String[] args) {
//          Solution solution = new LC215数组中的第K个最大元素().new Solution();
            
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            return (int) a - (int) b;
        });
        for (int i = 0; i < nums.length; i++){
            if(pq.size() < k){
                pq.add(nums[i]);
                continue;
            }
            if(pq.peek() < nums[i]){
                pq.poll();
                pq.add(nums[i]);
            }
        }
        return pq.poll();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}