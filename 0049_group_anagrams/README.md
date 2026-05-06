# 49. Group Anagrams

**Difficulty:** Medium

**Topics:** Hash Table, String, Sorting

**Link:** [https://leetcode.com/problems/group-anagrams/](https://leetcode.com/problems/group-anagrams/)

## Problem

Given an array of strings `strs`, group the anagrams together. You can return the answer in any order.

An **Anagram** is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

## Examples

### Example 1
```
Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
```

### Example 2
```
Input: strs = [""]
Output: [[""]]
```

### Example 3
```
Input: strs = ["a"]
Output: [["a"]]
```

## Constraints
- `1 <= strs.length <= 10^4`
- `0 <= strs[i].length <= 100`
- `strs[i]` consists of lowercase English letters.

---

## Approach

### Sorted Key
The simplest way to identify anagrams is to sort the characters of each string. All anagrams will result in the same sorted string, which we can use as a key in a hash map.

### Frequency Map
Instead of sorting, we can count the frequency of each character (a-z). A fixed-size array or a tuple of 26 integers serves as the canonical key. This avoids the $O(K \log K)$ sorting cost.

### Comparison of Approaches

| Approach | Time | Space | Notes |
|----------|------|-------|-------|
| **Sorted Key** | $O(N \cdot K \log K)$ | $O(N \cdot K)$ | Simple, efficient for short strings |
| **Frequency Map** | $O(N \cdot K)$ | $O(N \cdot K)$ | **Linear time complexity**, better for long strings |

---

## Step-by-Step Walkthrough

### Sorted Key: `strs = ["eat", "tea", "tan"]`
```
1. Word: "eat" -> Sorted: "aet" -> Map: {"aet": ["eat"]}
2. Word: "tea" -> Sorted: "aet" -> Map: {"aet": ["eat", "tea"]}
3. Word: "tan" -> Sorted: "ant" -> Map: {"aet": ["eat", "tea"], "ant": ["tan"]}
Result: [["eat", "tea"], ["tan"]]
```

### Frequency Map: `strs = ["eat"]`
```
1. Word: "eat"
2. Count: a=1, e=1, t=1 (others=0)
3. Key: (1, 0, 0, 0, 1, ..., 1, ..., 0)
4. Map: {key: ["eat"]}
```

---

## Call Trace

### Sorted Key Approach
```
groupAnagrams(["eat", "tea", "tan"])
│
├── "eat" -> sort() -> "aet"
│   └── groups["aet"].push("eat")
│
├── "tea" -> sort() -> "aet"
│   └── groups["aet"].push("tea")
│
├── "tan" -> sort() -> "ant"
│   └── groups["ant"].push("tan")
│
└── return [["eat", "tea"], ["tan"]]
```

---

## Complexity Analysis

### Sorted Key
- **Time Complexity:** $O(N \cdot K \log K)$, where $N$ is the number of strings and $K$ is the maximum length of a string. We sort each string.
- **Space Complexity:** $O(N \cdot K)$ to store the groups.

### Frequency Map
- **Time Complexity:** $O(N \cdot K)$, because we iterate through each string and each character exactly once.
- **Space Complexity:** $O(N \cdot K)$ to store the groups.

---

## Edge Cases

| Case | Input | Output | Why |
|------|-------|--------|-----|
| Empty list | `[]` | `[]` | No strings to group |
| Empty string | `[""]` | `[[""]]` | Empty string is its own anagram |
| Single character | `["a", "a"]` | `[["a", "a"]]` | Same characters are anagrams |
| No anagrams | `["a", "b"]` | `[["a"], ["b"]]` | Different characters go to different groups |
