package is_subsequence

import (
	"testing"
)

func TestIsSubsequence(t *testing.T) {
	tests := []struct {
		name     string
		s        string
		tt       string
		expected bool
	}{
		{"example 1: subsequence found", "abc", "ahbgdc", true},
		{"example 2: not a subsequence", "axc", "ahbgdc", false},
		{"empty s", "", "ahbgdc", true},
		{"both empty", "", "", true},
		{"s longer than t", "abc", "ab", false},
		{"s equals t", "abc", "abc", true},
		{"single char match", "a", "a", true},
		{"single char no match", "a", "b", false},
		{"match at end", "c", "abc", true},
		{"empty t non-empty s", "a", "", false},
	}

	for _, tc := range tests {
		t.Run(tc.name, func(t *testing.T) {
			result := isSubsequence(tc.s, tc.tt)
			if result != tc.expected {
				t.Errorf("isSubsequence(%q, %q) = %v, want %v", tc.s, tc.tt, result, tc.expected)
			}
		})
	}
}
