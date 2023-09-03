package com.yingjie.algorithm;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] nums = {3,4,6,2,4,4,7,4,5};
        System.out.println(Arrays.toString(mergeSort(nums, 0, nums.length-1)));
    }

    public static int[] mergeSort(int[] arr, int l, int r) {
        if (l == r)
            return new int[] { arr[l] };
        int mid = l + (r - l) / 2;
        int[] leftArr = mergeSort(arr, l, mid);
        int[] rightArr = mergeSort(arr, mid+1, r);
        int[] newArr = new int[leftArr.length + rightArr.length];
        int i = 0, j = 0, cur = 0;
        while (i < leftArr.length && j < rightArr.length) {
            if (leftArr[i] <= rightArr[j]) {
                newArr[cur] = leftArr[i];
                i++;
            } else {
                newArr[cur] = rightArr[j];
                j++;
            }
            cur++;
        }
        while (i < leftArr.length) {
            newArr[cur] = leftArr[i];
            cur++;
            i++;
        }
        while (j < rightArr.length) {
            newArr[cur] = rightArr[j];
            cur++;
            j++;
        }
        return newArr;
    }
}
