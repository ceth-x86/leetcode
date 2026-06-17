class Solution {
    fun topKFrequent(nums: IntArray, k: Int): List<Int> {
        val counts = mutableMapOf<Int, Int>()
        for (num in nums) {
            counts[num] = counts.getOrDefault(num, 0) + 1
        }

        val buckets = Array(nums.size + 1) { mutableListOf<Int>() }
        for ((num, frequency) in counts) {
            buckets[frequency].add(num)
        }

        val result = mutableListOf<Int>()
        for (frequency in buckets.size - 1 downTo 1) {
            for (num in buckets[frequency]) {
                result.add(num)
                if (result.size == k) return result
            }
        }

        return result
    }
}
