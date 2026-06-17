# Kotlin Solution

## Language Features Used

- **Mutable map** for frequency counting.
- **Array of mutable lists** for frequency buckets.
- **Reverse range** (`downTo`) to collect highest frequencies first.

## Implementation Decisions

- Bucket index equals frequency.
- The function returns as soon as `k` elements are collected.
- Tests sort expected and actual results because order among equal-frequency values is not required.

## Running Tests

```bash
kotlinc solution.kt solution_test.kt -include-runtime -d solution.jar && kotlin solution.jar
```
