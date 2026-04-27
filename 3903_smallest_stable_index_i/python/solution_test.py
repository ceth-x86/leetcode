import pytest

from solution import first_stable_index


@pytest.mark.parametrize(
    "nums, k, expected",
    [
        ([5, 0, 1, 4], 3, 3),
        ([4, 4, 4], 0, 0),
        ([9], 0, 0),
        ([2, 5, 7], 0, 0),
        ([10, 0], 5, -1),
        ([3, 1, 2], 0, -1),
        ([8, 2, 6, 7], 2, 2),
        ([1, 3, 2, 5], 1, 0),
    ],
)
def test_first_stable_index(nums: list[int], k: int, expected: int) -> None:
    assert first_stable_index(nums, k) == expected
