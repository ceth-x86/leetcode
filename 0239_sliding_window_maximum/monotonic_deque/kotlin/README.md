# Kotlin Solution

## Language Features Used

- **`ArrayDeque<Int>`** to store candidate indices.
- **`first`, `last`, `removeFirst`, and `removeLast`** for deque operations.
- **`withIndex()`** for index-aware iteration.

## Implementation Decisions

- The deque stores indices, not values, so stale windows can be detected.
- Values in the deque are kept in decreasing order.
- Tests use array content comparison.

## Running Tests

```bash
kotlinc solution.kt solution_test.kt -include-runtime -d solution.jar && java -jar solution.jar
```
