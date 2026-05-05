# Longest Common Prefix - Sorting Approach (Clojure)

## Language Features Used
- **sort**: Standard sorting function.
- **loop/recur**: For manual index comparison.

## Implementation Decisions
- **Immutable Sort**: Clojure's `sort` returns a new sorted sequence, maintaining immutability.

## Run Tests
```bash
clj -M -e "(require '[clojure.test :refer [run-tests]]) (load-file \"src/solution.clj\") (load-file \"test/solution_test.clj\") (run-tests 'solution-test)"
```
