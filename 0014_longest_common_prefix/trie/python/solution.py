from typing import List, Dict

class TrieNode:
    def __init__(self):
        self.children: Dict[str, 'TrieNode'] = {}
        self.is_end = False
        self.child_count = 0

class Trie:
    def __init__(self):
        self.root = TrieNode()

    def insert(self, word: str):
        node = self.root
        for char in word:
            if char not in node.children:
                node.children[char] = TrieNode()
                node.child_count += 1
            node = node.children[char]
        node.is_end = True

    def find_longest_prefix(self) -> str:
        node = self.root
        prefix = ""
        while node.child_count == 1 and not node.is_end:
            char = list(node.children.keys())[0]
            prefix += char
            node = node.children[char]
        return prefix

class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        if not strs:
            return ""
        if len(strs) == 1:
            return strs[0]
            
        trie = Trie()
        for s in strs:
            if not s: return ""
            trie.insert(s)
            
        return trie.find_longest_prefix()
