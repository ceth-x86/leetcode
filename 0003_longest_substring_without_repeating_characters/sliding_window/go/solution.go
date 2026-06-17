package longest_substring_without_repeating_characters

func lengthOfLongestSubstring(s string) int {
	lastSeen := make(map[rune]int)
	left := 0
	best := 0

	for right, ch := range []rune(s) {
		if previous, exists := lastSeen[ch]; exists && previous >= left {
			left = previous + 1
		}
		lastSeen[ch] = right
		if length := right - left + 1; length > best {
			best = length
		}
	}

	return best
}
