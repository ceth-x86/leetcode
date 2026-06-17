# C++ Solution

## Language Features Used

- **`std::string`** for input.
- **`std::unordered_map<char, int>`** for last-seen indices.
- **`std::max`** for best-window updates.
- **Assertions in `main`** for lightweight tests.

## Implementation Decisions

- The function takes `const std::string&` to avoid copying.
- Indices are stored as `int` because the input length is bounded by `5 * 10^4`.
- A previous character occurrence only moves `left` if it is still inside the active window.

## Running Tests

```bash
g++ -std=c++17 -o solution solution.cpp && ./solution
```
