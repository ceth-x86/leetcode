package best_time_to_buy_and_sell_stock

import "testing"

func TestMaxProfit(t *testing.T) {
	tests := []struct {
		name     string
		prices   []int
		expected int
	}{
		{"example 1: profitable swing", []int{7, 1, 5, 3, 6, 4}, 5},
		{"example 2: decreasing", []int{7, 6, 4, 3, 1}, 0},
		{"single price", []int{5}, 0},
		{"two increasing", []int{1, 2}, 1},
		{"two decreasing", []int{2, 1}, 0},
		{"best sale before later low", []int{2, 4, 1}, 2},
		{"multiple valleys", []int{3, 2, 6, 5, 0, 3}, 4},
		{"all equal", []int{5, 5, 5}, 0},
		{"zero price", []int{0, 4, 0, 10}, 10},
	}

	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			result := maxProfit(tt.prices)
			if result != tt.expected {
				t.Errorf("maxProfit(%v) = %v, want %v", tt.prices, result, tt.expected)
			}
		})
	}
}
