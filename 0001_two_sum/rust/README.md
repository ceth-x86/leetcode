# Rust Solution

## Language Features Used

- **`&[i32]` (slice reference)** — borrows the data without taking ownership; more flexible than `Vec<i32>`
- **`HashMap::with_capacity`** — pre-allocates to avoid reallocations during growth
- **`if let Some(&j)`** — pattern matching to destructure the `Option` returned by `HashMap::get`, binding the stored index
- **`enumerate()`** — iterator adapter yielding `(index, &value)` pairs
- **`&num` pattern in `for`** — destructures the reference yielded by `iter()` to get the value directly

## Implementation Decisions

- **Explicit loop over iterator combinators**: unlike Contains Duplicate where `any()` fits naturally, Two Sum needs to return two indices. An explicit `for` loop with `if let` is clearer than trying to force this into an iterator chain.
- **`i as i32` cast**: LeetCode expects `Vec<i32>` return type for indices. We store `usize` indices in the map (natural for Rust indexing) and cast on return.
- **`HashMap::get` vs `entry` API**: `get()` is simpler here since we either return immediately or insert. The `entry` API is better for "get or insert" patterns.

## Running Tests

```bash
cargo test
```
