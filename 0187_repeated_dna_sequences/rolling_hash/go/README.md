# Go Solution

## Language Features Used

- **Bit shifts and masks** on `int` values for the rolling window
- **Maps as sets** with `map[int]struct{}` for compact hash storage
- **Table-driven tests** with normalized slice comparisons

## Implementation Decisions

- `encode` maps each nucleotide to 2 bits, so a full DNA window fits in 20 bits.
- This avoids storing all 10-character fragments in the `seen` set.
- The original substring is sliced from `s` only when a repeated hash is discovered for the first time.

## Running Tests

```bash
go test -v
```
