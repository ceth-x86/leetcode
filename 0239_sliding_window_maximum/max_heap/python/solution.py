import heapq


def max_sliding_window(nums: list[int], k: int) -> list[int]:
    heap: list[tuple[int, int]] = []
    result: list[int] = []

    for i, value in enumerate(nums):
        heapq.heappush(heap, (-value, i))

        while heap[0][1] <= i - k:
            heapq.heappop(heap)

        if i >= k - 1:
            result.append(-heap[0][0])

    return result
