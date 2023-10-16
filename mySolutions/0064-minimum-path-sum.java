class Solution {
    int[][] memo;
    int[][] grid;
    int m;
    int n;

    private int dp(int row, int col) {
        if(row == m - 1 && col == n - 1) {
            memo[row][col] = grid[row][col];
            return memo[row][col];
        }
        if(row == m || col == n) {
            memo[row][col] = Integer.MAX_VALUE;
            return Integer.MAX_VALUE;
        }
        if(memo[row][col] == -1) {
            memo[row][col] = Math.min(dp(row + 1, col), dp(row, col + 1)) + grid[row][col];
        }
        return memo[row][col];
    }

    public int minPathSum(int[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        memo = new int[m + 1][n + 1];
        for(int i = 0; i <= m; i ++) {
            for(int j = 0; j <= n; j ++) {
                memo[i][j] = -1;
            }
        }
        return dp(0, 0);
    }
}