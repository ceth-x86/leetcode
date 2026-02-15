# C++ Solution

## Language Features Used

- **`std::unordered_set`** — hash-based set from `<unordered_set>`, O(1) average insert/lookup
- **`insert().second`** — `std::unordered_set::insert` returns a `pair<iterator, bool>` where `.second` is `false` if the element already existed. This combines the lookup and insertion into a single operation, avoiding a redundant `find()` + `insert()` pair.
- **`const std::vector<int>&`** — pass by const reference to avoid copying the input
- **`auto`** — type deduction in range-based for loop
- **Structured bindings** (C++17) — `const auto& [name, nums, expected]` to destructure `TestCase` in the test loop

## Implementation Decisions

- **`unordered_set` vs `set`**: `std::set` is tree-based (O(log n) operations), `std::unordered_set` is hash-based (O(1) average). Hash set is the right choice here since we don't need ordering.
- **`!insert().second` idiom**: more efficient than `count()` + `insert()` or `find()` + `insert()` because it does a single hash table probe instead of two.
- **Tests in `main()`**: for single-problem solutions, a lightweight assert-based approach in `main()` avoids external test framework dependencies.

## Running Tests

```bash
g++ -std=c++17 -o solution solution.cpp && ./solution
```
