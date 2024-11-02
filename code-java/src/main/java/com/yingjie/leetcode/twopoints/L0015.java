package com.yingjie.leetcode.twopoints;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，
 * 同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
 *
 * 你返回所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * <a href="https://leetcode.cn/problems/3sum/">...</a>
 */
public class L0015 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for(int i = 0; i<nums.length; i++){
            //因为已经是有序的，所以当前值大于0则后面不可能再有和为0的情况出现
            if(nums[i] > 0) break;
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int left = i + 1, right = nums.length - 1;
            while(left < right){
                int num = nums[i] + nums[left] + nums[right];
                // 得到想要的结果的同时，去重
                if(num == 0){
                    while(left < right && nums[right] == nums[right-1]) {
                        right--;
                    }
                    while(left < right && nums[left] == nums[left+1]) {
                        left++;
                    }
                    res.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    right--;
                    left++;
                } else if (num > 0){
                    right--;
                } else {
                    left++;
                }
            }
        }
        return res;
    }
}
