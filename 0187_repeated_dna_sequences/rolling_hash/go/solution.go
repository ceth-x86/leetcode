package repeateddnasequences

const (
	windowSize = 10
	windowMask = (1 << (windowSize * 2)) - 1
)

func encode(ch byte) int {
	switch ch {
	case 'A':
		return 0
	case 'C':
		return 1
	case 'G':
		return 2
	default:
		return 3
	}
}

func findRepeatedDnaSequences(s string) []string {
	if len(s) < windowSize {
		return []string{}
	}

	rolling := 0
	seen := make(map[int]struct{}, len(s))
	repeated := make(map[int]struct{})
	result := make([]string, 0)

	for index := range s {
		rolling = ((rolling << 2) | encode(s[index])) & windowMask
		if index < windowSize-1 {
			continue
		}

		start := index - windowSize + 1
		if _, ok := seen[rolling]; ok {
			if _, alreadyAdded := repeated[rolling]; !alreadyAdded {
				repeated[rolling] = struct{}{}
				result = append(result, s[start:index+1])
			}
			continue
		}
		seen[rolling] = struct{}{}
	}

	return result
}
