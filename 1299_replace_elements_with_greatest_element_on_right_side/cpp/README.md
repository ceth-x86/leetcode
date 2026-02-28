# C++ Solution

## Language Features Used

- **`std::max`** from `<algorithm>` — standard comparison function
- **`static_cast<int>(arr.size())`** — `size()` returns `size_t` (unsigned); casting to `int` allows the reverse loop with `i >= 0` to terminate correctly
- **`std::vector<int>&`** — pass by reference for in-place modification
- **Structured bindings** (C++17) — `auto& [name, arr, expected]` to destructure `TestCase` in the test loop

## Implementation Decisions

- **In-place modification**: the function takes a reference and modifies the vector directly, matching the LeetCode signature. It also returns the vector for convenience in assertions.
- **Reverse `for` loop with `int`**: using `int i` (not `size_t`) avoids unsigned underflow when `i` would go below 0. The `static_cast` makes this explicit.
- **`std::max` vs ternary**: `std::max` is clearer and avoids potential macro pitfalls (`max` macro on some platforms).

## Running Tests

```bash
g++ -std=c++17 -o solution solution.cpp && ./solution
```
