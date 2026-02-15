import pytest

from solution import is_anagram


@pytest.mark.parametrize(
    "s, t, expected",
    [
        ("anagram", "nagaram", True),
        ("rat", "car", False),
        ("a", "a", True),
        ("a", "b", False),
        ("ab", "abc", False),
        ("abc", "abc", True),
        ("aaa", "aaa", True),
        ("aacc", "ccac", False),
        ("", "", True),
    ],
)
def test_is_anagram(s: str, t: str, expected: bool) -> None:
    assert is_anagram(s, t) == expected
