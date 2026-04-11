# Go Solution

## Language Features Used

- **Slices** for the precomputed integer encoding array
- **Bit operations** for constant-time bitmask updates
- **Maps as sets** for seen bitmasks and repeated substrings

## Implementation Decisions

- This variant intentionally follows the classic bitmask exposition: precompute encoded characters, build the first window, then update subsequent windows in `O(1)`.
- It differs from the `rolling_hash` variant by separating first-window construction from later slides.
- The return slice is built from a set because answer ordering is irrelevant.

## Running Tests

```bash
go test -v
```
