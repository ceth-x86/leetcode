#include <iostream>
#include <vector>
#include <unordered_map>
#include <algorithm>
#include <cassert>

class Solution {
public:
    std::vector<int> topKFrequent(std::vector<int>& nums, int k) {
        std::unordered_map<int, int> counts;
        for (int num : nums) {
            counts[num]++;
        }
        
        std::vector<std::vector<int>> buckets(nums.size() + 1);
        for (auto const& [num, freq] : counts) {
            buckets[freq].push_back(num);
        }
        
        std::vector<int> result;
        for (int i = buckets.size() - 1; i >= 1; --i) {
            for (int num : buckets[i]) {
                result.push_back(num);
                if (result.size() == k) {
                    return result;
                }
            }
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
    
    std::vector<int> nums2 = {1};
    std::vector<int> res2 = sol.topKFrequent(nums2, 1);
    assert((res2 == std::vector<int>{1}));

    std::cout << "All tests passed!" << std::endl;
}

int main() {
    test();
    return 0;
}
