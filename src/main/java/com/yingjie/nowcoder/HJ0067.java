package com.yingjie.nowcoder;

import java.util.Scanner;

/**
 * 24点游戏算法
 * 描述
 * 给出4个1-10的数字，通过加减乘除运算，得到数字为24就算胜利,除法指实数除法运算,运算符仅允许出现在两个数字之间,本题对数字选取顺序无要求，但每个数字仅允许使用一次，且需考虑括号运算
 * 此题允许数字重复，如3 3 4 4为合法输入，此输入一共有两个3，但是每个数字只允许使用一次，则运算过程中两个3都被选取并进行对应的计算操作。
 * 输入描述：
 * 读入4个[1,10]的整数，数字允许重复，测试用例保证无异常数字。
 *
 * 输出描述：
 * 对于每组案例，输出一行表示能否得到24点，能输出true，不能输出false
 *
 * 示例1
 * 输入：
 * 7 2 1 10
 * 输出：
 * true
 */

public class HJ0067 {

    private static boolean flag = false;

    private static boolean visited[];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int[] arr = new int[4];
            for (int i = 0; i < 4; i++) {
                arr[i] = in.nextInt();
            }
            visited = new boolean[4];
            dfs(arr, 0, 0);
            if (flag) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }

        }
    }

    private static void dfs(int[] arr, float sum, int deep) {
        if (sum == 24f) {
            flag = true;
            return;
        }
        if (deep >= 4) {
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(arr, sum + arr[i], deep + 1);
                dfs(arr, sum - arr[i], deep + 1);
                dfs(arr, sum * arr[i], deep + 1);
                dfs(arr, sum / arr[i], deep + 1);
                visited[i] = false;
            }
        }

    }
}
