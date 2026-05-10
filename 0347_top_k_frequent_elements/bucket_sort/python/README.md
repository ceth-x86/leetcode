# Top K Frequent Elements - Bucket Sort (Python)

## Language Features Used
- **`collections.Counter`**: Efficient frequency counting.
- **List Comprehension**: For bucket initialization.
- **Nested Loops with Early Exit**: To collect the results from buckets.

## Implementation Decisions
- **Bucket Array**: We use an array of lists where the index represents the frequency. This allows us to group elements by their occurrence count and retrieve them in $O(N)$ time.

## Run Tests
```bash
python3 solution_test.py
```
