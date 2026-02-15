"""Visualization of the Contains Duplicate algorithm."""


def visualize(nums: list[int]) -> None:
    print(f"Input: {nums}")
    print(f"{'Step':<6} {'Element':<10} {'Action':<20} {'Seen Set'}")
    print("-" * 60)

    seen: set[int] = set()
    for i, num in enumerate(nums):
        if num in seen:
            print(f"{i + 1:<6} {num:<10} {'DUPLICATE FOUND!':<20} {sorted(seen)}")
            print(f"\n>>> Result: true (element {num} seen at earlier index)")
            return
        seen.add(num)
        print(f"{i + 1:<6} {num:<10} {'add to set':<20} {sorted(seen)}")

    print(f"\n>>> Result: false (all {len(nums)} elements are distinct)")


if __name__ == "__main__":
    print("=" * 60)
    print("Example 1:")
    visualize([1, 2, 3, 1])

    print("\n" + "=" * 60)
    print("Example 2:")
    visualize([1, 2, 3, 4])

    print("\n" + "=" * 60)
    print("Example 3:")
    visualize([1, 1, 1, 3, 3, 4, 3, 2, 4, 2])
