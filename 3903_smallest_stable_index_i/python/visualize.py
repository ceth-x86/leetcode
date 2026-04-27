"""Visualization of the Smallest Stable Index I algorithm."""


def visualize(nums: list[int], k: int) -> None:
    n = len(nums)
    suffix_min = [0] * n

    suffix_min[-1] = nums[-1]
    for i in range(n - 2, -1, -1):
        suffix_min[i] = min(suffix_min[i + 1], nums[i])

    print(f"nums = {nums}, k = {k}")
    print(f"{'Index':<8}{'Value':<8}{'Prefix Max':<12}{'Suffix Min':<12}{'Score':<8}{'Stable'}")
    print("-" * 60)

    prefix_max = nums[0]
    for i, num in enumerate(nums):
        prefix_max = max(prefix_max, num)
        score = prefix_max - suffix_min[i]
        stable = score <= k
        print(f"{i:<8}{num:<8}{prefix_max:<12}{suffix_min[i]:<12}{score:<8}{stable}")
        if stable:
            print(f"\n>>> Smallest stable index = {i}")
            return

    print("\n>>> No stable index exists")


if __name__ == "__main__":
    visualize([5, 0, 1, 4], 3)
    print()
    visualize([10, 0], 5)
