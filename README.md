# LeetCode Solutions

Interview preparation — each problem solved in Python, C++, Go, Rust, and Clojure with detailed explanations.

| # | Problem | Difficulty | Topics | Solution |
|---|---------|------------|--------|----------|
| 217 | [Contains Duplicate](https://leetcode.com/problems/contains-duplicate/) | Easy | Array, Hash Table | [Solution](0217_contains_duplicate/) |
| 242 | [Valid Anagram](https://leetcode.com/problems/valid-anagram/) | Easy | Hash Table, String, Sorting | [Solution](0242_valid_anagram/) |

## Running Tests

All commands are run from the problem's language subdirectory (e.g. `0217_contains_duplicate/python/`).

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
