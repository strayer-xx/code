package com.yingjie.zywl;


import java.util.*;

/**
 * 驾校某教练只有一辆车，一天开放14个小时供学员练车(5:00~19:00)，由于学员很多，教练定下规则: 学员需要提前一天报名并预约练车时间，
 * 说明开始时间、结束时间，时间必须取整(整点开始和结束)，时长不限(不超过14小时)。教练在前一天晚上会通知可以练车的学员明天练车。
 * 教练不按报名顺序安排练车，而是希望每天练车的人数尽可能多。 注: 每人每天最多选一个时段 测试示例:
 *  输入: 11
 * 6 9
 * 10 14
 * 11 15
 * 5 11
 * 10 12
 * 13 16
 * 7 18
 * 17 19
 * 13 17
 * 8 10
 * 8 13
 */
public class Zywl001 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            int num = Integer.parseInt(scanner.nextLine());
            int[][] stus = new int[num][2];
            for (int i = 0; i < num; i++) {
                String[] str = scanner.nextLine().split(" ");
                stus[i][0] = Integer.parseInt(str[0]);
                stus[i][1] = Integer.parseInt(str[1]);
            }
            // 根据结尾时间排序
            Arrays.sort(stus, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[1] - o2[1];
                }
            });
            int lastTime = stus[0][1];
            List<int[]> result = new ArrayList<>();
            result.add(stus[0]);
            for (int[] stu : stus) {
                if (stu[0] >= lastTime) {
                    result.add(stu);
                    lastTime = stu[1];
                }
            }
            System.out.println(result);
        }
    }
}