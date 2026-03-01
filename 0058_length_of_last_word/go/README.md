# Go Solution

## Language Features Used

- **Byte-level string indexing** (`s[i]`) — safe here since the problem guarantees only English letters and spaces (ASCII)
- **`len(s)`** — returns byte length, which equals character count for ASCII strings
- **Two-phase `for` loop** — first skips trailing spaces, then counts word characters

## Implementation Decisions

- **Byte indexing vs `strings.TrimRight` + `strings.LastIndex`**: standard library functions would work but allocate intermediate strings. Direct byte indexing is zero-allocation and maps the algorithm cleanly.
- **Single return via arithmetic** (`end - i`): avoids a counter variable, matching the Python and C++ implementations.

## Running Tests

```bash
go test -v
```
