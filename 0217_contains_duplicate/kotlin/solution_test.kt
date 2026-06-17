fun main() {
    val tests = listOf(
        intArrayOf(1, 2, 3, 1) to true,
        intArrayOf(1, 2, 3, 4) to false,
        intArrayOf(1, 1, 1, 3, 3, 4, 3, 2, 4, 2) to true,
        intArrayOf(1) to false,
        intArrayOf(1, 1) to true,
        intArrayOf(1, 2) to false,
        intArrayOf(5, 5, 5, 5) to true,
        intArrayOf(-1_000_000_000, 1_000_000_000) to false,
        (IntArray(100_001) { if (it == 100_000) 0 else it }) to true,
    )

    for ((nums, expected) in tests) {
        val result = containsDuplicate(nums)
        check(result == expected) { "Expected $expected, got $result" }
    }

    println("All Kotlin tests passed!")
}
