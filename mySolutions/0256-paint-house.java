import java.util.Arrays;

class Solution {

    int[][] costs;
    int[][] memo;
    int n;

    private int dp(int row, int col) {
        if(row == n - 1) {
            return costs[row][col];
        }
        if(memo[row][col] == -1) {
            memo[row][col] = costs[row][col] + Math.min(dp(row + 1, (col + 1) % 3), dp(row + 1, (col + 2) % 3));
        }
        return memo[row][col];
    }

    public int minCost(int[][] costs) {
        this.costs = costs;
        n = costs.length;
        memo = new int[n][3];
        for(int[] row : memo) {
            Arrays.fill(row, -1);
        }
        int min = 2000;
        for(int i = 0; i < 3; i ++) {
            min = Math.min(min, dp(0, i));
        }
        return min;
    }
}
