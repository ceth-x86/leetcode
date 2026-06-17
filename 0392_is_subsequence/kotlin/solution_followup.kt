import java.util.Collections

class SubsequenceChecker(t: String) {
    private val indexMap = mutableMapOf<Char, MutableList<Int>>()

    init {
        for ((index, char) in t.withIndex()) {
            indexMap.getOrPut(char) { mutableListOf() }.add(index)
        }
    }

    fun isSubsequence(s: String): Boolean {
        var position = 0

        for (char in s) {
            val indices = indexMap[char] ?: return false
            val rawIndex = Collections.binarySearch(indices, position)
            val insertionPoint = if (rawIndex >= 0) rawIndex else -rawIndex - 1
            if (insertionPoint == indices.size) return false
            position = indices[insertionPoint] + 1
        }

        return true
    }
}
