# Longest Common Prefix - Sorting Approach (C++)

## Language Features Used
- **std::sort**: Efficient sorting from `<algorithm>`.
- **std::string::substr**: To extract the prefix.

## Implementation Decisions
- **`std::sort`**: Leverages IntroSort for $O(N \log N)$ average performance.

## Run Tests
```bash
g++ -std=c++17 solution.cpp -o solution && ./solution
```
