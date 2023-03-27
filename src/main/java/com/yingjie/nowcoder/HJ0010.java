package com.yingjie.nowcoder;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * <p>Title: HJ0010</p>
 * <p>Description: </p>
 *
 * @author LiuYingJie
 * @version 1.0
 * @date 2023/3/25 20:26
 */
public class HJ0010 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            char[] chars = scanner.nextLine().toCharArray();
            Set<Character> set = new HashSet<>();
            for (char ch : chars) {
                set.add(ch);
            }
            System.out.println(set.size());
        }
    }
}
