from typing import List

def visualize(strs: List[str]):
    if not strs: return
    print(f"Input: {strs}")
    min_len = min(len(s) for s in strs)
    print(f"Min length: {min_len}")
    
    low, high = 1, min_len
    ans = 0
    while low <= high:
        mid = (low + high) // 2
        prefix = strs[0][:mid]
        print(f"\nChecking length {mid}, prefix '{prefix}':")
        is_common = True
        for i, s in enumerate(strs):
            if not s.startswith(prefix):
                print(f"  String {i} ('{s}') DOES NOT start with '{prefix}'")
                is_common = False
                break
            print(f"  String {i} ('{s}') starts with '{prefix}'")
        
        if is_common:
            print(f"  Result: Found common prefix of length {mid}. Searching right.")
            ans = mid
            low = mid + 1
        else:
            print(f"  Result: Length {mid} is too long. Searching left.")
            high = mid - 1
            
    print(f"\nFinal Result: '{strs[0][:ans]}'")

if __name__ == "__main__":
    visualize(["flower", "flow", "flight"])
