package com.yingjie.nowcoder;

import java.util.Scanner;

/**
 * HJ24 合唱队
 *
 * <a href="https://www.nowcoder.com/practice/6d9d69e3898f45169a441632b325c7b4?tpId=37&tqId=21247&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D37&difficulty=undefined&judgeStatus=undefined&tags=&title=">...</a>
 *
 */
public class HJ0024 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            int[] dpL= new int[n];
            int[] dpR = new int[n];

            for (int i = 0; i < n; i++) {
                dpL[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (arr[j] < arr[i]) {
                        dpL[i] = Math.max(dpL[i], dpL[j] + 1);
                    } else {
                        dpL[i] = Math.max(dpL[i], dpL[j]);
                    }
                }
            }

            for (int i = n - 1; i >= 0; i--) {
                dpR[i] = 1;
                for (int j = n - 1; j > i; j--) {
                    if (arr[j] < arr[i]) {
                        dpR[i] = Math.max(dpR[i], dpR[j] + 1);
                    } else {
                        dpR[i] = Math.max(dpR[i], dpR[j]);
                    }
                }
            }

            // 记录每个位置的值
            int[] result = new int[n];
            for (int i = 0; i < n; i++) {
                //位置 i计算了两次 所以需要－1
                result[i] = dpL[i] + dpR[i] - 1; //两个都包含本身
            }

            int max = 1;
            for (int i = 0; i < n; i++) {
                max = Math.max(result[i],max);
            }
            System.out.println(n - max);

        }
    }
}
