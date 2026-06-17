fun lengthOfLongestSubstring(s: String): Int {
    val lastSeen = mutableMapOf<Char, Int>()
    var left = 0
    var best = 0

    for ((right, ch) in s.withIndex()) {
        val previous = lastSeen[ch]
        if (previous != null && previous >= left) {
            left = previous + 1
        }
        lastSeen[ch] = right
        best = maxOf(best, right - left + 1)
    }

    return best
}
