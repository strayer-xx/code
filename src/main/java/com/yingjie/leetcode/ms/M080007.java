package com.yingjie.leetcode.ms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>Title: M080007</p>
 * <p>Description: 无重复字符串的排列组合</p>
 *
 * 无重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合，字符串每个字符均不相同。
 *
 * 输入：S = "qwe"
 * 输出：["qwe", "qew", "wqe", "weq", "ewq", "eqw"]
 */
public class M080007 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new M080007().permutation("qwe")));
    }

    private List<String> list = new ArrayList<>();

    private char[] chars;

    private boolean[] used;

    public String[] permutation(String S) {
        chars = S.toCharArray();
        used = new boolean[S.length()];
        dfs(new StringBuilder());
        return list.toArray(new String[0]);
    }

    private void dfs(StringBuilder sb) {
        if (sb.length() == chars.length) {
            list.add(sb.toString());
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (!used[i]) {
                sb.append(chars[i]);
                used[i] = true;
                dfs(sb);
                used[i] = false;
                sb.deleteCharAt(sb.length() - 1);
            }

        }
    }
}
