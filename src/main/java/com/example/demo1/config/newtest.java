package com.example.demo1.config;

import java.util.ArrayList;
import java.util.Scanner;

public class newtest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            ArrayList arrayList = new ArrayList();
            String data = in.next();

            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(a + b);
        }

    }
}
