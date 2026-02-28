#include <algorithm>
#include <cassert>
#include <iostream>
#include <string>
#include <vector>

std::vector<int> replaceElements(std::vector<int>& arr) {
    int right_max = -1;
    for (int i = static_cast<int>(arr.size()) - 1; i >= 0; --i) {
        int original = arr[i];
        arr[i] = right_max;
        right_max = std::max(right_max, original);
    }
    return arr;
}

struct TestCase {
    std::string name;
    std::vector<int> arr;
    std::vector<int> expected;
};

int main() {
    std::vector<TestCase> tests = {
        {"example 1",              {17, 18, 5, 4, 6, 1}, {18, 6, 6, 6, 1, -1}},
        {"single element",         {400},                 {-1}},
        {"two elements ascending", {1, 5},                {5, -1}},
        {"descending",             {5, 4, 3, 2, 1},      {4, 3, 2, 1, -1}},
        {"ascending",              {1, 2, 3, 4, 5},      {5, 5, 5, 5, -1}},
        {"all same",               {7, 7, 7},             {7, 7, -1}},
        {"two elements descending", {5, 1},               {1, -1}},
        {"large value",            {1, 100000},            {100000, -1}},
    };

    for (auto& [name, arr, expected] : tests) {
        auto result = replaceElements(arr);
        assert(result == expected);
        std::cout << "PASS: " << name << std::endl;
    }

    std::cout << "\nAll tests passed!" << std::endl;
    return 0;
}
