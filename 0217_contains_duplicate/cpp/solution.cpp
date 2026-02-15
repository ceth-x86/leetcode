#include <cassert>
#include <iostream>
#include <string>
#include <unordered_set>
#include <vector>

bool containsDuplicate(const std::vector<int>& nums) {
    std::unordered_set<int> seen;
    for (auto num : nums) {
        if (!seen.insert(num).second) {
            return true;
        }
    }
    return false;
}

struct TestCase {
    std::string name;
    std::vector<int> nums;
    bool expected;
};

int main() {
    std::vector<TestCase> tests = {
        {"example 1: has duplicate",      {1, 2, 3, 1},                      true},
        {"example 2: all distinct",       {1, 2, 3, 4},                      false},
        {"example 3: multiple dupes",     {1, 1, 1, 3, 3, 4, 3, 2, 4, 2},   true},
        {"single element",                {1},                                false},
        {"two same",                      {1, 1},                             true},
        {"two different",                 {1, 2},                             false},
        {"all same",                      {5, 5, 5, 5},                      true},
        {"extreme values",                {-1000000000, 1000000000},          false},
    };

    for (const auto& [name, nums, expected] : tests) {
        bool result = containsDuplicate(nums);
        assert(result == expected);
        std::cout << "PASS: " << name << std::endl;
    }

    std::cout << "\nAll tests passed!" << std::endl;
    return 0;
}
