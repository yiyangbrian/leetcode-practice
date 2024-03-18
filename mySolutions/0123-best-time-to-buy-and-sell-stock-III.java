class Solution {
    int[] prices;
    int n;
    int[][][] memo;

    private int dp(int i, int rem, int d) {
        if(i == 0 && d == 0) {
            memo[i][rem][d] = 0;
            return 0;
        }
        if(i == 0 && d == 1) {
            memo[i][rem][d] = -prices[i];
            return -prices[i];
        }

        if(memo[i][rem][d] == Integer.MIN_VALUE) {
            if(rem == 2) {
                memo[i][rem][d] = dp(i - 1, rem, d);
            }

            else if(rem == 1 || rem == 0) {

                if(d == 1) {
                    memo[i][rem][d] = Math.max(dp(i - 1, rem, 1), dp(i - 1, rem + 1, 0) - prices[i]);
                }
                else if(d == 0) {
                    memo[i][rem][d] = Math.max(dp(i - 1, rem, 0), dp(i - 1, rem, 1) + prices[i]);
                }

            }
        }
        return memo[i][rem][d];
    }

    public int maxProfit(int[] prices) {
        this.prices = prices;
        n = prices.length;
        memo = new int[n][3][2];
        for(int i = 0; i < n; i ++) {
            for(int j = 0; j < 3; j ++) {
                memo[i][j][0] = Integer.MIN_VALUE;
                memo[i][j][1] = Integer.MIN_VALUE;
            }
        }
        for(int i = n - 1; i >= 0; i --) {
            for(int j = 2; j >= 0; j --) {
                dp(i, j, 0);
                dp(i, j, 1);
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i = n - 1; i >= 0; i --) {
            for(int j = 2; j >= 0; j --) {
                max = Math.max(max, memo[i][j][0]);
                max = Math.max(max, memo[i][j][1]);
            }
        }
        return max;
    }
}
