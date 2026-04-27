pub fn first_stable_index(nums: &[i32], k: i32) -> i32 {
    let n = nums.len();
    let mut suffix_min = vec![0; n];

    suffix_min[n - 1] = nums[n - 1];
    for i in (0..n - 1).rev() {
        suffix_min[i] = suffix_min[i + 1].min(nums[i]);
    }

    let mut prefix_max = nums[0];
    for i in 0..n {
        prefix_max = prefix_max.max(nums[i]);
        if prefix_max - suffix_min[i] <= k {
            return i as i32;
        }
    }

    -1
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn example_one() {
        assert_eq!(first_stable_index(&[5, 0, 1, 4], 3), 3);
    }

    #[test]
    fn all_equal() {
        assert_eq!(first_stable_index(&[4, 4, 4], 0), 0);
    }

    #[test]
    fn single_element() {
        assert_eq!(first_stable_index(&[9], 0), 0);
    }

    #[test]
    fn first_index_stable() {
        assert_eq!(first_stable_index(&[2, 5, 7], 0), 0);
    }

    #[test]
    fn no_stable_index() {
        assert_eq!(first_stable_index(&[10, 0], 5), -1);
    }

    #[test]
    fn strict_threshold_miss() {
        assert_eq!(first_stable_index(&[3, 1, 2], 0), -1);
    }

    #[test]
    fn middle_index_stable() {
        assert_eq!(first_stable_index(&[8, 2, 6, 7], 2), 2);
    }

    #[test]
    fn stable_at_zero() {
        assert_eq!(first_stable_index(&[1, 3, 2, 5], 1), 0);
    }
}
