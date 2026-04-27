from solution import max_sliding_window


def test_example_one() -> None:
    assert max_sliding_window([1, 3, -1, -3, 5, 3, 6, 7], 3) == [3, 3, 5, 5, 6, 7]


def test_example_two() -> None:
    assert max_sliding_window([1], 1) == [1]


def test_full_array_window() -> None:
    assert max_sliding_window([2, 1, 3], 3) == [3]


def test_increasing_values() -> None:
    assert max_sliding_window([1, 2, 3, 4], 2) == [2, 3, 4]


def test_duplicates() -> None:
    assert max_sliding_window([1, 3, 3, 2], 2) == [3, 3, 3]


def test_negative_values() -> None:
    assert max_sliding_window([-4, -2, -5, -1], 2) == [-2, -2, -1]
