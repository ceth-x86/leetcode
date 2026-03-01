pub fn is_subsequence(s: &str, t: &str) -> bool {
    let mut s_iter = s.chars();
    let mut current = s_iter.next();
    for ch in t.chars() {
        if current == Some(ch) {
            current = s_iter.next();
        }
    }
    current.is_none()
}

pub struct SubsequenceChecker {
    index_map: [Vec<usize>; 26],
}

impl SubsequenceChecker {
    pub fn new(t: &str) -> Self {
        let mut index_map: [Vec<usize>; 26] = Default::default();
        for (i, ch) in t.chars().enumerate() {
            index_map[(ch as u8 - b'a') as usize].push(i);
        }
        SubsequenceChecker { index_map }
    }

    pub fn is_subsequence(&self, s: &str) -> bool {
        let mut pos = 0;
        for ch in s.chars() {
            let indices = &self.index_map[(ch as u8 - b'a') as usize];
            match indices.partition_point(|&x| x < pos) {
                idx if idx == indices.len() => return false,
                idx => pos = indices[idx] + 1,
            }
        }
        true
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn example_1() {
        assert!(is_subsequence("abc", "ahbgdc"));
    }

    #[test]
    fn example_2() {
        assert!(!is_subsequence("axc", "ahbgdc"));
    }

    #[test]
    fn empty_s() {
        assert!(is_subsequence("", "ahbgdc"));
    }

    #[test]
    fn both_empty() {
        assert!(is_subsequence("", ""));
    }

    #[test]
    fn s_longer_than_t() {
        assert!(!is_subsequence("abc", "ab"));
    }

    #[test]
    fn s_equals_t() {
        assert!(is_subsequence("abc", "abc"));
    }

    #[test]
    fn single_char_match() {
        assert!(is_subsequence("a", "a"));
    }

    #[test]
    fn single_char_no_match() {
        assert!(!is_subsequence("a", "b"));
    }

    #[test]
    fn match_at_end() {
        assert!(is_subsequence("c", "abc"));
    }

    #[test]
    fn empty_t_non_empty_s() {
        assert!(!is_subsequence("a", ""));
    }

    // Follow-up tests
    #[test]
    fn followup_example_1() {
        let checker = SubsequenceChecker::new("ahbgdc");
        assert!(checker.is_subsequence("abc"));
    }

    #[test]
    fn followup_example_2() {
        let checker = SubsequenceChecker::new("ahbgdc");
        assert!(!checker.is_subsequence("axc"));
    }

    #[test]
    fn followup_empty_s() {
        let checker = SubsequenceChecker::new("ahbgdc");
        assert!(checker.is_subsequence(""));
    }

    #[test]
    fn followup_s_equals_t() {
        let checker = SubsequenceChecker::new("ahbgdc");
        assert!(checker.is_subsequence("ahbgdc"));
    }

    #[test]
    fn followup_repeated_char_not_enough() {
        let checker = SubsequenceChecker::new("ahbgdc");
        assert!(!checker.is_subsequence("aaa"));
    }

    #[test]
    fn followup_empty_t() {
        let checker = SubsequenceChecker::new("");
        assert!(checker.is_subsequence(""));
        assert!(!checker.is_subsequence("a"));
    }

    #[test]
    fn followup_repeated_chars_in_t() {
        let checker = SubsequenceChecker::new("aabbc");
        assert!(checker.is_subsequence("abc"));
        assert!(checker.is_subsequence("aab"));
        assert!(checker.is_subsequence("aabbc"));
        assert!(!checker.is_subsequence("aabbcc"));
    }

    #[test]
    fn followup_many_queries() {
        let checker = SubsequenceChecker::new("abcdefghijklmnopqrstuvwxyz");
        assert!(checker.is_subsequence("ace"));
        assert!(checker.is_subsequence("az"));
        assert!(!checker.is_subsequence("za"));
        assert!(checker.is_subsequence("xyz"));
    }
}
