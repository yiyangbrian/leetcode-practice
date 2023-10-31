import java.util.Arrays;

class Solution {
    int[] coins;
    int[][] memo;

    private int dp(int i, int amount) {
        if(amount < 0) return 0;
        if(i == 0 && amount == 0) return 1;
        if(i == 0 && amount > 0) return 0;

        if(memo[i][amount] == -1) {
            memo[i][amount] = dp(i, amount - coins[i - 1]) + dp(i - 1, amount);
        }

        return memo[i][amount];
    }

    public int change(int amount, int[] coins) {
        this.coins = coins;
        memo = new int[coins.length + 1][amount + 1];
        for(int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dp(coins.length, amount);
    }
}
