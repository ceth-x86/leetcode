# C++ Solution

## Language Features Used

- **`std::unordered_set<std::string>`** for constant-average membership checks
- **`std::vector<std::string>`** to preserve output order
- **`std::sort`** in the lightweight test helper to compare results independent of order

## Implementation Decisions

- This version uses `substr` for each 10-character window because the goal of this variant is readability, not minimizing allocations.
- Separate `seen` and `repeated` sets keep the main loop simple and ensure each repeated fragment is returned once.
- Tests live in `solution.cpp` with assertions, matching the repository convention for C++.

## Running Tests

```bash
g++ -std=c++20 -O2 -o solution solution.cpp && ./solution
```
