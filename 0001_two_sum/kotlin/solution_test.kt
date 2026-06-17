private fun assertIntArrayEquals(expected: IntArray, actual: IntArray) {
    check(expected.contentEquals(actual)) {
        "Expected ${expected.contentToString()}, got ${actual.contentToString()}"
    }
}

fun main() {
    val tests = listOf(
        Triple(intArrayOf(2, 7, 11, 15), 9, intArrayOf(0, 1)),
        Triple(intArrayOf(3, 2, 4), 6, intArrayOf(1, 2)),
        Triple(intArrayOf(3, 3), 6, intArrayOf(0, 1)),
        Triple(intArrayOf(1, 2, 3, 4), 7, intArrayOf(2, 3)),
        Triple(intArrayOf(-1, -2, -3, -4, -5), -8, intArrayOf(2, 4)),
        Triple(intArrayOf(0, 4, 3, 0), 0, intArrayOf(0, 3)),
        Triple(intArrayOf(-1_000_000_000, 1_000_000_000), 0, intArrayOf(0, 1)),
        Triple(intArrayOf(1, 5, 5, 11), 10, intArrayOf(1, 2)),
    )

    for ((nums, target, expected) in tests) {
        assertIntArrayEquals(expected, twoSum(nums, target))
    }

    println("All Kotlin tests passed!")
}
