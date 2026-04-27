# 239. Sliding Window Maximum

**Difficulty:** Hard

**Topics:** Array, Queue, Sliding Window, Heap (Priority Queue), Monotonic Queue

**Link:** https://leetcode.com/problems/sliding-window-maximum/

## Problem

You are given an array of integers `nums`, and there is a sliding window of size `k` which moves from the very left of the array to the very right. You can only see the `k` numbers in the window at a time. Each time the sliding window moves right by one position.

Return the max sliding window.

## Examples

### Example 1

```text
Input: nums = [1, 3, -1, -3, 5, 3, 6, 7], k = 3
Output: [3, 3, 5, 5, 6, 7]
```

### Example 2

```text
Input: nums = [1], k = 1
Output: [1]
```

## Constraints

- `1 <= nums.length <= 10^5`
- `-10^4 <= nums[i] <= 10^4`
- `1 <= k <= nums.length`

## Approach

This directory contains two solution variants:

- `monotonic_deque/` maintains a decreasing deque of candidate indices and gives the optimal `O(n)` solution.
- `max_heap/` keeps a max-heap of `(value, index)` pairs and gives a simpler-to-generalize lazy-heap solution with `O(n log n)` worst-case complexity.

### Monotonic Deque Approach

**Idea:** Keep indices of elements in decreasing order of value. The front of the deque always points to the maximum element of the current window.

**Algorithm:**

1. Iterate through `nums` by index `i`.
2. Remove indices from the front if they are outside the current window.
3. Remove indices from the back while their values are smaller than or equal to `nums[i]`, because they can never become a future maximum.
4. Push `i` to the back.
5. Once the first full window is formed, append `nums[deque[0]]` to the answer.

### Max Heap Approach

**Idea:** Store each element as `(value, index)` in a max-heap. The heap top is the largest value seen so far, but it may be stale, so discard heap entries whose index is outside the current window.

**Algorithm:**

1. Iterate through `nums`.
2. Push `(nums[i], i)` into the max-heap.
3. While the heap top is outside the current window, pop it.
4. Once the first full window is formed, append the heap top value to the answer.

## Step-by-Step Walkthrough

### Monotonic Deque Walkthrough

#### Example 1: `nums = [1, 3, -1, -3, 5, 3, 6, 7], k = 3`

Store indices in decreasing-value order:

```text
i=0, nums[i]=1:
  deque = [0]                    values = [1]

i=1, nums[i]=3:
  pop 0 from back because 1 <= 3
  deque = [1]                    values = [3]

i=2, nums[i]=-1:
  deque = [1, 2]                 values = [3, -1]
  first full window [1, 3, -1] -> max = nums[1] = 3

i=3, nums[i]=-3:
  deque = [1, 2, 3]              values = [3, -1, -3]
  window [3, -1, -3] -> max = 3

i=4, nums[i]=5:
  index 1 leaves the window
  pop 3 from back because -3 <= 5
  pop 2 from back because -1 <= 5
  deque = [4]                    values = [5]
  window [-1, -3, 5] -> max = 5
```

Continuing the same process yields:

```text
result = [3, 3, 5, 5, 6, 7]
```

#### Example 2: `nums = [1], k = 1`

```text
i=0:
  deque = [0]
  first full window [1] -> max = 1
```

Final answer:

```text
[1]
```

### Max Heap Walkthrough

#### Example 1: `nums = [1, 3, -1, -3, 5, 3, 6, 7], k = 3`

Store `(value, index)` in a max-heap:

```text
i=0:
  heap = [(1, 0)]

i=1:
  heap = [(3, 1), (1, 0)]

i=2:
  heap = [(3, 1), (1, 0), (-1, 2)]
  first full window [1, 3, -1] -> top = 3

i=3:
  push (-3, 3)
  top (3, 1) is still in range -> window [3, -1, -3] -> max = 3

i=4:
  push (5, 4)
  top becomes (5, 4) -> window [-1, -3, 5] -> max = 5
```

Continuing the same process yields:

```text
result = [3, 3, 5, 5, 6, 7]
```

#### Example 2: `nums = [1], k = 1`

```text
i=0:
  heap = [(1, 0)]
  first full window [1] -> top = 1
```

Final answer:

```text
[1]
```

## Call Trace

### Monotonic Deque Call Trace

For `nums = [1, 3, -1, -3, 5]`, `k = 3`:

```text
maxSlidingWindow([1, 3, -1, -3, 5], 3)
│
├── i=0, value=1
│   deque = [0]
│
├── i=1, value=3
│   pop back 0 because nums[0] <= 3
│   deque = [1]
│
├── i=2, value=-1
│   deque = [1, 2]
│   append nums[1] = 3
│
├── i=3, value=-3
│   deque = [1, 2, 3]
│   append nums[1] = 3
│
├── i=4, value=5
│   pop front 1 because it left the window
│   pop back 3 because nums[3] <= 5
│   pop back 2 because nums[2] <= 5
│   deque = [4]
│   append nums[4] = 5
│
└── result = [3, 3, 5]
```

### Max Heap Call Trace

For `nums = [1, 3, -1, -3, 5]`, `k = 3`:

```text
maxSlidingWindow([1, 3, -1, -3, 5], 3)
│
├── i=0
│   push (1, 0)
│
├── i=1
│   push (3, 1)
│
├── i=2
│   push (-1, 2)
│   top = (3, 1)
│   append 3
│
├── i=3
│   push (-3, 3)
│   top = (3, 1), still inside window
│   append 3
│
├── i=4
│   push (5, 4)
│   top = (5, 4)
│   append 5
│
└── result = [3, 3, 5]
```

## Complexity Analysis

### Monotonic Deque Complexity

- Time: `O(n)` because each index is pushed once and removed at most once from the deque
- Space: `O(k)` because the deque stores at most one window of candidate indices

### Max Heap Complexity

- Time: `O(n log n)` in the worst case for this lazy-heap implementation, because old entries can remain in the heap until they reach the top
- Space: `O(n)` in the worst case because stale entries can accumulate below the heap top

## Solution Comparison

### Monotonic Deque Comparison

**Pros:**

- Optimal `O(n)` time
- Standard interview solution for this problem
- Keeps exactly the candidates that can still become a maximum

**Cons:**

- Less obvious the first time you see the monotonic-queue invariant
- Requires careful reasoning about when to pop from front vs back

### Max Heap Comparison

**Pros:**

- Conceptually closer to “keep the largest element available”
- Easier to adapt when you already have a heap-based streaming pattern
- Good stepping stone toward the deque solution

**Cons:**

- Slower than the deque solution
- Needs stale-entry cleanup because old indices can remain in the heap
- In this lazy form, the heap can grow beyond `k`, so the worst-case bounds are worse than the deque solution
- Usually not the optimal interview answer for this exact problem

### When To Prefer Which

- Prefer `monotonic_deque/` when you want the best asymptotic solution and the canonical answer.
- Prefer `max_heap/` when you want a simpler priority-queue framing or are practicing lazy heap cleanup.

## Edge Cases

| Case | Input | Output | Why |
|------|-------|--------|-----|
| Single element | `nums=[1], k=1` | `[1]` | One window, one maximum |
| Full-array window | `nums=[2,1,3], k=3` | `[3]` | Only one window across the whole array |
| Strictly increasing | `nums=[1,2,3,4], k=2` | `[2,3,4]` | Newest element keeps becoming the maximum |
| Strictly decreasing | `nums=[4,3,2,1], k=2` | `[4,3,2]` | Oldest element often remains the maximum |
| Duplicates | `nums=[1,3,3,2], k=2` | `[3,3,3]` | Equal maximums must be handled correctly |
| Negative values | `nums=[-4,-2,-5,-1], k=2` | `[-2,-2,-1]` | Maximum still means the least negative value |
