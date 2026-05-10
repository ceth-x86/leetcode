# Top K Frequent Elements - Bucket Sort (Clojure)

## Language Features Used
- **`frequencies`**: Standard library function for frequency counting.
- **`reduce` and `update`**: To build the bucket map.
- **`loop/recur`**: For efficient iteration over frequencies.

## Run Tests
```bash
clj -M -e "(require '[clojure.test :refer [run-tests]]) (load-file \"src/solution.clj\") (load-file \"test/solution_test.clj\") (run-tests 'solution-test)"
```
