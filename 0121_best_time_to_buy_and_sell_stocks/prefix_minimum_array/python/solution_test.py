import pytest

from solution import max_profit


@pytest.mark.parametrize(
    "prices, expected",
    [
        ([7, 1, 5, 3, 6, 4], 5),
        ([7, 6, 4, 3, 1], 0),
        ([5], 0),
        ([1, 2], 1),
        ([2, 1], 0),
        ([2, 4, 1], 2),
        ([3, 2, 6, 5, 0, 3], 4),
        ([5, 5, 5], 0),
        ([0, 4, 0, 10], 10),
    ],
)
def test_max_profit(prices: list[int], expected: int) -> None:
    assert max_profit(prices) == expected
