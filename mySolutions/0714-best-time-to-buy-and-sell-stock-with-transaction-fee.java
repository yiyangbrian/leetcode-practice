class Solution {
    int[] prices;
    int fee;
    int[][] memo;

    private int dp(int i, int d) {
        if(i == 0 && d == 0) return 0;
        if(i == 0 && d == 1) return -prices[0];

        if(memo[i][d] == Integer.MIN_VALUE) {
            if(d == 1) {
                memo[i][d] = Math.max(dp(i - 1, 0) - prices[i], dp(i - 1, 1));
            } else if(d == 0) {
                memo[i][d] = Math.max(dp(i - 1, 1) + prices[i] - fee, dp(i - 1, 0));
            }
        }
        return memo[i][d];
    }

    public int maxProfit(int[] prices, int fee) {
        this.prices = prices;
        this.fee = fee;
        int n = prices.length;
        memo = new int[n][2];
        for(int i = 0; i < n; i ++) {
            memo[i][0] = Integer.MIN_VALUE;
            memo[i][1] = Integer.MIN_VALUE;
        }
        return dp(n - 1, 0);
    }
}
