# Rust Solution

## Language Features Used

- **`VecDeque<usize>`** for efficient front/back queue operations
- **Slices** for borrowing the input without copying
- **Unit tests** inside `#[cfg(test)]` modules

## Implementation Decisions

- The deque stores indices so the code can compare values and expire old entries independently.
- Back pops use `<=` to keep only the newest representative of equal values.
- This is the optimal monotonic-queue solution in idiomatic Rust form.

## Running Tests

```bash
cargo test
```
