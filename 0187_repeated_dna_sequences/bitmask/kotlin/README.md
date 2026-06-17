# Kotlin Solution

## Language Features Used

- **Integer bit operations** (`shl`, `or`, `and`, `inv`) to encode DNA windows compactly.
- **Maps** for character-to-bit encoding.
- **Mutable sets** to track seen and repeated windows.
- **`linkedSetOf`** to avoid duplicate output while preserving discovery order.

## Implementation Decisions

- Each DNA character is encoded in two bits.
- The bitmask is updated incrementally after the first 10-character window.
- Tests use a simple executable `main` with `check` assertions.

## Running Tests

```bash
kotlinc solution.kt solution_test.kt -include-runtime -d solution.jar && java -jar solution.jar
```
