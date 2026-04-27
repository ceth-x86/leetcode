# C++ Solution

## Language Features Used

- **`std::priority_queue<std::pair<int, int>>`** for the max-heap
- **Pairs** of `(value, index)` to support lazy stale-entry removal
- **Assertions in `main`** for lightweight test coverage

## Implementation Decisions

- The heap top always gives the largest value seen so far, but old entries can remain until they surface at the top and are popped.
- Storing the index alongside the value is what makes lazy cleanup possible.
- This is a solid alternative solution, but not the optimal one for the problem.

## Running Tests

```bash
g++ -std=c++17 -O2 -o solution solution.cpp && ./solution
```
