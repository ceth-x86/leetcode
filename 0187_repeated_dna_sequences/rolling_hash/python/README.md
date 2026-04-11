# Python Solution

## Language Features Used

- **Integer bit operations** for the rolling 20-bit encoding
- **Dictionary literal** for compact nucleotide-to-bit mapping
- **Type hints** for readability of hash sets and returned fragments

## Implementation Decisions

- `A/C/G/T` are encoded into `0/1/2/3`, so each character consumes 2 bits and a 10-letter window fits in 20 bits.
- `WINDOW_MASK` trims old bits when the window slides.
- The result still returns original substrings from `s`; only the duplicate detection uses integer hashes.

## Running Tests

```bash
python3 -m pytest solution_test.py -v
```
