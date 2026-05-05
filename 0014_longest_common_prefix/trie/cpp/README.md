# Longest Common Prefix - Trie Approach (C++)

## Language Features Used
- **std::unordered_map**: To store children pointers.
- **Classes/Structs**: For Trie representation.

## Implementation Decisions
- **Dynamic Allocation**: Using `new TrieNode()` (note: in production code, smart pointers or a pool would be better for memory management).

## Run Tests
```bash
g++ -std=c++17 solution.cpp -o solution && ./solution
```
