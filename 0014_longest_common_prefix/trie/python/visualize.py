from typing import List

def visualize(strs: List[str]):
    print(f"Input: {strs}")
    print("\nBuilding Trie...")
    # Simplified visualization of Trie walk
    if not strs: return
    if any(not s for s in strs):
        print("Empty string found. Common prefix is \"\".")
        return

    node_count = 1
    # We simulate walking down the only path until a branch or end of word
    prefix = ""
    for i in range(len(strs[0])):
        char = strs[0][i]
        print(f"Index {i}, char '{char}':")
        for j, s in enumerate(strs):
            if i >= len(s) or s[i] != char:
                print(f"  Branch or end found at string {j}. Stop.")
                print(f"\nFinal Result: '{prefix}'")
                return
            print(f"  String {j} matches '{char}'")
        prefix += char
    print(f"\nFinal Result: '{prefix}'")

if __name__ == "__main__":
    visualize(["flower", "flow", "flight"])
