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


def test_examples() -> None:
    assert serialize(invert_tree(build_tree([4, 2, 7, 1, 3, 6, 9]))) == [4, 7, 2, 9, 6, 3, 1]
    assert serialize(invert_tree(build_tree([2, 1, 3]))) == [2, 3, 1]
    assert serialize(invert_tree(build_tree([]))) == []


def test_edge_cases() -> None:
    assert serialize(invert_tree(build_tree([1]))) == [1]
    assert serialize(invert_tree(build_tree([1, 2]))) == [1, None, 2]
    assert serialize(invert_tree(build_tree([1, None, 2]))) == [1, 2]
    assert serialize(invert_tree(build_tree([-1, -2, 3]))) == [-1, 3, -2]
