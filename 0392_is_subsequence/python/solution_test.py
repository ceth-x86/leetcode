import pytest

from solution import is_subsequence


@pytest.mark.parametrize(
    "s, t, expected",
    [
        ("abc", "ahbgdc", True),
        ("axc", "ahbgdc", False),
        ("", "ahbgdc", True),
        ("", "", True),
        ("abc", "ab", False),
        ("abc", "abc", True),
        ("a", "a", True),
        ("a", "b", False),
        ("c", "abc", True),
        ("a", "", False),
    ],
)
def test_is_subsequence(s: str, t: str, expected: bool) -> None:
    assert is_subsequence(s, t) == expected
