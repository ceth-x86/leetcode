package is_subsequence

import (
	"testing"
)

func TestSubsequenceChecker(t *testing.T) {
	checker := NewSubsequenceChecker("ahbgdc")

	tests := []struct {
		name     string
		s        string
		expected bool
	}{
		{"example 1: subsequence found", "abc", true},
		{"example 2: not a subsequence", "axc", false},
		{"empty s", "", true},
		{"s equals t", "ahbgdc", true},
		{"single char match", "a", true},
		{"match at end", "c", true},
		{"repeated char not enough", "aaa", false},
		{"non-contiguous match", "abdc", true},
		{"s longer than t", "ahbgdca", false},
	}

	for _, tc := range tests {
		t.Run(tc.name, func(t *testing.T) {
			result := checker.IsSubsequence(tc.s)
			if result != tc.expected {
				t.Errorf("IsSubsequence(%q) = %v, want %v", tc.s, result, tc.expected)
			}
		})
	}
}

func TestSubsequenceCheckerEmptyT(t *testing.T) {
	checker := NewSubsequenceChecker("")
	if !checker.IsSubsequence("") {
		t.Error("empty s should be subsequence of empty t")
	}
	if checker.IsSubsequence("a") {
		t.Error("non-empty s should not be subsequence of empty t")
	}
}

func TestSubsequenceCheckerRepeatedChars(t *testing.T) {
	checker := NewSubsequenceChecker("aabbc")
	tests := []struct {
		s        string
		expected bool
	}{
		{"abc", true},
		{"aab", true},
		{"aabbc", true},
		{"aabbcc", false},
	}
	for _, tc := range tests {
		if checker.IsSubsequence(tc.s) != tc.expected {
			t.Errorf("IsSubsequence(%q) want %v", tc.s, tc.expected)
		}
	}
}

func TestSubsequenceCheckerManyQueries(t *testing.T) {
	checker := NewSubsequenceChecker("abcdefghijklmnopqrstuvwxyz")
	tests := []struct {
		s        string
		expected bool
	}{
		{"ace", true},
		{"az", true},
		{"za", false},
		{"xyz", true},
	}
	for _, tc := range tests {
		if checker.IsSubsequence(tc.s) != tc.expected {
			t.Errorf("IsSubsequence(%q) want %v", tc.s, tc.expected)
		}
	}
}
