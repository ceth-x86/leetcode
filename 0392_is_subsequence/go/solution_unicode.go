package is_subsequence

func isSubsequenceUnicode(s, t string) bool {
	sRunes := []rune(s)
	i := 0
	for _, ch := range t {
		if i < len(sRunes) && sRunes[i] == ch {
			i++
		}
	}
	return i == len(sRunes)
}
