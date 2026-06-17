fun firstStableIndex(nums: IntArray, k: Int): Int {
    val suffixMin = IntArray(nums.size)
    suffixMin[nums.lastIndex] = nums.last()

    for (i in nums.size - 2 downTo 0) {
        suffixMin[i] = minOf(suffixMin[i + 1], nums[i])
    }

    var prefixMax = nums[0]
    for (i in nums.indices) {
        prefixMax = maxOf(prefixMax, nums[i])
        if (prefixMax - suffixMin[i] <= k) {
            return i
        }
    }

    return -1
}
