package com.yingjie.nowcoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <p>Title: HJ0060</p>
 * <p>Description: 查找组成一个偶数最接近的两个素数</p>
 *
 * 任意一个偶数（大于2）都可以由2个素数组成，组成偶数的2个素数有很多种情况，本题目要求输出组成指定偶数的两个素数差值最小的素数对。
 *
 * 输入描述：
 * 输入一个大于2的偶数
 *
 * 输出描述：
 * 从小到大输出两个素数
 */
public class HJ0060 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = reader.readLine()) != null) {
            int num = Integer.parseInt(line);
            for (int i = num / 2; i < num - 1; i++) {
                if (isPrime(i) && isPrime(num - i)){
                    System.out.println((num - i) + "\n" + i);
                    return;
                }
            }
        }
    }

    public static boolean isPrime(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
