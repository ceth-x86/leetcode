# Python Solution

## Language Features Used

- **List comprehensions** to precompute the DNA string as 2-bit integers
- **Integer bit operations** for constant-time sliding-window updates
- **Sets** for seen bitmasks and repeated substrings

## Implementation Decisions

- This variant follows the classic bitmask formulation closely: first build the initial 20-bit window in `O(L)`, then update later windows in `O(1)`.
- It keeps the encoded array `nums`, which makes the sliding logic explicit and close to the reference derivation.
- The output is accumulated in a set because order is not required by the problem.

## Running Tests

```bash
python3 -m pytest solution_test.py -v
```
