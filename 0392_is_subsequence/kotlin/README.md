# Kotlin Solution

## Language Features Used

- **Top-level function** for the standard two-pointer solution.
- **Class `SubsequenceChecker`** for the many-query follow-up.
- **Mutable map of character positions** for preprocessing.
- **`Collections.binarySearch`** for efficient follow-up queries.

## Implementation Decisions

- The standard function scans `t` once and advances a pointer into `s`.
- The follow-up stores sorted positions for each character in `t`.
- The follow-up test has a separate `main`, so compile it separately from the standard test.

## Running Tests

```bash
kotlinc solution.kt solution_test.kt -include-runtime -d solution.jar && kotlin solution.jar
kotlinc solution_followup.kt solution_followup_test.kt -include-runtime -d solution_followup.jar && kotlin solution_followup.jar
```
