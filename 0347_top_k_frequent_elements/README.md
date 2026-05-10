# 347. Top K Frequent Elements

**Difficulty:** Medium

**Topics:** Array, Hash Table, Divide and Conquer, Sorting, Heap (Priority Queue), Bucket Sort, Counting, Quickselect

**Link:** [https://leetcode.com/problems/top-k-frequent-elements/](https://leetcode.com/problems/top-k-frequent-elements/)

## Problem

Given an integer array `nums` and an integer `k`, return the `k` most frequent elements. You may return the answer in any order.

## Examples

### Example 1
```
Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
```

### Example 2
```
Input: nums = [1], k = 1
Output: [1]
```

## Constraints
- `1 <= nums.length <= 10^5`
- `-10^4 <= nums[i] <= 10^4`
- `k` is in the range `[1, the number of unique elements in the array]`.
- It is guaranteed that the answer is unique.

**Follow up:** Your algorithm's time complexity must be better than $O(n \log n)$, where $n$ is the array's size.

---

## Approach

### Bucket Sort (Optimal)
We count frequencies using a hash map. Then, we create "buckets" where the index of the bucket represents the frequency. Since the maximum frequency is the length of the input array, we can use an array of size $n+1$. Finally, we iterate from the highest frequency bucket down until we collect $k$ elements.

### Heap (Priority Queue)
We count frequencies using a hash map. We then maintain a **min-heap** of size $k$ containing pairs of `{frequency, element}`. If the heap size exceeds $k$, we pop the smallest frequency element. This ensures that the heap always contains the $k$ most frequent elements.

### Comparison of Approaches

| Approach | Time | Space | Notes |
|----------|------|-------|-------|
| **Bucket Sort** | **$O(N)$** | $O(N)$ | **Optimal time complexity**, bypasses sorting |
| Heap | $O(N \log k)$ | $O(N)$ | Good for streaming data or very small $k$ |

---

## Step-by-Step Walkthrough

### Bucket Sort: `nums = [1,1,1,2,2,3], k = 2`
```
1. Count: {1: 3, 2: 2, 3: 1}
2. Buckets:
   - index 1 (freq 1): [3]
   - index 2 (freq 2): [2]
   - index 3 (freq 3): [1]
3. Collect from index 3 down:
   - index 3: result = [1]
   - index 2: result = [1, 2]
4. Result size is 2. Stop.
Result: [1, 2]
```

### Heap: `nums = [1,1,1,2,2,3], k = 2`
```
1. Count: {1: 3, 2: 2, 3: 1}
2. Heap size k=2:
   - Push (3, 1): Heap = [(3, 1)]
   - Push (2, 2): Heap = [(2, 2), (3, 1)]
   - Push (1, 3): Heap = [(1, 3), (2, 2), (3, 1)] -> size 3 > 2
   - Pop min (1, 3): Heap = [(2, 2), (3, 1)]
Result: [2, 1]
```

---

## Call Trace

### Bucket Sort Approach
```
topKFrequent([1, 1, 1, 2, 2, 3], 2)
│
├── counts = {1: 3, 2: 2, 3: 1}
├── buckets = [[], [3], [2], [1], [], [], []]
│
├── i = 6: empty
├── i = 5: empty
├── i = 4: empty
├── i = 3: result = [1]
├── i = 2: result = [1, 2]
│
└── return [1, 2]
```

---

## Complexity Analysis

### Bucket Sort
- **Time Complexity:** $O(N)$. We iterate through the array once to count, then through the counts map once to fill buckets, then through the buckets once (total length $N$) to collect results.
- **Space Complexity:** $O(N)$ to store the counts and the buckets.

### Heap
- **Time Complexity:** $O(N \log k)$. We iterate through unique elements ($M \le N$) and perform heap operations of $O(\log k)$.
- **Space Complexity:** $O(N)$ for the frequency map and $O(k)$ for the heap.

---

## Edge Cases

| Case | Input | Output | Why |
|------|-------|--------|-----|
| Single element | `nums=[1], k=1` | `[1]` | Minimum input size |
| All identical | `nums=[1,1,1], k=1` | `[1]` | Max frequency |
| All unique | `nums=[1,2,3], k=2` | `[1,2]` (any 2) | All frequencies are 1 |
| k equals unique count | `nums=[1,2], k=2` | `[1,2]` | Return all unique elements |
