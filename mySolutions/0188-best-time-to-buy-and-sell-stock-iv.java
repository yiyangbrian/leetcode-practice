class Solution {

    int[] prices;
    int n;
    int[][] memo;

    private int dp(int i, int k) {
        if(k == 0 || i == n) {
            memo[i][k] = 0;
            return 0;
        }
        if(memo[i][k] == -1) {
            int localMax = 0;
            int res = -1001;
            for(int j = i + 1; j < n; j ++) {
                localMax = Math.max(prices[j], localMax);
                res = Math.max(res, localMax - prices[i] + dp(j + 1, k - 1));
            }
            memo[i][k] = res;
        }
        return memo[i][k];
    }

    public int maxProfit(int k, int[] prices) {
        if(prices.length < 2) return 0;
        this.prices = prices;
        n = prices.length;
        memo = new int[n + 1][k + 1];
        for(int i = 0; i < n + 1; i ++) {
            for(int j = 0; j < k + 1; j ++) {
                memo[i][j] = -1;
            }
        }
        for(int i = 0; i < n; i ++) {
            dp(i, k);
        }
        int res = Integer.MIN_VALUE;
        for(int i = 0; i < n + 1; i ++) {
            for(int j = 0; j < k + 1; j ++) {
                res = Math.max(res, memo[i][j]);
            }
        }
        return res;
    }
}
