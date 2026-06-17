fun isSubsequence(s: String, t: String): Boolean {
    var i = 0

    for (char in t) {
        if (i < s.length && s[i] == char) {
            i++
        }
    }

    return i == s.length
}
