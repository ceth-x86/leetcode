from collections import deque

from solution import TreeNode


def build_tree(values: list[int | None]) -> TreeNode | None:
    if not values:
        return None

    nodes = [None if value is None else TreeNode(value) for value in values]
    child = 1
    for node in nodes:
        if node is None:
            continue
        if child < len(nodes):
            node.left = nodes[child]
            child += 1
        if child < len(nodes):
            node.right = nodes[child]
            child += 1
    return nodes[0]


def serialize(root: TreeNode | None) -> list[int | None]:
    if root is None:
        return []

    result: list[int | None] = []
    queue: list[TreeNode | None] = [root]
    while queue:
        node = queue.pop(0)
        if node is None:
            result.append(None)
            continue
        result.append(node.val)
        queue.append(node.left)
        queue.append(node.right)

    while result and result[-1] is None:
        result.pop()
    return result


def trace_invert(root: TreeNode | None) -> TreeNode | None:
    if root is None:
        print("empty tree")
        return None

    queue: deque[TreeNode] = deque([root])
    step = 1
    while queue:
        node = queue.popleft()
        before = (node.left.val if node.left else None, node.right.val if node.right else None)
        node.left, node.right = node.right, node.left
        after = (node.left.val if node.left else None, node.right.val if node.right else None)
        print(f"step {step}: visit {node.val}, children {before} -> {after}")
        step += 1

        if node.left:
            queue.append(node.left)
        if node.right:
            queue.append(node.right)

    return root


if __name__ == "__main__":
    tree = build_tree([4, 2, 7, 1, 3, 6, 9])
    print(f"before: {serialize(tree)}")
    trace_invert(tree)
    print(f"after:  {serialize(tree)}")
