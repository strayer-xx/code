package com.yingjie.leetcode.slidewindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>Title: L0438</p>
 * <p>Description: 找到字符串中所有字母异位词</p>
 *
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 *
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 */
public class L0438 {

    public static void main(String[] args) {
        System.out.println(new L0438().findAnagrams("a", "a"));
    }

    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        if (p.length() > s.length()) {
            return result;
        }
        for (char ch : p.toCharArray()) {
            need.put(ch, need.getOrDefault(ch, 0) + 1);
        }

        int start = 0;
        int len = p.length();
        int count = 0;
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            window.put(ch, window.getOrDefault(ch, 0) + 1);
            if (window.get(ch).equals(need.get(ch))) {
                count++;
            }
        }
        while (start + len <= s.length()) {
            if (count == need.size()) {
                result.add(start);
            }
            if (start + len == s.length()) {
                break;
            }
            char leftChar = s.charAt(start);
            char rightChar = s.charAt(start + len);

            if (need.containsKey(leftChar)) {
                if (need.get(leftChar).equals(window.get(leftChar))) {
                    count--;
                }
            }
            window.put(leftChar, window.get(leftChar) - 1);
            window.put(rightChar, window.getOrDefault(rightChar, 0) + 1);
            if (need.containsKey(rightChar)) {
                if (need.get(rightChar).equals(window.get(rightChar))) {
                    count++;
                }
            }
            start++;

        }
        return result;
    }
}
