class Solution {
    public String nextClosestTime(String time) {
        char[] chars = time.toCharArray();
        char[] sorted = time.replace(":", "").toCharArray();
        Arrays.sort(sorted);
        
        for (char ch : sorted) {
            if (ch > chars[4]) {
                chars[4] = ch;
                return new String(chars);
            }
        }
        
        for (char ch : sorted) {
            if (ch > chars[3] && ch < '6') {
                chars[3] = ch;
                chars[4] = sorted[0];
                return new String(chars);
            }
        }

        for (char ch : sorted) {
            if (ch > chars[1] && (chars[0] < '2' || ch <= '3')) {
                chars[1] = ch;
                chars[3] = sorted[0];
                chars[4] = sorted[0];
                return new String(chars);
            }
        }

        for (char ch : sorted) {
            if (ch > chars[0] && ch <= '2') {
                chars[0] = ch;
                chars[1] = sorted[0];
                chars[3] = sorted[0];
                chars[4] = sorted[0];
                return new String(chars);
            }
        }
        chars[0] = sorted[0];
        chars[1] = sorted[0];
        chars[3] = sorted[0];
        chars[4] = sorted[0];
        return new String(chars);
    }
}