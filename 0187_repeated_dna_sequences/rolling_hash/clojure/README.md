# Clojure Solution

## Language Features Used

- **Bit operations** with `bit-shift-left`, `bit-or`, and `bit-and`
- **Persistent sets** for encoded windows that were seen or repeated
- **`loop` / `recur`** to keep the scan iterative and allocation-aware

## Implementation Decisions

- Each DNA character is encoded into 2 bits and folded into a 20-bit rolling integer.
- The inner loop stores integer hashes instead of strings, matching the intent of the rolling-hash approach.
- A substring is materialized only when the corresponding hash becomes repeated for the first time.

## Running Tests

```bash
clj -M -e "(require '[clojure.test :refer [run-tests]]) (load-file \"src/solution.clj\") (load-file \"test/solution_test.clj\") (run-tests 'solution-test)"
```
