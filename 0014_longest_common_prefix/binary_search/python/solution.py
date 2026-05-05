from typing import List

class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        if not strs:
            return ""
        
        min_len = min(len(s) for s in strs)
        low = 1
        high = min_len
        ans = 0
        
        while low <= high:
            mid = (low + high) // 2
            if self.isCommonPrefix(strs, mid):
                ans = mid
                low = mid + 1
            else:
                high = mid - 1
                
        return strs[0][:ans]

    def isCommonPrefix(self, strs: List[str], length: int) -> bool:
        prefix = strs[0][:length]
        for i in range(1, len(strs)):
            if not strs[i].startswith(prefix):
                return False
        return True
