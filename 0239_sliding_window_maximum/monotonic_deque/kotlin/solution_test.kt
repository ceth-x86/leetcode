private fun assertIntArrayEquals(expected: IntArray, actual: IntArray) {
    check(expected.contentEquals(actual)) {
        "Expected ${expected.contentToString()}, got ${actual.contentToString()}"
    }
}

fun main() {
    val tests = listOf(
        Triple(intArrayOf(1, 3, -1, -3, 5, 3, 6, 7), 3, intArrayOf(3, 3, 5, 5, 6, 7)),
        Triple(intArrayOf(1), 1, intArrayOf(1)),
        Triple(intArrayOf(2, 1, 3), 3, intArrayOf(3)),
        Triple(intArrayOf(1, 2, 3, 4), 2, intArrayOf(2, 3, 4)),
        Triple(intArrayOf(1, 3, 3, 2), 2, intArrayOf(3, 3, 3)),
        Triple(intArrayOf(-4, -2, -5, -1), 2, intArrayOf(-2, -2, -1)),
    )

    for ((nums, k, expected) in tests) {
        assertIntArrayEquals(expected, maxSlidingWindow(nums, k))
    }

    println("All Kotlin tests passed!")
}
