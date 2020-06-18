package com.navi;

/**
 * Queen Class
 * 八皇后问题
 *
 * @author navi
 * @date 2019-04-19
 * @since 1.0.0
 */
public class 八皇后问题 {

    private static int[][] array = new int[8][8];
    private static int total = 0;

    public void findQueen(int row) {
        if (row > 7) {
            total++;
            print();
            return;
        }

        for (int col = 0; col < 8; col++) {
            if (check(row, col)) {
                array[row][col] = 1;
                findQueen(row + 1);
                array[row][col] = 0;
            }
        }
    }

    private boolean check(int row, int col) {

        // 检查行列是否已经存在皇后节点
        for (int i = 0; i < 8; i++) {
            if (array[i][col] == 1 || array[row][i] == 1) {
                return false;
            }
        }

        // 检查左上是否已经存在皇后节点
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (array[i][j] == 1) {
                return false;
            }
        }

        // 检查右上是否已经存在皇后节点
        for (int i = row - 1, j = col + 1; i >= 0 && j < 8; i--, j++) {
            if (array[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    private void print() {

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(array[i][j] == 0 ? "-+" : "-O");
            }
            System.out.println();
        }

        System.out.println();
    }

    public static void main(String[] args) {
        八皇后问题 q = new 八皇后问题();
        q.findQueen(0);
        System.out.println("八皇后问题一共有 " + total + " 种解");
    }
}
