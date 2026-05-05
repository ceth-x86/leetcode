#include <iostream>
#include <vector>
#include <string>
#include <cassert>

class Solution {
public:
    std::string longestCommonPrefix(std::vector<std::string>& strs) {
        if (strs.empty()) {
            return "";
        }
        
        for (int i = 0; i < strs[0].length(); ++i) {
            char c = strs[0][i];
            for (int j = 1; j < strs.size(); ++j) {
                if (i == strs[j].length() || strs[j][i] != c) {
                    return strs[0].substr(0, i);
                }
            }
        }
        
        return strs[0];
    }
};

void test() {
    Solution sol;
    
    std::vector<std::string> strs1 = {"flower", "flow", "flight"};
    assert(sol.longestCommonPrefix(strs1) == "fl");
    
    std::vector<std::string> strs2 = {"dog", "racecar", "car"};
    assert(sol.longestCommonPrefix(strs2) == "");
    
    std::vector<std::string> strs3 = {"ab", "a"};
    assert(sol.longestCommonPrefix(strs3) == "a");

    std::vector<std::string> strs4 = {""};
    assert(sol.longestCommonPrefix(strs4) == "");

    std::vector<std::string> strs5 = {"a"};
    assert(sol.longestCommonPrefix(strs5) == "a");

    std::cout << "All tests passed!" << std::endl;
}

int main() {
    test();
    return 0;
}
