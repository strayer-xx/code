package com.yingjie.nowcoder;


import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

/**
 * 描述
 * 输入一个 int 型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。
 * 保证输入的整数最后一位不是 0 。
 */
public class HJ0009 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String input = in.nextLine();
            Set<Character> set = new HashSet<>();
            Stack<Character> stack = new Stack<>();
            for (char ch : input.toCharArray()) {
                stack.push(ch);
            }
            StringBuffer sb = new StringBuffer();
            while (!stack.isEmpty()) {
                Character character = stack.pop();
                if (!set.contains(character)){

                    sb.append(character);
                    set.add(character);
                }
            }
            System.out.println(sb);

        }
    }
}
