from typing import List
import heapq
from collections import Counter

def visualize(nums: List[int], k: int):
    print(f"Input: nums={nums}, k={k}\n")
    
    counts = Counter(nums)
    print(f"Frequencies: {dict(counts)}")
    
    print(f"\nBuilding a min-heap of size k={k}...")
    heap = []
    for num, freq in counts.items():
        print(f"  Pushing ({freq}, {num})")
        heapq.heappush(heap, (freq, num))
        if len(heap) > k:
            popped = heapq.heappop(heap)
            print(f"    Heap size {len(heap)+1} > {k}, popped minimum: {popped}")
        print(f"    Current Heap: {heap}")
        
    result = [num for freq, num in heap]
    print(f"\nFinal Result: {result}")
    return result

if __name__ == "__main__":
    visualize([1, 1, 1, 2, 2, 3], 2)
