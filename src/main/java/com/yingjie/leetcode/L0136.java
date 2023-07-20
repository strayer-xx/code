package com.yingjie.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Title: L0136</p>
 * <p>Description: 只出现一次的数字</p>
 *
 * 给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间。
 *
 * 链接：https://leetcode.cn/problems/single-number
 *
 * 输入：nums = [2,2,1]
 * 输出：1
 *
 */
public class L0136 {
    public static void main(String[] args) {
        new L0136().singleNumber(new int[]{2,2,4});
    }

    public int singleNumber(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>(nums.length);
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0));
        }
        for (Map.Entry entry : map.entrySet()) {
            if (entry.getValue().equals(1) ) {
                return (Integer) entry.getKey();
            }
        }
        return 0;
    }
}
