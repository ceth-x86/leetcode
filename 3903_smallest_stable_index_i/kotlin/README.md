# Kotlin Solution

## Language Features Used

- **`IntArray`** for prefix/suffix numeric state.
- **Reverse loop** to build suffix minimum values.
- **`minOf` and `maxOf`** for running extrema.

## Implementation Decisions

- `suffixMin[i]` stores the minimum value from index `i` to the end.
- `prefixMax` is updated left to right before evaluating each index.
- Tests use standard `check` assertions.

## Running Tests

```bash
kotlinc solution.kt solution_test.kt -include-runtime -d solution.jar && java -jar solution.jar
```
