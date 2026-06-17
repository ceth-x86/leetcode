fun twoSum(nums: IntArray, target: Int): IntArray {
    val seen = mutableMapOf<Int, Int>()

    for ((index, num) in nums.withIndex()) {
        val complement = target - num
        val complementIndex = seen[complement]
        if (complementIndex != null) {
            return intArrayOf(complementIndex, index)
        }
        seen[num] = index
    }

    return intArrayOf()
}
