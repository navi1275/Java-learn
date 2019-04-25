package com.navi.sort;

/**
 * BucketSort Class
 * <p>
 * 基数排序，桶排序
 *
 * @author navi
 * @date 2019-03-27
 * @since 1.0.0
 */
public class BucketSort {

    public static void sort(int[] arr) {

        int max = max(arr);
        int v = (int) Math.log10(max);

        for (int i = 0; i <= v; i++) {
            int[][] buckets = new int[arr.length][10];
            int k = (int) Math.pow(10, i);

            for (int j = 0; j < arr.length; j++) {
                int l = arr[j] / k % 10;
                buckets[j][l] = arr[j];
            }

            int n = 0;
            for (int y = 0; y < 10; y++) {
                for (int x = 0; x < arr.length; x++) {
                    if (buckets[x][y] != 0) {
                        arr[n] = buckets[x][y];
                        n++;
                    }
                }
            }
            print(arr);
        }
    }

    private static int max(int[] arr) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        return max;

    }

    private static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // int[] arr = {9, 7, 8, 3, 1, 5, 2, 4};
        // int[] arr = {9, 8, 7, 6, 5, 4, 3, 2};
        int[] arr = {2, 311, 54, 11115, 924, 1927, 8, 699};
        print(arr);

        sort(arr);

        // System.out.println(Math.log10(1));
        // System.out.println(Math.log10(10));
        // System.out.println(Math.log10(100));
        // System.out.println(Math.log10(101));
        // System.out.println(Math.log10(10000));
        // System.out.println(Math.log10(1000000000));

    }
}
