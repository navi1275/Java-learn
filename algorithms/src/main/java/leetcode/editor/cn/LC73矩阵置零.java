package leetcode.editor.cn;
 
//给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。 
//
// 进阶： 
//
// 
// 一个直观的解决方案是使用 O(mn) 的额外空间，但这并不是一个好的解决方案。 
// 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。 
// 你能想出一个仅使用常量空间的解决方案吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,1,1],[1,0,1],[1,1,1]]
//输出：[[1,0,1],[0,0,0],[1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
//输出：[[0,0,0,0],[0,4,5,0],[0,3,1,0]]
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[0].length 
// 1 <= m, n <= 200 
// -231 <= matrix[i][j] <= 231 - 1 
// 
// Related Topics 数组 
// 👍 442 👎 0

/**
 * LC73矩阵置零
 * 2021-03-21 21:57:37
 */
public class LC73矩阵置零{
    public static void main(String[] args) {
//          Solution solution = new LC73矩阵置零().new Solution();
            
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean row0Sign = false, col0Sign = false;
        for (int i = 0; i < m; i++) {
            if(matrix[i][0] == 0){
                col0Sign = true;
                break;
            }
        }
        for (int i = 0; i < n; i++) {
            if(matrix[0][i] == 0){
                row0Sign = true;
                break;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if(col0Sign) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
        if(row0Sign) {
            for (int i = 0; i < n; i++) {
                matrix[0][i] = 0;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}