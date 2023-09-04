package com.yingjie.nowcoder;


import java.util.*;

/**
 * 给定一个正整数N代表火车数量，0<N<10，接下来输入火车入站的序列，一共N辆火车，每辆火车以数字1-9编号，
 * 火车站只有一个方向进出，同时停靠在火车站的列车中，只有后进站的出站了，先进站的才能出站。
 * 要求输出所有火车出站的方案，以字典序排序输出。
 *
 * 输入描述：
 * 第一行输入一个正整数N（0 < N <= 10），第二行包括N个正整数，范围为1到10。
 *
 * 输出描述：
 * 输出以字典序从小到大排序的火车出站序列号，每个编号以空格隔开，每个输出序列换行，具体见sample。
 */
public class HJ0077 {

    public static List<String> result;
    public static Stack<String> stack;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int num = in.nextInt();
            int[] enOrder = new int[num];
            for (int i = 0; i < num; i++) {
                enOrder[i] = in.nextInt();
            }
            result = new ArrayList<>();
            stack = new Stack<>();
            traceback(0, "", 0, enOrder);
            Collections.sort(result);
            for (String s : result) {
                System.out.println(s);
            }

        }
    }

    public static void traceback(int cur, String path, int deep, int[] enOrder) {
        if (deep == enOrder.length) {
            result.add(path);
        }
        if (!stack.empty()) {
            String item = stack.pop();
            traceback(cur, path + item + " ", deep + 1, enOrder);
            stack.push(item);
        }
        if (cur < enOrder.length) {
            String item = String.valueOf(enOrder[cur]);
            stack.push(item);
            traceback(cur + 1, path, deep, enOrder);
            stack.pop();
        }
    }

}
