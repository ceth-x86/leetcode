package is_subsequence

import (
	"testing"
)

func TestIsSubsequenceUnicode(t *testing.T) {
	tests := []struct {
		name     string
		s        string
		tt       string
		expected bool
	}{
		// Original ASCII cases
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

		// Unicode: CJK characters
		{"chinese subsequence", "你世", "你好世界", true},
		{"chinese not subsequence", "界好", "你好世界", false},
		{"chinese full match", "你好世界", "你好世界", true},
		{"chinese single char", "世", "你好世界", true},
		{"chinese missing char", "吗", "你好世界", false},

		// Unicode: emoji
		{"emoji subsequence", "🌍🌊", "🌍🌸🌊🔥", true},
		{"emoji not subsequence", "🌊🌍", "🌍🌸🌊🔥", false},
		{"emoji single", "🔥", "🌍🌸🌊🔥", true},

		// Unicode: mixed scripts
		{"mixed scripts", "aЯ", "aбвЯг", true},
		{"cyrillic subsequence", "бг", "абвгд", true},
		{"cyrillic not subsequence", "гб", "абвгд", false},

		// Unicode: accented characters (multi-byte UTF-8)
		{"accented subsequence", "éà", "café à la crème", true},
		{"accented not subsequence", "àé", "étoile", false},

		// Edge: empty s with unicode t
		{"empty s unicode t", "", "你好🌍", true},
	}

	for _, tc := range tests {
		t.Run(tc.name, func(t *testing.T) {
			result := isSubsequenceUnicode(tc.s, tc.tt)
			if result != tc.expected {
				t.Errorf("isSubsequenceUnicode(%q, %q) = %v, want %v", tc.s, tc.tt, result, tc.expected)
			}
		})
	}
}
