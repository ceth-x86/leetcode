# Clojure Solution

## Language Features Used

- **Java `PriorityQueue` interop** for the heap
- **Custom comparator** to turn the queue into a max-heap
- **`loop` / `recur`** for iterative scanning

## Implementation Decisions

- Heap-based sliding-window maximum is much easier to express in Clojure through JVM interop than through a custom persistent heap.
- Each heap entry stores both the value and the index so stale windows can be removed lazily.
- This solution is pragmatic and clear, but not as efficient as the monotonic deque approach.

## Running Tests

```bash
clj -M -e "(require '[clojure.test :refer [run-tests]]) (load-file \"src/solution.clj\") (load-file \"test/solution_test.clj\") (run-tests 'solution-test)"
```
