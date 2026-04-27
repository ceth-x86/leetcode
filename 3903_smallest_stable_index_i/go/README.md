# Go Solution

## Language Features Used

- Slices for the input and the `suffixMin` preprocessing array.
- Straightforward indexed loops, which are the clearest fit for prefix and suffix table construction in Go.
- Table-driven tests with `t.Run`, consistent with the rest of the repository.

## Implementation Decisions

- The solution keeps only `suffixMin`. The left-side maximum is maintained incrementally in one integer variable during the final scan.
- The implementation returns on the first stable index rather than storing a candidate and continuing unnecessarily.

## Running Tests

```bash
go test -v
```
