package com.navi.struct;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import org.junit.Assert;

import java.util.HashSet;
import java.util.Set;

/**
 * BloomFilters Class
 *
 * @author navi
 * @date 2019-05-22
 * @since 1.0.0
 */
public class BloomFilters {

    private int arraySize;

    private int[] array;

    public BloomFilters(int arraySize) {
        this.arraySize = arraySize;
        this.array = new int[arraySize];
    }

    public static void main(String[] args) {
        // long star = System.currentTimeMillis();
        //
        // Set<Integer> hashset = new HashSet<>(100) ;
        // for (int i = 0; i < 10000000; i++) {
        //     hashset.add(i) ;
        // }
        // Assert.assertTrue(hashset.contains(1));
        // Assert.assertTrue(hashset.contains(2));
        // Assert.assertTrue(hashset.contains(3));
        //
        // long end = System.currentTimeMillis();
        // System.out.println("执行时间：" + (end - star));


        // long star = System.currentTimeMillis();
        // BloomFilters bloomFilters = new BloomFilters(10000000) ;
        // for (int i = 0; i < 10000000; i++) {
        //     bloomFilters.add(i + "") ;
        // }
        // Assert.assertTrue(bloomFilters.check(1+""));
        // Assert.assertTrue(bloomFilters.check(2+""));
        // Assert.assertTrue(bloomFilters.check(3+""));
        // Assert.assertTrue(bloomFilters.check(999999+""));
        // Assert.assertFalse(bloomFilters.check(400230340+""));
        // long end = System.currentTimeMillis();
        // System.out.println("执行时间：" + (end - star));

        long star = System.currentTimeMillis();
        BloomFilter<Integer> filter = BloomFilter.create(
                Funnels.integerFunnel(),
                10000000,
                0.01);

        for (int i = 0; i < 10000000; i++) {
            filter.put(i);
        }

        Assert.assertTrue(filter.mightContain(1));
        Assert.assertTrue(filter.mightContain(2));
        Assert.assertTrue(filter.mightContain(3));
        Assert.assertFalse(filter.mightContain(10000000));
        long end = System.currentTimeMillis();
        System.out.println("执行时间：" + (end - star));
    }

    public void add(String key){
        int first = hashcode_1(key);
        int second = hashcode_2(key);
        int third = hashcode_3(key);

        array[first % arraySize] = 1;
        array[second % arraySize] = 1;
        array[third % arraySize] = 1;
    }

    public boolean check(String key){
        int first = hashcode_1(key);
        int second = hashcode_2(key);
        int third = hashcode_3(key);


        if(array[first % arraySize] == 0 || array[second % arraySize] == 0 || array[third % arraySize] == 0){
            return false;
        }
        return true;
    }

    /**
     * hash 算法1
     * @param key
     * @return
     */
    private int hashcode_1(String key) {
        int hash = 0;
        int i;
        for (i = 0; i < key.length(); ++i) {
            hash = 33 * hash + key.charAt(i);
        }
        return Math.abs(hash);
    }

    /**
     * hash 算法2
     * @param data
     * @return
     */
    private int hashcode_2(String data) {
        final int p = 16777619;
        int hash = (int) 2166136261L;
        for (int i = 0; i < data.length(); i++) {
            hash = (hash ^ data.charAt(i)) * p;
        }
        hash += hash << 13;
        hash ^= hash >> 7;
        hash += hash << 3;
        hash ^= hash >> 17;
        hash += hash << 5;
        return Math.abs(hash);
    }

    /**
     *  hash 算法3
     * @param key
     * @return
     */
    private int hashcode_3(String key) {
        int hash, i;
        for (hash = 0, i = 0; i < key.length(); ++i) {
            hash += key.charAt(i);
            hash += (hash << 10);
            hash ^= (hash >> 6);
        }
        hash += (hash << 3);
        hash ^= (hash >> 11);
        hash += (hash << 15);
        return Math.abs(hash);
    }

}
