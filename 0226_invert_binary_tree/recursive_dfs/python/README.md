# Python Solution

## Language Features Used

- **`dataclass`** for a compact `TreeNode` definition.
- **Union type syntax** (`TreeNode | None`) for nullable children.
- **Recursive function** to mirror the tree structure directly.

## Implementation Decisions

- The function mutates the input tree in place, matching LeetCode's expected behavior.
- The recursive calls return inverted subtrees, then the current node swaps them.
- `visualize.py` prints a recursive trace of visits and swaps.

## Visualization

```bash
python3 visualize.py
```

## Running Tests

```bash
python3 -m pytest solution_test.py -v
```
