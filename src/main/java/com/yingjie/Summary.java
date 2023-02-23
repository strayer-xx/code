package com.yingjie;

import com.yingjie.leetcode.L0096;
import com.yingjie.leetcode.L0343;

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
            L0096.class
    });




    private Class[] aClazz;

    Summary(Class[] aClazz) {
        this.aClazz = aClazz;
    }

}
