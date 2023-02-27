package com.yingjie;

import com.yingjie.leetcode.*;

/**
 * <p>Title: Summary</p>
 * <p>Description: </p>
 *
 * @author LiuYingJie
 * @version 1.0
 * @date 2023/2/23 23:44
 */
public enum Summary {
    // 动态规划
    DP(new Class[]{
            L0343.class,
            L0096.class,
            L0416.class,
            L0494.class,
            L0139.class,
            L1049.class,
            L0053.class,
            L0122.class, // 买卖股票的最佳时机 II
            L0714.class, // 买卖股票的最佳时机含手续费
    }),

    // 贪心
    TX(new Class[]{
            L0122.class
    }),

    // 回溯
    HX(new Class[]{
            L0022.class
    }),

    // else
    ELSE(new Class[]{
            L0021.class,
            L0031.class, // imp
    });





    private final Class[] aClazz;

    Summary(Class[] aClazz) {
        this.aClazz = aClazz;
    }

}
