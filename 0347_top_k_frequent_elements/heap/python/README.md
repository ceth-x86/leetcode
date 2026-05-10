# Top K Frequent Elements - Heap Approach (Python)

## Language Features Used
- **`heapq`**: Python's built-in min-heap implementation.
- **`collections.Counter`**: For frequency counting.

## Implementation Decisions
- **Min-Heap**: By maintaining a min-heap of size $k$, we ensure that the smallest frequency among the "top" elements is always at the root. When the heap exceeds size $k$, we pop the smallest, leaving only the $k$ largest frequencies.

## Run Tests
```bash
python3 solution_test.py
```
