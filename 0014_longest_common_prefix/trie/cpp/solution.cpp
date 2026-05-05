#include <iostream>
#include <vector>
#include <string>
#include <unordered_map>
#include <cassert>

class TrieNode {
public:
    std::unordered_map<char, TrieNode*> children;
    bool isEnd = false;
    int childCount = 0;
};

class Trie {
public:
    Trie() { root = new TrieNode(); }
    
    void insert(const std::string& word) {
        TrieNode* node = root;
        for (char c : word) {
            if (node->children.find(c) == node->children.end()) {
                node->children[c] = new TrieNode();
                node->childCount++;
            }
            node = node->children[c];
        }
        node->isEnd = true;
    }
    
    std::string findLongestPrefix() {
        TrieNode* node = root;
        std::string prefix = "";
        while (node->childCount == 1 && !node->isEnd) {
            auto it = node->children.begin();
            prefix += it->first;
            node = it->second;
        }
        return prefix;
    }

private:
    TrieNode* root;
};

class Solution {
public:
    std::string longestCommonPrefix(std::vector<std::string>& strs) {
        if (strs.empty()) return "";
        if (strs.size() == 1) return strs[0];
        
        Trie trie;
        for (const std::string& s : strs) {
            if (s.empty()) return "";
            trie.insert(s);
        }
        return trie.findLongestPrefix();
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
