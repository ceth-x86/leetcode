use std::collections::HashSet;

const WINDOW_SIZE: usize = 10;

fn encode(ch: u8) -> u32 {
    match ch {
        b'A' => 0,
        b'C' => 1,
        b'G' => 2,
        _ => 3,
    }
}

pub fn find_repeated_dna_sequences(s: &str) -> Vec<String> {
    let n = s.len();
    if n <= WINDOW_SIZE {
        return Vec::new();
    }

    let nums: Vec<u32> = s.bytes().map(encode).collect();
    let mut bitmask = 0u32;
    let mut seen = HashSet::new();
    let mut output = HashSet::new();

    for start in 0..=n - WINDOW_SIZE {
        if start == 0 {
            for &value in nums.iter().take(WINDOW_SIZE) {
                bitmask = (bitmask << 2) | value;
            }
        } else {
            bitmask <<= 2;
            bitmask |= nums[start + WINDOW_SIZE - 1];
            bitmask &= !(3 << (2 * WINDOW_SIZE));
        }

        if seen.contains(&bitmask) {
            output.insert(s[start..start + WINDOW_SIZE].to_string());
        } else {
            seen.insert(bitmask);
        }
    }

    output.into_iter().collect()
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
