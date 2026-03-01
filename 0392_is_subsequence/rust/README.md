# Rust Solution

## Language Features Used

- **`chars()` iterator** — yields Unicode `char` values from a string slice; safe for any UTF-8 input
- **`Option<char>`** — uses `Some(ch)` to track the current character to match, and `None` to signal all matched
- **`is_none()`** — checks if the iterator has been exhausted (all characters matched)
- **`&str` (string slice)** — borrows string data without taking ownership

## Implementation Decisions

- **Iterator-based vs index-based**: Rust strings are UTF-8 encoded, so direct indexing (`s[i]`) is not available. Using `chars()` iterators is the idiomatic approach. We manually advance the `s` iterator with `next()` only on matches, while iterating through `t` with a `for` loop.
- **`Option<char>` as sentinel**: storing the current `s` character as `Option<char>` lets us use `None` to represent "all matched" — no separate index or length tracking needed.
- **`assert!` / `assert!(!...)` vs `assert_eq!`**: for boolean results, `assert!(result)` and `assert!(!result)` are more readable than `assert_eq!(result, true)`.

## Running Tests

```bash
cargo test
```

## Follow-up Solution (in `lib.rs`)

`SubsequenceChecker` preprocesses `t` into a `[Vec<usize>; 26]` array, then answers queries with binary search.

### Language Features Used

- **`[Vec<usize>; 26]`** with `Default::default()` — fixed-size array of vectors, initialized empty via the `Default` trait
- **`partition_point`** — Rust's built-in binary search on sorted slices; returns the index where the predicate switches from `true` to `false` (equivalent to `lower_bound`)
- **`match` on result** — pattern matching on the `partition_point` result with a guard (`idx if idx == indices.len()`) for clean control flow
