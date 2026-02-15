# Rust Solution

## Language Features Used

- **`&[i32]` (slice reference)** — borrows the data without taking ownership; more flexible than `Vec<i32>` since it accepts both vectors and arrays
- **`HashSet::with_capacity`** — pre-allocates to avoid reallocations during growth
- **`Iterator::any`** — short-circuit iterator adapter that returns `true` on the first element satisfying the predicate; replaces an explicit loop
- **`HashSet::insert` returns `bool`** — returns `false` if the value was already present, `true` if newly inserted. `!seen.insert(num)` is `true` when a duplicate is found.
- **`#[cfg(test)]` module** — Rust's built-in conditional compilation for tests, compiled only during `cargo test`

## Implementation Decisions

- **`nums.iter().any(|num| !seen.insert(num))`**: this is idiomatic Rust — iterator combinators are preferred over manual `for` loops when they express intent clearly. `any()` provides early exit on the first duplicate, same as an explicit loop with `return`.
- **`&[i32]` vs `Vec<i32>`**: taking a slice reference is more idiomatic because it doesn't require ownership transfer and works with any contiguous collection.
- **Mutable `HashSet` inside closure**: the closure captures `seen` by mutable reference. This is safe because `any()` processes elements sequentially.

## Running Tests

```bash
cargo test
```
