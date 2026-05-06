package frequency_map

import (
	"testing"
)

func TestGroupAnagrams(t *testing.T) {
	tests := []struct {
		strs []string
	}{
		{[]string{"eat", "tea", "tan", "ate", "nat", "bat"}},
	}

	for _, tt := range tests {
		t.Run("", func(t *testing.T) {
			got := groupAnagrams(tt.strs)
			if len(got) == 0 && len(tt.strs) > 0 {
				t.Errorf("got empty result")
			}
		})
	}
}
