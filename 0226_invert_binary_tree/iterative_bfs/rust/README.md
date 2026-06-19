# Rust Solution

## Language Features Used

- **`Rc<RefCell<TreeNode>>`** to match LeetCode's shared mutable tree representation.
- **`VecDeque`** for breadth-first traversal.
- **`take()`** to move child links before swapping.
- **`Option`** for nullable children.

## Implementation Decisions

- The algorithm mutates nodes in place and returns the original root.
- Children are cloned as `Rc` handles when enqueued.
- Build and serialize helpers are included for focused unit tests.

## Running Tests

```bash
cargo test
```
