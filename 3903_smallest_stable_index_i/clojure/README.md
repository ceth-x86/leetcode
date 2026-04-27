# Clojure Solution

## Language Features Used

- A persistent vector for suffix minima plus a running prefix maximum.
- `loop` and `recur` for efficient indexed traversal without mutable loops.
- A small `clojure.test` test suite consistent with the repository's existing Clojure setup.

## Implementation Decisions

- The implementation stores only the suffix minima vector. The prefix maximum is updated while scanning from left to right, so the solution stays `O(n)` with less auxiliary state.
- The code uses vectors and indexed access because this problem is naturally about positions, not lazy sequence processing.

## Running Tests

```bash
clj -M -e "(require '[clojure.test :refer [run-tests]]) (load-file \"src/solution.clj\") (load-file \"test/solution_test.clj\") (run-tests 'solution-test)"
```
