from __future__ import annotations

from dataclasses import dataclass


@dataclass
class TreeNode:
    val: int
    left: TreeNode | None = None
    right: TreeNode | None = None


def invert_tree(root: TreeNode | None) -> TreeNode | None:
    if root is None:
        return None

    left = invert_tree(root.left)
    right = invert_tree(root.right)
    root.left = right
    root.right = left
    return root
