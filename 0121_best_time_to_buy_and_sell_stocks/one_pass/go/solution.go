package best_time_to_buy_and_sell_stock

func maxProfit(prices []int) int {
	minPrice := prices[0]
	bestProfit := 0

	for _, price := range prices {
		if profit := price - minPrice; profit > bestProfit {
			bestProfit = profit
		}
		if price < minPrice {
			minPrice = price
		}
	}

	return bestProfit
}
