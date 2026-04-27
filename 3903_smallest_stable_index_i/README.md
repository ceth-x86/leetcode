# 3903. Smallest Stable Index I

**Difficulty:** Easy

**Topics:** Array

**Link:** https://leetcode.com/problems/smallest-stable-index-i/

## Problem

You are given an integer array `nums` of length `n` and an integer `k`.

For each index `i`, define its instability score as:

`max(nums[0..i]) - min(nums[i..n - 1])`

In other words:

- `max(nums[0..i])` is the largest value from index `0` through index `i`.
- `min(nums[i..n - 1])` is the smallest value from index `i` through index `n - 1`.

An index `i` is stable if its instability score is less than or equal to `k`.

Return the smallest stable index. If no such index exists, return `-1`.

## Example

### Example 1

```text
Input: nums = [5, 0, 1, 4], k = 3
Output: 3
```

Explanation:

- At index `0`, `max([5]) = 5` and `min([5, 0, 1, 4]) = 0`, so the score is `5`.
- At index `1`, `max([5, 0]) = 5` and `min([0, 1, 4]) = 0`, so the score is `5`.
- At index `2`, `max([5, 0, 1]) = 5` and `min([1, 4]) = 1`, so the score is `4`.
- At index `3`, `max([5, 0, 1, 4]) = 5` and `min([4]) = 4`, so the score is `1`.

The first score that is at most `k = 3` appears at index `3`.

## Constraints

- `1 <= nums.length <= 100`
- `0 <= nums[i] <= 10^9`
- `0 <= k <= 10^9`

## Approach

### Suffix Minimum + Running Prefix Maximum

The formula for each index depends on two values:

1. The maximum value seen from the left up to `i`.
2. The minimum value seen from the right starting at `i`.

We only need to preprocess the right-side minima:

- `suffix_min[i]` stores `min(nums[i..n-1])`

Then we scan from left to right while maintaining a single variable:

- `prefix_max = max(nums[0..i])`

At index `i`, the instability score is:

`prefix_max - suffix_min[i]`

We scan from left to right and return the first index whose score is at most `k`.

### Algorithm

1. Build `suffix_min` from right to left.
2. Initialize `prefix_max = nums[0]`.
3. Scan indices from `0` to `n - 1`.
4. Update `prefix_max = max(prefix_max, nums[i])`.
5. Return the first `i` where `prefix_max - suffix_min[i] <= k`.
6. If no index works, return `-1`.

## Step-by-Step Walkthrough

### Example 1: `nums = [5, 0, 1, 4]`, `k = 3`

Build suffix minima:

```text
suffix_min[3] = 4
suffix_min[2] = min(1, 4) = 1
suffix_min[1] = min(0, 1) = 0
suffix_min[0] = min(5, 0) = 0
```

So:

```text
suffix_min = [0, 0, 1, 4]
```

Scan left to right with a running prefix maximum:

```text
i = 0 -> prefix_max = max(5, 5) = 5 -> 5 - 0 = 5  > 3
i = 1 -> prefix_max = max(5, 0) = 5 -> 5 - 0 = 5  > 3
i = 2 -> prefix_max = max(5, 1) = 5 -> 5 - 1 = 4  > 3
i = 3 -> prefix_max = max(5, 4) = 5 -> 5 - 4 = 1 <= 3
```

The smallest stable index is `3`.

### Additional Sanity Check: `nums = [4, 4, 4]`, `k = 0`

`suffix_min = [4, 4, 4]`, and the running `prefix_max` is always `4`, so every score is `0`.

Index `0` is already stable, so the answer is `0`.

## Call Trace

For `firstStableIndex([5, 0, 1, 4], 3)`:

```text
firstStableIndex([5, 0, 1, 4], 3)
|
|-- build prefix_max
|-- build suffix_min
|   |-- suffix_min[3] = 4
|   |-- suffix_min[2] = 1
|   |-- suffix_min[1] = 0
|   `-- suffix_min[0] = 0
|
|-- scan indices
|   |-- prefix_max = 5
|   |-- i = 0 -> score = 5
|   |-- i = 1 -> score = 5
|   |-- i = 2 -> score = 4
|   `-- i = 3 -> score = 1 -> return 3
|
`-- result = 3
```

## Complexity Analysis

### Time Complexity: `O(n)`

- Building `suffix_min` takes one pass.
- Scanning for the first stable index with a running `prefix_max` takes one pass.

Total: `O(n)`.

### Space Complexity: `O(n)`

- We store one array of length `n`: `suffix_min`.

Total extra space: `O(n)`.

## Edge Cases

| Case | Input | Output | Why |
|---|---|---|---|
| Single element | `nums = [9], k = 0` | `0` | `max` and `min` are both `9`, so the score is `0` |
| First index already stable | `nums = [2, 5, 7], k = 0` | `0` | At index `0`, `2 - 2 = 0` |
| Only the last index is stable | `nums = [5, 0, 1, 4], k = 3` | `3` | Earlier scores are too large |
| No stable index | `nums = [10, 0], k = 5` | `-1` | Scores are `10` and `10` |
| All values equal | `nums = [4, 4, 4], k = 0` | `0` | Every score is `0` |
