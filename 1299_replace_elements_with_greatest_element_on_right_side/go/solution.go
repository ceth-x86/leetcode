package replace_elements

func replaceElements(arr []int) []int {
	rightMax := -1
	for i := len(arr) - 1; i >= 0; i-- {
		original := arr[i]
		arr[i] = rightMax
		if original > rightMax {
			rightMax = original
		}
	}
	return arr
}
