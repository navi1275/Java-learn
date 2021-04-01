package leetcode.editor.cn;
 
//给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。 
//
// 如果反转后整数超过 32 位的有符号整数的范围 [−231, 231 − 1] ，就返回 0。 
//假设环境不允许存储 64 位整数（有符号或无符号）。
//
// 
//
// 示例 1： 
//
// 
//输入：x = 123
//输出：321
// 
//
// 示例 2： 
//
// 
//输入：x = -123
//输出：-321
// 
//
// 示例 3： 
//
// 
//输入：x = 120
//输出：21
// 
//
// 示例 4： 
//
// 
//输入：x = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// -231 <= x <= 231 - 1 
// 
// Related Topics 数学 
// 👍 2607 👎 0

public class LC7整数反转20210317{
    public static void main(String[] args) {
         Solution solution = new LC7整数反转20210317().new Solution();
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println((int)Math.pow(2, 31) - 1);
        System.out.println((int)Math.pow(-2, 31));
        System.out.println(solution.reverse(1534236469));
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    //    n = n * 10 + x % 10;
    //先计算，如果存在越界， tmp/10!=ret
    public int reverse(int x) {
        int ret = 0, tmp = 0;
        while (x != 0){
            tmp = ret * 10 + x % 10;
            if(tmp / 10 != ret){
                return 0;
            }
            ret = tmp;
            x /= 10;
        }
        return ret;
    }

    //先判断会不会越界，越界返回0
    public int reverse1(int x) {
        int ret = 0;
        while (x != 0){
            if(ret > Integer.MAX_VALUE / 10 || (ret == Integer.MAX_VALUE && x % 10 > 0)){
                return 0;
            }
            if(ret < Integer.MIN_VALUE / 10 || (ret == Integer.MIN_VALUE && x % 10 < 0)){
                return 0;
            }
            ret = ret * 10 + x % 10;
            x /= 10;
        }
        return ret;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}