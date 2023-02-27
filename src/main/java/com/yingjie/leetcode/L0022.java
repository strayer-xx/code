package com.yingjie.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Title: L0022</p>
 * <p>Description: </p>
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 */
public class L0022 {

    /**
     * 回溯算法
     * 解题关键：在构建的过程中，只要在任意时刻open >= close，那么最后构建出来的就有效
     */
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    public void backtrack(List<String> ans, StringBuilder sb, int open, int close, int n) {
        if (open + close == 2 * n) {
            ans.add(sb.toString());
            return;
        }
        if (open < n) {
            sb.append("(");
            backtrack(ans, sb, open + 1, close, n);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (close < open) {
            sb.append(")");
            backtrack(ans, sb, open, close + 1, n);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
