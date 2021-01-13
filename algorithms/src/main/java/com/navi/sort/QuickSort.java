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

    public static void sort(int[] arr, int initLeft, int initRight){

        // 定义左右两个指针
        int pointLeft = initLeft;
        int pointRight = initRight;

        // 获取中间节点
        int pivot = arr[(pointLeft + pointRight)/2];
        // 循环
        while (pointLeft <= pointRight){
            // 获取左侧比中间节点大的数
            while (arr[pointLeft] < pivot){
                pointLeft++;
            }

            // 获取右侧比中间节点小的数
            while (arr[pointRight] > pivot){
                pointRight--;
            }

            // 交换，并偏移左右指针
            if(pointLeft<=pointRight){
                if(pointLeft<pointRight) {
                    int temp = arr[pointLeft];
                    arr[pointLeft] = arr[pointRight];
                    arr[pointRight] = temp;
                    print(arr);
                }
                pointLeft++;
                pointRight--;
            }
        }

        // 如果右指针大于左初始位置，调用自身
        if(pointRight > initLeft){
            sort(arr, initLeft, pointRight);
        }
        // 如果左指针小于右初始位置，调用自身
        if(pointLeft < initRight){
            sort(arr, pointLeft, initRight);
        }


    }

    private static void print(int[] arr){
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {9, 7, 8, 3, 1, 5, 2, 4, 6};
        // int[] arr = {9, 8, 7, 6, 5, 4, 3, 2};
        print(arr);

        sort(arr, 0, arr.length - 1);
    }
}
