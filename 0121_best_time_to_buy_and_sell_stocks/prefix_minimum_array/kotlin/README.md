# Kotlin Solution

## Language Features Used

- **`IntArray`** for both prices and prefix minimums.
- **Indexed loops** for the explicit DP transition.
- **`minOf` and `maxOf`** for prefix and profit updates.

## Implementation Decisions

- `prefixMin[i]` stores the lowest buy price available through day `i`.
- The solution intentionally uses O(n) extra space to show the prefix-state formulation.
- Tests use only the Kotlin standard library.

## Running Tests

```bash
kotlinc solution.kt solution_test.kt -include-runtime -d solution.jar && java -jar solution.jar
```
