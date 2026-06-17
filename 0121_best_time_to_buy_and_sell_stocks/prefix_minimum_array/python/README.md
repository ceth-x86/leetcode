# Python Solution

## Language Features Used

- **Type hints** (`list[int]`, `-> int`) for the function signature.
- **List allocation** to store the prefix minimum value for each index.
- **`range` indexing** to build `prefix_min[i]` from `prefix_min[i - 1]`.
- **`zip`** to pair each price with its precomputed buy price.

## Implementation Decisions

- `prefix_min[0]` is initialized from `prices[0]` because the input is guaranteed to be non-empty.
- The implementation uses two explicit passes: one to build the prefix minimum array, one to evaluate profits.
- Same-day profit (`prices[i] - prefix_min[i]`) can be `0`; this does not violate the final answer because the algorithm never returns a negative profit.

## Visualization

`visualize.py` prints both phases: prefix minimum construction and profit evaluation.

```bash
python3 visualize.py
```

## Running Tests

```bash
python3 -m pytest solution_test.py -v
```
