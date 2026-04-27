# Rust Solution

## Language Features Used

- `Vec<i32>` for the suffix minima plus a running prefix maximum.
- Borrowed slice input `&[i32]`, which is the idiomatic read-only parameter type in Rust.
- Unit tests in a `#[cfg(test)]` module, following the repository's Rust pattern.

## Implementation Decisions

- I keep only the suffix minima vector. The prefix maximum is tracked during the final scan, which removes one unnecessary allocation while staying explicit.
- The function returns `i32` to match the LeetCode-style index return value, including `-1` when no stable index exists.

## Running Tests

```bash
cargo test
```
