# Go Solution

## Language Features Used

- **`container/heap`** for the priority queue
- **Custom heap item struct** with value and index
- **Table-driven tests** with `testing`

## Implementation Decisions

- The heap is ordered by value descending, then by index descending to keep newer equal values ahead.
- Lazy cleanup removes stale entries only when they reach the heap top.
- This is a good general-purpose heap pattern, though it is not the optimal asymptotic solution here.

## Running Tests

```bash
go test -v
```
