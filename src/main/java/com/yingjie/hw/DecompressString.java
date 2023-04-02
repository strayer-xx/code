package com.yingjie.hw;

import java.util.Stack;

/**
 * <p>Title: DecompressString</p>
 * <p>Description: </p>
 *
 * @author LiuYingJie
 * @version 1.0
 * @date 2023/3/30 21:24
 */
public class DecompressString {

    public static void main(String[] args) {
        String compressedStr = "{A}3";
        String decompressedStr = DecompressString.decompress(compressedStr);
        System.out.println(decompressedStr);
    }

    public static String decompress(String compressedStr) {
        Stack<String> stack = new Stack<>();
        int i = 0;
        while (i < compressedStr.length()) {
            char c = compressedStr.charAt(i);
            if (Character.isLetter(c)) {
                stack.push(String.valueOf(c));
                i++;
            } else if (Character.isDigit(c)) {
                int num = 0;
                while (Character.isDigit(compressedStr.charAt(i))) {
                    num = num * 10 + (compressedStr.charAt(i) - '0');
                    i++;
                }
                String prevStr = stack.pop();
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < num; j++) {
                    sb.append(prevStr);
                }
                stack.push(sb.toString());
            } else if (c == '{') {
                stack.push(String.valueOf(c));
                i++;
            } else if (c == '}') {
                String str = "";
                while (!stack.peek().equals("{")) {
                    str = stack.pop() + str;
                }
                stack.pop();
                int num = 0;
                while (i + 1 < compressedStr.length() && Character.isDigit(compressedStr.charAt(i + 1))) {
                    num = num * 10 + (compressedStr.charAt(i + 1) - '0');
                    i++;
                }
                if (num == 0) {
                    num = 1;
                }
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < num; j++) {
                    sb.append(str);
                }
                stack.push(sb.toString());
                i++;
            }
        }
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.insert(0, stack.pop());
        }
        return result.toString();
    }
}
