package com.navi.sort;

/**
 * SelectionSort Class
 *
 * 选择排序
 * @author navi
 * @date 2019-03-27
 * @since 1.0.0
 */
public class SelectionSort {

    public static void sort(int[] arr){

        for (int i = arr.length - 1; i > 0; i--){
            int maxIndex = 0;
            // 将最大的值找出来，放到最后面
            for (int j = 1; j < i + 1; j++){
                if(arr[maxIndex] < arr[j]) {
                    maxIndex = j;
                }

            }
            int temp = arr[i];
            arr[i] = arr[maxIndex];
            arr[maxIndex] = temp;
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
