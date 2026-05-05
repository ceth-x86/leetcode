#include <iostream>
#include <vector>
#include <string>
#include <cassert>

class Solution {
public:
    std::string longestCommonPrefix(std::vector<std::string>& strs) {
        if (strs.empty()) return "";
        
        std::string prefix = strs[0];
        for (int i = 1; i < strs.size(); ++i) {
            while (strs[i].find(prefix) != 0) {
                prefix = prefix.substr(0, prefix.length() - 1);
                if (prefix.empty()) return "";
            }
        }
        return prefix;
    }
};

void test() {
    Solution sol;
    std::vector<std::string> strs1 = {"flower", "flow", "flight"};
    assert(sol.longestCommonPrefix(strs1) == "fl");
    
    std::vector<std::string> strs2 = {"dog", "racecar", "car"};
    assert(sol.longestCommonPrefix(strs2) == "");
    
    std::cout << "All tests passed!" << std::endl;
}

int main() {
    test();
    return 0;
}
