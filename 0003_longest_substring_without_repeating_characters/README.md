# 3. Longest Substring Without Repeating Characters

**Difficulty:** Medium

**Topics:** Hash Table, String, Sliding Window

**Link:** https://leetcode.com/problems/longest-substring-without-repeating-characters/

## Problem

Given a string `s`, find the length of the longest substring without duplicate characters.

A substring is a contiguous sequence of characters within the string.

## Examples

### Example 1

```text
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with length 3.
```

### Example 2

```text
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b".
```

### Example 3

```text
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with length 3.
"pwke" is a subsequence, not a substring.
```

## Constraints

- `0 <= s.length <= 5 * 10^4`
- `s` consists of English letters, digits, symbols, and spaces.

## Approach

### Sliding Window Approach

**Intuition:** We need the longest contiguous window with no repeated characters. Keep a left boundary for the current window and scan with a right boundary. If the current character was last seen inside the current window, move the left boundary right after its previous occurrence. Then the window is valid again.

**Algorithm:**

1. Create a map `last_seen` from character to its most recent index.
2. Initialize `left = 0` and `best = 0`.
3. For each index `right` and character `ch`:
   - If `ch` was seen at an index `>= left`, move `left` to `last_seen[ch] + 1`.
   - Store `last_seen[ch] = right`.
   - Update `best = max(best, right - left + 1)`.
4. Return `best`.

## Step-by-Step Walkthrough

### Sliding Window Walkthrough: `s = "abcabcbb"`

```text
left = 0, best = 0, last_seen = {}

right=0, ch='a':
  'a' not in window
  window = "a", best = 1
  last_seen = {'a': 0}

right=1, ch='b':
  'b' not in window
  window = "ab", best = 2
  last_seen = {'a': 0, 'b': 1}

right=2, ch='c':
  'c' not in window
  window = "abc", best = 3
  last_seen = {'a': 0, 'b': 1, 'c': 2}

right=3, ch='a':
  'a' was seen at 0, inside current window
  move left from 0 to 1
  window = "bca", best = 3
  last_seen['a'] = 3

right=4, ch='b':
  'b' was seen at 1, inside current window
  move left from 1 to 2
  window = "cab", best = 3
  last_seen['b'] = 4

right=5, ch='c':
  'c' was seen at 2, inside current window
  move left from 2 to 3
  window = "abc", best = 3
  last_seen['c'] = 5

right=6, ch='b':
  'b' was seen at 4, inside current window
  move left from 3 to 5
  window = "cb", best = 3
  last_seen['b'] = 6

right=7, ch='b':
  'b' was seen at 6, inside current window
  move left from 5 to 7
  window = "b", best = 3
  last_seen['b'] = 7

Result: 3
```

### Sliding Window Walkthrough: `s = "pwwkew"`

```text
right=0, 'p': window = "p", best = 1
right=1, 'w': window = "pw", best = 2
right=2, 'w': repeat inside window, left moves to 2, window = "w", best = 2
right=3, 'k': window = "wk", best = 2
right=4, 'e': window = "wke", best = 3
right=5, 'w': repeat inside window, left moves to 3, window = "kew", best = 3

Result: 3
```

## Call Trace

For `lengthOfLongestSubstring("abba")`:

```text
lengthOfLongestSubstring("abba")
|
+-- left = 0, best = 0, last_seen = {}
|
+-- right=0, ch='a'
|   +-- no repeat in current window
|   +-- last_seen['a'] = 0
|   +-- window length = 1, best = 1
|
+-- right=1, ch='b'
|   +-- no repeat in current window
|   +-- last_seen['b'] = 1
|   +-- window length = 2, best = 2
|
+-- right=2, ch='b'
|   +-- previous 'b' at 1 is inside window [0..1]
|   +-- left = 1 + 1 = 2
|   +-- last_seen['b'] = 2
|   +-- window length = 1, best = 2
|
+-- right=3, ch='a'
|   +-- previous 'a' at 0 is outside window [2..2]
|   +-- left remains 2
|   +-- last_seen['a'] = 3
|   +-- window length = 2, best = 2
|
+-- result: 2
```

## Complexity Analysis

### Sliding Window Complexity

**Time Complexity:** O(n)

- Each character is processed once by the right boundary.
- The left boundary only moves forward.
- Map lookup and update are O(1) on average.

**Space Complexity:** O(min(n, m))

- The map stores the most recent index for characters seen in the string.
- `m` is the character set size.

## Edge Cases

| Case | Input | Output | Why |
|------|-------|--------|-----|
| Empty string | `""` | `0` | No substring exists |
| Single character | `"a"` | `1` | One-character window |
| All same | `"bbbbb"` | `1` | Window collapses on every repeat |
| No repeats | `"abcdef"` | `6` | Whole string is valid |
| Repeat after stale occurrence | `"abba"` | `2` | Old `'a'` is outside the active window |
| Repeat after gap | `"dvdf"` | `3` | Longest substring is `"vdf"` |
| Includes spaces/symbols | `"a! b@a"` | `5` | Spaces and symbols are normal characters |
