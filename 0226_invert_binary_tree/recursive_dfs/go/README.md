# Go Solution

## Language Features Used

- **Pointer-based `TreeNode` struct** matching LeetCode's Go signature.
- **Recursive function** for depth-first traversal.
- **Table-driven tests** using `testing` and `t.Run`.
- **Pointer helpers** in tests to represent nullable level-order values.

## Implementation Decisions

- The tree is inverted in place.
- Recursive calls invert the subtrees before assigning them to opposite sides.
- Test serialization trims trailing nils to match LeetCode notation.

## Running Tests

```bash
go test -v
```
