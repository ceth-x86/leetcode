package smallest_stable_index_i

import "testing"

func TestFirstStableIndex(t *testing.T) {
	tests := []struct {
		name     string
		nums     []int
		k        int
		expected int
	}{
		{"example 1", []int{5, 0, 1, 4}, 3, 3},
		{"all equal", []int{4, 4, 4}, 0, 0},
		{"single element", []int{9}, 0, 0},
		{"first index stable", []int{2, 5, 7}, 0, 0},
		{"no stable index", []int{10, 0}, 5, -1},
		{"strict threshold miss", []int{3, 1, 2}, 0, -1},
		{"middle index stable", []int{8, 2, 6, 7}, 2, 2},
		{"stable at zero", []int{1, 3, 2, 5}, 1, 0},
	}

	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			result := firstStableIndex(tt.nums, tt.k)
			if result != tt.expected {
				t.Errorf("firstStableIndex(%v, %d) = %d, want %d", tt.nums, tt.k, result, tt.expected)
			}
		})
	}
}
