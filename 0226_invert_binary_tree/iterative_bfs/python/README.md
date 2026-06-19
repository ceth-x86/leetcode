# Python Solution

## Language Features Used

- **`dataclass`** for a compact `TreeNode` definition.
- **`collections.deque`** for O(1) queue operations.
- **Tuple assignment** to swap `left` and `right`.

## Implementation Decisions

- The solution mutates the tree in place.
- Only non-null children are enqueued after each swap.
- `visualize.py` prints the queue-driven swap order.

## Visualization

```bash
python3 visualize.py
```

## Running Tests

```bash
python3 -m pytest solution_test.py -v
```
