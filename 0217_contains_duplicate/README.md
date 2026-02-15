# 217. Contains Duplicate

**Difficulty:** Easy

**Topics:** Array, Hash Table, Sorting

**Link:** https://leetcode.com/problems/contains-duplicate/

## Problem

Given an integer array `nums`, return `true` if any value appears at least twice in the array, and return `false` if every element is distinct.

## Examples

### Example 1

```
Input: nums = [1, 2, 3, 1]
Output: true
Explanation: The element 1 occurs at the indices 0 and 3.
```

### Example 2

```
Input: nums = [1, 2, 3, 4]
Output: false
Explanation: All elements are distinct.
```

### Example 3

```
Input: nums = [1, 1, 1, 3, 3, 4, 3, 2, 4, 2]
Output: true
```

## Constraints

- `1 <= nums.length <= 10^5`
- `-10^9 <= nums[i] <= 10^9`

## Approach

### Hash Set (Optimal)

**Intuition:** As we iterate through the array, we maintain a set of elements we've already seen. For each element, we check if it's already in the set. If yes — we found a duplicate. If no — we add it to the set and continue.

A set provides O(1) average-time lookups and insertions, making this the most efficient single-pass approach.

**Algorithm:**

1. Create an empty set `seen`.
2. For each element `num` in `nums`:
   - If `num` is in `seen`, return `true`.
   - Otherwise, add `num` to `seen`.
3. If we finish the loop without finding a duplicate, return `false`.

### Alternative Approaches

| Approach | Time | Space | Notes |
|----------|------|-------|-------|
| Brute force (nested loops) | O(n^2) | O(1) | Compare every pair — too slow |
| Sort then scan | O(n log n) | O(1)* | Sort, then check adjacent elements. *O(1) extra if in-place sort, but modifies input |
| **Hash Set** | **O(n)** | **O(n)** | **Optimal time, uses extra space** |

## Step-by-Step Walkthrough

### Example 1: `nums = [1, 2, 3, 1]`

```
Step 1: num = 1, seen = {}        → 1 not in seen → add → seen = {1}
Step 2: num = 2, seen = {1}      → 2 not in seen → add → seen = {1, 2}
Step 3: num = 3, seen = {1, 2}   → 3 not in seen → add → seen = {1, 2, 3}
Step 4: num = 1, seen = {1, 2, 3} → 1 IS in seen → return true ✓
```

### Example 2: `nums = [1, 2, 3, 4]`

```
Step 1: num = 1, seen = {}           → add → seen = {1}
Step 2: num = 2, seen = {1}         → add → seen = {1, 2}
Step 3: num = 3, seen = {1, 2}      → add → seen = {1, 2, 3}
Step 4: num = 4, seen = {1, 2, 3}   → add → seen = {1, 2, 3, 4}
Loop ended → return false ✓
```

### Example 3: `nums = [1, 1, 1, 3, 3, 4, 3, 2, 4, 2]`

```
Step 1: num = 1, seen = {} → add → seen = {1}
Step 2: num = 1, seen = {1} → 1 IS in seen → return true ✓
(early exit on second element)
```

## Call Trace

For `containsDuplicate([1, 2, 3, 1])`:

```
containsDuplicate([1, 2, 3, 1])
│
├── seen = {}
│
├── i=0: num=1
│   ├── 1 in seen? → false
│   └── seen.add(1) → seen = {1}
│
├── i=1: num=2
│   ├── 2 in seen? → false
│   └── seen.add(2) → seen = {1, 2}
│
├── i=2: num=3
│   ├── 3 in seen? → false
│   └── seen.add(3) → seen = {1, 2, 3}
│
├── i=3: num=1
│   ├── 1 in seen? → true
│   └── return true
│
└── result: true
```

## Complexity Analysis

### Time Complexity: O(n)

- We iterate through the array once: O(n).
- Each set lookup (`in`) and insertion (`add`) is O(1) on average (hash table).
- Worst case (all elements are unique): n lookups + n insertions = O(n).
- Best case (duplicate at positions 0 and 1): O(1).

### Space Complexity: O(n)

- In the worst case (no duplicates), the set stores all n elements.
- In the best case (immediate duplicate), the set stores 1 element: O(1).

## Edge Cases

| Case | Input | Output | Why |
|------|-------|--------|-----|
| Single element | `[1]` | `false` | Can't have duplicates with one element |
| Two same elements | `[1, 1]` | `true` | Minimal duplicate case |
| Two different elements | `[1, 2]` | `false` | Minimal non-duplicate case |
| All same | `[5, 5, 5, 5]` | `true` | Detected on second element |
| Large range of values | `[-10^9, 10^9]` | `false` | Extreme values, no overflow issues with set |
| Duplicate at the end | `[1, 2, 3, ..., n, 1]` | `true` | Worst-case scan before finding duplicate |
