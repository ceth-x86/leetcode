# 58. Length of Last Word

**Difficulty:** Easy

**Topics:** String

**Link:** https://leetcode.com/problems/length-of-last-word/

## Problem

Given a string `s` consisting of words and spaces, return the length of the last word in the string.

A word is a maximal substring consisting of non-space characters only.

## Examples

### Example 1

```
Input: s = "Hello World"
Output: 5
Explanation: The last word is "World" with length 5.
```

### Example 2

```
Input: s = "   fly me   to   the moon  "
Output: 4
Explanation: The last word is "moon" with length 4.
```

### Example 3

```
Input: s = "luffy is still joyboy"
Output: 6
Explanation: The last word is "joyboy" with length 6.
```

## Constraints

- `1 <= s.length <= 10^4`
- `s` consists of only English letters and spaces `' '`.
- There will be at least one word in `s`.

## Approach

### Reverse Scan (Optimal)

**Intuition:** We want the last word's length. Instead of splitting the entire string, we can scan from the right: skip trailing spaces, then count characters until we hit a space or the beginning of the string.

**Algorithm:**

1. Start at the end of the string.
2. Skip trailing spaces.
3. Count consecutive non-space characters.
4. Return the count.

### Alternative Approaches

| Approach | Time | Space | Notes |
|----------|------|-------|-------|
| Split then take last | O(n) | O(n) | Creates array of all words — wasteful |
| Strip + split last | O(n) | O(n) | Slightly better but still allocates |
| **Reverse scan** | **O(n)** | **O(1)** | **No allocation, early termination** |

## Step-by-Step Walkthrough

### Example 1: `s = "Hello World"`

```
Start at i=10: s[10]='d' (not a space, start counting)
i=10: 'd' → length=1
i=9:  'l' → length=2
i=8:  'r' → length=3
i=7:  'o' → length=4
i=6:  'W' → length=5
i=5:  ' ' → stop

Result: 5 ✓
```

### Example 2: `s = "   fly me   to   the moon  "`

```
Start at i=26: s[26]=' ' (space, skip)
i=25: ' ' (space, skip)
i=24: 'n' → start counting, length=1
i=23: 'o' → length=2
i=22: 'o' → length=3
i=21: 'm' → length=4
i=20: ' ' → stop

Result: 4 ✓
```

### Example 3: `s = "luffy is still joyboy"`

```
Start at i=20: s[20]='y' (not a space, start counting)
i=20: 'y' → length=1
i=19: 'o' → length=2
i=18: 'b' → length=3
i=17: 'y' → length=4
i=16: 'o' → length=5
i=15: 'j' → length=6
i=14: ' ' → stop

Result: 6 ✓
```

## Call Trace

For `lengthOfLastWord("   fly me   to   the moon  ")`:

```
lengthOfLastWord("   fly me   to   the moon  ")
│
├── i=26: ' ' → skip trailing space
├── i=25: ' ' → skip trailing space
│
├── i=24: 'n' → count=1
├── i=23: 'o' → count=2
├── i=22: 'o' → count=3
├── i=21: 'm' → count=4
├── i=20: ' ' → hit space, stop
│
└── result: 4
```

## Complexity Analysis

### Time Complexity: O(n)

- Worst case: trailing spaces span the entire string except one word at the start — we scan all n characters.
- Best case: no trailing spaces and the last word is short — we scan just a few characters from the end.
- In practice, much faster than O(n) for typical inputs with short trailing spaces.

### Space Complexity: O(1)

- Only an index variable and a counter — no extra allocation.

## Edge Cases

| Case | Input | Output | Why |
|------|-------|--------|-----|
| No trailing spaces | `"Hello World"` | `5` | Last word ends at the string's end |
| Trailing spaces | `"Hello World   "` | `5` | Must skip spaces first |
| Single word | `"Hello"` | `5` | Entire string is one word |
| Single word with spaces | `"   Hello   "` | `5` | Spaces on both sides |
| Single character | `"a"` | `1` | Minimum valid input |
| All same characters | `"aaaa"` | `4` | One long word |
| Many spaces between | `"a   b"` | `1` | Last word is just "b" |
