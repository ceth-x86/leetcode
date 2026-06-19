# Rust Solution

## Language Features Used

- **`Rc<RefCell<TreeNode>>`** to match LeetCode's shared, mutable tree representation.
- **`Option`** for nullable children.
- **`take()`** to move child subtrees out before swapping them.
- **`VecDeque`** in tests for level-order serialization.

## Implementation Decisions

- `invert_tree` mutates nodes in place and returns the original root.
- Child pointers are taken before recursive calls to satisfy Rust's borrowing rules.
- Build and serialize helpers are public only to keep tests simple.

## Running Tests

```bash
cargo test
```
