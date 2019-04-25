package com.navi.sort;

/**
 * QuickSort Class
 *
 * 快速排序
 * @author navi
 * @date 2019-03-27
 * @since 1.0.0
 */
public class QuickSort {

    public static void sort(int[] arr, int L, int R){

        int i = L;
        int j = R;

        int pivot = arr[(i + j)/2];
        while (i <= j){
            while (arr[i] < pivot){
                i++;
            }

            while (arr[j] > pivot){
                j--;
            }

            if(i<=j){
                if(i<j) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    print(arr);
                }
                i++;
                j--;
            }
        }

        if(j > L){
            sort(arr, L, j);
        }
        if(i < R){
            sort(arr, i, R);
        }


    }

    private static void print(int[] arr){
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {9, 7, 8, 3, 1, 5, 2, 4};
        // int[] arr = {9, 8, 7, 6, 5, 4, 3, 2};
        print(arr);

        sort(arr, 0, arr.length - 1);
    }
}
