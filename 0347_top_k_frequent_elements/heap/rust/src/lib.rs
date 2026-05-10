use std::collections::{BinaryHeap, HashMap};
use std::cmp::Ordering;

#[derive(Eq, PartialEq)]
struct Item {
    value: i32,
    frequency: i32,
}

impl Ord for Item {
    fn cmp(&self, other: &Self) -> Ordering {
        // Reverse for min-heap
        other.frequency.cmp(&self.frequency)
    }
}

impl PartialOrd for Item {
    fn partial_cmp(&self, other: &Self) -> Option<Ordering> {
        Some(self.cmp(other))
    }
}

pub struct Solution;

impl Solution {
    pub fn top_k_frequent(nums: Vec<i32>, k: i32) -> Vec<i32> {
        let mut counts = HashMap::new();
        for num in nums {
            *counts.entry(num).or_insert(0) += 1;
        }
        
        let mut min_heap = BinaryHeap::new();
        for (num, freq) in counts {
            min_heap.push(Item { value: num, frequency: freq });
            if min_heap.len() > k as usize {
                min_heap.pop();
            }
        }
        
        min_heap.into_iter().map(|item| item.value).collect()
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_top_k_frequent() {
        let mut res = Solution::top_k_frequent(vec![1, 1, 1, 2, 2, 3], 2);
        res.sort();
        assert_eq!(res, vec![1, 2]);
    }
}
