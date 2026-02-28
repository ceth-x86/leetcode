"""Visualization of the Replace Elements with Greatest Element on Right Side algorithm."""


def visualize(arr: list[int]) -> None:
    original = arr.copy()
    print(f"Input: arr = {original}")
    print(f"\n{'Step':<6} {'i':<4} {'Original':<10} {'right_max':<12} {'arr[i] ←':<10} {'New right_max':<14} {'Array State'}")
    print("-" * 90)

    right_max = -1
    for step, i in enumerate(range(len(arr) - 1, -1, -1), 1):
        old_val = arr[i]
        new_right_max = max(right_max, old_val)
        arr[i] = right_max
        print(
            f"{step:<6} {i:<4} {old_val:<10} {right_max:<12} {arr[i]:<10} "
            f"{new_right_max:<14} {arr}"
        )
        right_max = new_right_max

    print(f"\n>>> Result: {arr}")


if __name__ == "__main__":
    print("=" * 90)
    print("Example 1:")
    visualize([17, 18, 5, 4, 6, 1])

    print("\n" + "=" * 90)
    print("Example 2: single element")
    visualize([400])

    print("\n" + "=" * 90)
    print("Example 3: ascending order")
    visualize([1, 2, 3, 4, 5])

    print("\n" + "=" * 90)
    print("Example 4: descending order")
    visualize([5, 4, 3, 2, 1])
