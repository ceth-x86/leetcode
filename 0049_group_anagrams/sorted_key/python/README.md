# Group Anagrams - Sorted Key Approach (Python)

## Language Features Used
- **`collections.defaultdict`**: To simplify dictionary management without manual key checks.
- **`sorted()`**: Efficiently sorts strings to create a canonical key.
- **`"".join()`**: Converts a list of characters back into a string for use as a dictionary key.

## Implementation Decisions
- **Canonical Key**: Sorting is an $O(K \log K)$ operation (where $K$ is string length), which is efficient enough given the constraints ($K \le 100$).

## Run Tests
```bash
python3 solution_test.py
```
