# Clojure Solution

## Language Features Used

- **Pure function** (`max-profit`) with immutable data.
- **`reductions`** to produce the prefix minimum sequence.
- **`map`** to compute each sell-day profit from `prices` and `prefix-min`.
- **`apply max`** to select the best non-negative profit.
- **`clojure.test`** for standard library tests.

## Implementation Decisions

- `(rest (reductions min (first prices) prices))` yields one prefix minimum for each input price.
- `(apply max 0 ...)` guarantees the result is never negative.
- The implementation keeps the prefix-state formulation visible instead of reducing to the O(1) one-pass variant.

## Running Tests

```bash
clj -M -e "(require '[clojure.test :refer [run-tests]]) (load-file \"src/solution.clj\") (load-file \"test/solution_test.clj\") (run-tests 'solution-test)"
```
