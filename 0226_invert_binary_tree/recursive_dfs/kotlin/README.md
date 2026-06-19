# Kotlin Solution

## Language Features Used

- **Nullable references** (`TreeNode?`) for optional children.
- **Mutable class properties** to match LeetCode's in-place tree API.
- **Recursive top-level function** for DFS inversion.
- **`ArrayDeque`** in tests for level-order serialization.

## Implementation Decisions

- `val` is escaped as `` `val` `` because it is a Kotlin keyword.
- The function mutates the tree in place and returns the same root.
- Tests use standard `check` assertions in `main`.

## Running Tests

```bash
kotlinc solution.kt solution_test.kt -include-runtime -d solution.jar && kotlin solution.jar
```
