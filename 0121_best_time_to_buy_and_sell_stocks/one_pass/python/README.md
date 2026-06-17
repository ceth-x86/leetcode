# Python Solution

## Language Features Used

- **Type hints** (`list[int]`, `-> int`) for a clear function contract.
- **Built-in `max` and `min`** for constant-time updates to the best profit and lowest price.
- **Single `for` loop** over the input, matching the one-pass algorithm directly.

## Implementation Decisions

- The function initializes `min_price` from `prices[0]` because the problem guarantees at least one price.
- It updates `best_profit` before `min_price` on each day, so the profit calculation uses a buy price from the current or earlier days.
- It avoids slicing (`prices[1:]`) to keep extra memory usage constant.

## Visualization

`visualize.py` prints the running minimum, candidate profit, and best profit at each day:

```bash
python3 visualize.py
```

## Running Tests

```bash
python3 -m pytest solution_test.py -v
```
