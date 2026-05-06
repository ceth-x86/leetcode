# Group Anagrams - Frequency Map Approach (Python)

## Language Features Used
- **`collections.defaultdict`**: For grouping anagrams.
- **`ord()`**: To calculate character indices in the frequency array.
- **`tuple()`**: To convert a list into a hashable key for the dictionary.

## Implementation Decisions
- **Linear Time Complexity**: Character counting is $O(K)$, avoiding the $O(K \log K)$ overhead of sorting. Total complexity is $O(N \cdot K)$.

## Run Tests
```bash
python3 solution_test.py
```
