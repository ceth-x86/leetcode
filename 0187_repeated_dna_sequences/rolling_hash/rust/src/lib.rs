const WINDOW_SIZE: usize = 10;
const WINDOW_MASK: u32 = (1 << (WINDOW_SIZE * 2)) - 1;

fn encode(ch: u8) -> u32 {
    match ch {
        b'A' => 0,
        b'C' => 1,
        b'G' => 2,
        _ => 3,
    }
}

pub fn find_repeated_dna_sequences(s: &str) -> Vec<String> {
    if s.len() < WINDOW_SIZE {
        return Vec::new();
    }

    let mut rolling = 0u32;
    let mut seen = std::collections::HashSet::new();
    let mut repeated = std::collections::HashSet::new();
    let mut result = Vec::new();

    for (index, ch) in s.bytes().enumerate() {
        rolling = ((rolling << 2) | encode(ch)) & WINDOW_MASK;
        if index < WINDOW_SIZE - 1 {
            continue;
        }

        let start = index + 1 - WINDOW_SIZE;
        if seen.contains(&rolling) {
            if repeated.insert(rolling) {
                result.push(s[start..start + WINDOW_SIZE].to_string());
            }
        } else {
            seen.insert(rolling);
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
