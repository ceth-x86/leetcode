# Clojure Solution: Prefix Sum

This implements the prefix sum approach to find the pivot index.

## Implementation Details

The solution calculates the total sum using `reduce +`. Then it iterates through the sequence using `loop` and `recur`, keeping track of the `left-sum` and the current index. At each step, it checks if `left-sum` equals `total-sum - left-sum - num`.

Time Complexity: O(N) where N is the length of `nums`
Space Complexity: O(1)

## Running Tests

```bash
clj -X:test
```
