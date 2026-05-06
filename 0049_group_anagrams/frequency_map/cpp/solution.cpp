#include <iostream>
#include <vector>
#include <string>
#include <unordered_map>
#include <array>
#include <cassert>

// Custom hash for std::array<int, 26> to use it as an unordered_map key
struct ArrayHasher {
    std::size_t operator()(const std::array<int, 26>& a) const {
        std::size_t h = 0;
        for (int x : a) {
            h ^= std::hash<int>{}(x) + 0x9e3779b9 + (h << 6) + (h >> 2);
        }
        return h;
    }
};

class Solution {
public:
    std::vector<std::vector<std::string>> groupAnagrams(std::vector<std::string>& strs) {
        std::unordered_map<std::array<int, 26>, std::vector<std::string>, ArrayHasher> groups;
        
        for (const std::string& s : strs) {
            std::array<int, 26> count = {0};
            for (char c : s) {
                count[c - 'a']++;
            }
            groups[count].push_back(s);
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
