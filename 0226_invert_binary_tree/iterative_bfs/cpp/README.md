# C++ Solution

## Language Features Used

- **`std::queue<TreeNode*>`** for breadth-first traversal.
- **`std::swap`** for child pointer swapping.
- **`std::unique_ptr`** in tests to own allocated nodes safely.
- **`std::optional<int>`** for nullable level-order test input.

## Implementation Decisions

- The LeetCode-style `TreeNode` uses raw child pointers.
- Ownership is handled only in tests; the algorithm mutates pointers in place.
- Only non-null children are enqueued.

## Running Tests

```bash
g++ -std=c++17 -o solution solution.cpp && ./solution
```
