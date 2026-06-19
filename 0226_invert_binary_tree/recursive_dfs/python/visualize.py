from solution import TreeNode, invert_tree


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


def trace_invert(root: TreeNode | None, depth: int = 0) -> TreeNode | None:
    indent = "  " * depth
    if root is None:
        print(f"{indent}invert(None) -> None")
        return None

    print(f"{indent}visit {root.val}")
    left = trace_invert(root.left, depth + 1)
    right = trace_invert(root.right, depth + 1)
    root.left = right
    root.right = left
    print(f"{indent}swap at {root.val}: left={root.left.val if root.left else None}, right={root.right.val if root.right else None}")
    return root


if __name__ == "__main__":
    tree = build_tree([4, 2, 7, 1, 3, 6, 9])
    print(f"before: {serialize(tree)}")
    trace_invert(tree)
    print(f"after:  {serialize(tree)}")
