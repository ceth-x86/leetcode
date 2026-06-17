# Kotlin Solution

## Language Features Used

- **Private helper classes** for `Trie` and `TrieNode`.
- **Mutable maps** for trie children.
- **`getOrPut`** for concise child insertion.
- **`StringBuilder`** for efficient prefix construction.

## Implementation Decisions

- Empty strings are handled before inserting into the trie.
- Traversal continues only while the current node has exactly one child and is not a word ending.
- Tests use a small `main` function with standard `check` assertions.

## Running Tests

```bash
kotlinc solution.kt solution_test.kt -include-runtime -d solution.jar && kotlin solution.jar
```
