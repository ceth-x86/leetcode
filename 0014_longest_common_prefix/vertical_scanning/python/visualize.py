import sys
from typing import List

def visualize(strs: List[str]):
    if not strs:
        print("Input list is empty.")
        return

    print(f"Input: {strs}")
    print("-" * 40)
    
    if not strs[0]:
        print("First string is empty. Common prefix is \"\".")
        return

    for i in range(len(strs[0])):
        char = strs[0][i]
        print(f"Checking index {i}, character '{char}':")
        
        for j, s in enumerate(strs):
            if i >= len(s):
                print(f"  String {j} ('{s}') ends at index {i}. Stop.")
                print(f"\nResult: '{strs[0][:i]}'")
                return
            
            match = s[i] == char
            status = "MATCH" if match else "MISMATCH"
            print(f"  String {j} ('{s}'): index {i} is '{s[i]}' -> {status}")
            
            if not match:
                print(f"\nMismatch found at index {i}. Stop.")
                print(f"\nResult: '{strs[0][:i]}'")
                return
        print("  All strings match at this index.\n")

    print(f"\nReached end of first string. Result: '{strs[0]}'")

if __name__ == "__main__":
    test_cases = [
        ["flower", "flow", "flight"],
        ["dog", "racecar", "car"],
        ["ab", "a"]
    ]
    for tc in test_cases:
        visualize(tc)
        print("=" * 40)
