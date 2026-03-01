# Clojure Solution

## Language Features Used

- **`loop`/`recur`** — explicit tail recursion with two index variables, equivalent to a two-pointer while loop
- **`cond`** — multi-branch conditional; checks termination conditions first, then match vs skip
- **`nth`** — indexed access into a string (returns a `char`)
- **`count`** — returns the length of a string

## Implementation Decisions

- **`loop`/`recur` vs `reduce`**: `reduce` would work by folding over `t` with `i` as the accumulator, but `loop`/`recur` with `cond` maps more directly to the two-pointer algorithm and makes the four cases (s exhausted, t exhausted, match, skip) explicit.
- **`cond` ordering**: checking `(>= i (count s))` first ensures we return `true` as soon as all characters are matched, even if `t` has remaining characters.
- **No early termination from reduce**: with `loop`/`recur`, we naturally stop when either string is exhausted. A `reduce` approach would need `reduced` for early exit.

## Running Tests

```bash
clj -M -e "(require '[clojure.test :refer [run-tests]]) (load-file \"src/solution.clj\") (load-file \"test/solution_test.clj\") (run-tests 'solution-test)"
```

## Follow-up Solution (`solution_followup.clj`)

`build-index-map` preprocesses `t` into a map of char to sorted vector of indices. `is-subsequence-followup` answers queries with binary search.

### Language Features Used

- **`reduce-kv`** — reduces over indexed collection, providing index and value; builds the char-to-indices map
- **`java.util.Collections/binarySearch`** — Java interop for binary search on the index vectors; returns negative insertion point when not found
- **`fnil`** — wraps `conj` to default to `[]` when the key is missing, avoiding nil checks
- **Separation of preprocessing and query** — `build-index-map` returns a plain map, `is-subsequence-followup` takes the map as a parameter

### Running Follow-up Tests

```bash
clj -M -e "(require '[clojure.test :refer [run-tests]]) (load-file \"src/solution_followup.clj\") (load-file \"test/solution_followup_test.clj\") (run-tests 'solution-followup-test)"
```
