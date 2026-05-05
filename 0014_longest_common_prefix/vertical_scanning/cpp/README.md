# Longest Common Prefix - Vertical Scanning (C++)

## Language Features Used
- **std::vector** and **std::string**: Standard containers.
- **std::string::substr**: To extract the common prefix.
- **Loops**: Nested loops for vertical scanning.

## Implementation Decisions
- **Early Exit**: The vertical scanning approach is naturally efficient in C++ as it minimizes memory allocations by only calling `substr` once at the end.

## Run Tests
```bash
g++ -std=c++17 solution.cpp -o solution && ./solution
```
