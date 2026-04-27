# Python Solution

## Language Features Used

- `list[int]` type hints for clear input and output contracts.
- A preallocated Python list for `suffix_min` and one running `prefix_max` variable.
- A simple left-to-right and right-to-left pass that maps directly to the problem statement.

## Implementation Decisions

- The implementation stores only `suffix_min`. The left-side maximum is tracked incrementally in `prefix_max`, which keeps the code simple and reduces extra memory.
- The function returns as soon as it finds the first stable index, which matches the problem requirement exactly.

## Visualization

`visualize.py` prints the suffix minima, the running prefix maximum, and the instability score at each index.

```bash
python3 visualize.py
```

## Running Tests

```bash
python3 -m pytest solution_test.py -v
```
