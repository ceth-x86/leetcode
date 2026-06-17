# Go Solution

## Language Features Used

- **Slices** (`[]int`) for the price list.
- **Range loop** for idiomatic iteration over prices.
- **Short variable declaration in `if`** to compute and compare candidate profit in one scoped expression.
- **Table-driven tests** with `t.Run`, matching common Go testing practice.

## Implementation Decisions

- The function is unexported (`maxProfit`) because it is package-internal test code.
- `prices[0]` initializes `minPrice` because the constraints guarantee at least one price.
- Explicit comparisons are used instead of helper functions, which keeps the loop allocation-free and straightforward.

## Running Tests

```bash
go test -v
```
