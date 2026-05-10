# Top K Frequent Elements - Heap Approach (Clojure)

## Language Features Used
- **Java Interop**: Using `java.util.PriorityQueue` for the heap.
- **`reify`**: To implement the `java.util.Comparator` interface.
- **`frequencies`**: Standard library frequency counting.

## Run Tests
```bash
clj -M -e "(require '[clojure.test :refer [run-tests]]) (load-file \"src/solution.clj\") (load-file \"test/solution_test.clj\") (run-tests 'solution-test)"
```
