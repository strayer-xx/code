package com.yingjie.leetcode;

import java.util.Arrays;

/**
 * <p>Title: L0066</p>
 * <p>Description: </p>
 *
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 */
public class L0066 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new L0066().plusOne(new int[]{9,9})));
    }

    public int[] plusOne(int[] digits) {
        return doPlus(digits, digits.length - 1);
    }

    int[] doPlus(int[] digits, int i) {
        if (i == 0 && digits[i] + 1 > 9) {
            int[] newArray = new int[digits.length + 1];
            System.arraycopy(newArray, 1, digits, 0, digits.length);
            newArray[0] = 1;
            return newArray;
        } else if (digits[i] + 1 > 9) {
            digits[i] = digits[i] + 1 - 10;
            return doPlus(digits, i - 1);
        } else {
            digits[i] = digits[i] + 1;
            return digits;
        }
    }
}
