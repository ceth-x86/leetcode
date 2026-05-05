# Longest Common Prefix - Vertical Scanning (Python)

## Language Features Used
- **List Iteration**: Iterating through strings and characters.
- **Slicing**: Returning the substring prefix.
- **Type Hints**: For better code clarity.

## Implementation Decisions
- **Vertical Scanning**: I chose vertical scanning because it allows us to return early as soon as a mismatch is found, potentially avoiding processing the full length of all strings if the common prefix is short.

## Run Tests
```bash
python3 solution_test.py
```
