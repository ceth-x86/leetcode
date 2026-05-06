#include <iostream>
#include <vector>
#include <string>
#include <unordered_map>
#include <algorithm>
#include <cassert>

class Solution {
public:
    std::vector<std::vector<std::string>> groupAnagrams(std::vector<std::string>& strs) {
        std::unordered_map<std::string, std::vector<std::string>> groups;
        
        for (const std::string& s : strs) {
            std::string key = s;
            std::sort(key.begin(), key.end());
            groups[key].push_back(s);
        }
        
        std::vector<std::vector<std::string>> result;
        for (auto& pair : groups) {
            result.push_back(std::move(pair.second));
        }
        return result;
    }
};

void test() {
    Solution sol;
    std::vector<std::string> strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
    auto result = sol.groupAnagrams(strs);
    assert(result.size() == 3);
    std::cout << "All tests passed!" << std::endl;
}

int main() {
    test();
    return 0;
}
