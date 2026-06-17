# Kotlin Solution

## Language Features Used

- **`substring`** to extract each 10-character DNA window.
- **Mutable sets** for seen and already-reported windows.
- **Mutable list** for ordered results.

## Implementation Decisions

- A repeated sequence is appended only once, even if it appears many times.
- This approach stores string windows directly, favoring clarity over compact encoding.
- Tests use Kotlin standard `check` assertions.

## Running Tests

```bash
kotlinc solution.kt solution_test.kt -include-runtime -d solution.jar && java -jar solution.jar
```
