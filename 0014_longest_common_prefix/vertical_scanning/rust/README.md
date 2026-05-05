# Longest Common Prefix - Vertical Scanning (Rust)

## Language Features Used
- **Iterators**: Using `chars().enumerate()` and `iter().skip(1)`.
- **String slicing**: Returning a new `String` from a slice.
- **Option matching**: Handling `nth(i)` which returns `Option<char>`.

## Implementation Decisions
- **Safety**: Rust's `chars().nth(i)` and slicing ensure safe access to UTF-8 characters, though the problem restricts input to lowercase English letters.

## Run Tests
```bash
cargo test
```
