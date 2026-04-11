#include <algorithm>
#include <cassert>
#include <cstdint>
#include <iostream>
#include <string>
#include <unordered_set>
#include <vector>

namespace {

constexpr int kWindowSize = 10;

int encode(char ch) {
    switch (ch) {
        case 'A':
            return 0;
        case 'C':
            return 1;
        case 'G':
            return 2;
        default:
            return 3;
    }
}

std::vector<std::string> findRepeatedDnaSequences(const std::string& s) {
    const int n = static_cast<int>(s.size());
    if (n <= kWindowSize) {
        return {};
    }

    std::vector<int> nums;
    nums.reserve(n);
    for (char ch : s) {
        nums.push_back(encode(ch));
    }

    std::uint32_t bitmask = 0;
    std::unordered_set<std::uint32_t> seen;
    std::unordered_set<std::string> output;

    for (int start = 0; start <= n - kWindowSize; ++start) {
        if (start == 0) {
            for (int i = 0; i < kWindowSize; ++i) {
                bitmask = (bitmask << 2) | static_cast<std::uint32_t>(nums[i]);
            }
        } else {
            bitmask <<= 2;
            bitmask |= static_cast<std::uint32_t>(nums[start + kWindowSize - 1]);
            bitmask &= ~(3u << (2 * kWindowSize));
        }

        if (seen.contains(bitmask)) {
            output.insert(s.substr(start, kWindowSize));
        } else {
            seen.insert(bitmask);
        }
    }

    return {output.begin(), output.end()};
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
