# Clojure Solution

## Language Features Used

- **Immutable maps** for tree nodes.
- **Loop/recur** for an explicit iterative traversal.
- **Vector queue of paths** into the tree.
- **`assoc-in`** to update a node at a path after swapping children.

## Implementation Decisions

- The function returns a new inverted tree instead of mutating nodes.
- Queue entries are paths such as `[:left :right]`, which identify nodes in the immutable tree.
- Nil paths are harmless: they are skipped when dequeued.

## Running Tests

```bash
clj -M -e "(require '[clojure.test :refer [run-tests]]) (load-file \"src/solution.clj\") (load-file \"test/solution_test.clj\") (run-tests 'solution-test)"
```
