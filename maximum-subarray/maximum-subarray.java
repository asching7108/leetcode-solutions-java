class Solution {
    public int maxSubArray(int[] nums) {
        int currentSubArray = nums[0];
        int maxSubArray = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currentSubArray = Math.max(nums[i], currentSubArray + nums[i]);
            maxSubArray = Math.max(maxSubArray, currentSubArray);
        }
        return maxSubArray;
    }
}