fun main() {
    val tests = listOf(
        Triple("abc", "ahbgdc", true),
        Triple("axc", "ahbgdc", false),
        Triple("", "ahbgdc", true),
        Triple("", "", true),
        Triple("abc", "ab", false),
        Triple("abc", "abc", true),
        Triple("a", "a", true),
        Triple("a", "b", false),
        Triple("c", "abc", true),
        Triple("a", "", false),
    )

    for ((s, t, expected) in tests) {
        val result = isSubsequence(s, t)
        check(result == expected) { "Expected $expected, got $result for '$s' in '$t'" }
    }

    println("All Kotlin tests passed!")
}
