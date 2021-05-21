package leetcode.editor.cn;
 
//如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数
//值排序之后中间两个数的平均值。 
//
// 例如， 
//
// [2,3,4] 的中位数是 3 
//
// [2,3] 的中位数是 (2 + 3) / 2 = 2.5 
//
// 设计一个支持以下两种操作的数据结构： 
//
// 
// void addNum(int num) - 从数据流中添加一个整数到数据结构中。 
// double findMedian() - 返回目前所有元素的中位数。 
// 
//
// 示例 1： 
//
// 输入：
//["MedianFinder","addNum","addNum","findMedian","addNum","findMedian"]
//[[],[1],[2],[],[3],[]]
//输出：[null,null,null,1.50000,null,2.00000]
// 
//
// 示例 2： 
//
// 输入：
//["MedianFinder","addNum","findMedian","addNum","findMedian"]
//[[],[2],[],[3],[]]
//输出：[null,null,2.00000,null,2.50000] 
//
// 
//
// 限制： 
//
// 
// 最多会对 addNum、findMedian 进行 50000 次调用。 
// 
//
// 注意：本题与主站 295 题相同：https://leetcode-cn.com/problems/find-median-from-data-strea
//m/ 
// Related Topics 堆 设计 
// 👍 146 👎 0

import java.util.PriorityQueue;

/**
 * LC剑指Offer41数据流中的中位数
 * 2021-05-20 13:10:09
 */
public class LC剑指Offer41数据流中的中位数{
    public static void main(String[] args) {
        MedianFinder solution = new LC剑指Offer41数据流中的中位数().new MedianFinder();
        solution.addNum(1);
        solution.addNum(2);
        System.out.println(solution.findMedian());
        solution.addNum(2);
        System.out.println(solution.findMedian());
            
    }
//leetcode submit region begin(Prohibit modification and deletion)
class MedianFinder {

        PriorityQueue<Integer> pq1;
        PriorityQueue<Integer> pq2;

    /** initialize your data structure here. */
    public MedianFinder() {
        pq1 = new PriorityQueue<Integer>((a, b)->{
            return b - a;
        });
        pq2 = new PriorityQueue<Integer>((a, b)->{
            return a - b;
        });
    }
    
    public void addNum(int num) {
        if (pq1.isEmpty()){
            pq1.add(num);
            return;
        }
        Integer p1 = pq1.peek();
        if(p1 <= num){
            pq2.add(num);
        }else {
            pq1.add(num);
        }
        int s1 = pq1.size();
        int s2 = pq2.size();
        if(s1 > s2 + 1){
            pq2.add(pq1.poll());
        }else if(s1 < s2){
            pq1.add(pq2.poll());
        }
    }
    
    public double findMedian() {
        int s1 = pq1.size();
        int s2 = pq2.size();
        return s1 == s2 ? ((double)pq1.peek() + (double)pq2.peek()) / 2 : pq1.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
//leetcode submit region end(Prohibit modification and deletion)

}