"""Visualization of the bitmask solution for Repeated DNA Sequences."""

WINDOW_SIZE = 10
ENCODE = {"A": 0, "C": 1, "G": 2, "T": 3}


def visualize(s: str) -> None:
    print(f'Input: s = "{s}"')

    n = len(s)
    if n <= WINDOW_SIZE:
        print(f"Length {n} is not greater than {WINDOW_SIZE} -> no repeated window possible")
        print(">>> Result: []")
        return

    nums = [ENCODE[ch] for ch in s]
    print(f"Encoded nucleotides: {nums}")

    bitmask = 0
    seen: set[int] = set()
    output: set[str] = set()

    print(f"\n{'Step':<6} {'Start':<6} {'Window':<14} {'Bitmask':<22} {'Action'}")
    print("-" * 90)

    for step, start in enumerate(range(n - WINDOW_SIZE + 1), 1):
        if start == 0:
            for index in range(WINDOW_SIZE):
                bitmask = (bitmask << 2) | nums[index]
            action = "build first window in O(L)"
        else:
            bitmask <<= 2
            bitmask |= nums[start + WINDOW_SIZE - 1]
            bitmask &= ~(3 << (2 * WINDOW_SIZE))
            action = "shift, append new code, clear oldest 2 bits"

        window = s[start:start + WINDOW_SIZE]
        if bitmask in seen:
            output.add(window)
            action += " -> repeated"
        else:
            seen.add(bitmask)
            action += " -> first time"

        print(f"{step:<6} {start:<6} {window:<14} {bitmask:020b}   {action}")

    print(f"\n>>> Result: {sorted(output)}")


if __name__ == "__main__":
    print("=" * 90)
    print("Example 1")
    visualize("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT")

    print("\n" + "=" * 90)
    print("Example 2")
    visualize("AAAAAAAAAAAAA")
