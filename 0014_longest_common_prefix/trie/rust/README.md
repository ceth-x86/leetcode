# Longest Common Prefix - Trie Approach (Rust)

## Language Features Used
- **HashMap**: To store children.
- **Mutable References**: To traverse and build the Trie.

## Implementation Decisions
- **Ownership**: The Trie is built manually. Rust's borrow checker requires careful handling of references when traversing down the tree.

## Run Tests
```bash
cargo test
```
