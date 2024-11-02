package com.yingjie.nowcoder;

import java.util.Scanner;
import java.util.Stack;


/**
 * HJ13 句子逆序
 *
 * 将一个英文语句以单词为单位逆序排放。例如“I am a boy”，逆序排放后为“boy a am I”
 * 所有单词之间用一个空格隔开，语句中除了英文字母外，不再包含其他字符
 *
 * 注意本题有多组输入
 * 输入描述：
 * 输入一个英文语句，每个单词用空格隔开。保证输入只包含空格和字母。
 *
 * 输出描述：
 * 得到逆序的句子
 */
public class HJ0013 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String input = in.nextLine();
            Stack<String> stack = new Stack<>();
            for (String str : input.split(" ")) {
                stack.push(str);
            }
            StringBuffer sb  = new StringBuffer();
            while (!stack.isEmpty()) {
                sb.append(stack.pop()).append(" ");
            }
            sb.deleteCharAt(sb.length() - 1);
            System.out.println(sb);
        }
    }
}
