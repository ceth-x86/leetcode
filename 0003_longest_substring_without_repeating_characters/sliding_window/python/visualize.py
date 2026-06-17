def visualize(s: str) -> None:
    last_seen: dict[str, int] = {}
    left = 0
    best = 0

    print(f"s = {s!r}")
    print()
    print(f"{'right':>5} {'char':>6} {'left':>5} {'window':>12} {'best':>5} action")
    print("-" * 64)

    for right, ch in enumerate(s):
        action = "extend window"
        if ch in last_seen and last_seen[ch] >= left:
            old_left = left
            left = last_seen[ch] + 1
            action = f"repeat at {last_seen[ch]}, left {old_left}->{left}"

        last_seen[ch] = right
        best = max(best, right - left + 1)
        window = s[left : right + 1]
        print(f"{right:>5} {ch!r:>6} {left:>5} {window!r:>12} {best:>5} {action}")

    print()
    print(f"longest length = {best}")


if __name__ == "__main__":
    visualize("abcabcbb")
