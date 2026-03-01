import pytest

from solution_followup import SubsequenceChecker


@pytest.fixture
def checker() -> SubsequenceChecker:
    return SubsequenceChecker("ahbgdc")


@pytest.mark.parametrize(
    "s, expected",
    [
        ("abc", True),
        ("axc", False),
        ("", True),
        ("ahbgdc", True),
        ("a", True),
        ("c", True),
        ("aaa", False),
        ("abdc", True),
        ("ahbgdca", False),
    ],
)
def test_followup_against_ahbgdc(checker: SubsequenceChecker, s: str, expected: bool) -> None:
    assert checker.is_subsequence(s) == expected


def test_empty_t() -> None:
    checker = SubsequenceChecker("")
    assert checker.is_subsequence("") is True
    assert checker.is_subsequence("a") is False


def test_single_char_t() -> None:
    checker = SubsequenceChecker("a")
    assert checker.is_subsequence("a") is True
    assert checker.is_subsequence("b") is False
    assert checker.is_subsequence("") is True


def test_repeated_chars_in_t() -> None:
    checker = SubsequenceChecker("aabbc")
    assert checker.is_subsequence("abc") is True
    assert checker.is_subsequence("aab") is True
    assert checker.is_subsequence("aabb") is True
    assert checker.is_subsequence("aabbc") is True
    assert checker.is_subsequence("aabbcc") is False


def test_many_queries_same_t() -> None:
    checker = SubsequenceChecker("abcdefghijklmnopqrstuvwxyz")
    assert checker.is_subsequence("ace") is True
    assert checker.is_subsequence("az") is True
    assert checker.is_subsequence("za") is False
    assert checker.is_subsequence("abc") is True
    assert checker.is_subsequence("xyz") is True
