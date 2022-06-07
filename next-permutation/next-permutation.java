class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        for (int i = n - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                for (int j = n - 1; j >= i; j--) {
                    if (nums[j] > nums[i - 1]) {
                        swap(i - 1, j, nums);
                        reverse(i, n - 1, nums);
                        return;
                    }
                }
            }
        }
        reverse(0, n - 1, nums);
    }
    
    private void reverse(int i, int j, int[] nums) {
        while (i < j) {
            swap(i, j, nums);
            i++;
            j--;
        }
    }
    
    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}