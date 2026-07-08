import pytest
from solution import Solution

def test_pivot_index():
    solution = Solution()
    assert solution.pivotIndex([1, 7, 3, 6, 5, 6]) == 3
    assert solution.pivotIndex([1, 2, 3]) == -1
    assert solution.pivotIndex([2, 1, -1]) == 0
    assert solution.pivotIndex([0]) == 0
