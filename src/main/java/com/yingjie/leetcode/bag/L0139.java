package com.yingjie.leetcode.bag;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <p>Title: L0139</p>
 * <p>Description: </p>
 *
 * @author LiuYingJie
 * @version 1.0
 * @date 2023/2/24 23:17
 */
public class L0139 {

    /**
     * dp[i] 表示字符串 s 前 i 个字符组成的字符串 s[0..i−1] 是否能被空格拆分成若干个字典中出现的单词
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
