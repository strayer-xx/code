package com.yingjie.leetcode;

import java.util.*;

/**
 * 347. 前 K 个高频元素
 *
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 * <a href="https://leetcode.cn/problems/top-k-frequent-elements/description/">...</a>
 */
public class L0347 {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer>  map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return map.entrySet().stream()
                .sorted(new Comparator<Map.Entry<Integer, Integer>>() {
                    @Override
                    public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                        return o2.getValue() - o1.getValue();
                    }
                })
                .limit(k)
                .mapToInt(item -> item.getKey())
                .toArray();
    }

}
