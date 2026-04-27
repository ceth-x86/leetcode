use std::collections::VecDeque;

pub fn max_sliding_window(nums: &[i32], k: usize) -> Vec<i32> {
    let mut deque: VecDeque<usize> = VecDeque::new();
    let mut result = Vec::with_capacity(nums.len() - k + 1);

    for (i, &value) in nums.iter().enumerate() {
        while let Some(&front) = deque.front() {
            if front + k <= i {
                deque.pop_front();
            } else {
                break;
            }
        }

        while let Some(&back) = deque.back() {
            if nums[back] <= value {
                deque.pop_back();
            } else {
                break;
            }
        }

        deque.push_back(i);

        if i + 1 >= k {
            result.push(nums[*deque.front().unwrap()]);
        }
    }

    result
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn example_one() {
        assert_eq!(
            max_sliding_window(&[1, 3, -1, -3, 5, 3, 6, 7], 3),
            vec![3, 3, 5, 5, 6, 7]
        );
    }

    #[test]
    fn example_two() {
        assert_eq!(max_sliding_window(&[1], 1), vec![1]);
    }

    #[test]
    fn full_array_window() {
        assert_eq!(max_sliding_window(&[2, 1, 3], 3), vec![3]);
    }

    #[test]
    fn increasing_values() {
        assert_eq!(max_sliding_window(&[1, 2, 3, 4], 2), vec![2, 3, 4]);
    }

    #[test]
    fn duplicates() {
        assert_eq!(max_sliding_window(&[1, 3, 3, 2], 2), vec![3, 3, 3]);
    }

    #[test]
    fn negative_values() {
        assert_eq!(max_sliding_window(&[-4, -2, -5, -1], 2), vec![-2, -2, -1]);
    }
}
