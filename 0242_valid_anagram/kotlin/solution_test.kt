fun main() {
    val tests = listOf(
        Triple("anagram", "nagaram", true),
        Triple("rat", "car", false),
        Triple("a", "a", true),
        Triple("a", "b", false),
        Triple("ab", "abc", false),
        Triple("abc", "abc", true),
        Triple("aaa", "aaa", true),
        Triple("aacc", "ccac", false),
        Triple("", "", true),
    )

    for ((s, t, expected) in tests) {
        val result = isAnagram(s, t)
        check(result == expected) { "Expected $expected, got $result for '$s' and '$t'" }
    }

    println("All Kotlin tests passed!")
}
