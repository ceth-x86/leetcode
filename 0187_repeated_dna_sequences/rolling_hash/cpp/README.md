# C++ Solution

## Language Features Used

- **Bitwise shifts and masks** for the rolling 20-bit encoding
- **`std::unordered_set<int>`** to store compact window signatures
- **`std::vector<std::string>`** for emitted repeated fragments

## Implementation Decisions

- This variant avoids storing every 10-character string in `seen`; it stores only integer encodings.
- `s.substr(start, 10)` is used only when a repeated window must be added to the answer.
- The code uses C++20 because `unordered_set::contains` keeps the loop cleaner.

## Running Tests

```bash
g++ -std=c++20 -O2 -o solution solution.cpp && ./solution
```
