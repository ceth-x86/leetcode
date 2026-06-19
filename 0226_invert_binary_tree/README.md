# 226. Invert Binary Tree

**Difficulty:** Easy

**Topics:** Tree, Depth-First Search, Breadth-First Search, Binary Tree

**Link:** https://leetcode.com/problems/invert-binary-tree/

## Problem

Given the root of a binary tree, invert the tree, and return its root.

Inverting a binary tree means swapping the left and right child of every node.

## Examples

### Example 1

```text
Input: root = [4, 2, 7, 1, 3, 6, 9]
Output: [4, 7, 2, 9, 6, 3, 1]
```

### Example 2

```text
Input: root = [2, 1, 3]
Output: [2, 3, 1]
```

### Example 3

```text
Input: root = []
Output: []
```

## Constraints

- The number of nodes in the tree is in the range `[0, 100]`.
- `-100 <= Node.val <= 100`

## Approach

### Recursive DFS Approach

**Intuition:** The inverse of a binary tree is local at every node: the left child and right child must be swapped. After swapping a node's children, the same rule applies independently to both subtrees.

This naturally fits depth-first recursion:

1. If the current node is `null`, return `null`.
2. Recursively invert the left subtree.
3. Recursively invert the right subtree.
4. Assign the inverted right subtree as the new left child.
5. Assign the inverted left subtree as the new right child.
6. Return the current node.

The swap can also happen before the recursive calls. Both forms are correct because every node's children are swapped exactly once.

### Iterative BFS Approach

**Intuition:** Inversion does not depend on traversal order. Every node needs the same local operation: swap its left and right child. Instead of relying on the call stack, we can keep a queue of nodes to process level by level.

This is breadth-first traversal:

1. If the root is `null`, return `null`.
2. Put the root in a queue.
3. While the queue is not empty:
   - Remove the next node.
   - Swap its left and right child.
   - Add each non-null child to the queue.
4. Return the original root.

## Step-by-Step Walkthrough

### Recursive DFS Walkthrough: `root = [4, 2, 7, 1, 3, 6, 9]`

Original tree:

```text
        4
      /   \
     2     7
    / \   / \
   1   3 6   9
```

Recursive inversion:

```text
invert(4)
  invert(2)
    invert(1) -> leaf, stays 1
    invert(3) -> leaf, stays 3
    swap children of 2: left=3, right=1

  invert(7)
    invert(6) -> leaf, stays 6
    invert(9) -> leaf, stays 9
    swap children of 7: left=9, right=6

  swap children of 4: left=7 subtree, right=2 subtree
```

Result level order: `[4, 7, 2, 9, 6, 3, 1]`

### Iterative BFS Walkthrough: `root = [4, 2, 7, 1, 3, 6, 9]`

```text
queue = [4]

Pop 4:
  swap children -> left=7, right=2
  queue = [7, 2]

Pop 7:
  swap children -> left=9, right=6
  queue = [2, 9, 6]

Pop 2:
  swap children -> left=3, right=1
  queue = [9, 6, 3, 1]

Pop 9:
  leaf, swap null children
  queue = [6, 3, 1]

Pop 6:
  leaf, swap null children
  queue = [3, 1]

Pop 3:
  leaf, swap null children
  queue = [1]

Pop 1:
  leaf, swap null children
  queue = []

Result level order: [4, 7, 2, 9, 6, 3, 1]
```

### Iterative BFS Walkthrough: `root = [2, 1, 3]`

```text
queue = [2]

Pop 2:
  swap children -> left=3, right=1
  queue = [3, 1]

Pop 3:
  leaf, queue = [1]

Pop 1:
  leaf, queue = []

Result: [2, 3, 1]
```

## Call Trace

### Recursive DFS Call Trace

For `invertTree([4, 2, 7, 1, 3, 6, 9])`:

```text
invertTree(4)
|
+-- left = invertTree(2)
|   |
|   +-- left = invertTree(1) -> return 1
|   +-- right = invertTree(3) -> return 3
|   +-- node 2 gets left=3, right=1
|   +-- return 2
|
+-- right = invertTree(7)
|   |
|   +-- left = invertTree(6) -> return 6
|   +-- right = invertTree(9) -> return 9
|   +-- node 7 gets left=9, right=6
|   +-- return 7
|
+-- node 4 gets left=7, right=2
+-- return 4
```

### Iterative BFS Call Trace

For `invertTree([4, 2, 7, 1, 3, 6, 9])`:

```text
invertTree(root=4)
|
+-- queue = [4]
|
+-- process 4
|   +-- swap left/right: 7, 2
|   +-- enqueue 7, 2
|
+-- process 7
|   +-- swap left/right: 9, 6
|   +-- enqueue 9, 6
|
+-- process 2
|   +-- swap left/right: 3, 1
|   +-- enqueue 3, 1
|
+-- process 9, 6, 3, 1
|   +-- leaves; each swap keeps null children null
|
+-- queue empty
+-- return root=4
```

## Complexity Analysis

### Recursive DFS Complexity

**Time Complexity:** O(n)

- Every node is visited once.
- Each visit performs O(1) work: two recursive calls and a swap.

**Space Complexity:** O(h)

- Recursion uses call stack proportional to tree height `h`.
- For a balanced tree, `h = O(log n)`.
- For a skewed tree, `h = O(n)`.

### Iterative BFS Complexity

**Time Complexity:** O(n)

- Every node is enqueued, dequeued, and swapped once.

**Space Complexity:** O(w)

- The queue stores at most one level of the tree plus pending nodes from the next level.
- `w` is the maximum width of the tree.
- In the worst case, `w = O(n)`.

## Comparison

| Approach | Time | Space | Pros | Cons |
|----------|------|-------|------|------|
| Recursive DFS | O(n) | O(h) | Shortest implementation; mirrors tree definition | Uses call stack; skewed tree can reach O(n) stack depth |
| Iterative BFS | O(n) | O(w) | Avoids recursion; explicit traversal order | Needs an explicit queue |

Both approaches are correct because inversion is a per-node operation independent of traversal order.

## Edge Cases

| Case | Input | Output | Why |
|------|-------|--------|-----|
| Empty tree | `[]` | `[]` | Base case returns `null` |
| Single node | `[1]` | `[1]` | No children to swap |
| Full tree | `[4,2,7,1,3,6,9]` | `[4,7,2,9,6,3,1]` | Every pair of children is swapped |
| Only left child | `[1,2]` | `[1,null,2]` | Left child moves to the right |
| Only right child | `[1,null,2]` | `[1,2]` | Right child moves to the left |
| Negative values | `[-1,-2,3]` | `[-1,3,-2]` | Values are irrelevant; only links change |
