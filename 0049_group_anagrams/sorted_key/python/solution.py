from typing import List
from collections import defaultdict

class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        # Use a hash map where key is the sorted string and value is a list of anagrams
        groups = defaultdict(list)
        
        for s in strs:
            # Sorting a string returns a list of characters, so we join them back to a string to use as a key
            sorted_s = "".join(sorted(s))
            groups[sorted_s].append(s)
            
        return list(groups.values())
