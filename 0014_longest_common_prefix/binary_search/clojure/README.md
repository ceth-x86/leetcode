# Longest Common Prefix - Binary Search (Clojure)

## Language Features Used
- **apply min**: To find the smallest string length.
- **loop/recur**: For binary search implementation.
- **subs**: To extract prefix.

## Implementation Decisions
- Standard binary search on length.

## Run Tests
```bash
clj -M -e "(require '[clojure.test :refer [run-tests]]) (load-file \"src/solution.clj\") (load-file \"test/solution_test.clj\") (run-tests 'solution-test)"
```
