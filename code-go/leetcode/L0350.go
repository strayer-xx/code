package main

import (
	"fmt"
	"sort"
)

/*
给你两个整数数组 nums1 和 nums2 ，请你以数组形式返回两数组的交集。返回结果中每个元素出现的次数，应与元素在两个数组中都出现的次数一致
（如果出现次数不一致，则考虑取较小值）。可以不考虑输出结果的顺序。

示例 1：
输入：nums1 = [1,2,2,1], nums2 = [2,2]
输出：[2,2]

示例 2:
输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
输出：[4,9]
url: https://leetcode.cn/problems/intersection-of-two-arrays-ii/
*/
func main() {
	fmt.Println(intersect([]int{4, 9, 5}, []int{9, 4, 9, 8, 4}))
	fmt.Println(intersectSorted([]int{4, 9, 5}, []int{9, 4, 9, 8, 4}))
}

func intersect(nums1 []int, nums2 []int) []int {
	m0 := make(map[int]int)
	for _, v := range nums1 {
		m0[v]++
	}
	k := 0
	for _, v := range nums2 {
		if m0[v] > 0 {
			m0[v]--
			nums2[k] = v
			k++
		}
	}
	return nums2[0:k]
}

func intersectSorted(nums1 []int, nums2 []int) []int {
	i, j, k := 0, 0, 0
	sort.Ints(nums1)
	sort.Ints(nums2)
	for i < len(nums1) && j < len(nums2) {
		if nums1[i] == nums2[j] {
			nums1[k] = nums2[j]
			i++
			j++
			k++
		} else if nums1[i] < nums2[j] {
			i++
		} else {
			j++
		}
	}
	return nums1[0:k]
}
