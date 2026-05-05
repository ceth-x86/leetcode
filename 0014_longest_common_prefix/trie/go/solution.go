package trie

type TrieNode struct {
	children   map[rune]*TrieNode
	isEnd      bool
	childCount int
}

type Trie struct {
	root *TrieNode
}

func NewTrie() *Trie {
	return &Trie{root: &TrieNode{children: make(map[rune]*TrieNode)}}
}

func (t *Trie) Insert(word string) {
	node := t.root
	for _, char := range word {
		if _, ok := node.children[char]; !ok {
			node.children[char] = &TrieNode{children: make(map[rune]*TrieNode)}
			node.childCount++
		}
		node = node.children[char]
	}
	node.isEnd = true
}

func (t *Trie) FindLongestPrefix() string {
	node := t.root
	prefix := ""
	for node.childCount == 1 && !node.isEnd {
		for char, child := range node.children {
			prefix += string(char)
			node = child
			break
		}
	}
	return prefix
}

func longestCommonPrefix(strs []string) string {
	if len(strs) == 0 {
		return ""
	}
	if len(strs) == 1 {
		return strs[0]
	}

	trie := NewTrie()
	for _, s := range strs {
		if s == "" {
			return ""
		}
		trie.Insert(s)
	}
	return trie.FindLongestPrefix()
}
