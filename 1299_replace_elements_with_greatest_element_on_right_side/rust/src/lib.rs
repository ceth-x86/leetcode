pub fn replace_elements(arr: &mut Vec<i32>) -> Vec<i32> {
    let mut right_max = -1;
    for i in (0..arr.len()).rev() {
        let original = arr[i];
        arr[i] = right_max;
        right_max = right_max.max(original);
    }
    arr.clone()
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn example_1() {
        assert_eq!(replace_elements(&mut vec![17, 18, 5, 4, 6, 1]), vec![18, 6, 6, 6, 1, -1]);
    }

    #[test]
    fn single_element() {
        assert_eq!(replace_elements(&mut vec![400]), vec![-1]);
    }

    #[test]
    fn two_elements_ascending() {
        assert_eq!(replace_elements(&mut vec![1, 5]), vec![5, -1]);
    }

    #[test]
    fn descending() {
        assert_eq!(replace_elements(&mut vec![5, 4, 3, 2, 1]), vec![4, 3, 2, 1, -1]);
    }

    #[test]
    fn ascending() {
        assert_eq!(replace_elements(&mut vec![1, 2, 3, 4, 5]), vec![5, 5, 5, 5, -1]);
    }

    #[test]
    fn all_same() {
        assert_eq!(replace_elements(&mut vec![7, 7, 7]), vec![7, 7, -1]);
    }

    #[test]
    fn two_elements_descending() {
        assert_eq!(replace_elements(&mut vec![5, 1]), vec![1, -1]);
    }

    #[test]
    fn large_value() {
        assert_eq!(replace_elements(&mut vec![1, 100_000]), vec![100_000, -1]);
    }
}
