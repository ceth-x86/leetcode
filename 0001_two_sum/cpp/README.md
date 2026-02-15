# C++ Solution

## Language Features Used

- **`std::unordered_map<int, int>`** — hash map from `<unordered_map>`, O(1) average insert/lookup; maps values to their indices
- **`find()` + iterator check** — `seen.find(complement)` returns an iterator; comparing to `seen.end()` checks existence without a second lookup. `it->second` retrieves the stored index directly.
- **`const std::vector<int>&`** — pass by const reference to avoid copying the input
- **Structured bindings** (C++17) — `const auto& [name, nums, target, expected]` to destructure `TestCase` in the test loop

## Implementation Decisions

- **`unordered_map` vs `map`**: `std::map` is tree-based (O(log n) operations), `std::unordered_map` is hash-based (O(1) average). Hash map is the right choice since we don't need ordering.
- **`find()` vs `count()` + `[]`**: `find()` does a single probe and returns both existence and the value via the iterator, while `count()` + `[]` does two probes.
- **Tests in `main()`**: lightweight assert-based approach avoids external test framework dependencies.

## Running Tests

```bash
g++ -std=c++17 -o solution solution.cpp && ./solution
```
