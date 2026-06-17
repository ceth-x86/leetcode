private fun assertIntArrayEquals(expected: IntArray, actual: IntArray) {
    check(expected.contentEquals(actual)) {
        "Expected ${expected.contentToString()}, got ${actual.contentToString()}"
    }
}

fun main() {
    val tests = listOf(
        intArrayOf(17, 18, 5, 4, 6, 1) to intArrayOf(18, 6, 6, 6, 1, -1),
        intArrayOf(400) to intArrayOf(-1),
        intArrayOf(1, 5) to intArrayOf(5, -1),
        intArrayOf(5, 4, 3, 2, 1) to intArrayOf(4, 3, 2, 1, -1),
        intArrayOf(1, 2, 3, 4, 5) to intArrayOf(5, 5, 5, 5, -1),
        intArrayOf(7, 7, 7) to intArrayOf(7, 7, -1),
        intArrayOf(5, 1) to intArrayOf(1, -1),
        intArrayOf(1, 100_000) to intArrayOf(100_000, -1),
    )

    for ((arr, expected) in tests) {
        assertIntArrayEquals(expected, replaceElements(arr))
    }

    println("All Kotlin tests passed!")
}
