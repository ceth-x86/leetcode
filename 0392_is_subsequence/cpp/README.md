# C++ Solution

## Language Features Used

- **`const std::string&`** — pass by const reference to avoid copying input strings
- **`static_cast<int>`** — explicit cast from `size_t` to `int` for safe comparison in loop conditions
- **Structured bindings** (C++17) — `const auto& [name, s, t, expected]` to destructure `TestCase`
- **Combined loop condition** — `j < t.size() && i < s.size()` short-circuits when all of `s` is matched

## Implementation Decisions

- **Combined loop condition**: checking `i < s.size()` in the `for` condition provides early termination — once all characters of `s` are matched, the loop exits immediately without scanning the rest of `t`.
- **`std::string` vs `std::string_view`**: `std::string` is sufficient here. `string_view` would avoid copies if the caller has raw `char*` data, but the function already takes const references.
- **No `find()` or `find_first_of()`**: while `std::string::find()` could locate each character, it would restart the search each time. The two-pointer approach is more direct.

## Running Tests

```bash
g++ -std=c++17 -o solution solution.cpp && ./solution
```

## Follow-up Solution (`solution_followup.cpp`)

`SubsequenceChecker` preprocesses `t` into a fixed-size array of 26 index vectors, then answers queries with binary search.

### Language Features Used

- **`std::vector<int>[26]`** — fixed-size array of vectors, one per lowercase letter; avoids hash map overhead
- **`std::lower_bound`** — STL binary search returning an iterator to the first element `>= pos`
- **`explicit` constructor** — prevents implicit conversions from string to `SubsequenceChecker`

### Running Follow-up Tests

```bash
g++ -std=c++17 -o solution_followup solution_followup.cpp && ./solution_followup
```
