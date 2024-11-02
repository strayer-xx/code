package com.yingjie.leetcode.dfs.traceback;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>Title: L0017</p>
 * <p>Description: 电话号码的字母组合</p>
 * 回溯法
 */
public class L0017 {
    public static void main(String[] args) {

    }

    private Map<Character, String> phoneMap = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};

    private List<String> result = new ArrayList<>();

    private StringBuilder str = new StringBuilder();

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return result;
        }
        traceBack(digits, 0);
        return result;
    }

    public void traceBack(String digits, int index) {
        if (digits.charAt(index) == '1') {
            if (index == digits.length() - 1) {
                result.add(str.toString());
            } else {
                traceBack(digits, index + 1);
            }
        } else {
            String dict = phoneMap.get(digits.charAt(index));
            for (char ch : dict.toCharArray()) {
                str.append(ch);
                if (index == digits.length() - 1) {
                    result.add(str.toString());
                } else {
                    traceBack(digits, index + 1);
                }
                str.deleteCharAt(index);
            }
        }
    }
}
