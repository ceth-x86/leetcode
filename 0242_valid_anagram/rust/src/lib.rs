pub fn is_anagram(s: &str, t: &str) -> bool {
    if s.len() != t.len() {
        return false;
    }

    let mut count = [0i32; 26];
    for (a, b) in s.bytes().zip(t.bytes()) {
        count[(a - b'a') as usize] += 1;
        count[(b - b'a') as usize] -= 1;
    }

    count.iter().all(|&c| c == 0)
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn anagram_match() {
        assert!(is_anagram("anagram", "nagaram"));
    }

    #[test]
    fn no_match() {
        assert!(!is_anagram("rat", "car"));
    }

    #[test]
    fn single_char_equal() {
        assert!(is_anagram("a", "a"));
    }

    #[test]
    fn single_char_differ() {
        assert!(!is_anagram("a", "b"));
    }

    #[test]
    fn different_lengths() {
        assert!(!is_anagram("ab", "abc"));
    }

    #[test]
    fn same_string() {
        assert!(is_anagram("abc", "abc"));
    }

    #[test]
    fn all_same_char() {
        assert!(is_anagram("aaa", "aaa"));
    }

    #[test]
    fn count_mismatch() {
        assert!(!is_anagram("aacc", "ccac"));
    }
}
