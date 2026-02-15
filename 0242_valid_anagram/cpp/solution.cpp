#include <array>
#include <cassert>
#include <iostream>
#include <string>
#include <string_view>
#include <vector>

bool isAnagram(std::string_view s, std::string_view t) {
    if (s.size() != t.size()) {
        return false;
    }

    std::array<int, 26> count{};
    for (size_t i = 0; i < s.size(); ++i) {
        ++count[s[i] - 'a'];
        --count[t[i] - 'a'];
    }

    for (auto c : count) {
        if (c != 0) return false;
    }
    return true;
}

struct TestCase {
    std::string name;
    std::string s;
    std::string t;
    bool expected;
};

int main() {
    std::vector<TestCase> tests = {
        {"anagram match",       "anagram", "nagaram", true},
        {"no match",            "rat",     "car",     false},
        {"single char equal",   "a",       "a",       true},
        {"single char differ",  "a",       "b",       false},
        {"different lengths",   "ab",      "abc",     false},
        {"same string",         "abc",     "abc",     true},
        {"all same char",       "aaa",     "aaa",     true},
        {"count mismatch",      "aacc",    "ccac",    false},
    };

    for (const auto& [name, s, t, expected] : tests) {
        bool result = isAnagram(s, t);
        assert(result == expected);
        std::cout << "PASS: " << name << std::endl;
    }

    std::cout << "\nAll tests passed!" << std::endl;
    return 0;
}
