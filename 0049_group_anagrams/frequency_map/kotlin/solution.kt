class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val groups = linkedMapOf<String, MutableList<String>>()

        for (str in strs) {
            val counts = IntArray(26)
            for (char in str) {
                counts[char - 'a']++
            }
            val key = counts.joinToString("#")
            groups.getOrPut(key) { mutableListOf() }.add(str)
        }

        return groups.values.toList()
    }
}
