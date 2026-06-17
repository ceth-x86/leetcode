fun main() {
    val checker = SubsequenceChecker("ahbgdc")
    val tests = listOf(
        "abc" to true,
        "axc" to false,
        "" to true,
        "ahbgdc" to true,
        "a" to true,
        "c" to true,
        "aaa" to false,
        "abdc" to true,
        "ahbgdca" to false,
    )

    for ((s, expected) in tests) {
        val result = checker.isSubsequence(s)
        check(result == expected) { "Expected $expected, got $result for '$s'" }
    }

    val emptyChecker = SubsequenceChecker("")
    check(emptyChecker.isSubsequence(""))
    check(!emptyChecker.isSubsequence("a"))

    val singleChecker = SubsequenceChecker("a")
    check(singleChecker.isSubsequence("a"))
    check(!singleChecker.isSubsequence("b"))
    check(singleChecker.isSubsequence(""))

    val repeatedChecker = SubsequenceChecker("aabbc")
    check(repeatedChecker.isSubsequence("abc"))
    check(repeatedChecker.isSubsequence("aab"))
    check(repeatedChecker.isSubsequence("aabb"))
    check(repeatedChecker.isSubsequence("aabbc"))
    check(!repeatedChecker.isSubsequence("aabbcc"))

    val alphabetChecker = SubsequenceChecker("abcdefghijklmnopqrstuvwxyz")
    check(alphabetChecker.isSubsequence("ace"))
    check(alphabetChecker.isSubsequence("az"))
    check(!alphabetChecker.isSubsequence("za"))
    check(alphabetChecker.isSubsequence("abc"))
    check(alphabetChecker.isSubsequence("xyz"))

    println("All Kotlin follow-up tests passed!")
}
