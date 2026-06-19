use std::cell::RefCell;
use std::collections::VecDeque;
use std::rc::Rc;

pub type Node = Option<Rc<RefCell<TreeNode>>>;

#[derive(Debug, PartialEq, Eq)]
pub struct TreeNode {
    pub val: i32,
    pub left: Node,
    pub right: Node,
}

impl TreeNode {
    pub fn new(val: i32) -> Self {
        Self {
            val,
            left: None,
            right: None,
        }
    }
}

pub fn invert_tree(root: Node) -> Node {
    let Some(root_node) = root.clone() else {
        return None;
    };

    let mut queue = VecDeque::from([root_node]);
    while let Some(node) = queue.pop_front() {
        let mut node_ref = node.borrow_mut();
        let left = node_ref.left.take();
        let right = node_ref.right.take();
        node_ref.left = right;
        node_ref.right = left;

        if let Some(left_node) = node_ref.left.clone() {
            queue.push_back(left_node);
        }
        if let Some(right_node) = node_ref.right.clone() {
            queue.push_back(right_node);
        }
    }

    root
}

pub fn build_tree(values: &[Option<i32>]) -> Node {
    if values.is_empty() || values[0].is_none() {
        return None;
    }

    let nodes: Vec<Node> = values
        .iter()
        .map(|value| value.map(|v| Rc::new(RefCell::new(TreeNode::new(v)))))
        .collect();

    let mut child = 1;
    for node in nodes.iter().flatten() {
        if child < nodes.len() {
            node.borrow_mut().left = nodes[child].clone();
            child += 1;
        }
        if child < nodes.len() {
            node.borrow_mut().right = nodes[child].clone();
            child += 1;
        }
    }

    nodes[0].clone()
}

pub fn serialize(root: &Node) -> Vec<Option<i32>> {
    let Some(root_node) = root else {
        return vec![];
    };

    let mut result = Vec::new();
    let mut queue = VecDeque::from([Some(root_node.clone())]);

    while let Some(node) = queue.pop_front() {
        if let Some(node) = node {
            let node_ref = node.borrow();
            result.push(Some(node_ref.val));
            queue.push_back(node_ref.left.clone());
            queue.push_back(node_ref.right.clone());
        } else {
            result.push(None);
        }
    }

    while result.last() == Some(&None) {
        result.pop();
    }
    result
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn examples() {
        let root = build_tree(&[
            Some(4),
            Some(2),
            Some(7),
            Some(1),
            Some(3),
            Some(6),
            Some(9),
        ]);
        assert_eq!(
            serialize(&invert_tree(root)),
            vec![
                Some(4),
                Some(7),
                Some(2),
                Some(9),
                Some(6),
                Some(3),
                Some(1)
            ]
        );

        let root = build_tree(&[Some(2), Some(1), Some(3)]);
        assert_eq!(
            serialize(&invert_tree(root)),
            vec![Some(2), Some(3), Some(1)]
        );

        let root = build_tree(&[]);
        assert_eq!(serialize(&invert_tree(root)), Vec::<Option<i32>>::new());
    }

    #[test]
    fn edge_cases() {
        let root = build_tree(&[Some(1)]);
        assert_eq!(serialize(&invert_tree(root)), vec![Some(1)]);

        let root = build_tree(&[Some(1), Some(2)]);
        assert_eq!(serialize(&invert_tree(root)), vec![Some(1), None, Some(2)]);

        let root = build_tree(&[Some(1), None, Some(2)]);
        assert_eq!(serialize(&invert_tree(root)), vec![Some(1), Some(2)]);

        let root = build_tree(&[Some(-1), Some(-2), Some(3)]);
        assert_eq!(
            serialize(&invert_tree(root)),
            vec![Some(-1), Some(3), Some(-2)]
        );
    }
}
