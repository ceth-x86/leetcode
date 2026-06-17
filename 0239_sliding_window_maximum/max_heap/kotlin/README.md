# Kotlin Solution

## Language Features Used

- **`PriorityQueue`** from the Java standard library for max-heap behavior.
- **Comparator composition** to order by value descending.
- **`IntArray` pairs** storing `[value, index]`.

## Implementation Decisions

- Stale heap entries are removed when their index falls outside the current window.
- Results are accumulated in a list and converted to `IntArray` at the end.
- Tests compare arrays with `contentEquals`.

## Running Tests

```bash
kotlinc solution.kt solution_test.kt -include-runtime -d solution.jar && kotlin solution.jar
```
