package length_of_last_word

import (
	"testing"
)

func TestLengthOfLastWord(t *testing.T) {
	tests := []struct {
		name     string
		s        string
		expected int
	}{
		{"example 1", "Hello World", 5},
		{"example 2: trailing spaces", "   fly me   to   the moon  ", 4},
		{"example 3", "luffy is still joyboy", 6},
		{"single word", "Hello", 5},
		{"single word with spaces", "   Hello   ", 5},
		{"single char", "a", 1},
		{"all same chars", "aaaa", 4},
		{"many spaces between", "a   b", 1},
		{"sentence", "Today is a nice day", 3},
	}

	for _, tc := range tests {
		t.Run(tc.name, func(t *testing.T) {
			result := lengthOfLastWord(tc.s)
			if result != tc.expected {
				t.Errorf("lengthOfLastWord(%q) = %d, want %d", tc.s, result, tc.expected)
			}
		})
	}
}
