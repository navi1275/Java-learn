package com.navi.task;

import java.util.Scanner;

/**
 * Demo0507 Class
 *
 * @author ganxf
 * @date 2021/5/7
 */
public class Demo0507 {


    public static void main(String[] args) {
        byte[] bytes = new byte[10];
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(s);
        String[] s1 = s.split(" ");
        Integer n = Integer.valueOf(s1[0]);
        Integer m = Integer.valueOf(s1[1]);
        WightQuickQuickUnion union = new WightQuickQuickUnion(n);
        for (int i = 0; i < m; i++) {
            s = scanner.nextLine();
            System.out.println(s);
            s1 = s.split(" ");
            Integer a = Integer.valueOf(s1[1]);
            Integer b = Integer.valueOf(s1[2]);
            if("1".equals(s1[0])){
                union.merge(a, b);
            }else{
                if(union.find(a) == union.find(b)){
                    System.out.println("YES");
                }else{
                    System.out.println("NO");
                }
            }

        }
    }
}
class WightQuickQuickUnion{
    int[] color;
    int number;

    public WightQuickQuickUnion(int n){
        number = n;
        color = new int[n];
        for (int i = 0; i < n; i++) {
            color[i] = i;
        }
    }

    public int find(int a){
        return color[a] = (color[a] == a ? a : find(color[a]));
    }
    public void merge(int a, int b){
        color[find(a)] = find(b);
        return;
    }
}

