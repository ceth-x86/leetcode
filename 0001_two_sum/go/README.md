# Go Solution

## Language Features Used

- **`map[int]int`** — Go's built-in hash map; maps values to their indices
- **Comma-ok idiom** — `j, exists := seen[complement]` returns both the value and a boolean indicating if the key exists
- **`make(map[int]int, len(nums))`** — pre-allocates map capacity to reduce rehashing
- **`reflect.DeepEqual`** — used in tests to compare slices, since Go has no built-in slice equality operator

## Implementation Decisions

- **`map[int]int` vs `map[int]struct{}`**: unlike Contains Duplicate where we only need membership, Two Sum needs to store each value's index, so `map[int]int` is the natural choice.
- **Unexported function** (`twoSum`): uses camelCase per Go convention since this is a package-internal function.
- **Table-driven tests** with `t.Run`: standard Go testing pattern with named subtests.

## Running Tests

```bash
go test -v
```
