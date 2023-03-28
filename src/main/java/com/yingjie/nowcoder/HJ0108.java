package com.yingjie.nowcoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <p>Title: HJ0108</p>
 * <p>Description: </p>
 *
 * 正整数A和正整数B 的最小公倍数是指 能被A和B整除的最小的正整数值，设计一个算法，求输入A和B的最小公倍数。
 *
 * 数据范围：
 * 1≤a,b≤100000
 *
 * 输入描述：
 * 输入两个正整数A和B。
 *
 * 输出描述：
 * 输出A和B的最小公倍数。
 */
public class HJ0108 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s = reader.readLine()) != null) {
            String[] arr = s.split(" ");
            int a = Integer.parseInt(arr[0]);
            int b = Integer.parseInt(arr[1]);

            System.out.println(gcb(a,b,a));

        }
    }

    // 公倍数的概念就是同时可以整除两个数。所以只要一个数逐渐累加自身到可以整除另一个数时就是既可以整除自己也可以整除另一个数，此时结果就是要得到的
    public static int gcb(int a, int b, int c) {
        if (a % b == 0) {
            return a;
        }
        return gcb(a + c, b, c);
    }
}
