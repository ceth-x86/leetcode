from typing import List
import heapq
from collections import Counter

class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        # Step 1: Count frequencies
        counts = Counter(nums)
        
        # Step 2: Use a min-heap to keep track of top k frequent elements
        # heap stores (frequency, num)
        heap = []
        for num, freq in counts.items():
            heapq.heappush(heap, (freq, num))
            if len(heap) > k:
                heapq.heappop(heap)
        
        # Step 3: Extract elements from heap
        return [num for freq, num in heap]
