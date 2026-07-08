# Python Solution: Prefix Sum

This implements the prefix sum approach to find the pivot index.

## Implementation Details

The solution calculates the total sum of the array first. Then it iterates through the array, keeping track of the `left_sum`. For any index `i`, the `right_sum` can be computed as `total_sum - left_sum - nums[i]`. If `left_sum` equals `right_sum`, we have found the pivot index.

Time Complexity: O(N) where N is the length of `nums`
Space Complexity: O(1)

## Running Tests

```bash
pytest solution_test.py
```
