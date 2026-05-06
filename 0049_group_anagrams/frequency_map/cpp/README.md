# Group Anagrams - Frequency Map Approach (C++)

## Language Features Used
- **`std::array<int, 26>`**: Fixed-size frequency array.
- **Custom Hasher**: Since `std::unordered_map` doesn't provide a default hash for `std::array`, we implement a simple XOR-based hash.
- **`std::unordered_map`**: To group strings by their frequency signature.

## Run Tests
```bash
g++ -std=c++17 solution.cpp -o solution && ./solution
```
