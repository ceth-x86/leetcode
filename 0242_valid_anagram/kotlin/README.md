# Kotlin Solution

## Language Features Used

- **Mutable map** for character counts.
- **`getOrDefault`** for concise frequency updates.
- **Early return** when lengths differ or a count drops below zero.

## Implementation Decisions

- The implementation works for any Kotlin `Char`, not only lowercase ASCII.
- Counts are removed when they return to zero, making the final emptiness check simple.
- Tests use `check` assertions in `main`.

## Running Tests

```bash
kotlinc solution.kt solution_test.kt -include-runtime -d solution.jar && kotlin solution.jar
```
