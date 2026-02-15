# Go Solution

## Language Features Used

- **`[26]int` array** — fixed-size array on the stack, zero-initialized by default in Go. No `make` or heap allocation needed.
- **`range` over string** — `for i := range s` iterates by byte index. Since the constraint guarantees lowercase ASCII, byte-level access with `s[i]` is safe and correct.
- **`s[i] - 'a'`** — byte arithmetic to convert ASCII letter to index. Go's `byte` type is an alias for `uint8`.

## Implementation Decisions

- **`[26]int` vs `map[byte]int`**: fixed array is idiomatic for known-size alphabets in Go — no allocation, no hashing overhead. A map would be needed for the Unicode follow-up, using `rune` as the key type.
- **Byte indexing vs rune iteration**: `for _, ch := range s` gives runes (Unicode codepoints), but since the constraint limits input to lowercase English letters, byte indexing with `s[i]` is simpler and avoids unnecessary rune decoding.
- **Single-pass**: increment for `s[i]`, decrement for `t[i]` in the same loop body — standard approach for the array-based solution.

## Running Tests

```bash
go test -v
```
