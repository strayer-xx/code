package com.yingjie.leetcode.slidewindow;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Title: L0076</p>
 * <p>Description: 最小覆盖子串</p>
 *
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。
 * 如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 *
 * 注意：
 * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
 *
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * 解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
 *
 * <a href="https://leetcode.cn/problems/minimum-window-substring/">...</a>
 */
public class L0076 {

    public String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap();
        Map<Character, Integer> window = new HashMap<>();
        for (char ch : t.toCharArray()) {
            need.put(ch, need.getOrDefault(ch, 0) + 1);
        }
        int lo = 0,hi = 0;
        // count的作用
        int count = 0;
        int len = Integer.MAX_VALUE;
        int start = 0;
        while (hi < s.length()) {
            char ch = s.charAt(hi);
            hi++;
            window.put(ch, window.getOrDefault(ch, 0) + 1);
            if (need.containsKey(ch)) {
                if (window.get(ch).equals(need.get(ch))) {
                    count++;
                }
            }
            while (count == need.size()) {
                if (hi - lo < len) {
                    len = hi - lo;
                    start = lo;
                }
                char loCh = s.charAt(lo);
                lo++;
                // 着重理解
                if (need.containsKey(loCh)) {
                    if (need.get(loCh).equals(window.get(loCh))) {
                        count--;
                    }
                    window.put(loCh, window.get(loCh) - 1);
                }

            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start,start+len);
    }
}
