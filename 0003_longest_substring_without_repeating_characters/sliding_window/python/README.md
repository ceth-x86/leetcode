# Python Solution

## Language Features Used

- **Type hints** (`str`, `dict[str, int]`, `-> int`) for a clear function contract.
- **Dictionary** for last-seen character positions.
- **`enumerate`** for index-aware iteration.
- **String slicing** in `visualize.py` to display the active window.

## Implementation Decisions

- `left` only moves forward, which keeps the algorithm O(n).
- Repeated characters older than `left` are ignored because they are outside the current window.
- The implementation treats all characters, including spaces and symbols, uniformly.

## Visualization

```bash
python3 visualize.py
```

## Running Tests

```bash
python3 -m pytest solution_test.py -v
```
