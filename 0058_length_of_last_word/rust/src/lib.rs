pub fn length_of_last_word(s: &str) -> usize {
    s.trim_end()
        .bytes()
        .rev()
        .take_while(|&b| b != b' ')
        .count()
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn example_1() {
        assert_eq!(length_of_last_word("Hello World"), 5);
    }

    #[test]
    fn example_2_trailing_spaces() {
        assert_eq!(length_of_last_word("   fly me   to   the moon  "), 4);
    }

    #[test]
    fn example_3() {
        assert_eq!(length_of_last_word("luffy is still joyboy"), 6);
    }

    #[test]
    fn single_word() {
        assert_eq!(length_of_last_word("Hello"), 5);
    }

    #[test]
    fn single_word_with_spaces() {
        assert_eq!(length_of_last_word("   Hello   "), 5);
    }

    #[test]
    fn single_char() {
        assert_eq!(length_of_last_word("a"), 1);
    }

    #[test]
    fn all_same_chars() {
        assert_eq!(length_of_last_word("aaaa"), 4);
    }

    #[test]
    fn many_spaces_between() {
        assert_eq!(length_of_last_word("a   b"), 1);
    }

    #[test]
    fn sentence() {
        assert_eq!(length_of_last_word("Today is a nice day"), 3);
    }
}
