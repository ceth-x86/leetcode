# Kotlin Solution

## Language Features Used

- **Bit shifting and masking** for rolling hash updates.
- **`withIndex()`** for index-aware character iteration.
- **Mutable sets** for seen and repeated hashes.

## Implementation Decisions

- The rolling hash keeps only the last 20 bits, enough for a 10-character DNA window.
- The result stores substrings so callers receive the original DNA fragments.
- Tests use a no-dependency `main` function.

## Running Tests

```bash
kotlinc solution.kt solution_test.kt -include-runtime -d solution.jar && kotlin solution.jar
```
