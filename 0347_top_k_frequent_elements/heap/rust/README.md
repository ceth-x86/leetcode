# Top K Frequent Elements - Heap Approach (Rust)

## Language Features Used
- **`std::collections::BinaryHeap`**: Standard max-heap. We implement a custom `Ord` to turn it into a min-heap.
- **`std::collections::HashMap`**: For frequency counting.
- **Traits**: `Ord`, `PartialOrd`, `Eq`, `PartialEq` to define custom heap ordering.

## Run Tests
```bash
cargo test
```
