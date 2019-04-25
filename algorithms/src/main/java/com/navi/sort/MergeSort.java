package com.navi.sort;

/**
 * SelectionSort Class
 *
 * 归并排序
 * @author navi
 * @date 2019-03-27
 * @since 1.0.0
 */
public class MergeSort {

    public static void sort(int[] arr, int begin, int end){

        if(begin == end){
            return;
        }

        int mid = (begin + end) / 2;

        sort(arr, begin, mid);
        sort(arr, mid + 1, end);
        merge(arr, begin, mid + 1, end);

    }

    /**
     * 合并排好序的2个子数组
     * @param arr
     * @param begin
     * @param mid
     * @param end
     */
    private static void merge(int[] arr, int begin, int mid, int end) {
        int[] larr = new int[mid - begin];
        int[] rarr = new int[end - mid + 1];

        for(int i = begin; i < mid; i++ ){
            larr[i - begin] = arr[i];
        }

        for(int i = mid; i < end + 1; i++ ){
            rarr[i - mid] = arr[i];
        }
        int i = 0;
        int j = 0;
        int k = begin;

        while (i < larr.length && j < rarr.length){
            if(larr[i] < rarr[j]){
                arr[k] = larr[i];
                i++;
                k++;
            }else{
                arr[k] = rarr[j];
                j++;
                k++;
            }

        }

        while (i < larr.length && larr[i] > arr[k]){
            arr[k] = larr[i];
            i++;
            k++;
        }
        while (j < rarr.length && rarr[j] > arr[k]){
            arr[k] = rarr[j];
            j++;
            k++;
        }
        print(arr);

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
