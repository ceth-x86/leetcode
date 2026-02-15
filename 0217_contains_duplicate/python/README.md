# Python Solution

## Language Features Used

- **Type hints** (`list[int]`, `set[int]`, `-> bool`) — built-in generic syntax available since Python 3.9, no `typing` import needed
- **`set`** — Python's built-in hash set backed by a hash table; `in` operator and `.add()` are O(1) average
- **Early return** — idiomatic Python pattern to exit as soon as the answer is known

## Implementation Decisions

- **Explicit loop over `len(nums) != len(set(nums))`**: the one-liner `len(nums) != len(set(nums))` is more concise but always processes the entire array. The explicit loop allows early exit on the first duplicate, which is faster in the average case.
- **`set()` vs `dict`**: both provide O(1) lookup, but `set` is semantically correct here — we only need membership, not key-value mapping.

## Visualization

`visualize.py` prints a step-by-step table showing the set state at each iteration:

```bash
python3 visualize.py
```

## Running Tests

```bash
python3 -m pytest solution_test.py -v
```

Uses `@pytest.mark.parametrize` for table-driven tests with 9 cases including edge cases and a large input (100k elements).
