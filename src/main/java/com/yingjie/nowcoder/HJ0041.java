package com.yingjie.nowcoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

/**
 * <p>Title: HJ41</p>
 * <p>Description: 称砝码</p>
 *
 * 现有n种砝码，重量互不相等，分别为 m1,m2,m3…mn ；
 * 每种砝码对应的数量为 x1,x2,x3...xn 。
 * 现在要用这些砝码去称物体的重量(放在同一侧)，问能称出多少种不同的重量。
 * 注：称重重量包括 0
 *
 * 对于每组测试数据：
 * 第一行：n --- 砝码的种数(范围[1,10])
 * 第二行：m1 m2 m3 ... mn --- 每种砝码的重量(范围[1,2000])
 * 第三行：x1 x2 x3 .... xn --- 每种砝码对应的数量(范围[1,10])
 *
 * <a href="https://www.nowcoder.com/practice/f9a4c19050fc477e9e27eb75f3bfd49c?tpId=37&tqId=21264&ru=/exam/oj">...</a>
 */
public class HJ0041 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = reader.readLine()) != null) {
            int n = Integer.parseInt(line);
            String[] s1 = reader.readLine().split(" ");
            String[] s2 = reader.readLine().split(" ");
            int[] weights = new int[n];
            int[] nums= new int[n];
            for (int i = 0; i < n; i++) {
                weights[i] = Integer.parseInt(s1[i]);
                nums[i] = Integer.parseInt(s2[i]);
            }
            //所有砝码重量组合情况set
            HashSet<Integer> hashSet = new HashSet<>();
            //由示例可知，0 重量也属于一种情况
            hashSet.add(0);
            for (int i = 0; i < n; i++) { //每一种砝码
                //加上该种砝码后会多出现哪些情况，统计好后一次性一次性合并，而不是边找到一个情况边直接往hashSet中添加
                HashSet<Integer> thisTimeNeedAddSet = new HashSet<>();
                for (int k = 1; k <= nums[i]; k++) { //该种砝码取多少个
                    //该种砝码取k个的重量
                    int singleTimeAddWeight = weights[i] * k;
                    //之前hashSet中所有的情况都是没有包含该种砝码的，所以我们现在需要将之前的所有情况都加上包含该种砝码的情况
                    for (Integer weight : hashSet) {
                        //只添加k个砝码的情况不要忘记加上哦
                        thisTimeNeedAddSet.add(singleTimeAddWeight);
                        //之前的情况 加上 添加k个砝码的情况
                        thisTimeNeedAddSet.add(weight + singleTimeAddWeight);
                    }
                }
                //将这次产生的新情况，与之前的情况进行汇总，去重
                hashSet.addAll(thisTimeNeedAddSet);
            }
            System.out.println(hashSet.size());
        }
    }
}
