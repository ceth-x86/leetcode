# Longest Common Prefix - Sorting Approach (Python)

## Language Features Used
- **list.sort()**: To sort strings lexicographically.
- **Indexing**: To access first and last strings.

## Implementation Decisions
- **Sorting Efficiency**: Sorting takes $O(N \log N)$ comparisons. In each comparison, we might look at $K$ characters.
- **LCP Logic**: Only comparing the first and last elements after sorting is sufficient because any common prefix among all elements must be shared by the two most distant elements in sorted order.

## Run Tests
```bash
python3 solution_test.py
```
