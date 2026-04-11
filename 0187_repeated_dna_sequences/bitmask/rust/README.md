# Rust Solution

## Language Features Used

- **`Vec<u32>`** for the precomputed encoded nucleotides
- **Bitwise operations** on `u32` for window updates
- **`HashSet`** for seen bitmasks and repeated strings

## Implementation Decisions

- This variant keeps the “first window in `O(L)`, rest in `O(1)`” structure explicit.
- Precomputing `nums` makes the bit-level derivation easy to read and compare with standard explanations of the problem.
- Output is collected from a set because the problem does not require a stable order.

## Running Tests

```bash
cargo test
```
