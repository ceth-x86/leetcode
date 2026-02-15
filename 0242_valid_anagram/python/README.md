# Python Solution

## Language Features Used

- **`collections.Counter`** — specialized `dict` subclass for counting hashable objects. `Counter(s)` builds a frequency map in one call. Two `Counter` objects can be compared with `==` directly.
- **Type hints** (`str`, `-> bool`) — built-in types, no imports needed since Python 3.9

## Implementation Decisions

- **`Counter(s) == Counter(t)` vs manual array**: `Counter` is the idiomatic Python choice — concise, readable, and handles Unicode out of the box. A 26-element list would be slightly faster for lowercase-only input but less Pythonic.
- **Early length check**: `Counter` comparison would catch length mismatches anyway, but checking `len(s) != len(t)` first avoids building two counter objects unnecessarily.
- **No single-pass optimization**: the single-pass increment/decrement approach is used in C++/Go/Rust. In Python, `Counter` equality is cleaner and the performance difference is negligible at n <= 5*10^4.

## Visualization

`visualize.py` shows both characters processed simultaneously at each step with running frequency counts:

```bash
python3 visualize.py
```

## Running Tests

```bash
python3 -m pytest solution_test.py -v
```
