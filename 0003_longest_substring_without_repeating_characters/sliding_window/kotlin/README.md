# Kotlin Solution

## Language Features Used

- **Mutable map** for last-seen character positions.
- **`withIndex()`** for index-aware string iteration.
- **`maxOf`** for best-window updates.
- **Top-level function** matching the repository's lightweight Kotlin style.

## Implementation Decisions

- `left` only moves forward when a duplicate is inside the current window.
- Characters outside the active window are stale and do not affect `left`.
- Tests use a `main` function with standard `check` assertions.

## Running Tests

```bash
kotlinc solution.kt solution_test.kt -include-runtime -d solution.jar && kotlin solution.jar
```
