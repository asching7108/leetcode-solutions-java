class Solution {
    class Replacement implements Comparable<Replacement> {
        int index;
        String source;
        String target;
        Replacement(int i, String s, String t) {
            index = i;
            source = s;
            target = t;
        }
        
        @Override
        public int compareTo(Replacement o) {
            return this.index - o.index;
        }
    }
    
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        int n = indices.length;
        Replacement[] replacements = new Replacement[n];
        for (int i = 0; i < n; i++) {
            replacements[i] = new Replacement(indices[i], sources[i], targets[i]);
        }
        Arrays.sort(replacements);
        
        int last = -1, start, end;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            Replacement curr = replacements[i];
            start = curr.index;
            end = start + curr.source.length();
            if (end <= s.length() && s.substring(start, end).equals(curr.source)) {
                if (start - last > 1) {
                    sb.append(s.substring(last + 1, start));
                }
                sb.append(curr.target);
                last = end - 1;
            }
        }
        if (last < s.length() - 1) {
            sb.append(s.substring(last + 1, s.length()));
        }
        return sb.toString();
    }
}