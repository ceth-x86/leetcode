# Rust Solution

## Language Features Used

- **Borrowed slice** (`&[i32]`) to avoid taking ownership of the input.
- **Pattern matching in the loop binding** (`for &price in prices`) to copy each integer out of the slice.
- **`i32::max` and `i32::min` methods** for concise state updates.
- **`#[cfg(test)]` module** for colocated unit tests.

## Implementation Decisions

- The solution indexes `prices[0]` because LeetCode guarantees a non-empty input.
- It returns `i32`, matching the common LeetCode Rust signature for this problem.
- No heap allocation is needed; only two scalar variables are updated during the scan.

## Running Tests

```bash
cargo test
```
