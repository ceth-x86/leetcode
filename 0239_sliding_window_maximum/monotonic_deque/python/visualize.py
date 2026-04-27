"""Visualization of the monotonic deque solution for Sliding Window Maximum."""

from collections import deque


def visualize(nums: list[int], k: int) -> None:
    dq: deque[int] = deque()
    result: list[int] = []

    print(f"nums = {nums}, k = {k}")
    print()
    print(f"{'Step':<6} {'i':<4} {'num':<6} {'Deque indices':<18} {'Deque values':<18} {'Output'}")
    print("-" * 80)

    for step, (i, value) in enumerate(enumerate(nums), 1):
        while dq and dq[0] <= i - k:
            dq.popleft()

        while dq and nums[dq[-1]] <= value:
            dq.pop()

        dq.append(i)

        if i >= k - 1:
            result.append(nums[dq[0]])

        deque_values = [nums[index] for index in dq]
        print(f"{step:<6} {i:<4} {value:<6} {list(dq)!s:<18} {str(deque_values):<18} {result}")


if __name__ == "__main__":
    print("=" * 80)
    visualize([1, 3, -1, -3, 5, 3, 6, 7], 3)

    print("\n" + "=" * 80)
    visualize([4, 3, 2, 1], 2)
