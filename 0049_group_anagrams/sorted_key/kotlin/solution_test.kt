private fun normalize(groups: List<List<String>>): List<List<String>> =
    groups.map { it.sorted() }.sortedBy { it.joinToString("|") }

fun main() {
    val solution = Solution()
    val tests = listOf(
        arrayOf("eat", "tea", "tan", "ate", "nat", "bat") to
            listOf(listOf("ate", "eat", "tea"), listOf("nat", "tan"), listOf("bat")),
        arrayOf("") to listOf(listOf("")),
        arrayOf("a") to listOf(listOf("a")),
    )

    for ((strs, expected) in tests) {
        val result = solution.groupAnagrams(strs)
        check(normalize(result) == normalize(expected)) {
            "Expected ${normalize(expected)}, got ${normalize(result)}"
        }
    }

    println("All Kotlin tests passed!")
}
