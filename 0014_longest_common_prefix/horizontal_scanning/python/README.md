# Longest Common Prefix - Horizontal Scanning (Python)

## Language Features Used
- **String `startswith` method**: To check if a string begins with the current prefix.
- **Slicing**: To reduce the prefix length.

## Implementation Decisions
- **Iterative Reduction**: We start with the first string as the prefix and shorten it until it matches the next string.

## Run Tests
```bash
python3 solution_test.py
```
