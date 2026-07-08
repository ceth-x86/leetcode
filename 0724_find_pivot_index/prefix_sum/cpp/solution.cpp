#include <iostream>
#include <vector>
#include <numeric>
#include <cassert>

class Solution {
public:
    int pivotIndex(std::vector<int>& nums) {
        int total_sum = std::accumulate(nums.begin(), nums.end(), 0);
        int left_sum = 0;
        
        for (int i = 0; i < nums.size(); ++i) {
            if (left_sum == total_sum - left_sum - nums[i]) {
                return i;
            }
            left_sum += nums[i];
        }
        
        return -1;
    }
};

void test() {
    Solution solution;
    
    std::vector<int> test1 = {1, 7, 3, 6, 5, 6};
    assert(solution.pivotIndex(test1) == 3);
    
    std::vector<int> test2 = {1, 2, 3};
    assert(solution.pivotIndex(test2) == -1);
    
    std::vector<int> test3 = {2, 1, -1};
    assert(solution.pivotIndex(test3) == 0);
    
    std::vector<int> test4 = {0};
    assert(solution.pivotIndex(test4) == 0);
    
    std::cout << "All tests passed!" << std::endl;
}

int main() {
    test();
    return 0;
}
