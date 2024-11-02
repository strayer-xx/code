package com.yingjie.nowcoder;


import java.util.Scanner;

/**
 * HJ2 计算某字符出现次数
 * 描述
 * 写出一个程序，接受一个由字母、数字和空格组成的字符串，和一个字符，然后输出输入字符串中该字符的出现次数。（不区分大小写字母）
 *

 * 输入描述：
 * 第一行输入一个由字母、数字和空格组成的字符串，第二行输入一个字符（保证该字符不为空格）。
 *
 * 输出描述：
 * 输出输入字符串中含有该字符的个数。（不区分大小写字母）
 */
public class HJ0002 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String str = in.nextLine().toLowerCase();
            char ch = in.nextLine().toLowerCase().charAt(0);

            int count = 0;
            for (char item : str.toCharArray()) {
                if (item == ch) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
