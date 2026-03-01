# C++ Solution

## Language Features Used

- **`const std::string&`** — pass by const reference to avoid copying
- **`static_cast<int>(s.size()) - 1`** — safe conversion from `size_t` to `int` for reverse indexing with `>= 0` comparison
- **Character literal `' '`** — single-char comparison for space detection
- **Structured bindings** (C++17) — `const auto& [name, s, expected]` to destructure test cases

## Implementation Decisions

- **Reverse scan vs `find_last_not_of` + `rfind`**: STL string methods could locate the last word boundaries, but they would require two passes and extra logic to combine. The manual reverse scan is straightforward and mirrors the algorithm directly.
- **`int` index vs `size_t`**: using `int` allows the `i >= 0` termination check. With `size_t`, decrementing past 0 wraps to a large value, requiring a different loop structure.

## Running Tests

```bash
g++ -std=c++17 -o solution solution.cpp && ./solution
```
