# Go Solution: Prefix Sum

This implements the prefix sum approach to find the pivot index.

## Implementation Details

The solution calculates the total sum of the array first. Then it iterates through the array keeping track of the `leftSum`. For any index `i`, the right sum can be computed as `totalSum - leftSum - nums[i]`. If `leftSum` equals the right sum, we have found the pivot index.

Time Complexity: O(N) where N is the length of `nums`
Space Complexity: O(1)

## Running Tests

```bash
go test -v
```
