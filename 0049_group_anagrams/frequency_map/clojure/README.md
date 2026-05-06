# Group Anagrams - Frequency Map Approach (Clojure)

## Language Features Used
- **`group-by`**: Using a custom frequency map as the grouping key.
- **`reduce` and `update`**: To build character frequency maps.
- **`fnil`**: To handle initial `nil` values in the frequency map.

## Run Tests
```bash
clj -M -e "(require '[clojure.test :refer [run-tests]]) (load-file \"src/solution.clj\") (load-file \"test/solution_test.clj\") (run-tests 'solution-test)"
```
