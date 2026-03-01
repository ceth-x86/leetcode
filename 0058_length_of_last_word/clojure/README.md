# Clojure Solution

## Language Features Used

- **Threading macro (`->>`)** — pipes the string through a transformation pipeline
- **`clojure.string/trimr`** — trims trailing whitespace from the string
- **`re-find`** with `#"\S+$"` — regex to match the last sequence of non-space characters; returns the matched string
- **`count`** — returns the length of the matched string

## Implementation Decisions

- **Regex vs manual index scan**: Clojure strings are Java strings without efficient reverse indexing. The regex `\S+$` directly expresses "last word" and leverages the regex engine's optimized matching. `trimr` handles trailing spaces so `\S+$` always matches.
- **`trimr` + `re-find` vs `split`**: `(last (str/split s #"\s+"))` works but creates a vector of all words. The regex approach avoids intermediate allocations for words we don't need.
- **Pipeline readability**: the `->>` threading macro makes the three-step process (trim, find, count) read top-to-bottom.

## Running Tests

```bash
clj -M -e "(require '[clojure.test :refer [run-tests]]) (load-file \"src/solution.clj\") (load-file \"test/solution_test.clj\") (run-tests 'solution-test)"
```
