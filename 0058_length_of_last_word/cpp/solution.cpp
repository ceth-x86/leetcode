#include <cassert>
#include <iostream>
#include <string>
#include <vector>

int lengthOfLastWord(const std::string& s) {
    int i = static_cast<int>(s.size()) - 1;
    while (i >= 0 && s[i] == ' ') {
        --i;
    }
    int end = i;
    while (i >= 0 && s[i] != ' ') {
        --i;
    }
    return end - i;
}

struct TestCase {
    std::string name;
    std::string s;
    int expected;
};

int main() {
    std::vector<TestCase> tests = {
        {"example 1",                  "Hello World",                    5},
        {"example 2: trailing spaces", "   fly me   to   the moon  ",   4},
        {"example 3",                  "luffy is still joyboy",          6},
        {"single word",                "Hello",                          5},
        {"single word with spaces",    "   Hello   ",                    5},
        {"single char",                "a",                              1},
        {"all same chars",             "aaaa",                           4},
        {"many spaces between",        "a   b",                          1},
        {"sentence",                   "Today is a nice day",            3},
    };

    for (const auto& [name, s, expected] : tests) {
        auto result = lengthOfLastWord(s);
        assert(result == expected);
        std::cout << "PASS: " << name << std::endl;
    }

    std::cout << "\nAll tests passed!" << std::endl;
    return 0;
}
