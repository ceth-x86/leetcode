fun maxProfit(prices: IntArray): Int {
    val prefixMin = IntArray(prices.size)
    prefixMin[0] = prices[0]

    for (i in 1 until prices.size) {
        prefixMin[i] = minOf(prefixMin[i - 1], prices[i])
    }

    var bestProfit = 0
    for (i in prices.indices) {
        bestProfit = maxOf(bestProfit, prices[i] - prefixMin[i])
    }

    return bestProfit
}
