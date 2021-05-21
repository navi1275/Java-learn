package leetcode.editor.cn;

//
// 
// 有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连
//。 
//
// 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。 
//
// 给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，而 
//isConnected[i][j] = 0 表示二者不直接相连。 
//
// 返回矩阵中 省份 的数量。 
//
// 
//
// 示例 1： 
//
// 
//输入：isConnected = [[1,1,0],[1,1,0],[0,0,1]]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：isConnected = [[1,0,0],[0,1,0],[0,0,1]]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 200 
// n == isConnected.length 
// n == isConnected[i].length 
// isConnected[i][j] 为 1 或 0 
// isConnected[i][i] == 1 
// isConnected[i][j] == isConnected[j][i] 
// 
// 
// 
// Related Topics 深度优先搜索 并查集 
// 👍 546 👎 0

/**
 * LC547省份数量
 * 2021-05-07 11:42:17
 */
public class LC547省份数量{
    public static void main(String[] args) {
//          Solution solution = new LC547省份数量().new Solution();

    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        WightQuickQuickUnion union = new WightQuickQuickUnion(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(isConnected[i][j] == 0) continue;
                union.merge(i, j);
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if(union.find(i) == i){
                ans++;
            }
        }
        return ans;
    }
}
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

//leetcode submit region end(Prohibit modification and deletion)

    class QuickFind{
        int[] color;
        int number;

        public QuickFind(int n){
            number = n;
            color = new int[n];
            for (int i = 0; i < n; i++) {
                color[i] = i;
            }
        }

        //quick find 算法
        public int find(int a){
            return color[a];
        }
        public void merge(int a, int b){
            int fb = find(b);
            for (int i = 0; i < number; i++) {
                if(color[i] == fb){
                    color[i] = find(a);
                }
            }
            return;
        }
    }

    class QuickUnion{
        int[] color;
        int number;

        public QuickUnion(int n){
            number = n;
            color = new int[n];
            for (int i = 0; i < n; i++) {
                color[i] = i;
            }
        }

        //quick union 算法
        public int find(int a){
            if(color[a] == a){
                return a;
            }
            return find(color[a]);
        }
        public void merge(int a, int b){
            int fa = find(a), fb = find(b);
            if(fa == fb) {
                return;
            }
            color[fb] = color[fa];
            return;
        }
    }

    class WightQuickUnion{
        int[] color;
        int[] size;
        int number;

        public WightQuickUnion(int n){
            number = n;
            color = new int[n];
            for (int i = 0; i < n; i++) {
                color[i] = i;
                size[i] = 1;
            }
        }

        //quick union 算法
        public int find(int a){
            if(color[a] == a){
                return a;
            }
            // 并查集路径压缩
            int root = find(color[a]);
            color[a] = root;
            return root;
        }
        public void merge(int a, int b){
            int fa = find(a), fb = find(b);
            if(fa == fb) {
                return;
            }
            if(size[fa] > size[fb]){
                color[fb] = color[fa];
                size[fa] += size[fb];
            }else{
                color[fa] = color[fb];
                size[fb] += size[fa];
            }
            return;
        }
    }

}