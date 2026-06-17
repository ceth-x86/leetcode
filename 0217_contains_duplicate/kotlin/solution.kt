fun containsDuplicate(nums: IntArray): Boolean {
    val seen = mutableSetOf<Int>()

    for (num in nums) {
        if (!seen.add(num)) {
            return true
        }
    }

    return false
}
