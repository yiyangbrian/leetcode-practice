import java.util.List;

class Solution {
    List<List<Integer>> triangle;
    int[][] memo;
    int n;

    private int dp(int row, int col) {
        if(row == 0 && col == 0) {
            memo[0][0] = triangle.get(0).get(0);
            return memo[0][0];
        }
        if(memo[row][col] == Integer.MAX_VALUE) {
            int cur = triangle.get(row).get(col);
            if(col == 0) {
                memo[row][col] = dp(row - 1, 0) + cur;
                return memo[row][col];
            }
            if(row == col) {
                memo[row][col] = dp(row - 1, col - 1) + cur;
                return memo[row][col];
            }
            memo[row][col] = Math.min(dp(row - 1, col - 1), dp(row - 1, col)) + cur;
        }
        return memo[row][col];
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        this.triangle = triangle;
        n = triangle.size();
        memo = new int[n][n];
        for(int i = 0; i < n; i ++) {
            for(int j = 0; j < n; j ++) {
                memo[i][j] = Integer.MAX_VALUE;
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i ++) {
            dp(n - 1, i);
            min = Math.min(memo[n - 1][i], min);
        }
        return min;
    }
}
