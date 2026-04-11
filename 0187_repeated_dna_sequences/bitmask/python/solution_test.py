from solution import find_repeated_dna_sequences


def test_example_one() -> None:
    assert sorted(find_repeated_dna_sequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT")) == [
        "AAAAACCCCC",
        "CCCCCAAAAA",
    ]


def test_example_two() -> None:
    assert find_repeated_dna_sequences("AAAAAAAAAAAAA") == ["AAAAAAAAAA"]


def test_too_short() -> None:
    assert find_repeated_dna_sequences("ACGT") == []


def test_exactly_ten() -> None:
    assert find_repeated_dna_sequences("ACGTACGTAC") == []


def test_single_repetition_reported_once() -> None:
    assert find_repeated_dna_sequences("AAAAAAAAAAAA") == ["AAAAAAAAAA"]
