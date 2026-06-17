package best_time_to_buy_and_sell_stock

func maxProfit(prices []int) int {
	prefixMin := make([]int, len(prices))
	prefixMin[0] = prices[0]

	for i := 1; i < len(prices); i++ {
		if prices[i] < prefixMin[i-1] {
			prefixMin[i] = prices[i]
		} else {
			prefixMin[i] = prefixMin[i-1]
		}
	}

	bestProfit := 0
	for i, price := range prices {
		if profit := price - prefixMin[i]; profit > bestProfit {
			bestProfit = profit
		}
	}

	return bestProfit
}
