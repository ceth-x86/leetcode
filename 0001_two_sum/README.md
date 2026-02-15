# 1. Two Sum

**Difficulty:** Easy

**Topics:** Array, Hash Table

**Link:** https://leetcode.com/problems/two-sum/

## Problem

Given an array of integers `nums` and an integer `target`, return indices of the two numbers such that they add up to `target`.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

## Examples

### Example 1

```
Input: nums = [2, 7, 11, 15], target = 9
Output: [0, 1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
```

### Example 2

```
Input: nums = [3, 2, 4], target = 6
Output: [1, 2]
```

### Example 3

```
Input: nums = [3, 3], target = 6
Output: [0, 1]
```

## Constraints

- `2 <= nums.length <= 10^4`
- `-10^9 <= nums[i] <= 10^9`
- `-10^9 <= target <= 10^9`
- Only one valid answer exists.

## Approach

### Hash Map (Optimal)

**Intuition:** For each element `num`, the value we need to find is `target - num` (the complement). Instead of scanning the rest of the array for the complement (O(n) per element), we store previously seen elements and their indices in a hash map for O(1) lookups.

We iterate through the array once. For each element, we check if its complement is already in the map. If yes, we've found the pair. If no, we store the current element and its index for future lookups.

**Algorithm:**

1. Create an empty hash map `seen` (value → index).
2. For each index `i` and element `num` in `nums`:
   - Compute `complement = target - num`.
   - If `complement` is in `seen`, return `[seen[complement], i]`.
   - Otherwise, store `seen[num] = i`.
3. (Guaranteed to find a solution before loop ends.)

### Alternative Approaches

| Approach | Time | Space | Notes |
|----------|------|-------|-------|
| Brute force (nested loops) | O(n^2) | O(1) | Check every pair — too slow |
| Sort + two pointers | O(n log n) | O(n) | Need to track original indices; sorting complicates things |
| **Hash Map** | **O(n)** | **O(n)** | **Optimal time, single pass** |

## Step-by-Step Walkthrough

### Example 1: `nums = [2, 7, 11, 15], target = 9`

```
Step 1: i=0, num=2, complement=7, seen={}        → 7 not in seen → store seen[2]=0
Step 2: i=1, num=7, complement=2, seen={2:0}     → 2 IS in seen → return [0, 1] ✓
```

### Example 2: `nums = [3, 2, 4], target = 6`

```
Step 1: i=0, num=3, complement=3, seen={}        → 3 not in seen → store seen[3]=0
Step 2: i=1, num=2, complement=4, seen={3:0}     → 4 not in seen → store seen[2]=1
Step 3: i=2, num=4, complement=2, seen={3:0,2:1} → 2 IS in seen → return [1, 2] ✓
```

### Example 3: `nums = [3, 3], target = 6`

```
Step 1: i=0, num=3, complement=3, seen={}    → 3 not in seen → store seen[3]=0
Step 2: i=1, num=3, complement=3, seen={3:0} → 3 IS in seen → return [0, 1] ✓
```

## Call Trace

For `twoSum([2, 7, 11, 15], 9)`:

```
twoSum([2, 7, 11, 15], 9)
│
├── seen = {}
│
├── i=0: num=2
│   ├── complement = 9 - 2 = 7
│   ├── 7 in seen? → false
│   └── seen[2] = 0 → seen = {2: 0}
│
├── i=1: num=7
│   ├── complement = 9 - 7 = 2
│   ├── 2 in seen? → true (index 0)
│   └── return [0, 1]
│
└── result: [0, 1]
```

## Complexity Analysis

### Time Complexity: O(n)

- We iterate through the array once: O(n).
- Each hash map lookup (`in`) and insertion is O(1) on average.
- Worst case (answer is the last pair): n lookups + n-1 insertions = O(n).
- Best case (answer is the first two elements): O(1).

### Space Complexity: O(n)

- In the worst case, we store n-1 elements in the map before finding the answer.
- In the best case (answer at indices 0 and 1), the map stores 0 elements: O(1).

## Edge Cases

| Case | Input | Output | Why |
|------|-------|--------|-----|
| Pair at start | `[2, 7, 11, 15], target=9` | `[0, 1]` | Found immediately |
| Pair at end | `[1, 2, 3, 4], target=7` | `[2, 3]` | Must scan entire array |
| Same elements | `[3, 3], target=6` | `[0, 1]` | Complement lookup happens before storing current |
| Negative numbers | `[-1, -2, -3, -4, -5], target=-8` | `[2, 4]` | Works with negatives |
| Zero in array | `[0, 4, 3, 0], target=0` | `[0, 3]` | Zero plus zero |
| Large values | `[-10^9, 10^9], target=0` | `[0, 1]` | Extreme values, no overflow in hash map |
