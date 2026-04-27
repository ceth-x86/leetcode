package slidingwindowmaximum

import (
	"slices"
	"testing"
)

func TestMaxSlidingWindow(t *testing.T) {
	tests := []struct {
		name string
		nums []int
		k    int
		want []int
	}{
		{"example one", []int{1, 3, -1, -3, 5, 3, 6, 7}, 3, []int{3, 3, 5, 5, 6, 7}},
		{"example two", []int{1}, 1, []int{1}},
		{"full array", []int{2, 1, 3}, 3, []int{3}},
		{"increasing", []int{1, 2, 3, 4}, 2, []int{2, 3, 4}},
		{"duplicates", []int{1, 3, 3, 2}, 2, []int{3, 3, 3}},
		{"negative values", []int{-4, -2, -5, -1}, 2, []int{-2, -2, -1}},
	}

	for _, tc := range tests {
		t.Run(tc.name, func(t *testing.T) {
			got := maxSlidingWindow(tc.nums, tc.k)
			if !slices.Equal(got, tc.want) {
				t.Fatalf("got %v, want %v", got, tc.want)
			}
		})
	}
}
