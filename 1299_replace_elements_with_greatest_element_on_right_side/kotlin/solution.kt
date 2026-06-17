fun replaceElements(arr: IntArray): IntArray {
    var rightMax = -1

    for (i in arr.indices.reversed()) {
        val current = arr[i]
        arr[i] = rightMax
        rightMax = maxOf(rightMax, current)
    }

    return arr
}
