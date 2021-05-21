package com.navi.sort;

/**
 * InsertSort Class
 * <p>
 * 插入排序
 *
 * @author navi
 * @date 2019-03-27
 * @since 1.0.0
 */
public class InsertSort {

    public static void sort(int[] arr) {

        // 从数组第二位开始遍历
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int index = i;
            // 遍历之前的序列，将第i个数字插入到有序序列中
            // 前i位有序，比第i位大的后移
            for (int j = i - 1; j > -1 && temp < arr[j]; j--) {
                arr[j + 1] = arr[j];
                index = j;
            }

            arr[index] = temp;

            print(arr);
        }

    }

    private static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {9, 7, 8, 3, 1, 5, 2, 4};
        // int[] arr = {9, 8, 7, 6, 5, 4, 3, 2};
        // int[] arr = {2, 3, 4, 5, 9, 7, 8, 9};
        print(arr);

        sort(arr);
    }
}
