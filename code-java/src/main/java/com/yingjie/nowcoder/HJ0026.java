package com.yingjie.nowcoder;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * 描述
 * 编写一个程序，将输入字符串中的字符按如下规则排序。
 * 规则 1 ：英文字母从 A 到 Z 排列，不区分大小写。
 * 如，输入： Type 输出： epTy
 *
 * 规则 2 ：同一个英文字母的大小写同时存在时，按照输入顺序排列。
 * 如，输入： BabA 输出： aABb
 *
 * 规则 3 ：非英文字母的其它字符保持原来的位置。
 * 如，输入： By?e 输出： Be?y
 *
 * 输入描述：
 * 输入字符串
 * 输出描述：
 * 输出字符串
 */
public class HJ0026 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String input = in.nextLine();
            List<Character> charList = new ArrayList<>(input.length());
            char[] chars = input.toCharArray();
            for (char ch : chars) {
                if (('a' <= ch && ch <= 'z') ||
                        ('A' <= ch && ch <= 'Z')) {
                    charList.add(ch);
                }
            }
            charList.sort(new Comparator<Character>() {
                @Override
                public int compare(Character o1, Character o2) {
                    char ch1 = Character.toLowerCase(o1);
                    char ch2 = Character.toLowerCase(o2);
                    if (ch1 == ch2){
                        return 0;
                    } else {
                        return ch1 - ch2;
                    }
                }
            });
            for (int i = 0; i < chars.length; i++) {
                if (('a' <= chars[i] && chars[i] <= 'z') ||
                        ('A' <= chars[i] && chars[i] <= 'Z')) {
                    chars[i] = charList.remove(0);
                }
            }
            System.out.println(new String(chars));
        }
    }

}
