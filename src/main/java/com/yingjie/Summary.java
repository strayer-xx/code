package com.yingjie;

import com.yingjie.leetcode.*;
import com.yingjie.leetcode.binaryseacher.L0033;
import com.yingjie.leetcode.binaryseacher.L0153;
import com.yingjie.leetcode.dp.*;
import com.yingjie.leetcode.linkedlist.L0021;
import com.yingjie.leetcode.subsequence.L0053;
import com.yingjie.leetcode.permutation.L0046;
import com.yingjie.leetcode.permutation.M080007;
import com.yingjie.leetcode.dfs.traceback.L0022;

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
            L0062.class, // 不同路径
            L0064.class, // 最小路径和
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
            L0122.class,
    }),

    // 回溯
    HX(new Class[]{
            L0046.class, // 全排列
            L0022.class,
    }),

    // 二分查找
    EF(new Class[] {
            L0034.class, // 在排序数组中查找元素的第一个和最后一个位置
            L0033.class, // 搜索选择排序数组
            L0153.class, // 寻找旋转排序数组中的最小值

    }),

    // 排列组合
    PLZH(new Class[]{
            M080007.class,
            M080007.class, // imp
    }),

    // else
    ELSE(new Class[]{
            L0021.class, // imp
            L0031.class, // imp
            L0048.class,
            L0049.class,
            L0055.class,
    });





    private final Class[] aClazz;

    Summary(Class[] aClazz) {
        this.aClazz = aClazz;
    }

}
