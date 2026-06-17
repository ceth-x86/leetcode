# C++ Solution

## Language Features Used

- **`std::vector<int>`** for both input prices and the prefix minimum array.
- **`std::min` and `std::max`** from `<algorithm>` for the DP transition and profit update.
- **`std::size_t` indices** for vector indexing.
- **Assertions in `main`** for lightweight executable tests.

## Implementation Decisions

- `maxProfit` takes `const std::vector<int>&` to avoid copying the input.
- `prefixMin` is allocated with `prices.size()` so each day has an explicit best buy price.
- The solution intentionally uses O(n) extra space to demonstrate the prefix-state formulation.

## Running Tests

```bash
g++ -std=c++17 -o solution solution.cpp && ./solution
```
