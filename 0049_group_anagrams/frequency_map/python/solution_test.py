import unittest
from solution import Solution

class TestGroupAnagrams(unittest.TestCase):
    def setUp(self):
        self.sol = Solution()

    def test_group_anagrams(self):
        def sort_result(res):
            return sorted([sorted(group) for group in res])

        test_cases = [
            (
                ["eat", "tea", "tan", "ate", "nat", "bat"],
                [["ate", "eat", "tea"], ["nat", "tan"], ["bat"]]
            ),
            ([""], [[""]]),
            (["a"], [["a"]]),
        ]
        for strs, expected in test_cases:
            with self.subTest(strs=strs):
                result = self.sol.groupAnagrams(strs)
                self.assertEqual(sort_result(result), sort_result(expected))

if __name__ == "__main__":
    unittest.main()
