# Clojure Solution

## Language Features Used

- **`loop`/`recur`** — Clojure's explicit tail recursion for stateful iteration without mutation
- **Persistent hash map (`{}`)** — immutable map updated via `assoc`, creating new versions efficiently through structural sharing
- **`contains?`** — checks key existence in a map (not value membership — a common Clojure gotcha)
- **`nth`** — indexed access into a vector, needed here to pair elements with their indices
- **Destructuring in `let`** — binds multiple values from a single expression

## Implementation Decisions

- **`loop`/`recur` vs `reduce`**: `reduce` with `reduced` for early exit works but is less readable here because we need both the index and the accumulator (seen map). `loop`/`recur` makes the index and map state explicit.
- **`contains?` vs `get` with nil check**: `contains?` is more intentional — it checks for key presence. `get` would also work since `nil` is falsy, but `contains?` communicates intent better.
- **Vector return `[j i]`**: Clojure vectors are the natural choice for ordered pairs.

## Running Tests

```bash
clj -M -e "(require '[clojure.test :refer [run-tests]]) (load-file \"src/solution.clj\") (load-file \"test/solution_test.clj\") (run-tests 'solution-test)"
```
