# Rust Solution

## Language Features Used

- **Borrowed slice** (`&[i32]`) so the function does not take ownership.
- **`Vec<i32>`** to store one prefix minimum per input price.
- **Iterator `zip` and `map`** to evaluate each sell-day profit against its precomputed buy price.
- **`#[cfg(test)]` module** for colocated unit tests.

## Implementation Decisions

- `prefix_min[0]` is initialized from `prices[0]` because the constraints guarantee a non-empty input.
- The crate name includes the approach name to avoid ambiguity with other Rust solutions for the same problem.
- `.unwrap_or(0)` keeps the final iterator expression total, even though the input cannot be empty under the constraints.

## Running Tests

```bash
cargo test
```
