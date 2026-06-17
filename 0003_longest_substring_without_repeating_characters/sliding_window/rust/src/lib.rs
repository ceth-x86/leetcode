use std::collections::HashMap;

pub fn length_of_longest_substring(s: &str) -> usize {
    let chars: Vec<char> = s.chars().collect();
    let mut last_seen: HashMap<char, usize> = HashMap::new();
    let mut left = 0;
    let mut best = 0;

    for (right, &ch) in chars.iter().enumerate() {
        if let Some(&previous) = last_seen.get(&ch) {
            if previous >= left {
                left = previous + 1;
            }
        }
        last_seen.insert(ch, right);
        best = best.max(right - left + 1);
    }

    best
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn examples() {
        assert_eq!(length_of_longest_substring("abcabcbb"), 3);
        assert_eq!(length_of_longest_substring("bbbbb"), 1);
        assert_eq!(length_of_longest_substring("pwwkew"), 3);
    }

    #[test]
    fn edge_cases() {
        assert_eq!(length_of_longest_substring(""), 0);
        assert_eq!(length_of_longest_substring("a"), 1);
        assert_eq!(length_of_longest_substring("abcdef"), 6);
        assert_eq!(length_of_longest_substring("abba"), 2);
        assert_eq!(length_of_longest_substring("dvdf"), 3);
        assert_eq!(length_of_longest_substring("aab"), 2);
        assert_eq!(length_of_longest_substring("tmmzuxt"), 5);
        assert_eq!(length_of_longest_substring("a! b@a"), 5);
    }
}
