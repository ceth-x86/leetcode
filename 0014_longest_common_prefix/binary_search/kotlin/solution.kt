class Solution {
    fun longestCommonPrefix(strs: Array<String>): String {
        if (strs.isEmpty()) return ""

        var low = 1
        var high = strs.minOf { it.length }
        var answer = 0

        while (low <= high) {
            val mid = (low + high) / 2
            if (isCommonPrefix(strs, mid)) {
                answer = mid
                low = mid + 1
            } else {
                high = mid - 1
            }
        }

        return strs[0].substring(0, answer)
    }

    private fun isCommonPrefix(strs: Array<String>, length: Int): Boolean {
        val prefix = strs[0].substring(0, length)
        return strs.drop(1).all { it.startsWith(prefix) }
    }
}
