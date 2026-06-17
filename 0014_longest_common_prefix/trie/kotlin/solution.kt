private class TrieNode {
    val children = mutableMapOf<Char, TrieNode>()
    var isEnd = false
}

private class Trie {
    private val root = TrieNode()

    fun insert(word: String) {
        var node = root
        for (char in word) {
            node = node.children.getOrPut(char) { TrieNode() }
        }
        node.isEnd = true
    }

    fun findLongestPrefix(): String {
        val prefix = StringBuilder()
        var node = root

        while (node.children.size == 1 && !node.isEnd) {
            val (char, next) = node.children.entries.first()
            prefix.append(char)
            node = next
        }

        return prefix.toString()
    }
}

class Solution {
    fun longestCommonPrefix(strs: Array<String>): String {
        if (strs.isEmpty()) return ""
        if (strs.size == 1) return strs[0]

        val trie = Trie()
        for (str in strs) {
            if (str.isEmpty()) return ""
            trie.insert(str)
        }

        return trie.findLongestPrefix()
    }
}
