# Rust Solution

## Language Features Used

- **`(0..arr.len()).rev()`** — creates a reverse range iterator for right-to-left traversal
- **`i32::max()`** — method on `i32` for computing the maximum of two values
- **`&mut Vec<i32>`** — mutable reference for in-place modification
- **`vec![]` macro** — convenient vector creation in tests

## Implementation Decisions

- **`&mut Vec<i32>` vs returning a new `Vec`**: the function modifies in-place to match the LeetCode pattern. It clones and returns the result for test assertions. In a real Rust codebase, you might take `&mut [i32]` and return nothing, letting the caller observe the mutation.
- **`i32::max()` vs `std::cmp::max`**: the method form (`right_max.max(original)`) reads more naturally in a chain and avoids importing `std::cmp::max`.
- **`(0..arr.len()).rev()` vs manual decrement**: the range-rev pattern is idiomatic Rust and avoids signed/unsigned issues.

## Running Tests

```bash
cargo test
```
