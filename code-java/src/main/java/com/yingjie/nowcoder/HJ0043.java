package com.yingjie.nowcoder;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 定义一个二维数组 N*M ，如 5 × 5 数组下所示：
 *
 *
 * int maze[5][5] = {
 * 0, 1, 0, 0, 0,
 * 0, 1, 1, 1, 0,
 * 0, 0, 0, 0, 0,
 * 0, 1, 1, 1, 0,
 * 0, 0, 0, 1, 0,
 * };
 *
 *
 * 它表示一个迷宫，其中的1表示墙壁，0表示可以走的路，只能横着走或竖着走，不能斜着走，
 * 要求编程序找出从左上角到右下角的路线。入口点为[0,0],既第一格是可以走的路。
 *
 */
public class HJ0043 {

    private static List<int[]> result = new ArrayList<>();

    private static int[][] arr;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int a = in.nextInt();
            int b = in.nextInt();
            arr = new int[a][b];
            for (int i = 0; i < a; i++) {
                for (int j = 0; j < b; j++) {
                    arr[i][j] = in.nextInt();
                }
            }
            dfs(0, 0);

        }
    }

    public static void dfs(int x, int y) {
        if (!inArea(x, y)) {
            return;
        }
        if (arr[x][y] == 1) {
            return;
        }
        result.add(new int[]{x, y});
        arr[x][y] = 1;

        if (x == arr.length - 1 && y == arr[0].length - 1) {
            for (int[] pos : result) {
                System.out.println("(" + pos[0] + "," + pos[1] + ")");
            }
            return;
        }

        dfs(x - 1, y);
        dfs(x + 1, y);
        dfs(x , y + 1);
        dfs(x, y - 1);
        if (result.size() > 1) result.remove(result.size() - 1);
    }

    public static boolean inArea(int x, int y) {
        return x < arr.length && x >= 0
                && y < arr[0].length && y >= 0;
    }
}
