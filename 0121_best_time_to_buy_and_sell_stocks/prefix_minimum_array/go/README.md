# Go Solution

## Language Features Used

- **Slices** for the input and prefix minimum array.
- **`make([]int, len(prices))`** to allocate one prefix value per day.
- **Indexed `for` loops** to express `prefixMin[i]` from `prefixMin[i-1]`.
- **Table-driven tests** with `t.Run`.

## Implementation Decisions

- The function is unexported (`maxProfit`) because it is tested inside the same package.
- `prefixMin[0]` is initialized from `prices[0]`; LeetCode guarantees the input is non-empty.
- Explicit comparisons avoid introducing helper functions just for `min` and `max`.

## Running Tests

```bash
go test -v
```
