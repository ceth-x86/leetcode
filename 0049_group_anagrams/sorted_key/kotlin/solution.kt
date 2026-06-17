class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val groups = linkedMapOf<String, MutableList<String>>()

        for (str in strs) {
            val chars = str.toCharArray()
            chars.sort()
            val key = String(chars)
            groups.getOrPut(key) { mutableListOf() }.add(str)
        }

        return groups.values.toList()
    }
}
