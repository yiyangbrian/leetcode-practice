class Solution {

    int[] prices;
    int n;
    int[][] memo;

    private int dp(int i, int decision) {

        // base cases
        if(i == 0 && decision == 0) {
            memo[i][decision] = 0;
            return memo[i][decision];
        }
        if(i == 0 && decision == 1) {
            memo[i][decision] = - prices[0];
            return memo[i][decision];
        }

        // decision == 1 -> buy or keep holding
        // decision == 0 -> sell or keep not holding

        if(memo[i][decision] == Integer.MIN_VALUE) {
            if(decision == 1 && i >= 2) {
                memo[i][decision] = Math.max(dp(i - 1, 1), dp(i - 2, 0) - prices[i]);
            }
            else if(decision == 1 && i < 2) {
                memo[i][decision] = Math.max(dp(i - 1, 1), - prices[i]);
            }
            else if(decision == 0) {
                memo[i][decision] = Math.max(dp(i - 1, 0), dp(i - 1, 1) + prices[i]);
            }
        }
        return memo[i][decision];
    }


    public int maxProfit(int[] prices) {
        this.prices = prices;
        n = prices.length;
        if(n == 1) return 0;

        memo = new int[n][2];
        for(int i = 0; i < n; i ++) {
            memo[i][0] = Integer.MIN_VALUE;
            memo[i][1] = Integer.MIN_VALUE;
        }
        return dp(n - 1, 0);
    }
}
