#include <algorithm>
#include <cassert>
#include <iostream>
#include <string>
#include <unordered_map>
#include <vector>

int lengthOfLongestSubstring(const std::string& s) {
    std::unordered_map<char, int> lastSeen;
    int left = 0;
    int best = 0;

    for (int right = 0; right < static_cast<int>(s.size()); ++right) {
        char ch = s[right];
        auto it = lastSeen.find(ch);
        if (it != lastSeen.end() && it->second >= left) {
            left = it->second + 1;
        }
        lastSeen[ch] = right;
        best = std::max(best, right - left + 1);
    }

    return best;
}

struct TestCase {
    std::string name;
    std::string s;
    int expected;
};

int main() {
    std::vector<TestCase> tests = {
        {"example 1", "abcabcbb", 3},
        {"example 2", "bbbbb", 1},
        {"example 3", "pwwkew", 3},
        {"empty", "", 0},
        {"single", "a", 1},
        {"no repeats", "abcdef", 6},
        {"stale repeat", "abba", 2},
        {"repeat after gap", "dvdf", 3},
        {"leading repeat", "aab", 2},
        {"late best", "tmmzuxt", 5},
        {"symbols and spaces", "a! b@a", 5},
    };

    for (const auto& [name, s, expected] : tests) {
        int result = lengthOfLongestSubstring(s);
        assert(result == expected);
        std::cout << "PASS: " << name << std::endl;
    }

    std::cout << "\nAll tests passed!" << std::endl;
    return 0;
}
