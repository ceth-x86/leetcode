# Rust Solution

## Language Features Used

- **Iterator chain** (`trim_end().bytes().rev().take_while().count()`) — functional pipeline that trims, reverses, takes non-space bytes, and counts them
- **`trim_end()`** — removes trailing whitespace, returning a `&str` slice (no allocation)
- **`bytes().rev()`** — iterates over bytes in reverse; safe for ASCII input
- **`take_while(|&b| b != b' ')`** — lazily takes bytes until a space is hit
- **`b' '`** — byte literal for space character

## Implementation Decisions

- **Iterator chain vs manual loop**: the iterator chain expresses the algorithm in a single statement — trim trailing spaces, walk backwards, count until space. It's concise, readable, and zero-allocation (trim_end returns a slice).
- **`bytes()` vs `chars()`**: since the problem guarantees ASCII, `bytes()` avoids UTF-8 decoding overhead. Each byte is one character.
- **`usize` return**: natural for Rust's `count()` which returns `usize`.

## Running Tests

```bash
cargo test
```
