fun main() {
    val tests = listOf(
        intArrayOf(7, 1, 5, 3, 6, 4) to 5,
        intArrayOf(7, 6, 4, 3, 1) to 0,
        intArrayOf(5) to 0,
        intArrayOf(1, 2) to 1,
        intArrayOf(2, 1) to 0,
        intArrayOf(2, 4, 1) to 2,
        intArrayOf(3, 2, 6, 5, 0, 3) to 4,
        intArrayOf(5, 5, 5) to 0,
        intArrayOf(0, 4, 0, 10) to 10,
    )

    for ((prices, expected) in tests) {
        val result = maxProfit(prices)
        check(result == expected) { "Expected $expected, got $result" }
    }

    println("All Kotlin tests passed!")
}
