# Clojure Solution

## Language Features Used

- **Threading macro (`->>`)** — pipes the array through a series of transformations for clear data flow
- **`reverse`** — processes elements right-to-left by reversing the sequence first
- **`reduce`** with tuple accumulator — carries both the result list and running maximum through the fold
- **`cons`** — prepends each replacement value to the result list, naturally rebuilding left-to-right order
- **Destructuring** (`[result right-max]`) — unpacks the accumulator tuple in the reducing function

## Implementation Decisions

- **`reduce` over reversed sequence vs `loop`/`recur` with index**: the `reduce` approach is more functional — it avoids explicit indexing and builds the result through composition. `cons` to a list naturally reverses the reversal, producing the correct output order.
- **Tuple accumulator `[result right-max]`**: `reduce` carries both the growing result and the running maximum as a pair. This keeps the reduction pure — no mutation needed.
- **`vec` at the end**: converts the final list to a vector for consistent comparison in tests.

## Running Tests

```bash
clj -M -e "(require '[clojure.test :refer [run-tests]]) (load-file \"src/solution.clj\") (load-file \"test/solution_test.clj\") (run-tests 'solution-test)"
```
