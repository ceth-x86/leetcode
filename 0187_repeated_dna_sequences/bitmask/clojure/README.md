# Clojure Solution

## Language Features Used

- **`mapv`** for the precomputed encoded nucleotide vector
- **Bit operations** with `bit-shift-left`, `bit-or`, `bit-and`, and `bit-not`
- **Persistent sets** for seen bitmasks and repeated substrings

## Implementation Decisions

- This version follows the standard bitmask derivation very closely: build the initial window once, then shift, append, and clear the oldest 2 bits.
- `build-first-window` makes the first-window initialization explicit instead of folding it into the main loop.
- Output is accumulated in a set because duplicates should appear once and ordering is irrelevant.

## Running Tests

```bash
clj -M -e "(require '[clojure.test :refer [run-tests]]) (load-file \"src/solution.clj\") (load-file \"test/solution_test.clj\") (run-tests 'solution-test)"
```
