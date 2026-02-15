"""Visualization of the Valid Anagram algorithm."""


def visualize(s: str, t: str) -> None:
    print(f'Input: s = "{s}", t = "{t}"')

    if len(s) != len(t):
        print(f"Length mismatch: {len(s)} != {len(t)}")
        print(">>> Result: false")
        return

    counts: dict[str, int] = {}

    print(f"\n{'Step':<6} {'Char s':<8} {'Char t':<8} {'Action':<28} {'Counts'}")
    print("-" * 75)

    for i in range(len(s)):
        sc, tc = s[i], t[i]
        counts[sc] = counts.get(sc, 0) + 1
        counts[tc] = counts.get(tc, 0) - 1

        non_zero = {k: v for k, v in sorted(counts.items()) if v != 0}
        display = non_zero if non_zero else "{all zero}"
        print(f"{i + 1:<6} {sc:<8} {tc:<8} {sc}:+1, {tc}:-1{'':<16} {display}")

    non_zero = {k: v for k, v in counts.items() if v != 0}
    if non_zero:
        print(f"\n>>> Result: false (non-zero counts: {non_zero})")
    else:
        print("\n>>> Result: true (all counts are zero)")


if __name__ == "__main__":
    print("=" * 75)
    print("Example 1:")
    visualize("anagram", "nagaram")

    print("\n" + "=" * 75)
    print("Example 2:")
    visualize("rat", "car")

    print("\n" + "=" * 75)
    print("Different lengths:")
    visualize("ab", "abc")
