from __future__ import annotations

from collections import deque
from dataclasses import dataclass


@dataclass
class TreeNode:
    val: int
    left: TreeNode | None = None
    right: TreeNode | None = None


def invert_tree(root: TreeNode | None) -> TreeNode | None:
    if root is None:
        return None

    queue: deque[TreeNode] = deque([root])
    while queue:
        node = queue.popleft()
        node.left, node.right = node.right, node.left

        if node.left is not None:
            queue.append(node.left)
        if node.right is not None:
            queue.append(node.right)

    return root
