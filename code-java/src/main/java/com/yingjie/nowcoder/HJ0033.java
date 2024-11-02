package com.yingjie.nowcoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <p>Title: HJ33</p>
 * <p>Description: </p>
 *
 * @author LiuYingJie
 * @version 1.0
 * @date 2023/3/25 21:33
 */
public class HJ0033 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = null;
        while (null != (input = reader.readLine())) {
            if (input.contains(".")) {
                System.out.println(string2Num(input));
            }else {
                System.out.println(num2String(Long.parseLong(input)));
            }
        }
    }

    public static String num2String(long num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 3; i >= 0; i--) {
            long localNum = (num >> 8 * i) & 255;
            sb.append(localNum + ".");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public static long string2Num(String str) {
        String[] strs = str.split("\\.");
        int count = 3;
        long sum = 0;
        for (String numStr : strs) {
            long num = Long.parseLong(numStr);
            sum += (num & (256 - 1)) << (8 * count);
            count--;
        }
        return sum;
    }
}
