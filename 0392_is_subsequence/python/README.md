# Python Solution

## Language Features Used

- **`for ch in t`** — iterates directly over characters in the string, no index needed for `t`
- **Short-circuit with `i < len(s)`** — stops comparing once all characters of `s` have been matched
- **Type hints** (`str`, `-> bool`) — standard Python type annotations

## Implementation Decisions

- **Single pointer + `for` loop vs two explicit pointers**: since we always advance through `t` one character at a time, a `for` loop over `t` is cleaner than managing a `j` pointer. We only need an explicit pointer `i` for `s`.
- **No early return**: we could `return True` as soon as `i == len(s)` inside the loop, but the loop naturally terminates quickly after all matches, and the single return at the end is simpler.

## Visualization

`visualize.py` prints a step-by-step table showing each comparison between `s[i]` and `t[j]`, whether they match, and progress toward full match:

```bash
python3 visualize.py
```

## Running Tests

```bash
python3 -m pytest solution_test.py -v
```

Uses `@pytest.mark.parametrize` for table-driven tests with 10 cases including edge cases.

## Follow-up Solution (`solution_followup.py`)

`SubsequenceChecker` preprocesses `t` into an index map, then answers queries with binary search.

### Language Features Used

- **`collections.defaultdict(list)`** — auto-creates empty lists for unseen keys during preprocessing
- **`bisect.bisect_left`** — standard library binary search; returns insertion point for the target value in a sorted list
- **Class-based API** — `SubsequenceChecker(t)` stores the index map, `.is_subsequence(s)` answers queries

### Running Follow-up Tests

```bash
python3 -m pytest solution_followup_test.py -v
```
