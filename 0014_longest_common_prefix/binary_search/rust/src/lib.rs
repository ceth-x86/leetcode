pub struct Solution;

impl Solution {
    pub fn longest_common_prefix(strs: Vec<String>) -> String {
        if strs.is_empty() {
            return String::new();
        }

        let min_len = strs.iter().map(|s| s.len()).min().unwrap_or(0);
        let mut low = 1;
        let mut high = min_len;
        let mut ans = 0;

        while low <= high {
            let mid = (low + high) / 2;
            if Self::is_common_prefix(&strs, mid) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        strs[0][..ans].to_string()
    }

    fn is_common_prefix(strs: &Vec<String>, len: usize) -> bool {
        let prefix = &strs[0][..len];
        for s in strs.iter().skip(1) {
            if !s.starts_with(prefix) {
                return false;
            }
        }
        true
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
