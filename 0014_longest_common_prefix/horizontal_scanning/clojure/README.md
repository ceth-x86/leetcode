# Longest Common Prefix - Horizontal Scanning (Clojure)

## Language Features Used
- **reduce**: To process strings one by one against the current prefix.
- **loop/recur**: To shorten the prefix.
- **clojure.string/starts-with?**: For prefix checking.

## Implementation Decisions
- **Reduce Approach**: Naturally expresses the horizontal scanning algorithm.

## Run Tests
```bash
clj -M -e "(require '[clojure.test :refer [run-tests]]) (load-file \"src/solution.clj\") (load-file \"test/solution_test.clj\") (run-tests 'solution-test)"
```
