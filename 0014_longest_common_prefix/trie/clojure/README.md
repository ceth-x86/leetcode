# Longest Common Prefix - Trie Approach (Clojure)

## Language Features Used
- **Maps**: To represent Trie nodes.
- **Recursive functions**: To insert words into the Trie.
- **loop/recur**: To find the common prefix.

## Implementation Decisions
- **Immutable Maps**: The Trie is built using nested maps. Each key (character) points to another map (node).

## Run Tests
```bash
clj -M -e "(require '[clojure.test :refer [run-tests]]) (load-file \"src/solution.clj\") (load-file \"test/solution_test.clj\") (run-tests 'solution-test)"
```
