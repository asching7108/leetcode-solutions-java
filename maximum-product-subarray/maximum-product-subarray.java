class Solution {
    public int maxProduct(int[] nums) {
        int max_so_far = nums[0], min_so_far = nums[0];
        int result = max_so_far;
        for (int i = 1; i < nums.length; i++) {
            int n = nums[i];
            int temp_max = Math.max(n, Math.max(max_so_far * n, min_so_far * n));
            min_so_far = Math.min(n, Math.min(max_so_far * n, min_so_far * n));
            max_so_far = temp_max;
            result = Math.max(result, max_so_far);
        }
        return result;
    }
}