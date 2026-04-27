"""Visualization of the max-heap solution for Sliding Window Maximum."""

import heapq


def visualize(nums: list[int], k: int) -> None:
    heap: list[tuple[int, int]] = []
    result: list[int] = []

    print(f"nums = {nums}, k = {k}")
    print()
    print(f"{'Step':<6} {'i':<4} {'num':<6} {'Heap top':<18} {'Output'}")
    print("-" * 70)

    for step, (i, value) in enumerate(enumerate(nums), 1):
        heapq.heappush(heap, (-value, i))

        while heap[0][1] <= i - k:
            heapq.heappop(heap)

        if i >= k - 1:
            result.append(-heap[0][0])

        top_value, top_index = -heap[0][0], heap[0][1]
        print(f"{step:<6} {i:<4} {value:<6} {str((top_value, top_index)):<18} {result}")


if __name__ == "__main__":
    print("=" * 70)
    visualize([1, 3, -1, -3, 5, 3, 6, 7], 3)
