package com.navi.task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.*;

/**
 * Demo0329 Class
 *
 * @author ganxf
 * @date 2021/3/29
 */
public class Demo0329 {
    public static void main(String[] args) throws IOException {

        URL resource = Demo0329.class.getClassLoader().getResource("data.txt");
        Deque<Integer> deque = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new InputStreamReader(resource.openStream()))) {
            String line;
            while (null  != (line = br.readLine())){
                if(line.startsWith("pop") && !deque.isEmpty()){
                    Integer pop = deque.pop();
                    list.add(pop);
                }else if(line.startsWith("push")){
                    String[] s = line.split(" ");
                    deque.push(Integer.valueOf(s[1]));
                }
            }
        }
        //11186206671
        long sum = 0;
        for (int i = 0; i <list.size(); i++) {
            sum += list.get(i) * (i + 1);
        }

        System.out.println(sum);
    }
}
