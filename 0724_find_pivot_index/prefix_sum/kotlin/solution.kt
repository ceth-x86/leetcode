class Solution {
    fun pivotIndex(nums: IntArray): Int {
        val totalSum = nums.sum()
        var leftSum = 0
        
        for (i in nums.indices) {
            if (leftSum == totalSum - leftSum - nums[i]) {
                return i
            }
            leftSum += nums[i]
        }
        
        return -1
    }
}
