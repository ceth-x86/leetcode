package pivot_index

import "testing"

func TestPivotIndex(t *testing.T) {
    tests := []struct {
        nums     []int
        expected int
    }{
        {[]int{1, 7, 3, 6, 5, 6}, 3},
        {[]int{1, 2, 3}, -1},
        {[]int{2, 1, -1}, 0},
        {[]int{0}, 0},
    }

    for _, tt := range tests {
        result := pivotIndex(tt.nums)
        if result != tt.expected {
            t.Errorf("pivotIndex(%v) = %v; expected %v", tt.nums, result, tt.expected)
        }
    }
}
