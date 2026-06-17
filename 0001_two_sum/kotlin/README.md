# Kotlin Solution

## Language Features Used

- **`IntArray`** for LeetCode-style integer arrays.
- **Mutable map** (`mutableMapOf<Int, Int>()`) for value-to-index lookup.
- **`withIndex()`** for idiomatic indexed iteration.
- **Top-level function** matching the repository's lightweight solution style.

## Implementation Decisions

- The map stores previously seen values only, so the same element cannot be reused.
- The function returns an empty array only as a fallback; valid LeetCode inputs always contain one answer.
- Tests use Kotlin's standard `check` function and require no external test framework.

## Running Tests

```bash
kotlinc solution.kt solution_test.kt -include-runtime -d solution.jar && java -jar solution.jar
```
