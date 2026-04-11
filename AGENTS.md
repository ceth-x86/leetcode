# LeetCode Repository Instructions

This file adapts the repository guidance from `CLAUDE.md` into Codex-readable project instructions.

## Scope

These instructions apply to the entire repository.

## Repository Purpose

This repository is for interview preparation through LeetCode problems. Each problem is solved in five languages:

- Python
- C++
- Go
- Rust
- Clojure

## Expected Repository Structure

```text
leetcode/
├── AGENTS.md
├── CLAUDE.md
├── README.md
├── indexes/
│   ├── difficulty.md
│   └── topics.md
└── NNNN_problem_slug/
    ├── README.md
    ├── hash_set/
    │   ├── python/
    │   │   ├── README.md
    │   │   ├── solution.py
    │   │   ├── solution_test.py
    │   │   └── visualize.py
    │   ├── cpp/
    │   │   ├── README.md
    │   │   └── solution.cpp
    │   ├── go/
    │   │   ├── README.md
    │   │   ├── go.mod
    │   │   ├── solution.go
    │   │   └── solution_test.go
    │   ├── rust/
    │   │   ├── README.md
    │   │   ├── Cargo.toml
    │   │   └── src/lib.rs
    │   └── clojure/
    │       ├── README.md
    │       ├── src/solution.clj
    │       └── test/solution_test.clj
    └── sorting/
        └── ...
```

## Workflow For A New Problem

When adding a new problem, follow this sequence:

1. Create a directory named `NNNN_problem_slug/`, for example `0217_contains_duplicate/`.
2. Write the problem-level `README.md`.
3. Create one or more solution subdirectories inside it, using logical names that explain the approach, for example `hash_set/`, `sorting/`, or `two_pointers/`.
4. Inside each solution subdirectory, create the fixed language subdirectories: `python/`, `cpp/`, `go/`, `rust/`, and `clojure/`.
5. Implement the solution in each language using the local conventions.
6. Add tests for each language.
7. Add a language-specific `README.md` in each language directory.
8. Add `python/visualize.py` in each solution directory's Python implementation.
9. Update the root [README.md](README.md).
10. Update [indexes/difficulty.md](indexes/difficulty.md).
11. Update [indexes/topics.md](indexes/topics.md).

## Problem-Level README Requirements

Each problem directory `README.md` must include:

1. Problem statement with LeetCode link.
2. Approach.
3. Step-by-step walkthrough on concrete examples.
4. Call trace or execution trace.
5. Complexity analysis with justification.
6. Edge cases and how the solution handles them.

## Language-Level README Requirements

Each language subdirectory `README.md` inside a solution directory should cover:

- Language features used.
- Implementation decisions and tradeoffs.
- Exact command to run tests for that language.

Do not duplicate the problem statement or full algorithm explanation from the problem-level `README.md`.

## Language-Specific Coding Guidelines

### Python

- Prefer idiomatic Python, including comprehensions, generators, `collections`, `itertools`, and type hints where appropriate.
- Tests use `pytest`.
- Keep `visualize.py` as an algorithm visualization tool. ASCII output, step traces, or plotting are acceptable when they fit the problem.

### C++

- Use modern C++17+ style.
- Prefer STL containers and algorithms.
- Avoid raw pointers unless there is a strong reason.
- Keep tests in `solution.cpp` using assertions or a lightweight approach.

### Go

- Prefer idiomatic Go with slices, maps, and table-driven tests.
- Tests use the standard `testing` package with `t.Run` subtests where useful.
- Follow standard Go naming conventions.

### Rust

- Prefer idiomatic Rust with ownership-aware design, iterators, `Option` and `Result`, and pattern matching.
- Use a Cargo project per problem.
- Keep tests in `#[cfg(test)]` modules.

### Clojure

- Prefer idiomatic Clojure with immutable data, sequences, higher-order functions, destructuring, and threading macros.
- Tests use `clojure.test`.
- Favor pure functions and functional composition.

## Root README Format

The root [README.md](README.md) is the index of solved problems. Add each new problem as a table row in this format:

```markdown
| # | Problem | Difficulty | Topics | Solution |
|---|---------|------------|--------|----------|
| 217 | [Contains Duplicate](https://leetcode.com/problems/contains-duplicate/) | Easy | Array, Hash Table | [Solution](0217_contains_duplicate/) |
```

## Validation

Before finishing work on a problem, verify that:

- Every solution subdirectory uses a descriptive name that explains the approach.
- Every solution subdirectory contains all five language directories.
- Each implementation has tests.
- Each language directory has its own `README.md`.
- Every Python implementation includes `visualize.py`.
- The root index and both topic/difficulty indexes were updated.
