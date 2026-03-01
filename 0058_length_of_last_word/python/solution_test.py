import pytest

from solution import length_of_last_word


@pytest.mark.parametrize(
    "s, expected",
    [
        ("Hello World", 5),
        ("   fly me   to   the moon  ", 4),
        ("luffy is still joyboy", 6),
        ("Hello", 5),
        ("   Hello   ", 5),
        ("a", 1),
        ("aaaa", 4),
        ("a   b", 1),
        ("Today is a nice day", 3),
    ],
)
def test_length_of_last_word(s: str, expected: int) -> None:
    assert length_of_last_word(s) == expected
