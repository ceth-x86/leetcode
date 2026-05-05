use std::collections::HashMap;

struct TrieNode {
    children: HashMap<char, TrieNode>,
    is_end: bool,
    child_count: usize,
}

impl TrieNode {
    fn new() -> Self {
        TrieNode {
            children: HashMap::new(),
            is_end: false,
            child_count: 0,
        }
    }
}

pub struct Solution;

impl Solution {
    pub fn longest_common_prefix(strs: Vec<String>) -> String {
        if strs.is_empty() {
            return String::new();
        }
        if strs.len() == 1 {
            return strs[0].clone();
        }

        let mut root = TrieNode::new();
        for s in strs {
            if s.is_empty() {
                return String::new();
            }
            let mut node = &mut root;
            for c in s.chars() {
                node = node.children.entry(c).or_insert_with(|| {
                    node.child_count += 1;
                    TrieNode::new()
                });
            }
            node.is_end = true;
        }

        let mut prefix = String::new();
        let mut node = &root;
        while node.child_count == 1 && !node.is_end {
            let (&c, next_node) = node.children.iter().next().unwrap();
            prefix.push(c);
            node = next_node;
        }
        prefix
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_longest_common_prefix() {
        assert_eq!(
            Solution::longest_common_prefix(vec![
                "flower".to_string(),
                "flow".to_string(),
                "flight".to_string()
            ]),
            "fl"
        );
    }
}
