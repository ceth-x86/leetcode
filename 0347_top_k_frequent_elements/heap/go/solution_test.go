package heap

import (
	"reflect"
	"sort"
	"testing"
)

func TestTopKFrequent(t *testing.T) {
	tests := []struct {
		nums     []int
		k        int
		expected []int
	}{
		{[]int{1, 1, 1, 2, 2, 3}, 2, []int{1, 2}},
	}

	for _, tt := range tests {
		t.Run("", func(t *testing.T) {
			got := topKFrequent(tt.nums, tt.k)
			sort.Ints(got)
			sort.Ints(tt.expected)
			if !reflect.DeepEqual(got, tt.expected) {
				t.Errorf("topKFrequent() = %v, want %v", got, tt.expected)
			}
		})
	}
}
