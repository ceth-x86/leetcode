# Rust Solution

## Language Features Used

- **Byte iteration** with `s.bytes()` for fast nucleotide processing
- **Bitwise operations** on `u32` for the rolling 20-bit signature
- **Unit tests** with order-normalized comparisons

## Implementation Decisions

- The alphabet is tiny, so a full 10-character window fits comfortably in a `u32`.
- The `seen` and `repeated` sets store encoded windows rather than `String`s.
- Actual substrings are reconstructed only for final answers, which keeps the inner loop compact.

## Running Tests

```bash
cargo test
```
