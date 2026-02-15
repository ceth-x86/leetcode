# Python Solution

## Language Features Used

- **Type hints** (`list[int]`, `dict[int, int]`, `-> list[int]`) — built-in generic syntax available since Python 3.9
- **`dict`** — Python's built-in hash map; `in` operator is O(1) average for key lookup
- **`enumerate`** — yields `(index, value)` pairs, avoiding manual index tracking
- **Early return** — exits as soon as the complement is found

## Implementation Decisions

- **Single-pass hash map**: we check for the complement *before* storing the current element. This naturally handles the "don't use the same element twice" constraint — when we look up the complement, it can only be an element from an earlier index.
- **`dict` vs two-pass approach**: a two-pass approach (build map first, then search) works but requires an extra pass. The single-pass approach finds the answer as early as possible.

## Visualization

`visualize.py` prints a step-by-step table showing the complement, action, and map state at each iteration:

```bash
python3 visualize.py
```

## Running Tests

```bash
python3 -m pytest solution_test.py -v
```

Uses `@pytest.mark.parametrize` for table-driven tests with 8 cases including edge cases.
