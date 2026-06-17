def visualize(prices: list[int]) -> None:
    prefix_min = [0] * len(prices)
    prefix_min[0] = prices[0]

    print(f"prices = {prices}")
    print()
    print("Building prefix minimum array:")
    print(f"  i=0: prefix_min[0] = {prefix_min[0]}")

    for i in range(1, len(prices)):
        prefix_min[i] = min(prefix_min[i - 1], prices[i])
        print(
            f"  i={i}: min({prefix_min[i - 1]}, {prices[i]}) "
            f"= {prefix_min[i]}"
        )

    print()
    print(f"prefix_min = {prefix_min}")
    print()
    print(f"{'day':>3} {'price':>5} {'buy_price':>9} {'profit':>7} {'best':>6}")
    print("-" * 40)

    best_profit = 0
    for day, (price, buy_price) in enumerate(zip(prices, prefix_min), start=1):
        profit = price - buy_price
        best_profit = max(best_profit, profit)
        print(f"{day:>3} {price:>5} {buy_price:>9} {profit:>7} {best_profit:>6}")

    print()
    print(f"maximum profit = {best_profit}")


if __name__ == "__main__":
    visualize([7, 1, 5, 3, 6, 4])
