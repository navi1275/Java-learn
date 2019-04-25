package com.navi.sort;

/**
 * HeapSort Class
 *
 * 堆排序
 * @author navi
 * @date 2019-03-27
 * @since 1.0.0
 */
public class HeapSort {

    /**
     * 完成一次建堆，最大值在堆的顶部(根节点)
     */
    public static void maxHeapify(int[] arrays, int size) {

        // 从数组的尾部开始，直到第一个元素(角标为0)
        for (int i = size - 1; i >= 0; i--) {
            if(2 * i + 1 < size) {
                heapify(arrays, i, size);
            }
        }

    }

    /**
     * 建堆
     *
     * @param arrays          看作是完全二叉树
     * @param currentRootNode 当前父节点位置
     * @param size            节点总数
     */
    public static void heapify(int[] arrays, int currentRootNode, int size) {

        if (currentRootNode < size) {
            //左子树和右字数的位置
            int left = 2 * currentRootNode + 1;
            int right = 2 * currentRootNode + 2;

            //把当前父节点位置看成是最大的
            int max = currentRootNode;

            if (left < size) {
                //如果比当前根元素要大，记录它的位置
                if (arrays[max] < arrays[left]) {
                    max = left;
                }
            }
            if (right < size) {
                //如果比当前根元素要大，记录它的位置
                if (arrays[max] < arrays[right]) {
                    max = right;
                }
            }
            //如果最大的不是根元素位置，那么就交换
            if (max != currentRootNode) {
                int temp = arrays[max];
                arrays[max] = arrays[currentRootNode];
                arrays[currentRootNode] = temp;

                //继续比较，直到完成一次建堆
                heapify(arrays, max, arrays.length);
            }
        }
    }

    private static void print(int[] arr){
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {9, 7, 8, 3, 1, 5, 2, 4, 5};
        // int[] arr = {9, 8, 7, 6, 5, 4, 3, 2};
        print(arr);

        for (int i = 0; i < arr.length; i++) {

            //每次建堆就可以排除一个元素了
            maxHeapify(arr, arr.length - i);

            //交换
            int temp = arr[0];
            arr[0] = arr[(arr.length - 1) - i];
            arr[(arr.length - 1) - i] = temp;

        }
    }
}
