private const val WINDOW_SIZE = 10
private const val WINDOW_MASK = (1 shl (WINDOW_SIZE * 2)) - 1
private val ENCODE = mapOf('A' to 0, 'C' to 1, 'G' to 2, 'T' to 3)

fun findRepeatedDnaSequences(s: String): List<String> {
    if (s.length < WINDOW_SIZE) return emptyList()

    var rolling = 0
    val seen = mutableSetOf<Int>()
    val repeated = mutableSetOf<Int>()
    val result = mutableListOf<String>()

    for ((index, char) in s.withIndex()) {
        rolling = ((rolling shl 2) or ENCODE.getValue(char)) and WINDOW_MASK
        if (index < WINDOW_SIZE - 1) continue

        val start = index - WINDOW_SIZE + 1
        if (rolling in seen) {
            if (repeated.add(rolling)) {
                result.add(s.substring(start, index + 1))
            }
        } else {
            seen.add(rolling)
        }
    }

    return result
}
