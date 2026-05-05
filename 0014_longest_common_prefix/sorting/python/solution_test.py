import unittest
from solution import Solution

class TestLongestCommonPrefix(unittest.TestCase):
    def setUp(self):
        self.sol = Solution()

    def test_longest_common_prefix(self):
        test_cases = [
            (["flower", "flow", "flight"], "fl"),
            (["dog", "racecar", "car"], ""),
            (["ab", "a"], "a"),
        ]
        for strs, expected in test_cases:
            with self.subTest(strs=strs):
                self.assertEqual(self.sol.longestCommonPrefix(strs), expected)

if __name__ == "__main__":
    unittest.main()
