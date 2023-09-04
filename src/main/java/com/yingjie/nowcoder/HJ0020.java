package com.yingjie.nowcoder;

import java.io.IOException;
import java.util.Scanner;

/**
 * <p>Title: HJ0020</p>
 * <p>Description: 密码验证合格程序</p>
 *
 * 密码要求:
 * 1.长度超过8位
 * 2.包括大小写字母.数字.其它符号,以上四种至少三种
 * 3.不能有长度大于2的包含公共元素的子串重复 （注：其他符号不含空格或换行）
 */
public class HJ0020 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            if (check(in.nextLine())) {
                System.out.println("OK");
            } else {
                System.out.println("NG");
            }
        }
    }

    private static boolean check(String input) {
        // 1.长度超过8位
        if (input.length() <= 8) {
            return false;
        }
        // 2.包括大小写字母.数字.其它符号,以上四种至少三种
        int count = 0;
        boolean flag1 = false;
        boolean flag2 = false;
        boolean flag3 = false;
        boolean flag4 = false;
        for (char ch : input.toCharArray()) {
            if ('a' <= ch && ch <= 'z') {
                if (!flag1) count++;
                flag1 = true;
            }
            else if ('A' <= ch && ch <= 'Z') {
                if (!flag2) count++;
                flag2 = true;
            }
            else if ('0' <= ch && ch <= '9') {
                if (!flag3) count++;
                flag3 = true;
            }
            else {
                if (!flag4) count++;
                flag4 = true;
            }
        }
        if (count < 3) {
            return false;
        }
        // 3.不能有长度大于2的包含公共元素的子串重复 （注：其他符号不含空格或换行）
        for (int i = 0; i < input.length() - 2; i++) {
            String str1 = input.substring(i, i + 3);
            int index1 = input.lastIndexOf(str1);
            int index2 = input.indexOf(str1);
            if (index1 != index2) {
                return false;
            }
        }
        return true;
    }
}
