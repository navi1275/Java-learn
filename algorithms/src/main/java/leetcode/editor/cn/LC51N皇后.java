package leetcode.editor.cn;

//n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
//
// 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
//
//
//
// 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
//
//
//
// 示例 1：
//
//
//输入：n = 4
//输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
//解释：如上图所示，4 皇后问题存在两个不同的解法。
//
//
// 示例 2：
//
//
//输入：n = 1
//输出：[["Q"]]
//
//
//
//
// 提示：
//
//
// 1 <= n <= 9
// 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。
//
//
//
// Related Topics 回溯算法
// 👍 791 👎 0

import java.util.ArrayList;
import java.util.List;

/**
 * LC51N皇后
 * 2021-03-17 11:06:51
 */
public class LC51N皇后{
    public static void main(String[] args) {
         Solution solution = new LC51N皇后().new Solution();
        List<List<String>> lists = solution.solveNQueens(5);
        for (int j = 0; j < lists.size(); j++) {
            List<String> strings = lists.get(j);
            System.out.print("[");
            for (int k = 0; k < strings.size(); k++) {

                System.out.print(strings.get(k) + ",");
            }
            System.out.print("]");
            System.out.println();

        }
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<String>> lists = new ArrayList<>();
    int n = 0;
    private boolean check(char[][] board, int row, int col){
            //行没有
            int i,j;
            for (i = 0; i < n; i++) {
                if(board[row][i] == 'Q'){
                    return false;
                }
            }

            //列没有
            for (i = 0; i < n; i++) {
                if(board[i][col] == 'Q'){
                    return false;
                }
            }
            //从上层开始放，只考虑左上和右上有没有'Q'的情况
            //左上没有
            for (i = row - 1, j = col - 1; i > -1 && j > -1 ; i--,j--) {
                if(board[i][j] == 'Q'){
                    return false;
                }
            }
            // 右上没有
            for (i = row - 1, j = col + 1; i > -1 && j < n; i--,j++){
                if(board[i][j] == 'Q'){
                    return false;
                }
            }
            return true;
        }


    public void findNQueens(char[][] board, int row) {
        if(row == n){
            List<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String s = new String(board[i]);
                list.add(s);
            }
            lists.add(list);
            return;
        }
        for (int i = 0; i < n; i++){
            //初始化
            if(row == 0) {
                board = new char[n][n];
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < n; k++) {
                        board[j][k] = '.';
                    }
                }
            }
            boolean check = check(board, row, i);
            if(check){
                board[row][i] = 'Q';
                //递归到下层查找
                findNQueens(board, row + 1);
                //找到后要将字段设置成'.'
                board[row][i] = '.';

            }
        }
    }
    public List<List<String>> solveNQueens(int num) {
        n = num;
        findNQueens(null, 0);
        return lists;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}