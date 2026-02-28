package replace_elements

import (
	"reflect"
	"testing"
)

func TestReplaceElements(t *testing.T) {
	tests := []struct {
		name     string
		arr      []int
		expected []int
	}{
		{"example 1", []int{17, 18, 5, 4, 6, 1}, []int{18, 6, 6, 6, 1, -1}},
		{"single element", []int{400}, []int{-1}},
		{"two elements ascending", []int{1, 5}, []int{5, -1}},
		{"descending", []int{5, 4, 3, 2, 1}, []int{4, 3, 2, 1, -1}},
		{"ascending", []int{1, 2, 3, 4, 5}, []int{5, 5, 5, 5, -1}},
		{"all same", []int{7, 7, 7}, []int{7, 7, -1}},
		{"two elements descending", []int{5, 1}, []int{1, -1}},
		{"large value", []int{1, 100_000}, []int{100_000, -1}},
	}

	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			result := replaceElements(tt.arr)
			if !reflect.DeepEqual(result, tt.expected) {
				t.Errorf("replaceElements(%v) = %v, want %v", tt.arr, result, tt.expected)
			}
		})
	}
}
