# Longest Common Prefix - Vertical Scanning (Go)

## Language Features Used
- **Slices**: For handling arrays of strings.
- **String indexing and slicing**: Efficiently checking characters and returning the prefix.
- **Range-based testing**: Using table-driven tests.

## Implementation Decisions
- **Byte indexing**: Since the problem constraints specify only lowercase English letters, we can safely use byte indexing `strs[0][i]` for performance.

## Run Tests
```bash
go test ./...
```
