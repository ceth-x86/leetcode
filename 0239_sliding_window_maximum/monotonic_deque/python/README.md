# Python Solution

## Language Features Used

- **`collections.deque`** for O(1) pushes and pops at both ends
- **Type hints** for the function signature and deque contents
- **List accumulation** for the result sequence

## Implementation Decisions

- The deque stores indices, not values, so the code can both compare `nums[...]` and detect expired window entries.
- The back-pop condition uses `<=` so equal values keep the newer index, which stays valid longer.
- This is the canonical optimal solution for the problem in Python.

## Running Tests

```bash
python3 -m pytest solution_test.py -v
```
