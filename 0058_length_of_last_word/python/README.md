# Python Solution

## Language Features Used

- **Index-based reverse scan** — two `while` loops scanning from the end: first skipping spaces, then counting non-space characters
- **Arithmetic length** (`end - i`) — avoids an explicit counter by computing the word length from the start and end positions
- **Type hints** (`str`, `-> int`) — standard Python type annotations

## Implementation Decisions

- **Two-phase while loop vs `str.rstrip().split()`**: `s.rstrip().split()[-1]` is a one-liner but allocates a stripped copy and a list of all words. The reverse scan uses O(1) space and stops as soon as the last word is found.
- **`end - i` vs explicit counter**: by recording `end` (the position of the last non-space character) and subtracting the final `i` (position of the space before the last word, or -1), we get the length without maintaining a separate variable.

## Visualization

`visualize.py` prints the index positions, trailing space skipping, and character-by-character counting:

```bash
python3 visualize.py
```

## Running Tests

```bash
python3 -m pytest solution_test.py -v
```

Uses `@pytest.mark.parametrize` for table-driven tests with 9 cases including edge cases.
