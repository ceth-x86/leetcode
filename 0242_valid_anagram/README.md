# 242. Valid Anagram

**Difficulty:** Easy

**Topics:** Hash Table, String, Sorting

**Link:** https://leetcode.com/problems/valid-anagram/

## Problem

Given two strings `s` and `t`, return `true` if `t` is an anagram of `s`, and `false` otherwise.

An anagram is a word formed by rearranging the letters of another word, using all the original letters exactly once.

## Examples

### Example 1

```
Input: s = "anagram", t = "nagaram"
Output: true
```

### Example 2

```
Input: s = "rat", t = "car"
Output: false
```

## Constraints

- `1 <= s.length, t.length <= 5 * 10^4`
- `s` and `t` consist of lowercase English letters.

**Follow up:** What if the inputs contain Unicode characters? How would you adapt your solution to such a case?

## Approach

### Character Frequency Count (Optimal)

**Intuition:** Two strings are anagrams if and only if they contain the same characters with the same frequencies. We count occurrences of each character in `s`, then subtract occurrences from `t`. If all counts end up at zero, the strings are anagrams.

**Algorithm:**

1. If `len(s) != len(t)`, return `false` immediately (anagrams must have equal length).
2. Create a frequency map (or array of size 26 for lowercase English letters).
3. For each character in `s`, increment its count.
4. For each character in `t`, decrement its count.
5. If all counts are zero, return `true`. Otherwise, return `false`.

**Optimization:** Instead of two passes, we can do a single pass incrementing for `s[i]` and decrementing for `t[i]` simultaneously.

### Alternative Approaches

| Approach | Time | Space | Notes |
|----------|------|-------|-------|
| Sort both strings | O(n log n) | O(n) | Sort and compare — simple but slower |
| **Frequency count (array)** | **O(n)** | **O(1)** | **26-element array for lowercase English** |
| Frequency count (hash map) | O(n) | O(k) | General solution for Unicode (k = unique chars) |

## Step-by-Step Walkthrough

### Example 1: `s = "anagram"`, `t = "nagaram"`

```
Length check: len("anagram") == len("nagaram") == 7 ✓

Building frequency from s = "anagram":
  a:+1 → {a:1}
  n:+1 → {a:1, n:1}
  a:+1 → {a:2, n:1}
  g:+1 → {a:2, n:1, g:1}
  r:+1 → {a:2, n:1, g:1, r:1}
  a:+1 → {a:3, n:1, g:1, r:1}
  m:+1 → {a:3, n:1, g:1, r:1, m:1}

Subtracting frequency from t = "nagaram":
  n:-1 → {a:3, n:0, g:1, r:1, m:1}
  a:-1 → {a:2, n:0, g:1, r:1, m:1}
  g:-1 → {a:2, n:0, g:0, r:1, m:1}
  a:-1 → {a:1, n:0, g:0, r:1, m:1}
  r:-1 → {a:1, n:0, g:0, r:0, m:1}
  a:-1 → {a:0, n:0, g:0, r:0, m:1}
  m:-1 → {a:0, n:0, g:0, r:0, m:0}

All counts are zero → return true ✓
```

### Example 2: `s = "rat"`, `t = "car"`

```
Length check: len("rat") == len("car") == 3 ✓

Building frequency from s = "rat":
  r:+1 → {r:1}
  a:+1 → {r:1, a:1}
  t:+1 → {r:1, a:1, t:1}

Subtracting frequency from t = "car":
  c:-1 → {r:1, a:1, t:1, c:-1}
  a:-1 → {r:1, a:0, t:1, c:-1}
  r:-1 → {r:0, a:0, t:1, c:-1}

Counts not all zero (t:1, c:-1) → return false ✓
```

## Call Trace

For `isAnagram("anagram", "nagaram")`:

```
isAnagram("anagram", "nagaram")
│
├── len(s)=7 == len(t)=7 → continue
│
├── count = [0] * 26
│
├── single pass (i=0..6):
│   i=0: s[0]='a' count[0]++ → 1,  t[0]='n' count[13]-- → -1
│   i=1: s[1]='n' count[13]++ → 0,  t[1]='a' count[0]-- → 0
│   i=2: s[2]='a' count[0]++ → 1,  t[2]='g' count[6]-- → -1
│   i=3: s[3]='g' count[6]++ → 0,  t[3]='a' count[0]-- → 0
│   i=4: s[4]='r' count[17]++ → 1,  t[4]='r' count[17]-- → 0
│   i=5: s[5]='a' count[0]++ → 1,  t[5]='a' count[0]-- → 0
│   i=6: s[6]='m' count[12]++ → 1,  t[6]='m' count[12]-- → 0
│
├── all(count[i] == 0) → true
│
└── result: true
```

## Complexity Analysis

### Time Complexity: O(n)

- Length comparison: O(1).
- Single pass through both strings simultaneously: O(n), where n = len(s).
- Final check that all 26 counts are zero: O(1) (constant alphabet size).
- Total: O(n).

### Space Complexity: O(1)

- Fixed-size array of 26 integers, regardless of input size.
- For the Unicode follow-up: O(k) where k is the number of unique characters.

## Edge Cases

| Case | Input | Output | Why |
|------|-------|--------|-----|
| Different lengths | `s="ab"`, `t="abc"` | `false` | Anagrams must have equal length |
| Single char equal | `s="a"`, `t="a"` | `true` | Trivial anagram |
| Single char different | `s="a"`, `t="b"` | `false` | Different characters |
| Same string | `s="abc"`, `t="abc"` | `true` | A string is an anagram of itself |
| All same char | `s="aaa"`, `t="aaa"` | `true` | All frequencies match |
| Repeated with mismatch | `s="aacc"`, `t="ccac"` | `false` | Same chars but different counts |

## Follow-up: Unicode

For Unicode characters, replace the fixed-size 26-element array with a hash map. The algorithm stays the same — increment for `s`, decrement for `t`, check all values are zero. Time remains O(n), space becomes O(k) where k is the number of unique characters.
