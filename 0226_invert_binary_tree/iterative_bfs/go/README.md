# Go Solution

## Language Features Used

- **Pointer-based `TreeNode` struct** matching LeetCode's Go signature.
- **Slice-backed queue** for breadth-first traversal.
- **Multiple assignment** to swap children.
- **Table-driven tests** with `t.Run`.

## Implementation Decisions

- The algorithm mutates the tree in place.
- Only non-nil children are appended to the queue.
- Serialization trims trailing nil values to match LeetCode format.

## Running Tests

```bash
go test -v
```
