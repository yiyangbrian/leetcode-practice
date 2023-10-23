import java.util.Arrays;

class Solution {
    int[][] memo;
    int m;
    int n;

    private int dp(int row, int col) {
        if(row == m - 1 || col == n - 1) {
            return 1;
        }
        if(memo[row][col] == -1) {
            memo[row][col] = dp(row + 1, col) + dp(row, col + 1);
        }
        return memo[row][col];
    }

    public int uniquePaths(int m, int n) {
        this.m = m;
        this.n = n;
        memo = new int[m][n];
        for(int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dp(0, 0);
    }
}
