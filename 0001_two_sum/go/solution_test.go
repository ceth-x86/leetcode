package two_sum

import (
	"reflect"
	"testing"
)

func TestTwoSum(t *testing.T) {
	tests := []struct {
		name     string
		nums     []int
		target   int
		expected []int
	}{
		{"pair at start", []int{2, 7, 11, 15}, 9, []int{0, 1}},
		{"pair in middle", []int{3, 2, 4}, 6, []int{1, 2}},
		{"same elements", []int{3, 3}, 6, []int{0, 1}},
		{"pair at end", []int{1, 2, 3, 4}, 7, []int{2, 3}},
		{"negative numbers", []int{-1, -2, -3, -4, -5}, -8, []int{2, 4}},
		{"zeros", []int{0, 4, 3, 0}, 0, []int{0, 3}},
		{"extreme values", []int{-1_000_000_000, 1_000_000_000}, 0, []int{0, 1}},
		{"duplicate values", []int{1, 5, 5, 11}, 10, []int{1, 2}},
	}

	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			result := twoSum(tt.nums, tt.target)
			if !reflect.DeepEqual(result, tt.expected) {
				t.Errorf("twoSum(%v, %d) = %v, want %v", tt.nums, tt.target, result, tt.expected)
			}
		})
	}
}
