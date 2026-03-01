"""Visualization of the Is Subsequence algorithm."""


def visualize(s: str, t: str) -> None:
    print(f'Input: s = "{s}", t = "{t}"')
    print()

    if not s:
        print("s is empty → trivially a subsequence")
        print(f"\n>>> Result: true")
        return

    print(f"{'Step':<6} {'j':<4} {'t[j]':<6} {'s[i]':<6} {'Match?':<8} {'Progress'}")
    print("-" * 60)

    i = 0
    for step, (j, ch) in enumerate(enumerate(t), 1):
        if i < len(s):
            matched = s[i] == ch
            progress = f"matched {i + 1}/{len(s)}" if matched else f"matched {i}/{len(s)}"
            marker = "YES" if matched else "no"
            print(f"{step:<6} {j:<4} {ch!r:<6} {s[i]!r:<6} {marker:<8} {progress}")
            if matched:
                i += 1
                if i == len(s):
                    print(f"\n>>> All characters of s matched! Result: true")
                    return
        else:
            break

    if i < len(s):
        print(f"\n>>> Exhausted t with {len(s) - i} character(s) of s unmatched. Result: false")
    else:
        print(f"\n>>> Result: true")


if __name__ == "__main__":
    print("=" * 60)
    print("Example 1: subsequence found")
    visualize("abc", "ahbgdc")

    print("\n" + "=" * 60)
    print("Example 2: not a subsequence")
    visualize("axc", "ahbgdc")

    print("\n" + "=" * 60)
    print("Example 3: empty s")
    visualize("", "ahbgdc")

    print("\n" + "=" * 60)
    print("Example 4: s equals t")
    visualize("abc", "abc")

    print("\n" + "=" * 60)
    print("Example 5: s longer than t")
    visualize("abc", "ab")
