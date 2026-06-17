fun main() {
    val tests = listOf(
        Triple(intArrayOf(5, 0, 1, 4), 3, 3),
        Triple(intArrayOf(4, 4, 4), 0, 0),
        Triple(intArrayOf(9), 0, 0),
        Triple(intArrayOf(2, 5, 7), 0, 0),
        Triple(intArrayOf(10, 0), 5, -1),
        Triple(intArrayOf(3, 1, 2), 0, -1),
        Triple(intArrayOf(8, 2, 6, 7), 2, 2),
        Triple(intArrayOf(1, 3, 2, 5), 1, 0),
    )

    for ((nums, k, expected) in tests) {
        val result = firstStableIndex(nums, k)
        check(result == expected) { "Expected $expected, got $result" }
    }

    println("All Kotlin tests passed!")
}
