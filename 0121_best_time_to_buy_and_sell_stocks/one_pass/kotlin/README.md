# Kotlin Solution

## Language Features Used

- **`IntArray`** for prices.
- **`maxOf` and `minOf`** for constant-time state updates.
- **Top-level function** matching the existing lightweight solutions.

## Implementation Decisions

- `minPrice` starts from `prices[0]` because the input is guaranteed non-empty.
- The solution keeps only the running minimum and best profit.
- Tests use `check` assertions in `main`.

## Running Tests

```bash
kotlinc solution.kt solution_test.kt -include-runtime -d solution.jar && java -jar solution.jar
```
