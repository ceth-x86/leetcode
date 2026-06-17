# C++ Solution

## Language Features Used

- **`std::vector<int>`** for the price sequence.
- **Range-based `for` loop** for concise iteration.
- **`std::max` and `std::min`** from `<algorithm>` for constant-time state updates.
- **Assertions in `main`** for lightweight executable tests.

## Implementation Decisions

- `maxProfit` accepts `const std::vector<int>&` to avoid copying the input.
- `prices.front()` initializes the minimum price because the constraints guarantee a non-empty vector.
- The implementation keeps only `minPrice` and `bestProfit`, so it stays O(1) in extra space.

## Running Tests

```bash
g++ -std=c++17 -o solution solution.cpp && ./solution
```
