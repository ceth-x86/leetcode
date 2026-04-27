package slidingwindowmaximum

import "container/heap"

type item struct {
	value int
	index int
}

type maxHeap []item

func (h maxHeap) Len() int { return len(h) }

func (h maxHeap) Less(i, j int) bool {
	if h[i].value == h[j].value {
		return h[i].index > h[j].index
	}
	return h[i].value > h[j].value
}

func (h maxHeap) Swap(i, j int) { h[i], h[j] = h[j], h[i] }

func (h *maxHeap) Push(x any) { *h = append(*h, x.(item)) }

func (h *maxHeap) Pop() any {
	old := *h
	last := old[len(old)-1]
	*h = old[:len(old)-1]
	return last
}

func maxSlidingWindow(nums []int, k int) []int {
	h := &maxHeap{}
	heap.Init(h)

	result := make([]int, 0, len(nums)-k+1)
	for i, value := range nums {
		heap.Push(h, item{value: value, index: i})

		for (*h)[0].index <= i-k {
			heap.Pop(h)
		}

		if i >= k-1 {
			result = append(result, (*h)[0].value)
		}
	}

	return result
}
