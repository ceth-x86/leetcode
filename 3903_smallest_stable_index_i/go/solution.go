package smallest_stable_index_i

func firstStableIndex(nums []int, k int) int {
	n := len(nums)
	suffixMin := make([]int, n)

	suffixMin[n-1] = nums[n-1]
	for i := n - 2; i >= 0; i-- {
		if suffixMin[i+1] < nums[i] {
			suffixMin[i] = suffixMin[i+1]
		} else {
			suffixMin[i] = nums[i]
		}
	}

	prefixMax := nums[0]
	for i := 0; i < n; i++ {
		if nums[i] > prefixMax {
			prefixMax = nums[i]
		}
		if prefixMax-suffixMin[i] <= k {
			return i
		}
	}

	return -1
}
