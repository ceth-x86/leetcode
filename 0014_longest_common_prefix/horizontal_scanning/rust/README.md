# Longest Common Prefix - Horizontal Scanning (Rust)

## Language Features Used
- **starts_with**: To check prefix matching.
- **pop()**: Efficiently removes the last character from a `String`.

## Implementation Decisions
- **`prefix.pop()`**: Using `pop()` is more efficient than slicing and creating a new `String` object in each iteration.

## Run Tests
```bash
cargo test
```
