# Clojure Solution

## Language Features Used

- **Immutable maps** to represent tree nodes in tests and solution code.
- **Recursive pure function** to return an inverted tree.
- **`clojure.test`** for unit tests.

## Implementation Decisions

- The Clojure implementation returns a new inverted tree instead of mutating nodes.
- `nil` represents an empty child.
- Test helpers convert between level-order vectors and nested maps.

## Running Tests

```bash
clj -M -e "(require '[clojure.test :refer [run-tests]]) (load-file \"src/solution.clj\") (load-file \"test/solution_test.clj\") (run-tests 'solution-test)"
```
