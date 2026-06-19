private fun buildTree(values: List<Int?>): TreeNode? {
    if (values.isEmpty() || values[0] == null) return null

    val nodes = values.map { value -> value?.let { TreeNode(it) } }
    var child = 1
    for (node in nodes) {
        if (node == null) continue
        if (child < nodes.size) {
            node.left = nodes[child++]
        }
        if (child < nodes.size) {
            node.right = nodes[child++]
        }
    }

    return nodes[0]
}

private fun serialize(root: TreeNode?): List<Int?> {
    if (root == null) return emptyList()

    val result = mutableListOf<Int?>()
    val queue = ArrayDeque<TreeNode?>()
    queue.addLast(root)

    while (queue.isNotEmpty()) {
        val node = queue.removeFirst()
        if (node == null) {
            result.add(null)
            continue
        }

        result.add(node.`val`)
        queue.addLast(node.left)
        queue.addLast(node.right)
    }

    while (result.isNotEmpty() && result.last() == null) {
        result.removeLast()
    }
    return result
}

fun main() {
    val tests = listOf(
        listOf(4, 2, 7, 1, 3, 6, 9) to listOf(4, 7, 2, 9, 6, 3, 1),
        listOf(2, 1, 3) to listOf(2, 3, 1),
        emptyList<Int?>() to emptyList(),
        listOf(1) to listOf(1),
        listOf(1, 2) to listOf(1, null, 2),
        listOf(1, null, 2) to listOf(1, 2),
        listOf(-1, -2, 3) to listOf(-1, 3, -2),
    )

    for ((input, expected) in tests) {
        val result = serialize(invertTree(buildTree(input)))
        check(result == expected) { "Expected $expected, got $result" }
    }

    println("All Kotlin tests passed!")
}
