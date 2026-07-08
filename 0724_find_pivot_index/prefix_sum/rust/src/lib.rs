pub struct Solution;

impl Solution {
    pub fn pivot_index(nums: Vec<i32>) -> i32 {
        let total_sum: i32 = nums.iter().sum();
        let mut left_sum = 0;
        
        for (i, &num) in nums.iter().enumerate() {
            if left_sum == total_sum - left_sum - num {
                return i as i32;
            }
            left_sum += num;
        }
        
        -1
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_pivot_index() {
        assert_eq!(Solution::pivot_index(vec![1, 7, 3, 6, 5, 6]), 3);
        assert_eq!(Solution::pivot_index(vec![1, 2, 3]), -1);
        assert_eq!(Solution::pivot_index(vec![2, 1, -1]), 0);
        assert_eq!(Solution::pivot_index(vec![0]), 0);
    }
}
