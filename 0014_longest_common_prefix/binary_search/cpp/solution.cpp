#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include <cassert>

class Solution {
public:
    std::string longestCommonPrefix(std::vector<std::string>& strs) {
        if (strs.empty()) return "";
        
        int minLen = strs[0].length();
        for (const std::string& s : strs) {
            minLen = std::min(minLen, (int)s.length());
        }
        
        int low = 1, high = minLen;
        int ans = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isCommonPrefix(strs, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return strs[0].substr(0, ans);
    }

private:
    bool isCommonPrefix(const std::vector<std::string>& strs, int len) {
        std::string prefix = strs[0].substr(0, len);
        for (int i = 1; i < strs.size(); i++) {
            if (strs[i].compare(0, len, prefix) != 0) {
                return false;
            }
        }
        return true;
    }
};

void test() {
    Solution sol;
    std::vector<std::string> strs1 = {"flower", "flow", "flight"};
    assert(sol.longestCommonPrefix(strs1) == "fl");
    std::cout << "All tests passed!" << std::endl;
}

int main() {
    test();
    return 0;
}
