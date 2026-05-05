# Longest Common Prefix - Vertical Scanning (Clojure)

## Language Features Used
- **loop/recur**: For manual iteration.
- **every?**: To check a condition across all strings in the list.
- **subs**: For string slicing.

## Implementation Decisions
- **Functional Approach**: While using `loop/recur`, the solution remains pure and leverages Clojure's sequence abstractions.

## Run Tests
```bash
clj -M -e "(require '[clojure.test :refer [run-tests]]) (load-file \"src/solution.clj\") (load-file \"test/solution_test.clj\") (run-tests 'solution-test)"
```
