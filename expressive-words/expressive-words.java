class Solution {
    class Group {
        int size;
        char ch;
        Group(int size, char ch) {
            this.size = size;
            this.ch = ch;
        }
    }
    public int expressiveWords(String s, String[] words) {
        List<Group> groups = new ArrayList();
        int size = 0;
        char prev = '#';    // dummy char
        for (char c : s.toCharArray()) {
            if (c == prev) {
                size++;
            } else {
                if (prev != '#') groups.add(new Group(size, prev));
                size = 1;
                prev = c;
            }
        }
        groups.add(new Group(size, prev));
        
        int ans = 0;
        for (String word : words) {
            boolean stretchy = true;
            int curr = 0;
            for (int i = 0; i < groups.size(); i++) {
                Group group = groups.get(i);
                size = 0;
                while (curr < word.length() && word.charAt(curr) == group.ch) {
                    size++;
                    curr++;
                }
                if (size == 0 || size > group.size || (group.size < 3 && size < group.size)) stretchy = false;;
            }
            if (curr == word.length() && stretchy) ans++;
        }
        return ans;
    }
}