# Clojure Solution

## Language Features Used

- **Persistent sets** for `seen` and `repeated`
- **`loop` / `recur`** for an efficient iterative scan without mutable state
- **Vectors** for stable output order

## Implementation Decisions

- Each 10-character window is extracted with `subs`, which keeps the code close to the problem statement.
- `repeated` avoids emitting the same fragment multiple times.
- Tests compare sets when output order is irrelevant and vectors when a single deterministic item is expected.

## Running Tests

```bash
clj -M -e "(require '[clojure.test :refer [run-tests]]) (load-file \"src/solution.clj\") (load-file \"test/solution_test.clj\") (run-tests 'solution-test)"
```
