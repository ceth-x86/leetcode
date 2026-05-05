# Longest Common Prefix - Horizontal Scanning (C++)

## Language Features Used
- **std::string::find**: To check if the prefix matches at index 0.
- **std::string::substr**: To reduce the prefix length.

## Implementation Decisions
- **`find(prefix) != 0`**: Efficiently checks if the current string starts with the prefix.

## Run Tests
```bash
g++ -std=c++17 solution.cpp -o solution && ./solution
```
