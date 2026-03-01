package is_subsequence

import "sort"

type SubsequenceChecker struct {
	indexMap [26][]int
}

func NewSubsequenceChecker(t string) *SubsequenceChecker {
	sc := &SubsequenceChecker{}
	for i, ch := range t {
		sc.indexMap[ch-'a'] = append(sc.indexMap[ch-'a'], i)
	}
	return sc
}

func (sc *SubsequenceChecker) IsSubsequence(s string) bool {
	pos := 0
	for _, ch := range s {
		indices := sc.indexMap[ch-'a']
		idx := sort.SearchInts(indices, pos)
		if idx == len(indices) {
			return false
		}
		pos = indices[idx] + 1
	}
	return true
}
