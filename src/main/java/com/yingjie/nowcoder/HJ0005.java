package com.yingjie.nowcoder;

import java.util.Scanner;

/**
 * <p>Title: HJ005</p>
 * <p>Description: </p>
 *
 * @author LiuYingJie
 * @version 1.0
 * @date 2023/3/23 20:39
 */
public class HJ0005 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String str = in.nextLine();
            int result = 0;
            char[] chars = str.toCharArray();
            int len = chars.length;
            for (int i = 2; i < len; i++) {
                char ch = chars[i];
                int num = ch >= 'A' ? ch - 'A' + 10 : ch - '0';
                result += num * Math.pow(16, len - i - 1);
            }
            System.out.println(result);
        }
    }
}
