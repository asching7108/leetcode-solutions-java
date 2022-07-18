class Solution {
    private Integer[][] memo;
    
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        memo = new Integer[m][n];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res = Math.max(res, getLongestIncPath(matrix, i, j));
            }
        }
        return res;
    }
    
    private int getLongestIncPath(int[][] matrix, int row, int col) {
        if (memo[row][col] != null) {
            return memo[row][col];
        }
        int longestIncPath = 1;
        for (int newRow : new int[]{row - 1, row + 1}) {
            if (newRow >= 0 && newRow < matrix.length && matrix[newRow][col] > matrix[row][col]) {
                longestIncPath = Math.max(longestIncPath, 1 + getLongestIncPath(matrix, newRow, col));
            }
        }
        for (int newCol : new int[]{col - 1, col + 1}) {
            if (newCol >= 0 && newCol < matrix[0].length && matrix[row][newCol] > matrix[row][col]) {
                longestIncPath = Math.max(longestIncPath, 1 + getLongestIncPath(matrix, row, newCol));
            }
        }
        return memo[row][col] = longestIncPath;
    }
}