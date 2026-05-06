from typing import List
from collections import defaultdict

def visualize(strs: List[str]):
    print(f"Input: {strs}\n")
    groups = defaultdict(list)
    
    print(f"{'Original':<10} | {'Sorted (Key)':<12} | {'Current Groups'}")
    print("-" * 50)
    
    for s in strs:
        sorted_s = "".join(sorted(s))
        groups[sorted_s].append(s)
        print(f"{s:<10} | {sorted_s:<12} | {list(groups.values())}")
        
    print(f"\nFinal Result: {list(groups.values())}")

if __name__ == "__main__":
    visualize(["eat", "tea", "tan", "ate", "nat", "bat"])
