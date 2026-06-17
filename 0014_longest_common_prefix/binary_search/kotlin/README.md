# Kotlin Solution

## Language Features Used

- **Class `Solution`** to match the LeetCode method style used by this problem.
- **`Array<String>`** for the input collection.
- **`minOf`** to find the binary-search upper bound.
- **`startsWith`** for prefix validation.

## Implementation Decisions

- Binary search is performed over possible prefix lengths.
- `isCommonPrefix` is private because it is an implementation detail.
- Tests use a simple `main` function with `check` assertions.

## Running Tests

```bash
kotlinc solution.kt solution_test.kt -include-runtime -d solution.jar && kotlin solution.jar
```
