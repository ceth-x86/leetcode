# 187. Repeated DNA Sequences

**Difficulty:** Medium

**Topics:** String, Hash Table, Bit Manipulation, Rolling Hash

**Link:** https://leetcode.com/problems/repeated-dna-sequences/

## Problem

The DNA sequence is composed of the nucleotides `'A'`, `'C'`, `'G'`, and `'T'`.

Given a string `s` that represents a DNA sequence, return all 10-letter-long substrings that occur more than once in `s`. You may return the answer in any order.

## Examples

### Example 1

```text
Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
Output: ["AAAAACCCCC", "CCCCCAAAAA"]
```

### Example 2

```text
Input: s = "AAAAAAAAAAAAA"
Output: ["AAAAAAAAAA"]
```

## Constraints

- `1 <= s.length <= 10^5`
- `s[i]` is either `'A'`, `'C'`, `'G'`, or `'T'`

## Approach

This directory contains two solution variants:

- `hash_set/` scans every length-10 window and stores substrings directly.
- `rolling_hash/` encodes each window into 20 bits and slides that encoding across the string.

### Hash Set Approach

**Idea:** Every valid answer is a substring of length 10. Iterate over all such windows, remember which ones have been seen before, and collect those that appear a second time.

**Algorithm:**

1. If `len(s) < 10`, return an empty list.
2. For every starting index `i`, extract `s[i:i+10]`.
3. If the substring was seen before and was not already added to the answer, append it.
4. Otherwise, record it in `seen`.

### Rolling Hash Approach

**Idea:** Because the alphabet has only four letters, each character can be represented by 2 bits:

- `A -> 00`
- `C -> 01`
- `G -> 10`
- `T -> 11`

A 10-character window then fits in 20 bits. This lets us update the current window in O(1) time without rebuilding a 10-character substring for every step.

**Algorithm:**

1. Encode each character into 2 bits.
2. Build a rolling 20-bit value for the current window.
3. Once the first 10 characters are processed, the encoded value uniquely identifies the current window.
4. Track encoded windows in `seen`.
5. When the same code appears again for the first time, append the corresponding substring to the answer.

## Step-by-Step Walkthrough

### Hash Set Walkthrough

#### Example 1: `s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"`

Track each 10-letter substring directly:

```text
start 0  -> "AAAAACCCCC" -> first time, add to seen
start 1  -> "AAAACCCCCA" -> first time, add to seen
start 2  -> "AAACCCCCAA" -> first time, add to seen
...
start 5  -> "CCCCCAAAAA" -> first time, add to seen
...
start 10 -> "AAAAACCCCC" -> already in seen, add to result
...
start 16 -> "CCCCCAAAAA" -> already in seen, add to result
```

At the end:

```text
result = ["AAAAACCCCC", "CCCCCAAAAA"]
```

#### Example 2: `s = "AAAAAAAAAAAAA"`

Every 10-letter window is identical:

```text
start 0 -> "AAAAAAAAAA" -> first time, add to seen
start 1 -> "AAAAAAAAAA" -> already in seen, add to result
start 2 -> "AAAAAAAAAA" -> already repeated, ignore
start 3 -> "AAAAAAAAAA" -> already repeated, ignore
```

Final answer:

```text
["AAAAAAAAAA"]
```

### Rolling Hash Walkthrough

#### Example 1: `s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"`

Encode `A/C/G/T` as `0/1/2/3` and update one 20-bit rolling value:

```text
index 0..9   builds hash for "AAAAACCCCC" -> first time, add encoded window to seen
index 1..10  gives hash for "AAAACCCCCA" -> first time, add to seen
index 2..11  gives hash for "AAACCCCCAA" -> first time, add to seen
...
index 5..14  gives hash for "CCCCCAAAAA" -> first time, add to seen
...
index 10..19 gives hash for "AAAAACCCCC" -> encoded window already in seen, add substring to result
...
index 16..25 gives hash for "CCCCCAAAAA" -> encoded window already in seen, add substring to result
```

Final answer:

```text
["AAAAACCCCC", "CCCCCAAAAA"]
```

#### Example 2: `s = "AAAAAAAAAAAAA"`

Because `A -> 00`, every 10-letter window encodes to the same 20-bit value:

```text
index 0..9   -> hash 0 -> first time, add to seen
index 1..10  -> hash 0 -> already in seen, add "AAAAAAAAAA" to result
index 2..11  -> hash 0 -> already repeated, ignore
index 3..12  -> hash 0 -> already repeated, ignore
```

Final answer:

```text
["AAAAAAAAAA"]
```

## Call Trace

### Hash Set Call Trace

For the hash-set approach on `s = "AAAAAAAAAAAAA"`:

```text
findRepeatedDnaSequences("AAAAAAAAAAAAA")
│
├── seen = {}
├── repeated = {}
│
├── start=0:
│   fragment = "AAAAAAAAAA"
│   not in seen
│   add to seen
│
├── start=1:
│   fragment = "AAAAAAAAAA"
│   already in seen
│   not yet in repeated
│   add to repeated and result
│
├── start=2:
│   fragment = "AAAAAAAAAA"
│   already in repeated
│   ignore
│
├── start=3:
│   fragment = "AAAAAAAAAA"
│   already in repeated
│   ignore
│
└── result = ["AAAAAAAAAA"]
```

### Rolling Hash Call Trace

For the rolling-hash approach on `s = "AAAAAAAAAAAAA"`:

```text
findRepeatedDnaSequences("AAAAAAAAAAAAA")
│
├── encode A as 00
├── build first 10-letter window:
│   hash("AAAAAAAAAA") = 0
│   seen = {0}
│
├── slide to index 1..10:
│   hash stays 0
│   0 already in seen
│   add "AAAAAAAAAA" to result
│
├── slide to index 2..11:
│   hash stays 0
│   already recorded as repeated
│
├── slide to index 3..12:
│   hash stays 0
│   already recorded as repeated
│
└── result = ["AAAAAAAAAA"]
```

## Complexity Analysis

### Hash Set Complexity

- Time: `O(n)` because there are `n - 9` windows and each substring has fixed length 10, so each extraction is constant-time with respect to `n`
- Space: `O(n)` in the worst case for the `seen` and `repeated` sets when many windows are distinct

### Rolling Hash Complexity

- Time: `O(n)` because each step updates the 20-bit code in constant time and only slices the original string when a repeated window is first reported
- Space: `O(n)` for the sets of encoded windows in the worst case

## Solution Comparison

### Hash Set Comparison

**Pros:**

- Simplest variant to understand and implement
- Logic maps directly to the problem statement: inspect each 10-character substring and remember whether it was seen
- Easier to debug because the sets contain real DNA fragments rather than encoded integers

**Cons:**

- Stores many full substrings, so constant factors are worse
- Rebuilds a 10-character slice for every window
- Less attractive when the goal is to optimize memory footprint or per-window overhead

### Rolling Hash Comparison

**Pros:**

- More space-efficient per stored window because duplicate detection uses compact integer encodings
- Avoids rebuilding and storing every 10-character substring in the main tracking set
- Better illustrates how to exploit the tiny 4-letter alphabet

**Cons:**

- Harder to read and explain than the direct hash-set version
- More implementation detail: encoding, masking, and rolling updates all need to be correct
- Easier to introduce subtle bugs than in the substring-based approach

### When To Prefer Which

- Prefer `hash_set/` when clarity, maintainability, and interview readability matter most.
- Prefer `rolling_hash/` when you want the more optimized and technically interesting version that reduces per-window overhead.

## Edge Cases

| Case | Input | Output | Why |
|------|-------|--------|-----|
| Too short | `"ACGT"` | `[]` | No 10-letter window exists |
| Exactly 10 chars | `"ACGTACGTAC"` | `[]` | Only one window, so nothing repeats |
| All same chars | `"AAAAAAAAAAAAA"` | `["AAAAAAAAAA"]` | Same window repeats many times but appears once in answer |
| Repeat appears late | `"CCCCCAAAAACCCCCAAAAAG"` | `["CCCCCAAAAA"]` | Duplicate may appear only after many unique windows |
| Multiple repeated windows | `"AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"` | `["AAAAACCCCC", "CCCCCAAAAA"]` | Need to report each repeated window once |
