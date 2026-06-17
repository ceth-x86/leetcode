fun main() {
    val tests = listOf(
        "abcabcbb" to 3,
        "bbbbb" to 1,
        "pwwkew" to 3,
        "" to 0,
        "a" to 1,
        "abcdef" to 6,
        "abba" to 2,
        "dvdf" to 3,
        "aab" to 2,
        "tmmzuxt" to 5,
        "a! b@a" to 5,
    )

    for ((s, expected) in tests) {
        val result = lengthOfLongestSubstring(s)
        check(result == expected) { "Expected $expected, got $result for '$s'" }
    }

    println("All Kotlin tests passed!")
}
