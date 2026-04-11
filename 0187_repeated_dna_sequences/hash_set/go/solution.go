package repeateddnasequences

const windowSize = 10

func findRepeatedDnaSequences(s string) []string {
	if len(s) < windowSize {
		return []string{}
	}

	seen := make(map[string]struct{}, len(s))
	repeated := make(map[string]struct{})
	result := make([]string, 0)

	for start := 0; start <= len(s)-windowSize; start++ {
		fragment := s[start : start+windowSize]
		if _, ok := seen[fragment]; ok {
			if _, alreadyAdded := repeated[fragment]; !alreadyAdded {
				repeated[fragment] = struct{}{}
				result = append(result, fragment)
			}
			continue
		}
		seen[fragment] = struct{}{}
	}

	return result
}
