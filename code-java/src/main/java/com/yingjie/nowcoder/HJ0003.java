package com.yingjie.nowcoder;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * <p>Title: Hj0003</p>
 * <p>Description: </p>
 *
 * @author LiuYingJie
 * @version 1.0
 * @date 2023/3/23 21:53
 */
public class HJ0003 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //获取个数
        int num = sc.nextInt();
        //创建TreeSet进行去重排序
        TreeSet<Integer> set = new TreeSet<>();
        //输入
        for(int i =0 ; i < num ;i++){
            set.add(sc.nextInt());
        }

        //输出
        for (Integer integer : set) {
            System.out.println(integer);
        }
    }
}
