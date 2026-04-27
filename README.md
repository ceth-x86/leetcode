# LeetCode Solutions

Interview preparation — each problem solved in Python, C++, Go, Rust, and Clojure with detailed explanations.

**Browse by:** [Difficulty](indexes/difficulty.md) | [Topic](indexes/topics.md)

| # | Problem | Difficulty | Topics | Solution |
|---|---------|------------|--------|----------|
| 1 | [Two Sum](https://leetcode.com/problems/two-sum/) | Easy | Array, Hash Table | [Solution](0001_two_sum/) |
| 58 | [Length of Last Word](https://leetcode.com/problems/length-of-last-word/) | Easy | String | [Solution](0058_length_of_last_word/) |
| 187 | [Repeated DNA Sequences](https://leetcode.com/problems/repeated-dna-sequences/) | Medium | String, Hash Table, Bit Manipulation, Rolling Hash | [Solution](0187_repeated_dna_sequences/) |
| 217 | [Contains Duplicate](https://leetcode.com/problems/contains-duplicate/) | Easy | Array, Hash Table | [Solution](0217_contains_duplicate/) |
| 239 | [Sliding Window Maximum](https://leetcode.com/problems/sliding-window-maximum/) | Hard | Array, Queue, Sliding Window, Heap (Priority Queue), Monotonic Queue | [Solution](0239_sliding_window_maximum/) |
| 242 | [Valid Anagram](https://leetcode.com/problems/valid-anagram/) | Easy | Hash Table, String, Sorting | [Solution](0242_valid_anagram/) |
| 392 | [Is Subsequence](https://leetcode.com/problems/is-subsequence/) | Easy | Two Pointers, String, Dynamic Programming | [Solution](0392_is_subsequence/) |
| 1299 | [Replace Elements with Greatest Element on Right Side](https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/) | Easy | Array | [Solution](1299_replace_elements_with_greatest_element_on_right_side/) |
| 3903 | [Smallest Stable Index I](https://leetcode.com/problems/smallest-stable-index-i/) | Easy | Array | [Solution](3903_smallest_stable_index_i/) |

## Running Tests

All commands are run from a solution's language subdirectory (e.g. `0187_repeated_dna_sequences/rolling_hash/python/`).

**Python** (pytest)
```bash
python3 -m pytest solution_test.py -v
```

**C++** (C++17, assertions in main)
```bash
g++ -std=c++17 -o solution solution.cpp && ./solution
```

**Go** (standard testing package)
```bash
go test -v
```

**Rust** (Cargo)
```bash
cargo test
```

**Clojure** (clojure.test)
```bash
clj -M -e "(require '[clojure.test :refer [run-tests]]) (load-file \"src/solution.clj\") (load-file \"test/solution_test.clj\") (run-tests 'solution-test)"
```
