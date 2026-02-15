use std::collections::HashSet;

pub fn contains_duplicate(nums: &[i32]) -> bool {
    let mut seen = HashSet::with_capacity(nums.len());
    nums.iter().any(|num| !seen.insert(num))
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn has_duplicate() {
        assert!(contains_duplicate(&[1, 2, 3, 1]));
    }

    #[test]
    fn all_distinct() {
        assert!(!contains_duplicate(&[1, 2, 3, 4]));
    }

    #[test]
    fn multiple_dupes() {
        assert!(contains_duplicate(&[1, 1, 1, 3, 3, 4, 3, 2, 4, 2]));
    }

    #[test]
    fn single_element() {
        assert!(!contains_duplicate(&[1]));
    }

    #[test]
    fn two_same() {
        assert!(contains_duplicate(&[1, 1]));
    }

    #[test]
    fn two_different() {
        assert!(!contains_duplicate(&[1, 2]));
    }

    #[test]
    fn all_same() {
        assert!(contains_duplicate(&[5, 5, 5, 5]));
    }

    #[test]
    fn extreme_values() {
        assert!(!contains_duplicate(&[-1_000_000_000, 1_000_000_000]));
    }
}
