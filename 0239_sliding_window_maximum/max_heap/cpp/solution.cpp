#include <cassert>
#include <iostream>
#include <queue>
#include <utility>
#include <vector>

std::vector<int> maxSlidingWindow(const std::vector<int>& nums, int k) {
    std::priority_queue<std::pair<int, int>> max_heap;
    std::vector<int> result;
    result.reserve(nums.size() - k + 1);

    for (int i = 0; i < static_cast<int>(nums.size()); ++i) {
        max_heap.emplace(nums[i], i);

        while (max_heap.top().second <= i - k) {
            max_heap.pop();
        }

        if (i >= k - 1) {
            result.push_back(max_heap.top().first);
        }
    }

    return result;
}

void assertEqual(const std::vector<int>& actual, const std::vector<int>& expected) {
    assert(actual == expected);
}

int main() {
    assertEqual(maxSlidingWindow({1, 3, -1, -3, 5, 3, 6, 7}, 3), {3, 3, 5, 5, 6, 7});
    assertEqual(maxSlidingWindow({1}, 1), {1});
    assertEqual(maxSlidingWindow({2, 1, 3}, 3), {3});
    assertEqual(maxSlidingWindow({1, 2, 3, 4}, 2), {2, 3, 4});
    assertEqual(maxSlidingWindow({1, 3, 3, 2}, 2), {3, 3, 3});
    assertEqual(maxSlidingWindow({-4, -2, -5, -1}, 2), {-2, -2, -1});

    std::cout << "All tests passed!\n";
    return 0;
}
