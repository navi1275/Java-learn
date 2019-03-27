package com.navi;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/**
 * KmpDemo Class
 * KMP算法，字符串子串查找问题
 *
 * @author ganxiongfeng@foresee.com.cn
 * @date 2019-03-26
 * @since 1.0.0
 */
public class KmpDemo {

    public static int kmpSearch(String source, String search){
        int i = 0;
        int j = -1;
        int sourceLength = source.length();
        int searchLength = search.length();

        int[] next = new int[searchLength];
        getNext(search, next);

        while (i < sourceLength && j < searchLength){
            if(j == -1 || source.charAt(i) == search.charAt(j)){
                i++;
                j++;
            }else{
                j = next[j];
            }
        }

        if (j == search.length()) {
            return i - j;
        } else {
            return -1;
        }
    }

    private static void getNext(String search, int[] next){
        next[0] = -1;
        int length = search.length();
        int i = 0;
        int j = -1;

        while (i < length - 1){
            if(j == -1 || search.charAt(i) == search.charAt(j)){
                ++i;
                ++j;
                if (search.charAt(i) != search.charAt(j)) {
                    next[i] = j;
                }else {
                    //因为不能出现p[j] = p[ next[j ]]，所以当出现时需要继续递归，k = next[k] = next[next[k]]
                    next[i] = next[j];
                }
            }else{
                j = next[j];
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(kmpSearch("BBD ABCAB CABCDABABCDACEFABCDABESAMPLE", "ABCDABABCDACEF"));
    }
}
