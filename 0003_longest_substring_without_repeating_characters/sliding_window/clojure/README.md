# Clojure Solution

## Language Features Used

- **`reduce`** to carry sliding-window state.
- **`map-indexed`** to pair each character with its index.
- **Immutable maps** for `last-seen` state.
- **`clojure.test`** for tests.

## Implementation Decisions

- The reducer state contains `left`, `best`, and `last-seen`.
- `left` only advances when a repeated character is still inside the current window.
- The function remains pure: each step returns a new state map.

## Running Tests

```bash
clj -M -e "(require '[clojure.test :refer [run-tests]]) (load-file \"src/solution.clj\") (load-file \"test/solution_test.clj\") (run-tests 'solution-test)"
```
