package com.yingjie.nowcoder;

import java.util.*;
import java.util.stream.Collectors;

/**
 * <p>Title: NC0061</p>
 * <p>Description: 两数之和</p>
 *
 * 给定一个整数数组 nums 和一个目标值 target，
 * 请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 */
public class NC0061 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String input = in.nextLine();
            int index = input.lastIndexOf(',');
            // import 注意如何list转数组
            Integer[] nums = Arrays.stream(input.substring(1, index - 1).split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .toArray(Integer[]::new);
            int target = Integer.parseInt(input.substring(index + 1));
            System.out.println(Arrays.toString(solution(nums, target)));
        }
    }

    public static int[] solution(Integer[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i< nums.length; i++) {
            if(map.containsKey(target - nums[i])) {
                return new int[] {map.get(target-nums[i]),i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
