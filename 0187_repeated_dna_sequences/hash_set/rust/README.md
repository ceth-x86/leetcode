# Rust Solution

## Language Features Used

- **`HashSet<String>`** for direct storage of 10-character fragments
- **Slices** (`&s[start..start + 10]`) for window access before cloning only when needed
- **Unit tests** inside `#[cfg(test)]` modules

## Implementation Decisions

- This variant favors straightforward code over minimizing allocations.
- Windows are cloned into owned `String`s only when stored in `seen` or returned in `result`.
- The result preserves first-repeat discovery order while tests normalize order before comparison.

## Running Tests

```bash
cargo test
```
