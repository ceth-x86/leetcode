package vertical_scanning

import "testing"

func TestLongestCommonPrefix(t *testing.T) {
	tests := []struct {
		strs     []string
		expected string
	}{
		{[]string{"flower", "flow", "flight"}, "fl"},
		{[]string{"dog", "racecar", "car"}, ""},
		{[]string{"ab", "a"}, "a"},
		{[]string{""}, ""},
		{[]string{"a"}, "a"},
	}

	for _, tt := range tests {
		t.Run("", func(t *testing.T) {
			result := longestCommonPrefix(tt.strs)
			if result != tt.expected {
				t.Errorf("longestCommonPrefix(%v) = %v; want %v", tt.strs, result, tt.expected)
			}
		})
	}
}
