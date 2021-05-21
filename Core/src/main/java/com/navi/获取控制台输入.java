package com.navi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * 获取控制台输入 Class
 *
 * @author ganxf
 * @date 2021/5/7
 */
public class 获取控制台输入 {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String s = br.readLine();
            System.out.println("BufferedReader: " + s);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println("Scanner: " + s);

        // 在使用 IDE 的情况下，是无法获取到Console实例的
        Console console = System.console();
        if(console != null) {
            String s1 = console.readLine();
            System.out.println("Console: " + s1);
        }
    }
}
