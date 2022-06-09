class Solution {
    public String minWindow(String s, String t) {
        int m = s.length(), n = t.length();
        if (m < n) {
            return "";
        }
        int start = 0, end = 0, min = m + 1, counter = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }
        for (int l = 0, r = 0; r < m; r++) {
            char ch = s.charAt(r);
            if (map.containsKey(ch)) {
                if (map.get(ch) > 0) {
                    counter++;
                }
                map.put(ch, map.get(ch) - 1);
            }
            if (counter == n) {
                while (l <= r) {
                    ch = s.charAt(l);
                    if (map.containsKey(ch)) {
                        if (map.get(ch) == 0) {
                            if (r - l < min) {
                                start = l;
                                end = r + 1;
                                min = r - l;
                            }
                            break;
                        }
                        map.put(ch, map.get(ch) + 1);
                    }
                    l++;
                }
            }
        }
        return s.substring(start, end);
    }
}