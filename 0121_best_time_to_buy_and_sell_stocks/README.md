# 121. Best Time to Buy and Sell Stock

**Difficulty:** Easy

**Topics:** Array, Dynamic Programming

**Link:** https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

## Problem

You are given an array `prices` where `prices[i]` is the price of a given stock on the `i`th day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return `0`.

## Examples

### Example 1

```text
Input: prices = [7, 1, 5, 3, 6, 4]
Output: 5
Explanation: Buy on day 2 at price 1 and sell on day 5 at price 6.
Profit = 6 - 1 = 5.
```

### Example 2

```text
Input: prices = [7, 6, 4, 3, 1]
Output: 0
Explanation: Prices only decrease, so no profitable transaction exists.
```

## Constraints

- `1 <= prices.length <= 10^5`
- `0 <= prices[i] <= 10^4`

## Approach

### One Pass Approach

**Intuition:** Each day can be treated as a possible sell day. The best buy day for that sell day is the lowest price seen so far. While scanning prices from left to right, keep the running minimum price and use it to compute the best profit for selling today.

Because selling before buying is not allowed, the running minimum only comes from the current or earlier days.

**Algorithm:**

1. Initialize `min_price` to the first price.
2. Initialize `best_profit` to `0`.
3. For each price:
   - Compute `price - min_price`.
   - Update `best_profit` if this candidate profit is larger.
   - Update `min_price` if today's price is lower.
4. Return `best_profit`.

### Prefix Minimum Array Approach

**Intuition:** Instead of keeping only one running minimum, precompute the best buy price available for every day. The prefix minimum array at index `i` stores the lowest price from day `0` through day `i`. Then each day can be evaluated independently as `prices[i] - prefix_min[i]`.

This makes the dynamic programming state explicit: `prefix_min[i] = min(prefix_min[i - 1], prices[i])`.

**Algorithm:**

1. Create `prefix_min` with the same length as `prices`.
2. Set `prefix_min[0] = prices[0]`.
3. For each index `i` from `1` to `n - 1`:
   - Set `prefix_min[i] = min(prefix_min[i - 1], prices[i])`.
4. Initialize `best_profit = 0`.
5. For each index `i`:
   - Compute `prices[i] - prefix_min[i]`.
   - Update `best_profit` if this candidate profit is larger.
6. Return `best_profit`.

## Step-by-Step Walkthrough

### One Pass Walkthrough

For `prices = [7, 1, 5, 3, 6, 4]`:

```text
Start: min_price = 7, best_profit = 0

Day 1, price = 7:
  profit = 7 - 7 = 0
  best_profit = 0
  min_price = 7

Day 2, price = 1:
  profit = 1 - 7 = -6
  best_profit = 0
  min_price = 1

Day 3, price = 5:
  profit = 5 - 1 = 4
  best_profit = 4
  min_price = 1

Day 4, price = 3:
  profit = 3 - 1 = 2
  best_profit = 4
  min_price = 1

Day 5, price = 6:
  profit = 6 - 1 = 5
  best_profit = 5
  min_price = 1

Day 6, price = 4:
  profit = 4 - 1 = 3
  best_profit = 5
  min_price = 1

Result: 5
```

### Prefix Minimum Array Walkthrough

For `prices = [7, 1, 5, 3, 6, 4]`:

```text
Build prefix_min:
  i=0: prefix_min[0] = 7
  i=1: prefix_min[1] = min(7, 1) = 1
  i=2: prefix_min[2] = min(1, 5) = 1
  i=3: prefix_min[3] = min(1, 3) = 1
  i=4: prefix_min[4] = min(1, 6) = 1
  i=5: prefix_min[5] = min(1, 4) = 1

prefix_min = [7, 1, 1, 1, 1, 1]

Evaluate profits:
  i=0: 7 - 7 = 0  -> best_profit = 0
  i=1: 1 - 1 = 0  -> best_profit = 0
  i=2: 5 - 1 = 4  -> best_profit = 4
  i=3: 3 - 1 = 2  -> best_profit = 4
  i=4: 6 - 1 = 5  -> best_profit = 5
  i=5: 4 - 1 = 3  -> best_profit = 5

Result: 5
```

For `prices = [7, 6, 4, 3, 1]`:

```text
prefix_min = [7, 6, 4, 3, 1]

profits:
  7 - 7 = 0
  6 - 6 = 0
  4 - 4 = 0
  3 - 3 = 0
  1 - 1 = 0

Result: 0
```

## Call Trace

### One Pass Call Trace

For `maxProfit([7, 1, 5, 3, 6, 4])`:

```text
maxProfit([7, 1, 5, 3, 6, 4])
|
+-- min_price = 7
+-- best_profit = 0
|
+-- day 1, price = 7 -> candidate = 0, best_profit = 0, min_price = 7
+-- day 2, price = 1 -> candidate = -6, best_profit = 0, min_price = 1
+-- day 3, price = 5 -> candidate = 4, best_profit = 4, min_price = 1
+-- day 4, price = 3 -> candidate = 2, best_profit = 4, min_price = 1
+-- day 5, price = 6 -> candidate = 5, best_profit = 5, min_price = 1
+-- day 6, price = 4 -> candidate = 3, best_profit = 5, min_price = 1
|
+-- result: 5
```

### Prefix Minimum Array Call Trace

For `maxProfit([7, 1, 5, 3, 6, 4])`:

```text
maxProfit([7, 1, 5, 3, 6, 4])
|
+-- prefix_min = [0, 0, 0, 0, 0, 0]
+-- prefix_min[0] = 7
|
+-- build prefix_min
|   +-- i=1: min(7, 1) = 1 -> [7, 1, 0, 0, 0, 0]
|   +-- i=2: min(1, 5) = 1 -> [7, 1, 1, 0, 0, 0]
|   +-- i=3: min(1, 3) = 1 -> [7, 1, 1, 1, 0, 0]
|   +-- i=4: min(1, 6) = 1 -> [7, 1, 1, 1, 1, 0]
|   +-- i=5: min(1, 4) = 1 -> [7, 1, 1, 1, 1, 1]
|
+-- evaluate profits
|   +-- i=0: 7 - 7 = 0 -> best_profit = 0
|   +-- i=1: 1 - 1 = 0 -> best_profit = 0
|   +-- i=2: 5 - 1 = 4 -> best_profit = 4
|   +-- i=3: 3 - 1 = 2 -> best_profit = 4
|   +-- i=4: 6 - 1 = 5 -> best_profit = 5
|   +-- i=5: 4 - 1 = 3 -> best_profit = 5
|
+-- result: 5
```

## Complexity Analysis

### One Pass Complexity

**Time Complexity:** O(n)

- Scans the array once.
- Each day does constant-time arithmetic and comparisons.

**Space Complexity:** O(1)

- Stores only `min_price` and `best_profit`.

### Prefix Minimum Array Complexity

**Time Complexity:** O(n)

- One pass builds the prefix minimum array.
- One pass evaluates all candidate sell-day profits.
- The two passes still simplify to O(n).

**Space Complexity:** O(n)

- Stores one prefix minimum value for each input price.

## Comparison

| Approach | Time | Space | Pros | Cons |
|----------|------|-------|------|------|
| One pass | O(n) | O(1) | Best practical solution; minimal state | Running state is implicit |
| Prefix minimum array | O(n) | O(n) | Makes the dynamic programming state visible and easy to inspect | Stores unnecessary state for this problem |
| Brute force all pairs | O(n^2) | O(1) | Simple to reason about | Too slow for `10^5` prices |

The prefix minimum array approach is useful for learning because it exposes the DP transition clearly. The one-pass approach is the optimized form of the same idea after observing that only the latest prefix minimum is needed.

## Edge Cases

| Case | Input | Output | Why |
|------|-------|--------|-----|
| Single price | `[5]` | `0` | Cannot sell on a future day |
| Strictly decreasing | `[7, 6, 4, 3, 1]` | `0` | No profitable transaction exists |
| Strictly increasing | `[1, 2, 3, 4, 5]` | `4` | Buy on first day, sell on last day |
| Best buy after first day | `[7, 1, 5, 3, 6, 4]` | `5` | Prefix minimum updates before the best sale |
| All equal | `[5, 5, 5]` | `0` | Profit never becomes positive |
| Price can be zero | `[0, 4, 0, 10]` | `10` | Zero is a valid buy price |
