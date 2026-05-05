pub struct Solution;

impl Solution {
    pub fn longest_common_prefix(strs: Vec<String>) -> String {
        if strs.is_empty() {
            return String::new();
        }

        let first_str = &strs[0];
        for (i, c) in first_str.chars().enumerate() {
            for s in strs.iter().skip(1) {
                if i == s.len() || s.chars().nth(i) != Some(c) {
                    return first_str[..i].to_string();
                }
            }
        }

        first_str.to_string()
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
        assert_eq!(
            Solution::longest_common_prefix(vec![
                "dog".to_string(),
                "racecar".to_string(),
                "car".to_string()
            ]),
            ""
        );
        assert_eq!(
            Solution::longest_common_prefix(vec!["ab".to_string(), "a".to_string()]),
            "a"
        );
        assert_eq!(
            Solution::longest_common_prefix(vec!["".to_string()]),
            ""
        );
        assert_eq!(
            Solution::longest_common_prefix(vec!["a".to_string()]),
            "a"
        );
    }
}
