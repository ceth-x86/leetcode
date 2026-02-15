"""Visualization of the Two Sum algorithm."""


def visualize(nums: list[int], target: int) -> None:
    print(f"Input: nums = {nums}, target = {target}")
    print(f"{'Step':<6} {'Element':<10} {'Complement':<12} {'Action':<24} {'Seen Map'}")
    print("-" * 80)

    seen: dict[int, int] = {}
    for i, num in enumerate(nums):
        complement = target - num
        if complement in seen:
            print(
                f"{i + 1:<6} {num:<10} {complement:<12} "
                f"{'FOUND! return ' + str([seen[complement], i]):<24} {seen}"
            )
            print(f"\n>>> Result: {[seen[complement], i]}")
            return
        seen[num] = i
        print(f"{i + 1:<6} {num:<10} {complement:<12} {'store index ' + str(i):<24} {seen}")

    print("\n>>> No solution found")


if __name__ == "__main__":
    print("=" * 80)
    print("Example 1:")
    visualize([2, 7, 11, 15], 9)

    print("\n" + "=" * 80)
    print("Example 2:")
    visualize([3, 2, 4], 6)

    print("\n" + "=" * 80)
    print("Example 3:")
    visualize([3, 3], 6)
