# C++ Solution

## Language Features Used

- **Raw child pointers** in `TreeNode`, matching common LeetCode C++ signatures.
- **`std::unique_ptr`** in tests to own allocated nodes safely.
- **`std::optional<int>`** for level-order test data with missing children.
- **Recursive DFS** for the tree inversion.

## Implementation Decisions

- `invertTree` mutates the tree in place and returns the original root pointer.
- Tests keep ownership outside the tree nodes to avoid manual `delete`.
- The helper serializer trims trailing nulls to match LeetCode's level-order format.

## Running Tests

```bash
g++ -std=c++17 -o solution solution.cpp && ./solution
```
