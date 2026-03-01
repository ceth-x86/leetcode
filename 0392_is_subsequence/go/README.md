# Go Solution

## Language Features Used

- **Byte-level string indexing** (`s[i]`, `t[j]`) — Go strings are byte slices; since the problem guarantees lowercase English letters (ASCII), byte comparison is safe and efficient
- **Combined `for` condition** — `j < len(t) && i < len(s)` provides early exit when all characters of `s` are matched
- **`bool` return** — Go's native boolean type

## Implementation Decisions

- **Byte indexing vs `range`**: `range` over a string yields runes (Unicode code points), but since the problem guarantees lowercase ASCII letters, direct byte indexing with `s[i]` and `t[j]` is simpler and avoids rune decoding overhead.
- **`tt` in test struct**: the second input parameter is named `tt` in the test struct to avoid shadowing Go's `*testing.T` parameter `t`.
- **Table-driven tests** with `t.Run`: standard Go testing pattern with named subtests.

## Running Tests

```bash
go test -v
```

## Unicode Solution (`solution_unicode.go`)

Handles strings containing any Unicode code points (CJK, emoji, Cyrillic, accented characters, etc.) — not just ASCII.

### Key Differences from ASCII Solution

- **`[]rune(s)`** — converts `s` to a rune slice upfront for O(1) indexed access by code point. The byte-indexed `s[i]` in the ASCII version would split multi-byte characters.
- **`range t`** — iterates over `t` by rune (not byte), automatically decoding UTF-8. Each iteration yields the rune and its byte offset.
- **Rune comparison** (`sRunes[i] == ch`) — compares full Unicode code points instead of individual bytes.

### Why a Separate Solution

The ASCII solution (`solution.go`) uses `s[i]` and `t[j]` byte indexing with `len()` which counts bytes. For multi-byte UTF-8 characters (e.g., `"你"` is 3 bytes, `"🌍"` is 4 bytes), byte indexing would compare partial bytes and `len()` would return the wrong count. The unicode solution pays the cost of rune decoding but handles all of Unicode correctly.

### Running Unicode Tests

```bash
go test -v -run "Unicode"
```

## Follow-up Solution (`solution_followup.go`)

`SubsequenceChecker` preprocesses `t` into a `[26][]int` array, then answers queries with binary search.

### Language Features Used

- **`[26][]int`** — fixed-size array of slices, one per lowercase letter; zero-allocation for unused characters
- **`sort.SearchInts`** — standard library binary search over a sorted `[]int` slice; returns the insertion point
- **Exported struct + methods** — `NewSubsequenceChecker(t)` constructor, `IsSubsequence(s)` method

### Running Follow-up Tests

```bash
go test -v -run "Subsequence"
```
