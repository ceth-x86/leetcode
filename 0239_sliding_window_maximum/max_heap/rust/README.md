# Rust Solution

## Language Features Used

- **`BinaryHeap<(i32, usize)>`** for the max-heap
- **Slices** for zero-copy input access
- **Inline unit tests** in `#[cfg(test)]`

## Implementation Decisions

- Rust's `BinaryHeap` is already a max-heap, so `(value, index)` pairs fit naturally.
- Stale elements are removed lazily by checking the top index against the current window.
- This variant is shorter to derive than the monotonic deque, but asymptotically slower.

## Running Tests

```bash
cargo test
```
