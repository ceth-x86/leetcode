# Python Solution

## Language Features Used

- **`set[str]`** for `seen` and `repeated` windows with average O(1) membership checks
- **String slicing** (`s[start:start + 10]`) to extract each DNA window directly
- **Type hints** for the function signature and local containers

## Implementation Decisions

- This version optimizes for clarity: each 10-character substring is materialized and stored directly.
- The result keeps first-repeat discovery order by appending only when a window becomes repeated for the first time.
- A separate `repeated` set prevents duplicates in the output list.

## Running Tests

```bash
python3 -m pytest solution_test.py -v
```
