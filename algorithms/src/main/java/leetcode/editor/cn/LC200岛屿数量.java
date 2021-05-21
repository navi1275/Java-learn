package leetcode.editor.cn;
 
//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 300 
// grid[i][j] 的值为 '0' 或 '1' 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 
// 👍 1141 👎 0

/**
 * LC200岛屿数量
 * 2021-05-07 14:40:17
 */
public class LC200岛屿数量{
    public static void main(String[] args) {
//          Solution solution = new LC200岛屿数量().new Solution();
            
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    class WightQuickQuickUnion{
        int[] color;
        int number;

        public WightQuickQuickUnion(int n){
            number = n;
            color = new int[n];
            for (int i = 0; i < n; i++) {
                color[i] = i;
            }
        }

        public int find(int a){
            return color[a] = (color[a] == a ? a : find(color[a]));
        }
        public void merge(int a, int b){
            color[find(a)] = find(b);
            return;
        }
    }


    private int ind(int length, int i, int j){
        return i * length + j;
    }

    public int numIslands(char[][] grid) {
        int n = grid[0].length;
        int m = grid.length;
        WightQuickQuickUnion union = new WightQuickQuickUnion(n * m);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == '0') continue;
                if(j - 1 >= 0 && grid[i][j - 1] == '1'){
                    union.merge(ind(n, i, j), ind(n, i , j - 1));
                }
                if(i - 1 >= 0 && grid[i - 1][j] == '1'){
                    union.merge(ind(n, i - 1, j), ind(n, i, j));
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == '1' && union.find(ind(n, i, j)) == ind(n, i, j)){
                    ans += 1;
                }
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}