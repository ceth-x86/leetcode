fun main() {
    val tests = listOf(
        "Hello World" to 5,
        "   fly me   to   the moon  " to 4,
        "luffy is still joyboy" to 6,
        "Hello" to 5,
        "   Hello   " to 5,
        "a" to 1,
        "aaaa" to 4,
        "a   b" to 1,
        "Today is a nice day" to 3,
    )

    for ((s, expected) in tests) {
        val result = lengthOfLastWord(s)
        check(result == expected) { "Expected $expected, got $result for '$s'" }
    }

    println("All Kotlin tests passed!")
}
