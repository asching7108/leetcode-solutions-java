class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int[] arr = new int[128];
        int counter = 0, res = 0;
        for (int l = 0, r = 0; r < s.length(); r++) {
            char ch = s.charAt(r);
            if (arr[ch - 'A'] == 0) {
                counter++;
            }
            arr[ch - 'A']++;
            if (counter > 0 && counter <= 2) {
                res = Math.max(res, r - l + 1);
            }
            while (counter > 2) {
                ch = s.charAt(l);
                if (arr[ch - 'A'] == 1) {
                    counter--;
                }
                arr[ch - 'A']--;
                l++;
            }
        }
        return res;
    }
}