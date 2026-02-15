import pytest

from solution import contains_duplicate


@pytest.mark.parametrize(
    "nums, expected",
    [
        ([1, 2, 3, 1], True),
        ([1, 2, 3, 4], False),
        ([1, 1, 1, 3, 3, 4, 3, 2, 4, 2], True),
        ([1], False),
        ([1, 1], True),
        ([1, 2], False),
        ([5, 5, 5, 5], True),
        ([-1_000_000_000, 1_000_000_000], False),
        (list(range(100_000)) + [0], True),
    ],
)
def test_contains_duplicate(nums: list[int], expected: bool) -> None:
    assert contains_duplicate(nums) == expected
