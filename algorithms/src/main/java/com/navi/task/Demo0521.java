package com.navi.task;

import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Demo0521 Class
 *
 * @author ganxf
 * @date 2021/5/21
 */
public class Demo0521 {

    static class IdCardData{
        Integer num1;
        Integer num2;
        String num3;
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        Integer n = Integer.valueOf(s);
        PriorityQueue<IdCardData> pq = new PriorityQueue<IdCardData>((d1, d2) -> {
            return d1.num2.equals(d2.num2) ? (d1.num1.equals(d2.num1) ? d2.num3.compareTo(d1.num3) : d2.num1 - d1.num1) : d2.num2 - d1.num2;
        });
        for (int i = 0; i < n; i++) {
            s = scanner.nextLine();
            IdCardData data = new IdCardData();
            data.num1 = Integer.parseInt(s.substring(0, 6));
            data.num2 = Integer.parseInt(s.substring(6, 14));
            data.num3 = s.substring(14, 18);
            pq.add(data);
        }
        while (!pq.isEmpty()){
            System.out.println(pq.poll());
        }


    }
}
