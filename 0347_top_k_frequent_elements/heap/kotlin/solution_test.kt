fun main() {
    val solution = Solution()
    val tests = listOf(
        Triple(intArrayOf(1, 1, 1, 2, 2, 3), 2, listOf(1, 2)),
        Triple(intArrayOf(1), 1, listOf(1)),
    )

    for ((nums, k, expected) in tests) {
        val result = solution.topKFrequent(nums, k)
        check(result.sorted() == expected.sorted()) {
            "Expected ${expected.sorted()}, got ${result.sorted()}"
        }
    }

    println("All Kotlin tests passed!")
}
