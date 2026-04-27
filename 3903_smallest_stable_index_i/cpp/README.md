# C++ Solution

## Language Features Used

- `std::vector<int>` for the suffix minima and a single running prefix maximum.
- `std::max` and `std::min` from the standard library for clear range updates.
- A compact assertion-based test harness in `main()`, matching the repository's existing C++ pattern.

## Implementation Decisions

- I store only the suffix minima array. The prefix maximum is updated on the fly during the final scan, which keeps the algorithm linear without an unnecessary second array.
- The function takes `const std::vector<int>&` because the input is read-only.

## Running Tests

```bash
g++ -std=c++17 -o solution solution.cpp && ./solution
```
