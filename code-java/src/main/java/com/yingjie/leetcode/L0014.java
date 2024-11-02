package com.yingjie.leetcode;


/**
 * 14. 最长公共前缀
 *
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * <a href="https://leetcode.cn/problems/longest-common-prefix/">...</a>
 *
 */
public class L0014 {
    public String longestCommonPrefix(String[] strs) {
        String maxPrefix = "";
        for (int l = 1; l <= strs[0].length(); l++) {
            String prefix = strs[0].substring(0, l);
            for (int i = 0; i < strs.length; i++) {
                if (prefix.length() > strs[i].length()) {
                    return maxPrefix;
                }
                if (!strs[i].startsWith(prefix)) {
                    return maxPrefix;
                }
            }
            maxPrefix = prefix;
        }
        return maxPrefix;
    }

}
