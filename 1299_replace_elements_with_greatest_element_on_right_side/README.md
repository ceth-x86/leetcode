# 1299. Replace Elements with Greatest Element on Right Side

**Difficulty:** Easy

**Topics:** Array

**Link:** https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/

## Problem

Given an array `arr`, replace every element in that array with the greatest element among the elements to its right, and replace the last element with `-1`.

After doing so, return the array.

## Examples

### Example 1

```
Input: arr = [17, 18, 5, 4, 6, 1]
Output: [18, 6, 6, 6, 1, -1]
Explanation:
- index 0 → max(18, 5, 4, 6, 1) = 18
- index 1 → max(5, 4, 6, 1) = 6
- index 2 → max(4, 6, 1) = 6
- index 3 → max(6, 1) = 6
- index 4 → max(1) = 1
- index 5 → no elements to the right = -1
```

### Example 2

```
Input: arr = [400]
Output: [-1]
```

## Constraints

- `1 <= arr.length <= 10^4`
- `1 <= arr[i] <= 10^5`

## Approach

### Right-to-Left Scan (Optimal)

**Intuition:** For each element, we need the maximum of all elements to its right. If we scan left-to-right, we'd need to look at all remaining elements for each position — O(n^2). But if we scan right-to-left, we can maintain a running maximum that naturally accumulates the "greatest element to the right."

**Algorithm:**

1. Initialize `right_max = -1` (the answer for the last element).
2. Traverse the array from right to left.
3. At each position:
   - Save the current element (we'll need it to update the running max).
   - Replace the current element with `right_max`.
   - Update `right_max = max(right_max, saved_element)`.
4. Return the modified array.

### Alternative Approaches

| Approach | Time | Space | Notes |
|----------|------|-------|-------|
| Brute force (for each element, scan right) | O(n^2) | O(1) | Nested loop — too slow for large arrays |
| Suffix max array (precompute) | O(n) | O(n) | Build a suffix-max array, then copy values — extra space |
| **Right-to-left scan** | **O(n)** | **O(1)** | **Optimal: single pass, in-place** |

## Step-by-Step Walkthrough

### Example 1: `arr = [17, 18, 5, 4, 6, 1]`

```
right_max starts at -1

Step 1: i=5, arr[5]=1,  right_max=-1 → arr[5]=-1, right_max=max(-1, 1)=1
Step 2: i=4, arr[4]=6,  right_max=1  → arr[4]=1,  right_max=max(1, 6)=6
Step 3: i=3, arr[3]=4,  right_max=6  → arr[3]=6,  right_max=max(6, 4)=6
Step 4: i=2, arr[2]=5,  right_max=6  → arr[2]=6,  right_max=max(6, 5)=6
Step 5: i=1, arr[1]=18, right_max=6  → arr[1]=6,  right_max=max(6, 18)=18
Step 6: i=0, arr[0]=17, right_max=18 → arr[0]=18, right_max=max(18, 17)=18

Result: [18, 6, 6, 6, 1, -1] ✓
```

### Example 2: `arr = [400]`

```
right_max starts at -1

Step 1: i=0, arr[0]=400, right_max=-1 → arr[0]=-1, right_max=max(-1, 400)=400

Result: [-1] ✓
```

## Call Trace

For `replaceElements([17, 18, 5, 4, 6, 1])`:

```
replaceElements([17, 18, 5, 4, 6, 1])
│
├── right_max = -1
│
├── i=5: original=1
│   ├── arr[5] = -1
│   └── right_max = max(-1, 1) = 1
│
├── i=4: original=6
│   ├── arr[4] = 1
│   └── right_max = max(1, 6) = 6
│
├── i=3: original=4
│   ├── arr[3] = 6
│   └── right_max = max(6, 4) = 6
│
├── i=2: original=5
│   ├── arr[2] = 6
│   └── right_max = max(6, 5) = 6
│
├── i=1: original=18
│   ├── arr[1] = 6
│   └── right_max = max(6, 18) = 18
│
├── i=0: original=17
│   ├── arr[0] = 18
│   └── right_max = max(18, 17) = 18
│
└── result: [18, 6, 6, 6, 1, -1]
```

## Complexity Analysis

### Time Complexity: O(n)

- Single pass through the array from right to left: n iterations.
- Each iteration does O(1) work (one comparison, one assignment).

### Space Complexity: O(1)

- Only one extra variable (`right_max`) regardless of input size.
- The replacement is done in-place.

## Edge Cases

| Case | Input | Output | Why |
|------|-------|--------|-----|
| Single element | `[400]` | `[-1]` | No elements to the right |
| Two elements | `[1, 5]` | `[5, -1]` | Trivial case |
| Already descending | `[5, 4, 3, 2, 1]` | `[4, 3, 2, 1, -1]` | Each element's right max is its immediate neighbor |
| Already ascending | `[1, 2, 3, 4, 5]` | `[5, 5, 5, 5, -1]` | Right max is always the last element (5) |
| All same values | `[7, 7, 7]` | `[7, 7, -1]` | Right max stays constant |
| Two elements descending | `[5, 1]` | `[1, -1]` | Right max is the smaller element |
