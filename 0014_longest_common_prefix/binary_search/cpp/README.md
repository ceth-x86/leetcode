# Longest Common Prefix - Binary Search (C++)

## Language Features Used
- **std::min**: To find min length.
- **std::string::compare**: Efficiently checking prefixes.

## Implementation Decisions
- Binary search on prefix length provides $O(S \log K)$ complexity.

## Run Tests
```bash
g++ -std=c++17 solution.cpp -o solution && ./solution
```
