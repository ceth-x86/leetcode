#include <algorithm>
#include <cassert>
#include <iostream>
#include <string>
#include <vector>

int firstStableIndex(const std::vector<int>& nums, int k) {
    const int n = static_cast<int>(nums.size());
    std::vector<int> suffixMin(n);

    suffixMin[n - 1] = nums[n - 1];
    for (int i = n - 2; i >= 0; --i) {
        suffixMin[i] = std::min(suffixMin[i + 1], nums[i]);
    }

    int prefixMax = nums[0];
    for (int i = 0; i < n; ++i) {
        prefixMax = std::max(prefixMax, nums[i]);
        if (prefixMax - suffixMin[i] <= k) {
            return i;
        }
    }

    return -1;
}

struct TestCase {
    std::string name;
    std::vector<int> nums;
    int k;
    int expected;
};

int main() {
    const std::vector<TestCase> tests = {
        {"example 1", {5, 0, 1, 4}, 3, 3},
        {"all equal", {4, 4, 4}, 0, 0},
        {"single element", {9}, 0, 0},
        {"first index stable", {2, 5, 7}, 0, 0},
        {"no stable index", {10, 0}, 5, -1},
        {"strict threshold miss", {3, 1, 2}, 0, -1},
        {"middle index stable", {8, 2, 6, 7}, 2, 2},
        {"stable at zero", {1, 3, 2, 5}, 1, 0},
    };

    for (const auto& [name, nums, k, expected] : tests) {
        const int result = firstStableIndex(nums, k);
        assert(result == expected);
        std::cout << "PASS: " << name << '\n';
    }

    std::cout << "\nAll tests passed!\n";
    return 0;
}
