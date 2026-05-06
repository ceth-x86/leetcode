from typing import List
from collections import defaultdict

def visualize(strs: List[str]):
    print(f"Input: {strs}\n")
    groups = defaultdict(list)
    
    for s in strs:
        count = [0] * 26
        for char in s:
            count[ord(char) - ord('a')] += 1
        
        # Visualize only non-zero counts
        freq_desc = ", ".join([f"{chr(i + ord('a'))}:{c}" for i, c in enumerate(count) if c > 0])
        groups[tuple(count)].append(s)
        
        print(f"Word: '{s}'")
        print(f"  Frequencies: [{freq_desc}]")
        print(f"  Added to group for key: {tuple(count)[:5]}... (truncated)")
        print("-" * 20)
        
    print(f"\nFinal Result: {list(groups.values())}")

if __name__ == "__main__":
    visualize(["eat", "tea", "tan"])
