# Go Solution

## Language Features Used

- **Maps as sets** with `map[string]struct{}` for low-overhead membership tracking
- **Slices** to preserve discovery order in the returned result
- **Table-driven tests** using the standard `testing` package

## Implementation Decisions

- The `hash_set` variant stores each 10-character fragment directly as a string.
- `repeated` is separate from `seen` so repeated windows are appended exactly once.
- Tests sort both slices before comparison because LeetCode accepts any order.

## Running Tests

```bash
go test -v
```
