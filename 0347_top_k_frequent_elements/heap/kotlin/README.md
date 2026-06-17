# Kotlin Solution

## Language Features Used

- **Mutable map** for frequency counting.
- **`PriorityQueue`** as a min-heap of `(frequency, value)` pairs.
- **`Pair`** for compact heap entries.

## Implementation Decisions

- The heap is capped at size `k`.
- Removing the smallest frequency keeps only the top candidates.
- Tests compare sorted results because output order is not semantically important.

## Running Tests

```bash
kotlinc solution.kt solution_test.kt -include-runtime -d solution.jar && kotlin solution.jar
```
