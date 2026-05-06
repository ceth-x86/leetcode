from typing import List
from collections import defaultdict

class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        # Use a hash map where key is a tuple of character frequencies (size 26)
        groups = defaultdict(list)
        
        for s in strs:
            # Create a frequency array for characters 'a' through 'z'
            count = [0] * 26
            for char in s:
                count[ord(char) - ord('a')] += 1
            
            # Use the frequency tuple as a dictionary key
            groups[tuple(count)].append(s)
            
        return list(groups.values())
