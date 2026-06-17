# Kotlin Solution

## Language Features Used

- **`IntArray`** for in-place replacement.
- **Reversed indices** to scan from right to left.
- **`maxOf`** for updating the running right-side maximum.

## Implementation Decisions

- The input array is mutated in place, matching the existing solution.
- `rightMax` starts at `-1`, the required replacement for the last element.
- Tests compare arrays by content.

## Running Tests

```bash
kotlinc solution.kt solution_test.kt -include-runtime -d solution.jar && java -jar solution.jar
```
