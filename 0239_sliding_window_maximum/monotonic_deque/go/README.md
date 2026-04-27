# Go Solution

## Language Features Used

- **Slices** to represent the deque of candidate indices
- **Table-driven tests** with the standard `testing` package
- **`slices.Equal`** for direct result comparison in tests

## Implementation Decisions

- The deque is stored as a slice of indices, which keeps the implementation compact and idiomatic.
- Front eviction and back monotonic cleanup are both expressed directly with slice reslicing.
- This is the optimal solution and the main implementation to reach for in Go.

## Running Tests

```bash
go test -v
```
