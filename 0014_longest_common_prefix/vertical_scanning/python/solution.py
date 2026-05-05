from typing import List

class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        if not strs:
            return ""
        
        # Take the first string as the reference
        for i in range(len(strs[0])):
            char = strs[0][i]
            # Compare this character with the character at the same position in other strings
            for j in range(1, len(strs)):
                # If we reach the end of a string or characters don't match
                if i == len(strs[j]) or strs[j][i] != char:
                    return strs[0][:i]
        
        return strs[0]
