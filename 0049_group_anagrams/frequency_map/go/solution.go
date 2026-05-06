package frequency_map

func groupAnagrams(strs []string) [][]string {
	// In Go, arrays are comparable and can be used as map keys
	groups := make(map[[26]int][]string)
	
	for _, s := range strs {
		var count [26]int
		for _, char := range s {
			count[char-'a']++
		}
		groups[count] = append(groups[count], s)
	}
	
	result := make([][]string, 0, len(groups))
	for _, group := range groups {
		result = append(result, group)
	}
	return result
}
