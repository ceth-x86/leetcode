package longest_substring_without_repeating_characters

import "testing"

func TestLengthOfLongestSubstring(t *testing.T) {
	tests := []struct {
		name     string
		s        string
		expected int
	}{
		{"example 1", "abcabcbb", 3},
		{"example 2", "bbbbb", 1},
		{"example 3", "pwwkew", 3},
		{"empty", "", 0},
		{"single", "a", 1},
		{"no repeats", "abcdef", 6},
		{"stale repeat", "abba", 2},
		{"repeat after gap", "dvdf", 3},
		{"leading repeat", "aab", 2},
		{"late best", "tmmzuxt", 5},
		{"symbols and spaces", "a! b@a", 5},
	}

	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			result := lengthOfLongestSubstring(tt.s)
			if result != tt.expected {
				t.Errorf("lengthOfLongestSubstring(%q) = %v, want %v", tt.s, result, tt.expected)
			}
		})
	}
}
