#include <algorithm>
#include <cassert>
#include <iostream>
#include <string>
#include <unordered_set>
#include <vector>

namespace {

constexpr int kWindowSize = 10;

std::vector<std::string> findRepeatedDnaSequences(const std::string& s) {
    if (s.size() < kWindowSize) {
        return {};
    }

    std::unordered_set<std::string> seen;
    std::unordered_set<std::string> repeated;
    std::vector<std::string> result;

    for (int start = 0; start <= static_cast<int>(s.size()) - kWindowSize; ++start) {
        std::string fragment = s.substr(start, kWindowSize);
        if (seen.contains(fragment)) {
            if (!repeated.contains(fragment)) {
                repeated.insert(fragment);
                result.push_back(fragment);
            }
        } else {
            seen.insert(fragment);
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
