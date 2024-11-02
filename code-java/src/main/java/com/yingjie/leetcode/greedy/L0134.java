package com.yingjie.leetcode.greedy;


/**
 * 134. 加油站
 *
 * 在一条环路上有 n 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。
 * 你从其中的一个加油站出发，开始时油箱为空。
 * 给定两个整数数组 gas 和 cost ，如果你可以按顺序绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1 。
 * 如果存在解，则 保证 它是 唯一 的。
 *
 * <a href="https://leetcode.cn/problems/gas-station/">...</a>
 */
public class L0134 {

    public static void main(String[] args) {
        new L0134().canCompleteCircuit(new int[]{1,2,3,4,5}, new int[]{3,4,5,1,2});
    }

    /**
     * 超时，注意如何巧妙的处理环形数组
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        for (int start = 0; start < n; start++) {
            int tank = 0;
            for (int step = 0; step < n; step++) {
                int i = (start + step) % n;
                tank += gas[i];
                tank -= cost[i];
                if (tank < 0) {
                    break;
                }
            }
            if (tank >= 0) {
                return start;
            }
        }
        return -1;
    }

    /**
     * 贪心算法
     * 1、如果走完一圈剩余油量大于0，那么一定有解
     * 2、有且只有一个解，那这个解一定是在剩余油量最小的下一个位置
     */
    public int canCompleteCircuitPro(int[] gas, int[] cost) {
        int n = gas.length;
        int sum = 0;
        int min = 0;
        int idx = 0;
        for (int i = 0; i < n; i++) {
            sum += gas[i] - cost[i];
            if (sum < min) {
                min = sum;
                idx = i + 1;
            }
        }
        return sum < 0 ? -1 : idx;
    }

}
