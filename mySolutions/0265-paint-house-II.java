import java.util.Arrays;

class Solution {
    int[][] costs;
    int[][] memo;
    int n;
    int k;

    private int dp(int row, int col) {
        if(row == n - 1) {
            return costs[row][col];
        }
        if(memo[row][col] == -1) {
            int res = Integer.MAX_VALUE;
            for(int i = 0; i < k; i ++) {
                if(i == col) {
                    continue;
                } else {
                    res = Math.min(res, dp(row + 1, i));
                }
            }
            memo[row][col] = res + costs[row][col];
        }
        return memo[row][col];
    }

    public int minCostII(int[][] costs) {
        this.costs = costs;
        n = costs.length;
        k = costs[0].length;
        memo = new int[n][k];
        for(int[] row : memo) {
            Arrays.fill(row, -1);
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < k; i ++) {
            min = Math.min(min, dp(0, i));
        }
        return min;
    }
}
