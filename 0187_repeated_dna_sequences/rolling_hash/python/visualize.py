"""Visualization of the rolling-hash solution for Repeated DNA Sequences."""

WINDOW_SIZE = 10
WINDOW_MASK = (1 << (WINDOW_SIZE * 2)) - 1
ENCODE = {"A": 0, "C": 1, "G": 2, "T": 3}


def visualize(s: str) -> None:
    print(f'Input: s = "{s}"')

    if len(s) < WINDOW_SIZE:
        print(f"Length {len(s)} is smaller than {WINDOW_SIZE} -> no windows")
        print(">>> Result: []")
        return

    rolling = 0
    seen: set[int] = set()
    repeated: set[int] = set()
    result: list[str] = []

    print(f"\n{'Step':<6} {'Char':<6} {'Window':<14} {'20-bit hash':<22} {'Action'}")
    print("-" * 90)

    for step, (index, ch) in enumerate(enumerate(s), 1):
        rolling = ((rolling << 2) | ENCODE[ch]) & WINDOW_MASK
        if index < WINDOW_SIZE - 1:
            print(f"{step:<6} {ch:<6} {'-':<14} {rolling:020b} build initial window")
            continue

        start = index - WINDOW_SIZE + 1
        window = s[start:index + 1]
        if rolling in seen:
            if rolling in repeated:
                action = "already known repeat"
            else:
                repeated.add(rolling)
                result.append(window)
                action = "seen before -> append to result"
        else:
            seen.add(rolling)
            action = "first time seen"

        print(f"{step:<6} {ch:<6} {window:<14} {rolling:020b}   {action}")

    print(f"\n>>> Result: {result}")


if __name__ == "__main__":
    print("=" * 90)
    print("Example 1")
    visualize("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT")

    print("\n" + "=" * 90)
    print("Example 2")
    visualize("AAAAAAAAAAAAA")

    print("\n" + "=" * 90)
    print("Short input")
    visualize("ACGT")
