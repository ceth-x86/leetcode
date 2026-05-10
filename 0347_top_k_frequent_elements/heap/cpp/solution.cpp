#include <iostream>
#include <vector>
#include <unordered_map>
#include <queue>
#include <algorithm>
#include <cassert>

class Solution {
public:
    std::vector<int> topKFrequent(std::vector<int>& nums, int k) {
        std::unordered_map<int, int> counts;
        for (int num : nums) {
            counts[num]++;
        }
        
        // pair: {frequency, num}
        // Min-heap to keep the top k elements
        std::priority_queue<std::pair<int, int>, std::vector<std::pair<int, int>>, std::greater<std::pair<int, int>>> min_heap;
        
        for (auto const& [num, freq] : counts) {
            min_heap.push({freq, num});
            if (min_heap.size() > k) {
                min_heap.pop();
            }
        }
        
        std::vector<int> result;
        while (!min_heap.empty()) {
            result.push_back(min_heap.top().second);
            min_heap.pop();
        }
        return result;
    }
};

void test() {
    Solution sol;
    std::vector<int> nums1 = {1, 1, 1, 2, 2, 3};
    std::vector<int> res1 = sol.topKFrequent(nums1, 2);
    std::sort(res1.begin(), res1.end());
    assert((res1 == std::vector<int>{1, 2}));
    std::cout << "All tests passed!" << std::endl;
}

int main() {
    test();
    return 0;
}
