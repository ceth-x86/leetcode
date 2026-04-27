# Python Solution

## Language Features Used

- **`heapq`** with negated values to emulate a max-heap
- **Tuples** of `(-value, index)` for heap ordering and stale-entry cleanup
- **Type hints** for clarity of heap contents and return type

## Implementation Decisions

- Python only provides a min-heap, so values are negated to make the largest value rise to the top.
- The heap stores indices as well, because old values remain in the heap until they reach the top and can be discarded lazily.
- This version is easier to derive from generic heap patterns, but it is slower than the deque solution.

## Running Tests

```bash
python3 -m pytest solution_test.py -v
```
