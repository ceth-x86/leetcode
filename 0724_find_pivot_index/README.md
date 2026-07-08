# 724. Find Pivot Index

[LeetCode Link](https://leetcode.com/problems/find-pivot-index/)

## Problem Statement

Given an array of integers `nums`, calculate the pivot index of this array.

The pivot index is the index where the sum of all the numbers strictly to the left of the index is equal to the sum of all the numbers strictly to the index's right.

If the index is on the left edge of the array, then the left sum is 0 because there are no elements to the left. This also applies to the right edge of the array.

Return the leftmost pivot index. If no such index exists, return -1.

## Prefix Sum Approach

The naive approach would be to iterate through each index and calculate the sum of its left and right sides, which would take O(N^2) time. We can optimize this using the prefix sum technique.

Since we know the sum of the entire array, we can iterate through the array while keeping a running sum of the elements to the left (`left_sum`). The right sum can easily be derived as `total_sum - left_sum - nums[i]`. If the two sums match, we have found the pivot index.

### Prefix Sum Walkthrough

Let's trace the algorithm with the example `nums = [1, 7, 3, 6, 5, 6]`.

1. Calculate `total_sum`: 1 + 7 + 3 + 6 + 5 + 6 = 28
2. Initialize `left_sum` = 0

Iterating through `nums`:

| Index `i` | Value `nums[i]` | `left_sum` | `right_sum` = `total_sum - left_sum - nums[i]` | Match? | New `left_sum` |
| :--- | :--- | :--- | :--- | :--- | :--- |
| 0 | 1 | 0 | 28 - 0 - 1 = 27 | No (0 != 27) | 0 + 1 = 1 |
| 1 | 7 | 1 | 28 - 1 - 7 = 20 | No (1 != 20) | 1 + 7 = 8 |
| 2 | 3 | 8 | 28 - 8 - 3 = 17 | No (8 != 17) | 8 + 3 = 11 |
| 3 | 6 | 11 | 28 - 11 - 6 = 11 | **Yes** (11 == 11) | - |

We return index 3.

### Prefix Sum Call Trace

```python
pivotIndex([2, 1, -1])
  total_sum = sum([2, 1, -1]) = 2
  left_sum = 0
  
  i = 0, num = 2
    right_sum = 2 - 0 - 2 = 0
    left_sum (0) == right_sum (0) -> True
    return 0
```

### Prefix Sum Complexity

- **Time Complexity:** O(N), where N is the length of `nums`. We do one pass to compute the total sum and a second pass to find the pivot index.
- **Space Complexity:** O(1), since we only use a few integer variables (`total_sum` and `left_sum`) regardless of the array size.

## Edge Cases

- **Pivot index at the beginning (index 0):** Handled correctly. The `left_sum` starts at 0, which corresponds to the problem statement. E.g., `nums = [2, 1, -1]`.
- **Pivot index at the end:** Handled correctly. The `right_sum` evaluates to 0. E.g., `nums = [-1, 1, 2]`.
- **No pivot index:** The loop finishes without returning, and the function returns `-1` at the end. E.g., `nums = [1, 2, 3]`.
- **Array with single element:** Handled correctly. `total_sum` equals that element, `left_sum = 0`, `right_sum = 0`. Returns 0. E.g., `nums = [0]`.
