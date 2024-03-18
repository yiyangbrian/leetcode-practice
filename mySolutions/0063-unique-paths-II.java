class Solution {
    int[][] obstacleGrid;
    int[][] memo;
    int m;
    int n;

    private int dp(int row, int col) {
        if(row == m || col == n) {
            memo[row][col] = 0;
            return 0;
        }
        if(row == m - 1 && col == n - 1) {
            memo[row][col] = 1;
            return 1;
        }
        if(obstacleGrid[row][col] == 1) {
            memo[row][col] = 0;
            return 0;
        }
        if(memo[row][col] == -1) {
            memo[row][col] = dp(row + 1, col) + dp(row, col + 1);
        }
        return memo[row][col];
    }


    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        this.obstacleGrid = obstacleGrid;
        m = obstacleGrid.length;
        n = obstacleGrid[0].length;
        if(obstacleGrid[m - 1][n - 1] == 1) return 0;
        memo = new int[m + 1][n + 1];
        for(int i = 0; i < m + 1; i ++) {
            for(int j = 0; j < n + 1; j ++) {
                memo[i][j] = -1;
            }
        }
        return dp(0, 0);
    }
}
