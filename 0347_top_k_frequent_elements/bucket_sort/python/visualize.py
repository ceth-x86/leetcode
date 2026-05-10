from typing import List
from collections import Counter

def visualize(nums: List[int], k: int):
    print(f"Input: nums={nums}, k={k}\n")
    
    # Frequency counting
    counts = Counter(nums)
    print(f"Frequencies: {dict(counts)}")
    
    # Bucket filling
    buckets = [[] for _ in range(len(nums) + 1)]
    for num, freq in counts.items():
        buckets[freq].append(num)
    
    print("\nBuckets (Index = Frequency):")
    for freq, items in enumerate(buckets):
        if items:
            print(f"  Freq {freq}: {items}")
            
    # Result collection
    print(f"\nCollecting top {k} elements starting from the highest frequency bucket...")
    result = []
    for i in range(len(buckets) - 1, 0, -1):
        if buckets[i]:
            print(f"  Checking bucket {i}: {buckets[i]}")
            for num in buckets[i]:
                result.append(num)
                print(f"    Added {num}, current result: {result}")
                if len(result) == k:
                    print(f"\nFinal Result: {result}")
                    return result

if __name__ == "__main__":
    visualize([1, 1, 1, 2, 2, 3], 2)
