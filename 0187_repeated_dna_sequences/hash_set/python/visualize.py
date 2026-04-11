"""Visualization of the hash-set solution for Repeated DNA Sequences."""

WINDOW_SIZE = 10


def visualize(s: str) -> None:
    print(f'Input: s = "{s}"')

    if len(s) < WINDOW_SIZE:
        print(f"Length {len(s)} is smaller than {WINDOW_SIZE} -> no windows")
        print(">>> Result: []")
        return

    seen: set[str] = set()
    repeated: set[str] = set()
    result: list[str] = []

    print(f"\n{'Step':<6} {'Start':<6} {'Window':<14} {'Action'}")
    print("-" * 60)

    for step, start in enumerate(range(len(s) - WINDOW_SIZE + 1), 1):
        window = s[start:start + WINDOW_SIZE]
        if window in seen:
            if window in repeated:
                action = "already known repeat"
            else:
                repeated.add(window)
                result.append(window)
                action = "seen before -> append to result"
        else:
            seen.add(window)
            action = "first time seen"

        print(f"{step:<6} {start:<6} {window:<14} {action}")

    print(f"\n>>> Result: {result}")


if __name__ == "__main__":
    print("=" * 60)
    print("Example 1")
    visualize("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT")

    print("\n" + "=" * 60)
    print("Example 2")
    visualize("AAAAAAAAAAAAA")

    print("\n" + "=" * 60)
    print("Short input")
    visualize("ACGT")
