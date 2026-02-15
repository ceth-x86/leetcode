# Clojure Solution

## Language Features Used

- **`frequencies`** — built-in function that returns a map from each distinct element to its count. Works on any sequence, including strings (which are sequences of characters in Clojure).
- **`and` short-circuit** — `(and (= (count s) (count t)) ...)` skips the frequency comparison if lengths differ.
- **`count` on strings** — O(1) since Java strings cache their length.
- **`anagram?` naming** — the `?` suffix is a Clojure convention for predicate functions.

## Implementation Decisions

- **`frequencies` vs manual `reduce`**: `frequencies` is the idiomatic Clojure equivalent of Python's `Counter`. It reads declaratively: "are the frequencies of s equal to the frequencies of t?". A `reduce` accumulating into a map would be more code for no benefit.
- **No array-based approach**: Clojure doesn't have mutable fixed-size arrays in the same way as C/Go/Rust. Using `frequencies` (backed by a persistent hash map) is natural. For this problem size (n <= 5*10^4), the performance difference is irrelevant.
- **Unicode-ready by default**: since `frequencies` works on any sequence of characters and Clojure strings are Java strings (UTF-16), this solution handles Unicode without modification.

## Running Tests

```bash
clj -M -e "(require '[clojure.test :refer [run-tests]]) (load-file \"src/solution.clj\") (load-file \"test/solution_test.clj\") (run-tests 'solution-test)"
```
