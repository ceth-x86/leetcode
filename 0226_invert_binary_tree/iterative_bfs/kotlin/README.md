# Kotlin Solution

## Language Features Used

- **Nullable references** (`TreeNode?`) for optional children.
- **`ArrayDeque<TreeNode>`** as the BFS queue.
- **Mutable class properties** to swap child pointers in place.
- **Safe-call `let`** to enqueue non-null children.

## Implementation Decisions

- `val` is escaped as `` `val` `` because it is a Kotlin keyword.
- The function mutates the tree and returns the original root.
- Tests use standard `check` assertions in `main`.

## Running Tests

```bash
kotlinc solution.kt solution_test.kt -include-runtime -d solution.jar && kotlin solution.jar
```
