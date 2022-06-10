class Solution {
    public boolean backspaceCompare(String s, String t) {
        int c1 = 0, c2 = 0; // backspace counts
        int j = t.length() - 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '#') {
                c1++;
            } else if (c1 > 0) {
                c1--;
            } else {
                boolean charFound = false;
                while (j >= 0) {
                    if (t.charAt(j) == '#') {
                        c2++;
                    } else if (c2 > 0) {
                        c2--;
                    } else {
                        if (s.charAt(i) != t.charAt(j)) {
                            return false;
                        }
                        charFound = true;
                        j--;
                        break;
                    }
                    j--;
                }
                if (j < 0 && !charFound) {
                    return false;
                }
            }
        }
        while (j >= 0) {
            if (t.charAt(j) == '#') {
                c2++;
            } else if (c2 > 0) {
                c2--;
            } else {
                return false;
            }
            j--;
        }
        return true;
    }
}