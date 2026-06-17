private const val WINDOW_SIZE = 10
private val ENCODE = mapOf('A' to 0, 'C' to 1, 'G' to 2, 'T' to 3)

fun findRepeatedDnaSequences(s: String): List<String> {
    if (s.length <= WINDOW_SIZE) return emptyList()

    val nums = s.map { ENCODE.getValue(it) }
    var bitmask = 0
    val seen = mutableSetOf<Int>()
    val output = linkedSetOf<String>()
    val clearLeadingBitsMask = (3 shl (2 * WINDOW_SIZE)).inv()

    for (start in 0..s.length - WINDOW_SIZE) {
        if (start == 0) {
            for (index in 0 until WINDOW_SIZE) {
                bitmask = (bitmask shl 2) or nums[index]
            }
        } else {
            bitmask = bitmask shl 2
            bitmask = bitmask or nums[start + WINDOW_SIZE - 1]
            bitmask = bitmask and clearLeadingBitsMask
        }

        if (!seen.add(bitmask)) {
            output.add(s.substring(start, start + WINDOW_SIZE))
        }
    }

    return output.toList()
}
