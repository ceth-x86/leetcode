use std::collections::HashMap;

pub fn two_sum(nums: &[i32], target: i32) -> Vec<i32> {
    let mut seen = HashMap::with_capacity(nums.len());
    for (i, &num) in nums.iter().enumerate() {
        let complement = target - num;
        if let Some(&j) = seen.get(&complement) {
            return vec![j as i32, i as i32];
        }
        seen.insert(num, i);
    }
    vec![]
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn pair_at_start() {
        assert_eq!(two_sum(&[2, 7, 11, 15], 9), vec![0, 1]);
    }

    #[test]
    fn pair_in_middle() {
        assert_eq!(two_sum(&[3, 2, 4], 6), vec![1, 2]);
    }

    #[test]
    fn same_elements() {
        assert_eq!(two_sum(&[3, 3], 6), vec![0, 1]);
    }

    #[test]
    fn pair_at_end() {
        assert_eq!(two_sum(&[1, 2, 3, 4], 7), vec![2, 3]);
    }

    #[test]
    fn negative_numbers() {
        assert_eq!(two_sum(&[-1, -2, -3, -4, -5], -8), vec![2, 4]);
    }

    #[test]
    fn zeros() {
        assert_eq!(two_sum(&[0, 4, 3, 0], 0), vec![0, 3]);
    }

    #[test]
    fn extreme_values() {
        assert_eq!(two_sum(&[-1_000_000_000, 1_000_000_000], 0), vec![0, 1]);
    }

    #[test]
    fn duplicate_values() {
        assert_eq!(two_sum(&[1, 5, 5, 11], 10), vec![1, 2]);
    }
}
