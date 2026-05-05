#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include <cassert>

class Solution {
public:
    std::string longestCommonPrefix(std::vector<std::string>& strs) {
        if (strs.empty()) return "";
        
        std::sort(strs.begin(), strs.end());
        
        std::string first = strs[0];
        std::string last = strs.back();
        
        int i = 0;
        while (i < first.length() && i < last.length() && first[i] == last[i]) {
            i++;
        }
        
        return first.substr(0, i);
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
