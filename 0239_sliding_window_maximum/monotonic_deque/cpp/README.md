# C++ Solution

## Language Features Used

- **`std::deque<int>`** for efficient front/back maintenance
- **`std::vector<int>`** for result storage
- **Assertions in `main`** for lightweight repository-style testing

## Implementation Decisions

- The deque stores indices so the code can expire out-of-window elements without extra bookkeeping.
- Using `<=` when popping from the back keeps only the most recent equal value, which simplifies stale-index handling.
- This is the optimal `O(n)` solution and the main reference implementation for the problem.

## Running Tests

```bash
g++ -std=c++17 -O2 -o solution solution.cpp && ./solution
```
