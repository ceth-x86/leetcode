# Clojure Solution

## Language Features Used

- **Pure function** (`max-profit`) with immutable inputs.
- **`reduce`** to carry the running minimum and best profit through the sequence.
- **Vector destructuring** (`[min-price best-profit]`) to keep the reducer state readable.
- **`clojure.test`** for standard library unit tests.

## Implementation Decisions

- The reducer state is `[min-price best-profit]`.
- Candidate profit is computed with the previous `min-price`, then the state stores the updated minimum.
- `(first prices)` is valid because the problem guarantees at least one price.

## Running Tests

```bash
clj -M -e "(require '[clojure.test :refer [run-tests]]) (load-file \"src/solution.clj\") (load-file \"test/solution_test.clj\") (run-tests 'solution-test)"
```
