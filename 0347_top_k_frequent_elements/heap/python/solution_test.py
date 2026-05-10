import unittest
from solution import Solution

class TestTopKFrequent(unittest.TestCase):
    def setUp(self):
        self.sol = Solution()

    def test_top_k_frequent(self):
        test_cases = [
            ([1, 1, 1, 2, 2, 3], 2, [1, 2]),
            ([1], 1, [1]),
        ]
        for nums, k, expected in test_cases:
            with self.subTest(nums=nums, k=k):
                result = self.sol.topKFrequent(nums, k)
                self.assertEqual(sorted(result), sorted(expected))

if __name__ == "__main__":
    unittest.main()
