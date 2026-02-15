# Go Solution

## Language Features Used

- **`map[int]struct{}`** — idiomatic Go set. Go has no built-in set type; a map with empty struct values is the standard pattern. `struct{}` takes zero bytes of storage.
- **Comma-ok idiom** — `_, exists := seen[num]; exists` is Go's pattern for checking map membership without caring about the value
- **`make(map[int]struct{}, len(nums))`** — pre-allocates map capacity to reduce rehashing

## Implementation Decisions

- **`map[int]struct{}` vs `map[int]bool`**: `struct{}` is zero-size, so the map only stores keys with no wasted space for values. `map[int]bool` works but allocates a byte per value unnecessarily.
- **Unexported function** (`containsDuplicate`): uses camelCase per Go convention since this is a package-internal function, not part of a public API.
- **Table-driven tests** with `t.Run`: standard Go testing pattern that gives named subtests and clear failure output.

## Running Tests

```bash
go test -v
```
