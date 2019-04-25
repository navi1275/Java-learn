package com.navi.sort;

/**
 * ShellSort Class
 * <p>
 * 希尔排序
 *
 * @author navi
 * @date 2019-03-27
 * @since 1.0.0
 */
public class ShellSort {

    public static void sort(int[] arr) {

        for (int i = arr.length / 2; i > 0; i/=2) {
            for (int j = i; j < arr.length; j++){
                int temp = arr[j];
                int index = j;
                for (int k = j - i; k > -1 && temp < arr[k]; k=k-i) {
                    arr[k + i] = arr[k];
                    index = k;
                }

                arr[index] = temp;
            }


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
