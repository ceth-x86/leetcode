# LeetCode Interview Prep

Repository for interview preparation by solving LeetCode problems. Each problem is solved in five languages: Python, C++, Go, Rust, and Clojure.

## Project Structure

```
leetcode/
├── CLAUDE.md
├── README.md                    # Index of all solved problems with links
├── indexes/
│   ├── difficulty.md            # Problems grouped by difficulty
│   └── topics.md               # Problems grouped by topic
└── NNNN_problem_slug/           # e.g. 0217_contains_duplicate/
    ├── README.md                # Problem statement + detailed solution
    ├── python/
    │   ├── README.md            # Language-specific notes
    │   ├── solution.py
    │   ├── solution_test.py     # pytest
    │   └── visualize.py         # Algorithm visualization
    ├── cpp/
    │   ├── README.md            # Language-specific notes
    │   └── solution.cpp         # Solution + tests in one file
    ├── go/
    │   ├── README.md            # Language-specific notes
    │   ├── go.mod
    │   ├── solution.go
    │   └── solution_test.go
    ├── rust/
    │   ├── README.md            # Language-specific notes
    │   ├── Cargo.toml
    │   └── src/
    │       └── lib.rs           # Solution + #[cfg(test)] tests
    └── clojure/
        ├── README.md            # Language-specific notes
        ├── src/solution.clj
        └── test/solution_test.clj
```

## README.md Format (per problem)

Each problem's `README.md` must contain the problem statement followed by a detailed solution:

1. **Problem statement** — brief description and link to LeetCode
2. **Approach** — explanation of the algorithm and intuition behind it
3. **Step-by-step walkthrough** — trace through examples showing how the algorithm works on concrete inputs
4. **Call trace** — detailed execution trace (function calls, variable states, recursive tree if applicable)
5. **Complexity analysis** — time and space complexity with justification
6. **Edge cases** — list of edge cases and how the solution handles them

## Language-Specific README.md

Each language subdirectory has its own `README.md` describing:
- **Language features used** — specific constructs, idioms, standard library types
- **Implementation decisions** — why this approach over alternatives, tradeoffs
- **How to run tests** — exact command for this language

This file does NOT duplicate the problem statement or algorithm explanation from the problem's root `README.md`.

## Language-Specific Guidelines

### Python
- Idiomatic Python: list comprehensions, generators, `collections`, `itertools`, type hints
- Tests: `pytest`
- Include `visualize.py` with algorithm visualization (ASCII art, step-by-step state printing, or matplotlib plots where appropriate)

### C++
- Modern C++ (C++17+): `std::vector`, `std::unordered_map`, structured bindings, `auto`, range-based loops
- Tests: single-file tests with assertions or a lightweight framework
- Avoid raw pointers when possible; use STL containers and algorithms

### Go
- Idiomatic Go: slices, maps, error handling, table-driven tests
- Tests: standard `testing` package with `t.Run` subtests
- Follow Go naming conventions (`camelCase` for unexported, `PascalCase` for exported)

### Rust
- Idiomatic Rust: ownership, iterators, `Option`/`Result`, pattern matching
- Tests: built-in `#[cfg(test)]` module with `#[test]` functions
- Use Cargo project per problem

### Clojure
- Idiomatic Clojure: immutable data, sequences, higher-order functions, destructuring, threading macros (`->`, `->>`)
- Tests: `clojure.test`
- Prefer pure functions and functional composition

## README.md Format

The root `README.md` is an index of all solved problems:

```markdown
# LeetCode Solutions

| # | Problem | Difficulty | Topics | Solution |
|---|---------|------------|--------|----------|
| 217 | [Contains Duplicate](https://leetcode.com/problems/contains-duplicate/) | Easy | Array, Hash Table | [Solution](0217_contains_duplicate/) |
```

## Workflow

1. Create problem directory: `NNNN_problem_slug/` (e.g. `0217_contains_duplicate/`)
2. Write `README.md` with problem statement and full solution explanation
3. Implement solution in all five languages with tests
4. Write `README.md` per language with features, decisions, and run instructions
5. Add Python visualization
6. Update root `README.md` with the new problem entry
7. Update `indexes/difficulty.md` with the new problem
8. Update `indexes/topics.md` with the new problem (a problem may appear in multiple topics)
