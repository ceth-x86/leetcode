# Clojure Solution

## Language Features Used

- **Vectors** as a compact deque representation
- **`loop` / `recur`** for efficient iterative processing
- **Pure helper functions** to expire old indices and maintain decreasing order

## Implementation Decisions

- A vector works well here because we need `first`, `peek`, `pop`, `conj`, and occasional `subvec` from the front.
- The helpers separate the two deque invariants: remove expired indices, then remove smaller trailing values.
- This is the optimal monotonic-queue version expressed in a mostly functional style.

## Running Tests

```bash
clj -M -e "(require '[clojure.test :refer [run-tests]]) (load-file \"src/solution.clj\") (load-file \"test/solution_test.clj\") (run-tests 'solution-test)"
```
