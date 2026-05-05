# Longest Common Prefix - Trie Approach (Python)

## Language Features Used
- **Classes**: To define `TrieNode` and `Trie`.
- **Dictionaries**: To store children of a node.

## Implementation Decisions
- **Child count**: Each node tracks how many children it has. A common prefix continues as long as a node has exactly one child and is not the end of any word.

## Run Tests
```bash
python3 solution_test.py
```
