fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
    val deque = ArrayDeque<Int>()
    val result = mutableListOf<Int>()

    for ((i, value) in nums.withIndex()) {
        while (deque.isNotEmpty() && deque.first() <= i - k) {
            deque.removeFirst()
        }

        while (deque.isNotEmpty() && nums[deque.last()] <= value) {
            deque.removeLast()
        }

        deque.addLast(i)

        if (i >= k - 1) {
            result.add(nums[deque.first()])
        }
    }

    return result.toIntArray()
}
