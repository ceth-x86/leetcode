# Go Solution

## Language Features Used

- **Slice mutation** (`arr[i] = rightMax`) — slices are reference types in Go, so in-place modification is natural
- **Manual `max`** — Go doesn't have a built-in `max` for integers (prior to Go 1.21), so we use an `if` comparison
- **Reverse `for` loop** — `for i := len(arr) - 1; i >= 0; i--` is the idiomatic Go reverse iteration pattern

## Implementation Decisions

- **`if` vs `max()`**: while Go 1.21+ has a built-in `max`, using an explicit `if` is more universally compatible and equally readable for a two-value comparison.
- **In-place modification**: Go slices are reference types (backed by the same underlying array), so modifying `arr` in the function modifies the caller's data. We return the slice for API consistency with LeetCode.
- **Table-driven tests** with `t.Run`: standard Go testing pattern with named subtests.

## Running Tests

```bash
go test -v
```
