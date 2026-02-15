# Clojure Solution

## Language Features Used

- **`set`** — Clojure's immutable hash set, built from a collection in O(n) time
- **`count`** — works on any collection; O(1) for vectors and sets (they cache their size)
- **`not=`** — idiomatic negated equality, reads as "not equal"
- **Pure function** — no mutation, no side effects; takes a value, returns a value

## Implementation Decisions

- **`(not= (count nums) (count (set nums)))` vs explicit `reduce`**: the declarative approach is the most idiomatic Clojure. Converting to a set and comparing sizes reads as a direct expression of the problem: "are there duplicates?" = "does the set have fewer elements than the original?". A `reduce` with `reduced` for early exit would be more performant on large inputs with early duplicates, but less readable.
- **No early exit**: unlike the imperative solutions, this always processes the entire collection. This is acceptable because Clojure's persistent hash set creation is well-optimized, and the code clarity tradeoff is worth it for this problem size (n <= 10^5).
- **`contains-duplicate?` naming**: the `?` suffix is a Clojure convention for predicate functions that return boolean values.

## Running Tests

```bash
clj -M -e "(require '[clojure.test :refer [run-tests]]) (load-file \"src/solution.clj\") (load-file \"test/solution_test.clj\") (run-tests 'solution-test)"
```
