fun lengthOfLastWord(s: String): Int {
    var i = s.length - 1
    while (i >= 0 && s[i] == ' ') {
        i--
    }

    val end = i
    while (i >= 0 && s[i] != ' ') {
        i--
    }

    return end - i
}
