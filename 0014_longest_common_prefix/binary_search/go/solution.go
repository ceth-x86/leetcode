package binary_search

import "strings"

func longestCommonPrefix(strs []string) string {
	if len(strs) == 0 {
		return ""
	}

	minLen := len(strs[0])
	for _, s := range strs {
		if len(s) < minLen {
			minLen = len(s)
		}
	}

	low, high := 1, minLen
	ans := 0
	for low <= high {
		mid := (low + high) / 2
		if isCommonPrefix(strs, mid) {
			ans = mid
			low = mid + 1
		} else {
			high = mid - 1
		}
	}
	return strs[0][:ans]
}

func isCommonPrefix(strs []string, length int) bool {
	prefix := strs[0][:length]
	for i := 1; i < len(strs); i++ {
		if !strings.HasPrefix(strs[i], prefix) {
			return false
		}
	}
	return true
}
