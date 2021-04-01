package leetcode.editor.cn;

//编写一个算法来判断一个数 n 是不是快乐数。 
//
// 「快乐数」定义为： 
//
// 
// 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。 
// 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。 
// 如果 可以变为 1，那么这个数就是快乐数。 
// 
//
// 如果 n 是快乐数就返回 true ；不是，则返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：19
//输出：true
//解释：
//12 + 92 = 82
//82 + 22 = 68
//62 + 82 = 100
//12 + 02 + 02 = 1
// 
//
// 示例 2： 
//
// 
//输入：n = 2
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 231 - 1 
// 
// Related Topics 哈希表 数学 
// 👍 542 👎 0

import java.util.stream.IntStream;

public class LC202快乐数 {
    public static void main(String[] args) {
        Solution solution = new LC202快乐数().new Solution();
        int sum = IntStream.range(1, 100001).filter((n) -> {
            boolean happy = solution.isHappy(n);
            if(happy){
                System.out.println(n);
            }
            return happy;
        }).sum();
        System.out.println(sum);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int getNext(int n) {
            int next = 0;
            do {
                next += (n % 10) * (n % 10);
                n = n / 10;
            } while (n > 0);
            return next;
        }

        public boolean isHappy(int n) {

            if(n == 1) {
                return true;
            }

            int p = n, q = n;
            do{
                p = getNext(p);
                q = getNext(getNext(q));
            }while (p != q && q != 1);

            return q == 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}