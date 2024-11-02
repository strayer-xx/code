package com.yingjie.leetcode;


/**
 * 169. 多数元素
 *
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于⌊ n/2 ⌋的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 链接：<a href="https://leetcode.cn/problems/majority-element">...</a>
 * 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
 */
public class L0169 {

    /**
     * 摩尔投票法：
     * 核心就是对拼消耗。
     * 玩一个诸侯争霸的游戏，假设你方人口超过总人口一半以上，并且能保证每个人口出去干仗都能一对一同归于尽。最后还有人活下来的国家就是胜利。
     * 那就大混战呗，最差所有人都联合起来对付你（对应你每次选择作为计数器的数都是众数），或者其他国家也会相互攻击（会选择其他数作为计数器的数），但是只要你们不要内斗，最后肯定你赢。
     * 最后能剩下的必定是自己人。
     *
     * 从第一个数开始count=1，遇到相同的就加1，遇到不同的就减1，减到0就重新换个数开始计数，总能找到最多的那个
     */
    public int majorityElement(int[] nums) {
        int cur = nums[0];
        int count = 0;
        for (int num : nums) {
            if (num == cur) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    count = 1;
                    cur = num;
                }
            }
        }
        return cur;
    }
}