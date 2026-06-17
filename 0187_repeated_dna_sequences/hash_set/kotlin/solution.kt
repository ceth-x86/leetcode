private const val WINDOW_SIZE = 10

fun findRepeatedDnaSequences(s: String): List<String> {
    if (s.length < WINDOW_SIZE) return emptyList()

    val seen = mutableSetOf<String>()
    val repeated = mutableSetOf<String>()
    val result = mutableListOf<String>()

    for (start in 0..s.length - WINDOW_SIZE) {
        val fragment = s.substring(start, start + WINDOW_SIZE)
        if (fragment in seen) {
            if (repeated.add(fragment)) {
                result.add(fragment)
            }
        } else {
            seen.add(fragment)
        }
    }

    return result
}
