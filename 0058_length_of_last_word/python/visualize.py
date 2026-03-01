"""Visualization of the Length of Last Word algorithm."""


def visualize(s: str) -> None:
    print(f'Input: s = "{s}"')
    print(f"       idx: ", end="")
    for i in range(len(s)):
        print(f"{i % 10}", end="")
    print()
    print()

    i = len(s) - 1

    # Phase 1: skip trailing spaces
    skipped = 0
    while i >= 0 and s[i] == " ":
        skipped += 1
        i -= 1

    if skipped > 0:
        print(f"  Skip {skipped} trailing space(s), now at i={i}")
    else:
        print(f"  No trailing spaces")

    # Phase 2: count word characters
    end = i
    print(f"  Counting from i={end}:")
    while i >= 0 and s[i] != " ":
        print(f"    i={i}: '{s[i]}'")
        i -= 1

    length = end - i
    if i >= 0:
        print(f"  Hit space at i={i}, stop")
    else:
        print(f"  Reached start of string")

    print(f"\n>>> Last word: \"{s[i + 1:end + 1]}\", length: {length}")


if __name__ == "__main__":
    print("=" * 60)
    print("Example 1:")
    visualize("Hello World")

    print("\n" + "=" * 60)
    print("Example 2: trailing spaces")
    visualize("   fly me   to   the moon  ")

    print("\n" + "=" * 60)
    print("Example 3: no trailing spaces")
    visualize("luffy is still joyboy")

    print("\n" + "=" * 60)
    print("Example 4: single word with spaces")
    visualize("   Hello   ")
