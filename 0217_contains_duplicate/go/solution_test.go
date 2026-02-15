package contains_duplicate

import "testing"

func TestContainsDuplicate(t *testing.T) {
	tests := []struct {
		name     string
		nums     []int
		expected bool
	}{
		{"has duplicate", []int{1, 2, 3, 1}, true},
		{"all distinct", []int{1, 2, 3, 4}, false},
		{"multiple dupes", []int{1, 1, 1, 3, 3, 4, 3, 2, 4, 2}, true},
		{"single element", []int{1}, false},
		{"two same", []int{1, 1}, true},
		{"two different", []int{1, 2}, false},
		{"all same", []int{5, 5, 5, 5}, true},
		{"extreme values", []int{-1_000_000_000, 1_000_000_000}, false},
	}

	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			result := containsDuplicate(tt.nums)
			if result != tt.expected {
				t.Errorf("containsDuplicate(%v) = %v, want %v", tt.nums, result, tt.expected)
			}
		})
	}
}
