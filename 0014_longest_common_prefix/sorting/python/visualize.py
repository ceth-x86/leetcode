import sys
from typing import List

def visualize(strs: List[str]):
    if not strs:
        return
    
    print(f"Input: {strs}")
    strs.sort()
    print(f"Sorted: {strs}")
    
    first = strs[0]
    last = strs[-1]
    print(f"Comparing first ('{first}') and last ('{last}'):")
    
    i = 0
    while i < len(first) and i < len(last) and first[i] == last[i]:
        print(f"  Index {i}: '{first[i]}' == '{last[i]}' -> MATCH")
        i += 1
    
    if i < len(first) and i < len(last):
        print(f"  Index {i}: '{first[i]}' != '{last[i]}' -> MISMATCH")
    
    print(f"\nFinal Result: '{first[:i]}'")

if __name__ == "__main__":
    visualize(["flower", "flow", "flight"])
