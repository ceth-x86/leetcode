import java.util.PriorityQueue

fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
    val heap = PriorityQueue<IntArray>(
        compareByDescending<IntArray> { it[0] }.thenBy { it[1] },
    )
    val result = mutableListOf<Int>()

    for ((i, value) in nums.withIndex()) {
        heap.add(intArrayOf(value, i))

        while (heap.peek()[1] <= i - k) {
            heap.poll()
        }

        if (i >= k - 1) {
            result.add(heap.peek()[0])
        }
    }

    return result.toIntArray()
}
