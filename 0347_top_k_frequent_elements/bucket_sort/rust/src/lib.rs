use std::collections::HashMap;

pub struct Solution;

impl Solution {
    pub fn top_k_frequent(nums: Vec<i32>, k: i32) -> Vec<i32> {
        let mut counts = HashMap::new();
        for num in &nums {
            *counts.entry(*num).or_insert(0) += 1;
        }
        
        let mut buckets: Vec<Vec<i32>> = vec![vec![]; nums.len() + 1];
        for (num, freq) in counts {
            buckets[freq as usize].push(num);
        }
        
        let mut result = Vec::new();
        for i in (1..=nums.len()).rev() {
            for num in &buckets[i] {
                result.push(*num);
                if result.len() == k as usize {
                    return result;
                }
            }
        }
        result
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_top_k_frequent() {
        let mut res1 = Solution::top_k_frequent(vec![1, 1, 1, 2, 2, 3], 2);
        res1.sort();
        assert_eq!(res1, vec![1, 2]);
        
        let res2 = Solution::top_k_frequent(vec![1], 1);
        assert_eq!(res2, vec![1]);
    }
}
