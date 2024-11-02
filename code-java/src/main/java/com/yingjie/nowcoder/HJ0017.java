package com.yingjie.nowcoder;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>Title: HJ0017</p>
 * <p>Description: 坐标移动</p>
 *
 * @author LiuYingJie
 * @version 1.0
 * @date 2023/3/25 20:32
 */
public class HJ0017 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String str = scanner.nextLine();
            AtomicInteger x = new AtomicInteger(0);
            AtomicInteger y = new AtomicInteger(0);

            Arrays.stream(str.split(";"))
                    .filter(item -> isValid(item))
                    .forEach(item -> {
                        char ch = item.charAt(0);
                        int num = Integer.parseInt(item.substring(1));
                        if (ch == 'A' || ch == 'D') {
                            x.addAndGet(ch == 'A' ? -num : num);
                        } else {
                            y.addAndGet(ch == 'W' ? num : -num);
                        }
                    });
            System.out.println(x.get() + "," + y.get());


        }
    }

    private static boolean isValid(String str) {
        if (str.length() < 2) {
            return false;
        }
        if (str.charAt(0) == 0 && (
                str.charAt(0) != 'A' ||
                        str.charAt(0) != 'S'||
                        str.charAt(0) != 'D'||
                        str.charAt(0) != 'W')) {
            return false;
        }
        try {
            int num = Integer.parseInt(str.substring(1));
            if (num < 0) {
                return false;
            }
        } catch (Throwable t){
            return false;
        }
        return true;

    }



}
