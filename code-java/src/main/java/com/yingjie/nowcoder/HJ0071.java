package com.yingjie.nowcoder;


import java.util.Scanner;

/**
 * HJ71 字符串通配符
 *
 * 问题描述：在计算机中，通配符一种特殊语法，广泛应用于文件搜索、数据库、正则表达式等领域。现要求各位实现字符串通配符的算法。
 * 要求：
 * 实现如下2个通配符：
 * *：匹配0个或以上的字符（注：能被*和?匹配的字符仅由英文字母和数字0到9组成，下同）
 * ？：匹配1个字符
 *
 * 注意：匹配时不区分大小写。
 */
public class HJ0071 {



    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String regex1 = "(\\d|\\w)*";
        String regex2 = "(\\d|\\w)";
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String regex = in.nextLine().toLowerCase();
            String input = in.nextLine().toLowerCase();
            // 不加这一行在某些用例会超时
            String realRegex = regex.replaceAll("\\*{2,}", "\\*");
            realRegex = realRegex.replace("?", regex2);
            realRegex = realRegex.replace("*", regex1);
            if (input.matches(realRegex)) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }

        }
    }
}
