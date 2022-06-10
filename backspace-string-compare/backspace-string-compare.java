class Solution {
    public boolean backspaceCompare(String s, String t) {
        int backS = 0, backT = 0; // backspace counts
        int i = s.length() - 1, j = t.length() - 1;
        while (i >= 0 || j >= 0) {
            while (i >= 0) {
                if (s.charAt(i) == '#') { backS++; i--; }
                else if (backS > 0) { backS--; i--; }
                else break;
            }
            while (j >= 0) {
                if (t.charAt(j) == '#') { backT++; j--; }
                else if (backT > 0) { backT--; j--; }
                else break;
            }
            if (i >= 0 && j >= 0 && s.charAt(i) != t.charAt(j)) {
                return false;
            }
            if ((i >= 0) != (j >= 0)) {
                return false;
            }
            i--;
            j--;
        }
        return true;
    }
}