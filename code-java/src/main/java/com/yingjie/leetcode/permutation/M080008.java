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

        traceback();
        return res.toArray(new String[0]);
    }


    private void traceback() {
        // 到达叶子结点
        if (path.length() == sChar.length) {
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
                // 要避免重复，那就要保证相同数字的相对位置不能变，例如î 1 2，必须要保证î永远在1前面，否则就会出现重复。
                if (i > 0 && sChar[i] == sChar[i-1] && !used[i-1]) {
                    continue;
                }
                path.append(sChar[i]);
                used[i] = true;
                traceback();
                path.deleteCharAt(path.length() - 1);
                used[i] = false;
            }
        }
    }
}
