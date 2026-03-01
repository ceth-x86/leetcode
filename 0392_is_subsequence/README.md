# 392. Is Subsequence

**Difficulty:** Easy

**Topics:** Two Pointers, String, Dynamic Programming

**Link:** https://leetcode.com/problems/is-subsequence/

## Problem

Given two strings `s` and `t`, return `true` if `s` is a subsequence of `t`, or `false` otherwise.

A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., `"ace"` is a subsequence of `"abcde"` while `"aec"` is not).

## Examples

### Example 1

```
Input: s = "abc", t = "ahbgdc"
Output: true
Explanation: "abc" is a subsequence of "ahbgdc" — match a, skip h, match b, skip g, skip d, match c.
```

### Example 2

```
Input: s = "axc", t = "ahbgdc"
Output: false
Explanation: After matching 'a', there is no 'x' in the remaining part of t.
```

## Constraints

- `0 <= s.length <= 100`
- `0 <= t.length <= 10^4`
- `s` and `t` consist only of lowercase English letters.

**Follow up:** Suppose there are lots of incoming `s` (say `s1, s2, ..., sk` where `k >= 10^9`), and you want to check one by one to see if `t` has its subsequence. In this scenario, how would you change your code?

## Approach

### Two Pointers (Optimal for single query)

**Intuition:** We need to check if every character in `s` appears in `t` in the same relative order. We can use two pointers — one scanning `s`, one scanning `t`. As we walk through `t`, whenever we find a character matching the current character in `s`, we advance the `s` pointer. If the `s` pointer reaches the end, every character was matched in order.

**Algorithm:**

1. Initialize pointer `i = 0` for `s` and `j = 0` for `t`.
2. While both pointers are within bounds:
   - If `s[i] == t[j]`, advance `i` (matched one character of `s`).
   - Always advance `j` (move through `t`).
3. Return `true` if `i == len(s)` (all characters of `s` were matched).

### Follow-up: Precomputed Index Map + Binary Search

For many queries against the same `t`, scanning `t` from scratch each time is wasteful. Instead, preprocess `t` once into a data structure that allows fast lookups.

**Intuition:** Build a map from each character to its sorted list of positions in `t`. For each query `s`, walk through `s` character by character. For each character, binary search the index list to find the first occurrence at or after the current position in `t`. If found, advance past it. If not found, `s` is not a subsequence.

**Algorithm:**

1. **Preprocess:** For each character `c` in `t`, store a sorted list of indices where `c` appears.
2. **Query:** For each character `c` in `s`:
   - Look up the index list for `c`.
   - Binary search for the smallest index `>= pos` (current position in `t`).
   - If no such index exists, return `false`.
   - Otherwise, set `pos = found_index + 1`.
3. Return `true` if all characters of `s` were matched.

**Separate solution files** (`solution_followup.*`) implement this approach in all five languages.

### Alternative Approaches

| Approach | Time | Space | Notes |
|----------|------|-------|-------|
| Brute force (find each char linearly from last position) | O(s * t) | O(1) | Restart search each time — slow |
| **Two pointers** | **O(t)** | **O(1)** | **Single pass through t, optimal for one query** |
| Precomputed index map + binary search | O(t) preprocess + O(s log t) per query | O(t) | Best for many queries against same t |
| Dynamic programming | O(s * t) | O(s * t) | Overkill for this problem; useful for related problems |

## Step-by-Step Walkthrough

### Example 1: `s = "abc", t = "ahbgdc"`

```
i=0, j=0: s[0]='a' == t[0]='a' → match! i=1, j=1
i=1, j=1: s[1]='b' != t[1]='h' → skip.  j=2
i=1, j=2: s[1]='b' == t[2]='b' → match! i=2, j=3
i=2, j=3: s[2]='c' != t[3]='g' → skip.  j=4
i=2, j=4: s[2]='c' != t[4]='d' → skip.  j=5
i=2, j=5: s[2]='c' == t[5]='c' → match! i=3, j=6

i=3 == len(s)=3 → return true ✓
```

### Example 2: `s = "axc", t = "ahbgdc"`

```
i=0, j=0: s[0]='a' == t[0]='a' → match! i=1, j=1
i=1, j=1: s[1]='x' != t[1]='h' → skip.  j=2
i=1, j=2: s[1]='x' != t[2]='b' → skip.  j=3
i=1, j=3: s[1]='x' != t[3]='g' → skip.  j=4
i=1, j=4: s[1]='x' != t[4]='d' → skip.  j=5
i=1, j=5: s[1]='x' != t[5]='c' → skip.  j=6

j=6 == len(t)=6, but i=1 != len(s)=3 → return false ✓
```

## Call Trace

For `isSubsequence("abc", "ahbgdc")`:

```
isSubsequence("abc", "ahbgdc")
│
├── i=0, j=0
│
├── j=0: t[0]='a'
│   ├── s[0]='a' == 'a'? → yes
│   └── i=1
│
├── j=1: t[1]='h'
│   └── s[1]='b' == 'h'? → no
│
├── j=2: t[2]='b'
│   ├── s[1]='b' == 'b'? → yes
│   └── i=2
│
├── j=3: t[3]='g'
│   └── s[2]='c' == 'g'? → no
│
├── j=4: t[4]='d'
│   └── s[2]='c' == 'd'? → no
│
├── j=5: t[5]='c'
│   ├── s[2]='c' == 'c'? → yes
│   └── i=3
│
├── i=3 == len("abc")=3 → all matched
│
└── result: true
```

## Complexity Analysis

### Time Complexity: O(t)

- We iterate through `t` at most once with pointer `j`: O(|t|) steps.
- Pointer `i` advances at most |s| times, but this is bounded by |t| since |s| <= |t| for a valid subsequence.
- Each step does O(1) work (one character comparison).

### Space Complexity: O(1)

- Only two integer pointers (`i`, `j`) regardless of input size.

## Follow-up: Step-by-Step Walkthrough

### `t = "ahbgdc"`, query `s = "abc"`

```
Preprocessing t = "ahbgdc":
  'a' → [0]
  'b' → [2]
  'c' → [5]
  'd' → [4]
  'g' → [3]
  'h' → [1]

Query s = "abc", pos = 0:
  s[0]='a': indices=[0], bisect(0, pos=0) → idx=0, found at 0. pos=1
  s[1]='b': indices=[2], bisect(2, pos=1) → idx=0, found at 2. pos=3
  s[2]='c': indices=[5], bisect(5, pos=3) → idx=0, found at 5. pos=6

All matched → true ✓
```

### `t = "ahbgdc"`, query `s = "aaa"`

```
Query s = "aaa", pos = 0:
  s[0]='a': indices=[0], bisect(0, pos=0) → idx=0, found at 0. pos=1
  s[1]='a': indices=[0], bisect(0, pos=1) → idx=1, idx == len → NOT FOUND

return false ✓ (only one 'a' in t, but s needs three)
```

## Follow-up: Complexity Analysis

### Preprocessing: O(|t|)

- Single pass through `t` to build the index map.
- 26 lists (one per letter), total entries = |t|.

### Per Query: O(|s| * log |t|)

- For each of the |s| characters, one binary search over at most |t| indices.

### Space: O(|t|)

- The index map stores one entry per character in `t`.

## Edge Cases

| Case | Input | Output | Why |
|------|-------|--------|-----|
| Empty s | `s="", t="ahbgdc"` | `true` | Empty string is a subsequence of everything |
| Both empty | `s="", t=""` | `true` | Empty string is a subsequence of empty string |
| s longer than t | `s="abc", t="ab"` | `false` | Can't fit 3 characters in 2 |
| s equals t | `s="abc", t="abc"` | `true` | Every character matches in order |
| Single char match | `s="a", t="a"` | `true` | Trivial match |
| Single char no match | `s="a", t="b"` | `false` | Character not found |
| Match at very end | `s="c", t="abc"` | `true` | Must scan to the end |
| Empty t, non-empty s | `s="a", t=""` | `false` | Can't match any characters |
