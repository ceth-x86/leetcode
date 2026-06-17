fun main() {
    check(findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT").sorted() ==
        listOf("AAAAACCCCC", "CCCCCAAAAA"))
    check(findRepeatedDnaSequences("AAAAAAAAAAAAA") == listOf("AAAAAAAAAA"))
    check(findRepeatedDnaSequences("ACGT").isEmpty())
    check(findRepeatedDnaSequences("ACGTACGTAC").isEmpty())
    check(findRepeatedDnaSequences("AAAAAAAAAAAA") == listOf("AAAAAAAAAA"))

    println("All Kotlin tests passed!")
}
