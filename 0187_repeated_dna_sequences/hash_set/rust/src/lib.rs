use std::collections::HashSet;

const WINDOW_SIZE: usize = 10;

pub fn find_repeated_dna_sequences(s: &str) -> Vec<String> {
    if s.len() < WINDOW_SIZE {
        return Vec::new();
    }

    let mut seen = HashSet::new();
    let mut repeated = HashSet::new();
    let mut result = Vec::new();

    for start in 0..=s.len() - WINDOW_SIZE {
        let fragment = &s[start..start + WINDOW_SIZE];
        if seen.contains(fragment) {
            if repeated.insert(fragment.to_string()) {
                result.push(fragment.to_string());
            }
        } else {
            seen.insert(fragment.to_string());
        }
    }

    result
}

#[cfg(test)]
mod tests {
    use super::*;

    fn assert_same_contents(mut actual: Vec<String>, mut expected: Vec<String>) {
        actual.sort();
        expected.sort();
        assert_eq!(actual, expected);
    }

    #[test]
    fn example_one() {
        assert_same_contents(
            find_repeated_dna_sequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"),
            vec!["AAAAACCCCC".into(), "CCCCCAAAAA".into()],
        );
    }

    #[test]
    fn example_two() {
        assert_same_contents(
            find_repeated_dna_sequences("AAAAAAAAAAAAA"),
            vec!["AAAAAAAAAA".into()],
        );
    }

    #[test]
    fn too_short() {
        assert_same_contents(find_repeated_dna_sequences("ACGT"), vec![]);
    }

    #[test]
    fn exactly_ten() {
        assert_same_contents(find_repeated_dna_sequences("ACGTACGTAC"), vec![]);
    }

    #[test]
    fn same_fragment_reported_once() {
        assert_same_contents(
            find_repeated_dna_sequences("AAAAAAAAAAAA"),
            vec!["AAAAAAAAAA".into()],
        );
    }
}
