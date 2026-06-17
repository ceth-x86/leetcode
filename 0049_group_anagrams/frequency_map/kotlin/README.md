# Kotlin Solution

## Language Features Used

- **`IntArray(26)`** to build fixed-size character frequency keys.
- **`linkedMapOf`** to group anagrams while preserving insertion order.
- **`getOrPut`** to create groups on demand.

## Implementation Decisions

- Frequency arrays are serialized with `joinToString` so they can be used as map keys.
- The implementation assumes lowercase English letters, matching the LeetCode constraints.
- Tests normalize nested lists before comparison because group order is not semantically important.

## Running Tests

```bash
kotlinc solution.kt solution_test.kt -include-runtime -d solution.jar && kotlin solution.jar
```
