# Rust Solution

## Language Features Used

- **`HashMap<char, usize>`** for last-seen character positions.
- **Iterator enumeration** to scan with indices.
- **Pattern matching with `if let`** for optional map lookups.
- **Built-in test module** with `#[cfg(test)]`.

## Implementation Decisions

- The input is collected into `Vec<char>` so window lengths are character counts.
- `left` only advances when the previous occurrence is inside the active window.
- The function returns `usize`, which is idiomatic for lengths in Rust.

## Running Tests

```bash
cargo test
```
