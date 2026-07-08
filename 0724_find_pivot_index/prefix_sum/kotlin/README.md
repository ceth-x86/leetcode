# Kotlin Solution: Prefix Sum

This implements the prefix sum approach to find the pivot index.

## Implementation Details

The solution calculates the total sum of the array first using `nums.sum()`. Then it iterates through the array keeping track of `leftSum`. For any index `i`, the `rightSum` can be computed as `totalSum - leftSum - nums[i]`. If `leftSum` equals `rightSum`, we have found the pivot index.

Time Complexity: O(N) where N is the length of `nums`
Space Complexity: O(1)

## Running Tests

```bash
kotlinc solution.kt solution_test.kt -include-runtime -d solution.jar && java -jar solution.jar
```
