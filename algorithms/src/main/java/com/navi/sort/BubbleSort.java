package com.navi.sort;

/**
 * BubbleSort Class
 *
 * 冒泡排序
 * @author navi
 * @date 2019-03-27
 * @since 1.0.0
 */
public class BubbleSort {

    public static void sort(int[] arr){

        for (int i = 0; i < arr.length - 1; i++){
            for (int j = 0; j < arr.length - i - 1; j++){
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
