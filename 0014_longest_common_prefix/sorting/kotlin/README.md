# Kotlin Solution

## Language Features Used

- **`Array.sort()`** for lexicographic ordering.
- **`first()` and `last()`** to inspect the only two strings needed after sorting.
- **String indexing** for character-by-character comparison.

## Implementation Decisions

- Sorting mutates the input array, matching the approach used in the existing solution.
- The common prefix of all strings is the common prefix of the sorted first and last strings.
- Tests use simple `check` assertions.

## Running Tests

```bash
kotlinc solution.kt solution_test.kt -include-runtime -d solution.jar && java -jar solution.jar
```
