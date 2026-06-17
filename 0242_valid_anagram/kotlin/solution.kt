fun isAnagram(s: String, t: String): Boolean {
    if (s.length != t.length) return false

    val counts = mutableMapOf<Char, Int>()
    for (char in s) {
        counts[char] = counts.getOrDefault(char, 0) + 1
    }
    for (char in t) {
        val next = counts.getOrDefault(char, 0) - 1
        if (next < 0) return false
        if (next == 0) {
            counts.remove(char)
        } else {
            counts[char] = next
        }
    }

    return counts.isEmpty()
}
