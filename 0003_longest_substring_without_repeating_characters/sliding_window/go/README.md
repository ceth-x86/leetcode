# Go Solution

## Language Features Used

- **`map[rune]int`** for last-seen character positions.
- **Rune slice conversion** so indices count characters rather than bytes.
- **Comma-ok idiom** for checking whether a character has appeared before.
- **Table-driven tests** with `t.Run`.

## Implementation Decisions

- `left` and `right` are rune indices.
- The solution is robust for Unicode, even though LeetCode constrains the input to English letters, digits, symbols, and spaces.
- The function is unexported to match local package-internal style.

## Running Tests

```bash
go test -v
```
