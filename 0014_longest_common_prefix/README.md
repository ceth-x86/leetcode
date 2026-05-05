# 14. Longest Common Prefix

**Difficulty:** Easy

**Topics:** String

**Link:** [https://leetcode.com/problems/longest-common-prefix/](https://leetcode.com/problems/longest-common-prefix/)

## Problem

Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string `""`.

## Examples

### Example 1
```
Input: strs = ["flower","flow","flight"]
Output: "fl"
```

### Example 2
```
Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
```

## Constraints
- `1 <= strs.length <= 200`
- `0 <= strs[i].length <= 200`
- `strs[i]` consists of only lowercase English letters if it is non-empty.

---

## Approach

### Horizontal Scanning
We assume the first string is the common prefix. We then compare it with the next string and shorten it until it's also a prefix of that string. We repeat this for all strings.

### Vertical Scanning
We iterate through the characters of the strings index by index. We take the first string as a reference and compare its $i$-th character with the $i$-th character of all other strings.

### Sorting
We sort the array of strings lexicographically. The common prefix of the entire array must be the common prefix of the **first** and the **last** strings in the sorted array.

### Binary Search
We binary search on the length of the prefix. The range is `[0, minLen]`. For a given length `mid`, we check if the first `mid` characters of the first string are a common prefix for all strings.

### Trie (Prefix Tree)
We insert all strings into a Trie. The longest common prefix is the path from the root until we hit a node that has more than one child or is marked as the end of a word.

### Comparison of Approaches

| Approach | Time | Space | Notes |
|----------|------|-------|-------|
| Horizontal Scanning | $O(S)$ | $O(1)$ | Simple, good if LCP is long |
| Vertical Scanning | $O(S)$ | $O(1)$ | **Optimal for early exits (short LCP)** |
| Sorting | $O(N \cdot K \log N)$ | $O(1)$ | Elegant but slower due to sorting |
| Binary Search | $O(S \log K)$ | $O(1)$ | Good for very long strings |
| Trie | $O(S)$ | $O(S)$ | Efficient for multiple queries, high memory |

---

## Step-by-Step Walkthrough

### Horizontal Scanning: `strs = ["flower","flow","flight"]`
```
1. Start: prefix = "flower"
2. Compare with "flow":
   - "flow" starts with "flow"? No. Shorten to "flowe".
   - "flow" starts with "flow"? Yes. prefix = "flow"
3. Compare with "flight":
   - "flight" starts with "flow"? No. Shorten to "flo".
   - "flight" starts with "flo"? No. Shorten to "fl".
   - "flight" starts with "fl"? Yes. prefix = "fl"
Result: "fl"
```

### Vertical Scanning: `strs = ["flower","flow","flight"]`
```
Index 0: 'f' (flower[0], flow[0], flight[0]) -> All match
Index 1: 'l' (flower[1], flow[1], flight[1]) -> All match
Index 2: 'o' (flower[2], flow[2]) vs 'i' (flight[2]) -> MISMATCH
Result: "fl"
```

### Sorting: `strs = ["flower","flow","flight"]`
```
1. Sorted: ["flight", "flow", "flower"]
2. First: "flight", Last: "flower"
3. Index 0: 'f' == 'f' (match)
4. Index 1: 'l' == 'l' (match)
5. Index 2: 'i' != 'o' (mismatch)
Result: "fl"
```

### Binary Search: `strs = ["flower","flow","flight"]`
```
Min Length: 4 ("flow")
Range: [1, 4] -> Mid: 2
Check "fl": Common? Yes. -> Range [3, 4], ans = 2
Mid: 3
Check "flo": Common? No. -> Range [3, 3]
Mid: 3 (already checked) -> Stop.
Result: "fl"
```

### Trie: `strs = ["flower","flow","flight"]`
```
Insert "flower", "flow", "flight"
Traverse from root:
- Node 'f': 1 child, not end -> prefix="f"
- Node 'l': 1 child, not end -> prefix="fl"
- Node 'o'/'i': BRANCH FOUND (2 children) -> Stop
Result: "fl"
```

---

## Call Trace

### Vertical Scanning
```
longestCommonPrefix(["flower", "flow", "flight"])
│
├── i=0: char='f'
│   ├── strs[1][0] == 'f' (match)
│   └── strs[2][0] == 'f' (match)
│
├── i=1: char='l'
│   ├── strs[1][1] == 'l' (match)
│   └── strs[2][1] == 'l' (match)
│
└── i=2: char='o'
    ├── strs[1][2] == 'o' (match)
    └── strs[2][2] == 'i' (MISMATCH!)
        └── return "fl"
```

---

## Complexity Analysis

### Horizontal Scanning
- **Time Complexity:** $O(S)$, where $S$ is the sum of characters.
- **Space Complexity:** $O(1)$.

### Vertical Scanning
- **Time Complexity:** $O(S)$. Best case is $O(n \cdot LCP\_length)$.
- **Space Complexity:** $O(1)$.

### Sorting
- **Time Complexity:** $O(N \cdot K \log N)$, where $N$ is the number of strings and $K$ is the max length.
- **Space Complexity:** $O(1)$ or $O(N \cdot K)$ (sort overhead).

### Binary Search
- **Time Complexity:** $O(S \log K)$.
- **Space Complexity:** $O(1)$.

### Trie
- **Time Complexity:** $O(S)$.
- **Space Complexity:** $O(S)$.

---

## Edge Cases

| Case | Input | Output | Why |
|------|-------|--------|-----|
| Empty list | `[]` | `""` | No strings to compare |
| Empty string in list | `["", "b"]` | `""` | Prefix of empty string is empty |
| No common prefix | `["a", "b"]` | `""` | Mismatch at first character |
| One string | `["a"]` | `"a"` | The string itself is the prefix |
| All identical | `["a", "a"]` | `"a"` | Full string is the prefix |
