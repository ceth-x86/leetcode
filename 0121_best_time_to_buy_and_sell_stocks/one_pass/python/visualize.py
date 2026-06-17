def visualize(prices: list[int]) -> None:
    min_price = prices[0]
    best_profit = 0

    print(f"prices = {prices}")
    print()
    print(f"{'day':>3} {'price':>5} {'min_before':>10} {'candidate':>10} {'best':>6} action")
    print("-" * 62)

    for day, price in enumerate(prices, start=1):
        min_before = min_price
        candidate = price - min_before

        if price < min_before:
            action = f"new minimum buy price: {price}"
        elif candidate > best_profit:
            action = f"new best profit: {candidate}"
        else:
            action = "no change"

        best_profit = max(best_profit, candidate)
        min_price = min(min_price, price)

        print(
            f"{day:>3} {price:>5} {min_before:>10} "
            f"{candidate:>10} {best_profit:>6} {action}"
        )

    print()
    print(f"maximum profit = {best_profit}")


if __name__ == "__main__":
    visualize([7, 1, 5, 3, 6, 4])
