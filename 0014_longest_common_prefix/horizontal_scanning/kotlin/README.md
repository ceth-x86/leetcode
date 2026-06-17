# Kotlin Solution

## Language Features Used

- **Class `Solution`** for the LeetCode-style method.
- **Mutable local `prefix`** to shrink the candidate prefix.
- **`startsWith`** for direct prefix checks.
- **`dropLast(1)`** to shorten the current prefix.

## Implementation Decisions

- The first string starts as the candidate prefix.
- The prefix is reduced until every string starts with it.
- Tests use Kotlin standard assertions in `main`.

## Running Tests

```bash
kotlinc solution.kt solution_test.kt -include-runtime -d solution.jar && java -jar solution.jar
```
