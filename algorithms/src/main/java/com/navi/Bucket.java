package com.navi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Bucket Class
 *
 *
 * @author ganxiongfeng@foresee.com.cn
 * @date 2019-02-18
 * @since 1.0.0
 */
public class Bucket {

    public static int[] bucket_limit = {8, 5, 3};
    public static int[] bucket_init_value = {8, 0, 0};
    public static int[] result = {4, 4, 0};
    public static int count = 0;

    private List<int[]> change_history;

    private int[] bucket_value;
    private List<int[]> history;

    public Bucket(int[] bucket_value, List<int[]> history) {
        // this.bucket_value = Arrays.copyOf(bucket_value, 3);
        this.bucket_value = Arrays.copyOf(bucket_value, 3);
        this.history = new ArrayList<>();
        this.history.addAll(history);
        this.history.add(Arrays.copyOf(bucket_value, 3));
        // this.history.add(bucket_value);

    }

    public void start(){
        for (int i = 0; i < bucket_init_value.length; i++){
            for (int j = i + 1; j < bucket_init_value.length; j++){
                changeBucketValue(i, j);
                changeBucketValue(j, i);
            }
        }
    }

    public void changeBucketValue(int i, int j){
        if(i == j || bucket_value[i] == 0 || bucket_limit[j] == bucket_value[j]){
            return;
        }

        int water = 0;
        if(bucket_limit[j] - bucket_value[j] <= bucket_value[i]){
            water = bucket_limit[j] - bucket_value[j];
        }else{
            water = bucket_value[i];
        }
        int[] tmp = Arrays.copyOf(bucket_value, 3);

        tmp[i] -= water;
        tmp[j] += water;

        if(Arrays.equals(tmp, result)){
            change_history = new ArrayList<>();
            change_history.addAll(history);
            change_history.add(tmp);
            getResult();
        }else{
            if(!checkBucketStatus(tmp)) {
                Bucket bucket = new Bucket(tmp, history);
                bucket.start();
            }
        }
    }

    private boolean checkBucketStatus(int[] tmp) {
        for (int[] i : history ){
            if(Arrays.equals(i, tmp)) {
                return true;
            }
        }
        return false;
    }

    public void getResult(){
        for (int[] i : change_history){
            System.out.print(Arrays.toString(i));
            System.out.print(", ");
        }
        count++;

        System.out.println();

    }

    public static void main(String[] args) {
        // Bucket bucket = new Bucket(bucket_init_value, new ArrayList<int[]>());
        // bucket.start();
        System.out.printf("总共有 %d 种方法", count);
        System.out.println(-Integer.MIN_VALUE);
        System.out.println(-Integer.MIN_VALUE == Integer.MIN_VALUE);

        System.out.println(Math.round(-1.5));


    }
}
