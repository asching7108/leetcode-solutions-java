class Solution {
    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> output = new ArrayList();
        wordSquaresHelper(words, output, new String[words[0].length()], 0);
        return output;
    }
    
    private void wordSquaresHelper(String[] words, List<List<String>> output, String[] square, int k) {
        if (k == words[0].length()) {
            output.add(new ArrayList(Arrays.asList(square)));
            return;
        }
        for (String word : words) {
            boolean isValid = true;
            for (int i = 0; i < k; i++) {
                isValid = square[i].charAt(k) == word.charAt(i);
                if (!isValid) break;
            }
            if (isValid) {
                square[k] = word;
                wordSquaresHelper(words, output, square, k + 1);
            }
        }
    }
}