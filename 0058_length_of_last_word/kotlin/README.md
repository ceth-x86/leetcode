# Kotlin Solution

## Language Features Used

- **String indexing** for direct reverse scanning.
- **Mutable index variable** to avoid allocating split arrays or trimmed strings.
- **Top-level function** for a compact LeetCode-style solution.

## Implementation Decisions

- The first loop skips trailing spaces.
- The second loop counts the final word by moving left until a space or start of string.
- Tests use only Kotlin standard library assertions.

## Running Tests

```bash
kotlinc solution.kt solution_test.kt -include-runtime -d solution.jar && kotlin solution.jar
```
