#include <cassert>
#include <iostream>
#include <string>
#include <vector>

bool isSubsequence(const std::string& s, const std::string& t) {
    int i = 0;
    for (int j = 0; j < static_cast<int>(t.size()) && i < static_cast<int>(s.size()); ++j) {
        if (s[i] == t[j]) {
            ++i;
        }
    }
    return i == static_cast<int>(s.size());
}

struct TestCase {
    std::string name;
    std::string s;
    std::string t;
    bool expected;
};

int main() {
    std::vector<TestCase> tests = {
        {"example 1: subsequence found",  "abc", "ahbgdc", true},
        {"example 2: not a subsequence",  "axc", "ahbgdc", false},
        {"empty s",                       "",    "ahbgdc", true},
        {"both empty",                    "",    "",       true},
        {"s longer than t",               "abc", "ab",     false},
        {"s equals t",                    "abc", "abc",    true},
        {"single char match",             "a",   "a",      true},
        {"single char no match",          "a",   "b",      false},
        {"match at end",                  "c",   "abc",    true},
        {"empty t non-empty s",           "a",   "",       false},
    };

    for (const auto& [name, s, t, expected] : tests) {
        auto result = isSubsequence(s, t);
        assert(result == expected);
        std::cout << "PASS: " << name << std::endl;
    }

    std::cout << "\nAll tests passed!" << std::endl;
    return 0;
}
