import sys
from typing import List

def visualize(strs: List[str]):
    if not strs:
        return
    
    print(f"Input: {strs}")
    prefix = strs[0]
    print(f"Initial prefix: '{prefix}'")
    
    for i in range(1, len(strs)):
        print(f"\nComparing with '{strs[i]}':")
        while not strs[i].startswith(prefix):
            prefix = prefix[:-1]
            print(f"  Prefix reduced to: '{prefix}'")
            if not prefix:
                print("  Prefix empty. Stop.")
                return
        print(f"  Current common prefix: '{prefix}'")

    print(f"\nFinal Result: '{prefix}'")

if __name__ == "__main__":
    visualize(["flower", "flow", "flight"])
