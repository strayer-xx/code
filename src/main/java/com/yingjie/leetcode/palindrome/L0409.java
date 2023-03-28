package com.yingjie.leetcode.palindrome;

import java.util.Iterator;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>Title: L0409</p>
 * <p>Description: </p>
 *
 * 给定一个包含大写字母和小写字母的字符串 s ，返回 通过这些字母构造成的 最长的回文串 。
 * 在构造过程中，请注意 区分大小写 。比如 "Aa" 不能当做一个回文字符串。
 */
public class L0409 {

    public int longestPalindrome(String s) {
        if (s.length() == 1) {
            return 1;
        }
        Map<Character, Long> map = s.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        Iterator<Map.Entry<Character, Long>> iterator = map.entrySet().iterator();
        int res = 0;
        boolean flag = false;
        while (iterator.hasNext()) {
            int value = Math.toIntExact(iterator.next().getValue());
            int num = value / 2;
            if (value % 2 != 0) {
                flag = true;
            }
            res += num;
        }
        res = res * 2;
        if (flag) {
            res++;
        }
        return res;
    }
}
