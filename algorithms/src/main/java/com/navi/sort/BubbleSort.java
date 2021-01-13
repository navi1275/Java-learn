package com.navi.sort;

/**
 * BubbleSort Class
 *
 * 冒泡排序
 * 每次遍历把目标数（最大值或者最小值）放到第arr.length-1-i处
 * 9 8 7 6 5 4 3 2
 * 8 7 6 5 4 3 2 9
 * 7 6 5 4 3 2 8 9
 * 6 5 4 3 2 7 8 9
 * 5 4 3 2 6 7 8 9
 * 4 3 2 5 6 7 8 9
 * 3 2 4 5 6 7 8 9
 * 2 3 4 5 6 7 8 9
 * @author navi
 * @date 2019-03-27
 * @since 1.0.0
 */
public class BubbleSort {

    public static void sort(int[] arr){

        // 遍历次数n=数组长度-1
        for (int i = 0; i < arr.length - 1; i++){
            // 每次遍历把目标数（最大值或者最小值）放到第arr.length-1-i处
            for (int j = 0; j < arr.length - 1 - i; j++){
                if(arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }

            }
            print(arr);
        }

    }

    private static void print(int[] arr){
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // int[] arr = {9, 7, 8, 3, 1, 5, 2, 4};
        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2};
        print(arr);

        sort(arr);
    }
}
