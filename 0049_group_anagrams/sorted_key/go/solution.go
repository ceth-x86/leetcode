package sorted_key

import (
	"sort"
)

func groupAnagrams(strs []string) [][]string {
	groups := make(map[string][]string)
	
	for _, s := range strs {
		key := sortString(s)
		groups[key] = append(groups[key], s)
	}
	
	result := make([][]string, 0, len(groups))
	for _, group := range groups {
		result = append(result, group)
	}
	return result
}

func sortString(s string) string {
	runes := []rune(s)
	sort.Slice(runes, func(i, j int) bool {
		return runes[i] < runes[j]
	})
	return string(runes)
}
