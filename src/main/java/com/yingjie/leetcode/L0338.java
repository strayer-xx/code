package com.yingjie.leetcode;

/**
 * 338. 比特位计数
 *
 * 给你一个整数 n ，对于 0 <= i <= n 中的每个 i ，计算其二进制表示中 1 的个数 ，
 * 返回一个长度为 n + 1 的数组 ans 作为答案。
 *
 * <a href="https://leetcode.cn/problems/counting-bits/description/">...</a>
 *
 */
public class L0338 {

    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            ans[i] = ans[i >> 1] + (1 & i);
        }
        return ans;
    }


    /**
     * 补充：计算单个10进制有几个1
     */
    public static int countOne1(int num) {
        return Integer.bitCount(num);
    }

    public static int countOne2(int num) {
        int count = 0;
        while (num != 0) {
            if ((num & 1) == 1) {
                count++;
            }
            num = num >> 1;
        }
        return count;
    }

}
