fun main() {
    val solution = Solution()
    val tests = listOf(
        arrayOf("flower", "flow", "flight") to "fl",
        arrayOf("dog", "racecar", "car") to "",
        arrayOf("ab", "a") to "a",
        arrayOf("") to "",
        arrayOf("a") to "a",
    )

    for ((strs, expected) in tests) {
        val result = solution.longestCommonPrefix(strs)
        check(result == expected) { "Expected '$expected', got '$result'" }
    }

    println("All Kotlin tests passed!")
}
