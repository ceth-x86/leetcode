#include <cassert>
#include <iostream>
#include <string>
#include <unordered_map>
#include <vector>

std::vector<int> twoSum(const std::vector<int>& nums, int target) {
    std::unordered_map<int, int> seen;
    for (int i = 0; i < static_cast<int>(nums.size()); ++i) {
        int complement = target - nums[i];
        auto it = seen.find(complement);
        if (it != seen.end()) {
            return {it->second, i};
        }
        seen[nums[i]] = i;
    }
    return {};
}

struct TestCase {
    std::string name;
    std::vector<int> nums;
    int target;
    std::vector<int> expected;
};

int main() {
    std::vector<TestCase> tests = {
        {"example 1: pair at start",     {2, 7, 11, 15},            9,  {0, 1}},
        {"example 2: pair in middle",    {3, 2, 4},                 6,  {1, 2}},
        {"example 3: same elements",     {3, 3},                    6,  {0, 1}},
        {"pair at end",                  {1, 2, 3, 4},              7,  {2, 3}},
        {"negative numbers",            {-1, -2, -3, -4, -5},      -8, {2, 4}},
        {"zeros",                        {0, 4, 3, 0},              0,  {0, 3}},
        {"extreme values",              {-1000000000, 1000000000},  0,  {0, 1}},
        {"duplicate values",            {1, 5, 5, 11},              10, {1, 2}},
    };

    for (const auto& [name, nums, target, expected] : tests) {
        auto result = twoSum(nums, target);
        assert(result == expected);
        std::cout << "PASS: " << name << std::endl;
    }

    std::cout << "\nAll tests passed!" << std::endl;
    return 0;
}
