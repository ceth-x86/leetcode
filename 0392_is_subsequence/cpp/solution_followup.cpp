#include <algorithm>
#include <cassert>
#include <iostream>
#include <string>
#include <vector>

class SubsequenceChecker {
public:
    explicit SubsequenceChecker(const std::string& t) {
        for (int i = 0; i < static_cast<int>(t.size()); ++i) {
            index_map_[t[i] - 'a'].push_back(i);
        }
    }

    bool isSubsequence(const std::string& s) const {
        int pos = 0;
        for (char ch : s) {
            const auto& indices = index_map_[ch - 'a'];
            auto it = std::lower_bound(indices.begin(), indices.end(), pos);
            if (it == indices.end()) {
                return false;
            }
            pos = *it + 1;
        }
        return true;
    }

private:
    std::vector<int> index_map_[26];
};

struct TestCase {
    std::string name;
    std::string s;
    bool expected;
};

int main() {
    // Tests against t = "ahbgdc"
    SubsequenceChecker checker("ahbgdc");
    std::vector<TestCase> tests = {
        {"example 1: subsequence found",  "abc",     true},
        {"example 2: not a subsequence",  "axc",     false},
        {"empty s",                       "",        true},
        {"s equals t",                    "ahbgdc",  true},
        {"single char match",             "a",       true},
        {"match at end",                  "c",       true},
        {"repeated char not enough",      "aaa",     false},
        {"non-contiguous match",          "abdc",    true},
        {"s longer than t",               "ahbgdca", false},
    };

    for (const auto& [name, s, expected] : tests) {
        assert(checker.isSubsequence(s) == expected);
        std::cout << "PASS: " << name << std::endl;
    }

    // Tests with empty t
    SubsequenceChecker empty_checker("");
    assert(empty_checker.isSubsequence("") == true);
    assert(empty_checker.isSubsequence("a") == false);
    std::cout << "PASS: empty t" << std::endl;

    // Tests with repeated chars in t
    SubsequenceChecker repeat_checker("aabbc");
    assert(repeat_checker.isSubsequence("abc") == true);
    assert(repeat_checker.isSubsequence("aab") == true);
    assert(repeat_checker.isSubsequence("aabbc") == true);
    assert(repeat_checker.isSubsequence("aabbcc") == false);
    std::cout << "PASS: repeated chars in t" << std::endl;

    // Tests with many queries against same t
    SubsequenceChecker alpha_checker("abcdefghijklmnopqrstuvwxyz");
    assert(alpha_checker.isSubsequence("ace") == true);
    assert(alpha_checker.isSubsequence("az") == true);
    assert(alpha_checker.isSubsequence("za") == false);
    assert(alpha_checker.isSubsequence("xyz") == true);
    std::cout << "PASS: many queries" << std::endl;

    std::cout << "\nAll tests passed!" << std::endl;
    return 0;
}
