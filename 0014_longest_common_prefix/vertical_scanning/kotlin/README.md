# Kotlin Solution

## Language Features Used

- **String indices** to scan columns of the first string.
- **Nested loops** for direct character comparison.
- **Early return** when a mismatch or shorter string is found.

## Implementation Decisions

- The first string is used as the reference.
- The scan stops as soon as any string fails the current character.
- Tests use Kotlin standard `check` assertions.

## Running Tests

```bash
kotlinc solution.kt solution_test.kt -include-runtime -d solution.jar && java -jar solution.jar
```
