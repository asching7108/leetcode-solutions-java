class Solution {
    public int splitArray(int[] nums, int m) {
        int n = nums.length;
        int[] prefixSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        Integer[][] memo = new Integer[n + 1][m + 1];
        return getMinimumLargestSplitSum(prefixSum, memo, 0, m);
    }
    
    private int getMinimumLargestSplitSum(int[] prefixSum, Integer[][] memo, int currentIndex, int subarrayCount) {
        int n = prefixSum.length - 1;    
        
        // base case
        if (subarrayCount == 1) {
            return prefixSum[n] - prefixSum[currentIndex];
        }
        
        // split sum calculated
        if (memo[currentIndex][subarrayCount] != null) {
            return memo[currentIndex][subarrayCount];
        }
        
        int minimumLargestSplitSum = Integer.MAX_VALUE;
        for (int i = currentIndex; i <= n - subarrayCount; i++) {
            int firstSplitSum = prefixSum[i + 1] - prefixSum[currentIndex];
            int largestSplitSum = Math.max(firstSplitSum, getMinimumLargestSplitSum(prefixSum, memo, i + 1, subarrayCount - 1));
            minimumLargestSplitSum = Math.min(minimumLargestSplitSum, largestSplitSum);
            // prune search since firstSplitSum will only gets larger
            if (firstSplitSum >= minimumLargestSplitSum) {
                break;
            }
        }
        return memo[currentIndex][subarrayCount] = minimumLargestSplitSum;
    }
}