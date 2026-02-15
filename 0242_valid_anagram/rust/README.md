# Rust Solution

## Language Features Used

- **`s.bytes().zip(t.bytes())`** — `bytes()` returns an iterator over raw bytes (`u8`). `zip` pairs elements from both iterators, enabling a single-pass approach. Zip stops at the shorter iterator, but we've already checked lengths are equal.
- **`b'a'`** — byte literal syntax for the ASCII value of `'a'`.
- **`[0i32; 26]`** — fixed-size array initialization with explicit `i32` type (counts can go negative).
- **`count.iter().all(|&c| c == 0)`** — iterator method to check all counts are zero. `all` short-circuits on the first non-zero value.
- **Pattern `|&c|`** — destructuring reference in closure parameter, equivalent to `|c| *c == 0`.

## Implementation Decisions

- **`bytes()` vs `chars()`**: `bytes()` iterates over raw `u8` values — correct and efficient for ASCII-only input. `chars()` would decode UTF-8 into `char` (Unicode scalar values), which is unnecessary here but would be needed for the Unicode follow-up.
- **`zip` for single-pass**: more idiomatic than indexing with `s.as_bytes()[i]`. Rust iterators are zero-cost abstractions — `zip` compiles to the same machine code as a manual index loop.
- **`&str` parameter type**: borrowed string slice, the standard way to accept string input in Rust without taking ownership.

## Running Tests

```bash
cargo test
```
