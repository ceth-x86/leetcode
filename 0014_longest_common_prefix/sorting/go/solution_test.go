package sorting

import "testing"

func TestLongestCommonPrefix(t *testing.T) {
	tests := []struct {
		strs     []string
		expected string
	}{
		{[]string{"flower", "flow", "flight"}, "fl"},
	}

	for _, tt := range tests {
		t.Run("", func(t *testing.T) {
			if got := longestCommonPrefix(tt.strs); got != tt.expected {
				t.Errorf("longestCommonPrefix() = %v, want %v", got, tt.expected)
			}
		})
	}
}
