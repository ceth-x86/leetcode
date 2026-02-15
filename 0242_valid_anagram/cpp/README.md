# C++ Solution

## Language Features Used

- **`std::array<int, 26>`** — fixed-size stack-allocated array with zero initialization via `{}`. More efficient than `std::vector` or `std::unordered_map` for a known small alphabet.
- **`std::string_view`** — lightweight non-owning reference to a string. Avoids copying when passing string literals or `std::string` to the function.
- **Single-pass loop** — increments count for `s[i]` and decrements for `t[i]` in one iteration, halving the number of array accesses vs two separate passes.
- **`s[i] - 'a'`** — maps lowercase letter to array index (0–25). Works because ASCII values of `a`–`z` are contiguous.

## Implementation Decisions

- **`std::array<int, 26>` vs `std::unordered_map<char, int>`**: for a fixed 26-letter alphabet, a plain array is faster (no hashing, cache-friendly). Hash map would be needed for the Unicode follow-up.
- **`string_view` vs `const string&`**: `string_view` is the modern C++17 way to accept read-only string data. It works with both `std::string` and string literals without copies.
- **Structured bindings** (C++17): `const auto& [name, s, t, expected]` destructures `TestCase` cleanly in the test loop.

## Running Tests

```bash
g++ -std=c++17 -o solution solution.cpp && ./solution
```
