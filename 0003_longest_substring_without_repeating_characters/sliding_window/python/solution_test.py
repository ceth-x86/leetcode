import pytest

from solution import length_of_longest_substring


@pytest.mark.parametrize(
    "s, expected",
    [
        ("abcabcbb", 3),
        ("bbbbb", 1),
        ("pwwkew", 3),
        ("", 0),
        ("a", 1),
        ("abcdef", 6),
        ("abba", 2),
        ("dvdf", 3),
        ("aab", 2),
        ("tmmzuxt", 5),
        ("a! b@a", 5),
    ],
)
def test_length_of_longest_substring(s: str, expected: int) -> None:
    assert length_of_longest_substring(s) == expected
