#include <cassert>
#include <deque>
#include <iostream>
#include <vector>

std::vector<int> maxSlidingWindow(const std::vector<int>& nums, int k) {
    std::deque<int> dq;
    std::vector<int> result;
    result.reserve(nums.size() - k + 1);

    for (int i = 0; i < static_cast<int>(nums.size()); ++i) {
        while (!dq.empty() && dq.front() <= i - k) {
            dq.pop_front();
        }

        while (!dq.empty() && nums[dq.back()] <= nums[i]) {
            dq.pop_back();
        }

        dq.push_back(i);

        if (i >= k - 1) {
            result.push_back(nums[dq.front()]);
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
