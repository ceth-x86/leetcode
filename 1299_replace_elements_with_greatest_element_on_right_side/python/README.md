# Python Solution

## Language Features Used

- **Tuple swap** (`right_max, arr[i] = max(right_max, arr[i]), right_max`) — Python evaluates the right side fully before assigning, enabling simultaneous swap without a temporary variable
- **`range(len(arr) - 1, -1, -1)`** — reverse iteration by index, stepping from the last element to the first
- **Type hints** (`list[int]`, `-> list[int]`) — built-in generic syntax (Python 3.9+)
- **In-place mutation** — modifies the input list directly and returns it

## Implementation Decisions

- **Tuple swap vs temporary variable**: the tuple swap `right_max, arr[i] = max(right_max, arr[i]), right_max` computes both values on the right-hand side before any assignment. This is more Pythonic than using an explicit `tmp` variable, and eliminates any risk of using a stale value.
- **`range` vs `reversed`**: `range(len(arr) - 1, -1, -1)` gives direct index access, which we need for in-place replacement. `reversed(enumerate(arr))` would also work but is slightly less direct.

## Visualization

`visualize.py` prints a step-by-step table showing the original value, current `right_max`, the replacement, and the array state at each iteration:

```bash
python3 visualize.py
```

## Running Tests

```bash
python3 -m pytest solution_test.py -v
```

Uses `@pytest.mark.parametrize` for table-driven tests with 8 cases including edge cases.
