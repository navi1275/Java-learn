package com.navi;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * LongestCommonPrefix Class
 *
 * Leetcode: 编写一个函数来查找字符串数组中的最长公共前缀。如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 *
 * @author ganxiongfeng@foresee.com.cn
 * @date 2019-03-27
 * @since 1.0.0
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {

        String[] arr1 =  {"flower","flow","flight"};
        String[] arr2 =  {"dog","racecar","car"};

        System.out.println(getLongestCommonPrefix(arr1));
        System.out.println(getLongestCommonPrefix(arr2));
    }

    private static String getLongestCommonPrefix(String[] array) {
        if(array == null || array.length < 1){
            return "";
        }

        List<String> list = Arrays.asList(array);

        Collections.sort(list);

        String first = list.get(0);
        String last = list.get(array.length - 1);

        int min = first.length() > last.length() ? last.length() : first.length();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < min; i++){
            if(first.charAt(i) == last.charAt(i)){
                sb.append(first.charAt(i));
            }else{
                break;
            }
        }

        return sb.toString();


    }
}
