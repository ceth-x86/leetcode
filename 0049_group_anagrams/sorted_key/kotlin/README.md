# Kotlin Solution

## Language Features Used

- **`toCharArray()` and `sort()`** to build each anagram key.
- **`linkedMapOf`** for grouping.
- **`getOrPut`** for concise map insertion.

## Implementation Decisions

- The sorted string is used as the canonical key for an anagram group.
- Group order is not important, so tests normalize before comparing.
- The approach is simple and readable, with O(k log k) sorting per string.

## Running Tests

```bash
kotlinc solution.kt solution_test.kt -include-runtime -d solution.jar && kotlin solution.jar
```
