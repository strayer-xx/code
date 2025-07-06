package main

import (
	"fmt"
	"strings"
)

func main() {
	fmt.Println(longestCommonPrefix([]string{"flower", "flow", "flight"}))
	fmt.Println(longestCommonPrefix([]string{"a"}))
	fmt.Println(longestCommonPrefix([]string{"flower", "flower", "flower"}))
	fmt.Println(longestCommonPrefix([]string{"c", "acc", "ccc"}))
}

func longestCommonPrefix(strs []string) string {
	if len(strs) < 1 {
		return ""
	}
	if len(strs) == 1 {
		return strs[0]
	}
	for i := 1; i <= len(strs[0]); i++ {
		for _, k := range strs {
			if strings.Index(k, strs[0][:i]) != 0 {
				return strs[0][:i-1]
			}
		}
	}
	return strs[0]
}
