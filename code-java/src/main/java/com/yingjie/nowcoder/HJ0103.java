package com.yingjie.nowcoder;


import java.util.Scanner;

/**
 * HJ103 Redraiment的走法
 *
 * Redraiment是走梅花桩的高手。
 * Redraiment可以选择任意一个起点，从前到后，但只能从低处往高处的桩子走。
 * 他希望走的步数最多，你能替Redraiment研究他最多走的步数吗？
 */
public class HJ0103 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int len = in.nextInt();
            int[] nums = new int[len];
            for (int i = 0; i < len; i++) {
                nums[i] = in.nextInt();
            }
            System.out.println(dpHelper(nums));
        }
    }

    public static int dpHelper(int[] nums) {
        int len = nums.length;
        int max = 0;
        // dp[i] 以i结尾的最长递增子序列
        int[] dp = new int[len];
        dp[0] = 1;
        for (int i = 1; i < len; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {

                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }

}
