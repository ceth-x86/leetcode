package valid_anagram

import "testing"

func TestIsAnagram(t *testing.T) {
	tests := []struct {
		name     string
		s        string
		tt       string
		expected bool
	}{
		{"anagram match", "anagram", "nagaram", true},
		{"no match", "rat", "car", false},
		{"single char equal", "a", "a", true},
		{"single char differ", "a", "b", false},
		{"different lengths", "ab", "abc", false},
		{"same string", "abc", "abc", true},
		{"all same char", "aaa", "aaa", true},
		{"count mismatch", "aacc", "ccac", false},
	}

	for _, tc := range tests {
		t.Run(tc.name, func(t *testing.T) {
			result := isAnagram(tc.s, tc.tt)
			if result != tc.expected {
				t.Errorf("isAnagram(%q, %q) = %v, want %v", tc.s, tc.tt, result, tc.expected)
			}
		})
	}
}
