use std::collections::HashMap;

pub struct Solution;

impl Solution {
    pub fn group_anagrams(strs: Vec<String>) -> Vec<Vec<String>> {
        // In Rust, arrays are hashable and can be used as map keys
        let mut groups: HashMap<[i32; 26], Vec<String>> = HashMap::new();
        
        for s in strs {
            let mut count = [0i32; 26];
            for c in s.chars() {
                count[(c as usize) - ('a' as usize)] += 1;
            }
            groups.entry(count).or_insert_with(Vec::new).push(s);
        }
        
        groups.into_values().collect()
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_group_anagrams() {
        let input = vec![
            "eat".to_string(),
            "tea".to_string(),
            "tan".to_string(),
            "ate".to_string(),
            "nat".to_string(),
            "bat".to_string(),
        ];
        let result = Solution::group_anagrams(input);
        assert_eq!(result.len(), 3);
    }
}
