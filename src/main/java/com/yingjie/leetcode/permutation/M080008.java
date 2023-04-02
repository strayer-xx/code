package com.yingjie.leetcode.permutation;

import java.util.*;

/**
 * <p>Title: M080008</p>
 * <p>Description: 有重复字符串的排列组合</p>
 *
 * 有重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合。
 *
 * 本题可以直接将M080007中的List换成Set即可
 */
public class M080008 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new M080008().permutation("eqq")));
    }

    private char[] sChar;
    private boolean[] used;
    private List<String> res = new ArrayList<>();
    private StringBuilder path = new StringBuilder();

    public String[] permutation(String S) {
        int len = S.length();
        if (len == 0) return new String[0];
        used = new boolean[len];
        sChar = S.toCharArray();


        // 排序是为了后面的剪枝
        Arrays.sort(sChar);

        dfs(0);
        return res.toArray(new String[0]);
    }

    /**
     * @param depth 当前树的深度
     */
    private void dfs(int depth) {
        // 到达叶子结点
        if (depth == sChar.length) {
            res.add(path.toString());
            return;
        }

        for (int i = 0; i < sChar.length; i++) {
            if (!used[i]) {
                // 根据已排序字符数组, 剪枝（**关键**）
                // 理解!used[i-1]的作用
                // i == 0直接添加
                // sChar[i] ！= sChar[i-1] 直接添加
                // used[i-1] == true 直接添加
                if (i > 0 && sChar[i] == sChar[i-1] && !used[i-1]) {
                    continue;
                }
                path.append(sChar[i]);
                used[i] = true;
                dfs(depth + 1);
                path.deleteCharAt(depth);
                used[i] = false;
            }
        }
    }
}
