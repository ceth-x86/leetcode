# Top K Frequent Elements - Bucket Sort (C++)

## Language Features Used
- **`std::unordered_map`**: For $O(1)$ average frequency counting.
- **`std::vector<std::vector<int>>`**: Implementing the bucket structure.
- **Structured Bindings (C++17)**: `for (auto const& [num, freq] : counts)`.

## Run Tests
```bash
g++ -std=c++17 solution.cpp -o solution && ./solution
```
