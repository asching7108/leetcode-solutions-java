class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n - 2 && nums[i] <= 0; i++) {
            if (i == 0 || nums[i] > nums[i - 1]) {
                int l = i + 1, r = n - 1;
                while (l < r) {
                    if (nums[l] + nums[r] < -nums[i]) {
                        l++;
                    } else if (nums[l] + nums[r] > -nums[i]) {
                        r--;
                    } else {
                        res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                        l++;
                        r--;
                        while (l < r && nums[l] == nums[l - 1]) {
                            l++;
                        }
                    }
                }
            }
        }
        return res;
    }
}