# Kotlin Solution

## Language Features Used

- **`IntArray`** for the input numbers.
- **Mutable set** for O(1) average membership checks.
- **`add` return value** to detect duplicates concisely.

## Implementation Decisions

- The function exits early as soon as a repeated value is found.
- A set is used because only membership matters.
- Tests use Kotlin's standard `check` function.

## Running Tests

```bash
kotlinc solution.kt solution_test.kt -include-runtime -d solution.jar && java -jar solution.jar
```
