#include <algorithm>
#include <array>
#include <cassert>
#include <iostream>
#include <string>
#include <unordered_set>
#include <vector>

namespace {

constexpr int kWindowSize = 10;
constexpr int kWindowMask = (1 << (kWindowSize * 2)) - 1;

int encode(char ch) {
    switch (ch) {
        case 'A':
            return 0;
        case 'C':
            return 1;
        case 'G':
            return 2;
        case 'T':
            return 3;
        default:
            return 0;
    }
}

std::vector<std::string> findRepeatedDnaSequences(const std::string& s) {
    if (s.size() < kWindowSize) {
        return {};
    }

    int rolling = 0;
    std::unordered_set<int> seen;
    std::unordered_set<int> repeated;
    std::vector<std::string> result;

    for (int index = 0; index < static_cast<int>(s.size()); ++index) {
        rolling = ((rolling << 2) | encode(s[index])) & kWindowMask;
        if (index < kWindowSize - 1) {
            continue;
        }

        const int start = index - kWindowSize + 1;
        if (seen.contains(rolling)) {
            if (!repeated.contains(rolling)) {
                repeated.insert(rolling);
                result.push_back(s.substr(start, kWindowSize));
            }
        } else {
            seen.insert(rolling);
        }
    }

    return result;
}

void assertSameContents(std::vector<std::string> actual, std::vector<std::string> expected) {
    std::sort(actual.begin(), actual.end());
    std::sort(expected.begin(), expected.end());
    assert(actual == expected);
}

}  // namespace

int main() {
    assertSameContents(
        findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"),
        {"AAAAACCCCC", "CCCCCAAAAA"});
    assertSameContents(findRepeatedDnaSequences("AAAAAAAAAAAAA"), {"AAAAAAAAAA"});
    assertSameContents(findRepeatedDnaSequences("ACGT"), {});
    assertSameContents(findRepeatedDnaSequences("ACGTACGTAC"), {});
    assertSameContents(findRepeatedDnaSequences("AAAAAAAAAAAA"), {"AAAAAAAAAA"});

    std::cout << "All tests passed!\n";
    return 0;
}
