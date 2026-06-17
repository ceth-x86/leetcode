fun maxProfit(prices: IntArray): Int {
    var minPrice = prices[0]
    var bestProfit = 0

    for (price in prices) {
        bestProfit = maxOf(bestProfit, price - minPrice)
        minPrice = minOf(minPrice, price)
    }

    return bestProfit
}
