pub struct Solution;

impl Solution {
    pub fn longest_common_prefix(mut strs: Vec<String>) -> String {
        if strs.is_empty() {
            return String::new();
        }

        strs.sort();

        let first = &strs[0];
        let last = &strs[strs.len() - 1];

        let mut i = 0;
        let first_chars: Vec<char> = first.chars().collect();
        let last_chars: Vec<char> = last.chars().collect();

        while i < first_chars.len() && i < last_chars.len() && first_chars[i] == last_chars[i] {
            i += 1;
        }

        first_chars[..i].iter().collect()
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
