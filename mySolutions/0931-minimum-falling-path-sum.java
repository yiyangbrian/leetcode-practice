import java.util.Arrays;

class Solution {
    int[][] matrix;
    int[][] memo;
    int n;

    private int dp(int row, int col) {
        if(col == 0 || col == n + 1) {
            return 10001;
        }
        if(row == n - 1) {
            return matrix[row][col - 1];
        }
        if(memo[row][col] == Integer.MIN_VALUE) {
            memo[row][col] = Math.min(dp(row + 1, col - 1), Math.min(dp(row + 1, col), dp(row + 1, col + 1))) + matrix[row][col - 1];
        }
        return memo[row][col];
    }

    public int minFallingPathSum(int[][] matrix) {
        this.matrix = matrix;
        this.n = matrix.length;
        memo = new int[n][n + 2];
        for(int[] row : memo) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }
        int min = Integer.MAX_VALUE;
        for(int i = 1; i <= n; i ++) {
            min = Math.min(min, dp(0, i));
        }
        return min;
    }
}
