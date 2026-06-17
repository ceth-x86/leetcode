def max_profit(prices: list[int]) -> int:
    prefix_min = [0] * len(prices)
    prefix_min[0] = prices[0]

    for i in range(1, len(prices)):
        prefix_min[i] = min(prefix_min[i - 1], prices[i])

    best_profit = 0
    for price, buy_price in zip(prices, prefix_min):
        best_profit = max(best_profit, price - buy_price)

    return best_profit
