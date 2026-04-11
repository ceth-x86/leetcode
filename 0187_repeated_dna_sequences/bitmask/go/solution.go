package repeateddnasequences

const windowSize = 10

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
	n := len(s)
	if n <= windowSize {
		return []string{}
	}

	nums := make([]int, n)
	for i := range s {
		nums[i] = encode(s[i])
	}

	bitmask := 0
	seen := make(map[int]struct{}, n)
	output := make(map[string]struct{})

	for start := 0; start <= n-windowSize; start++ {
		if start == 0 {
			for i := 0; i < windowSize; i++ {
				bitmask = (bitmask << 2) | nums[i]
			}
		} else {
			bitmask <<= 2
			bitmask |= nums[start+windowSize-1]
			bitmask &= ^(3 << (2 * windowSize))
		}

		if _, ok := seen[bitmask]; ok {
			output[s[start:start+windowSize]] = struct{}{}
		} else {
			seen[bitmask] = struct{}{}
		}
	}

	result := make([]string, 0, len(output))
	for fragment := range output {
		result = append(result, fragment)
	}
	return result
}
