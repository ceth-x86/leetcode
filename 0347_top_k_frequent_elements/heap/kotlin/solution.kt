import java.util.PriorityQueue

class Solution {
    fun topKFrequent(nums: IntArray, k: Int): List<Int> {
        val counts = mutableMapOf<Int, Int>()
        for (num in nums) {
            counts[num] = counts.getOrDefault(num, 0) + 1
        }

        val heap = PriorityQueue<Pair<Int, Int>>(compareBy { it.first })
        for ((num, frequency) in counts) {
            heap.add(frequency to num)
            if (heap.size > k) {
                heap.poll()
            }
        }

        return heap.map { it.second }
    }
}
