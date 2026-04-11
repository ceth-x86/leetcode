# C++ Solution

## Language Features Used

- **`std::vector<int>`** for the precomputed 2-bit encoding array
- **Bitwise operations** on `std::uint32_t` for fixed-width window updates
- **`std::unordered_set`** for both seen bitmasks and emitted answers

## Implementation Decisions

- This version mirrors the textbook bitmask derivation: build the first window once, then shift and clear the oldest 2 bits on every slide.
- Keeping `nums` makes the formula easier to verify than mixing encoding and sliding in one loop.
- Output order is normalized in tests because the problem accepts any ordering.

## Running Tests

```bash
g++ -std=c++20 -O2 -o solution solution.cpp && ./solution
```
