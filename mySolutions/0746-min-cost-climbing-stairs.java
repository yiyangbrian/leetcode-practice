import java.util.Arrays;

class Solution {
    int[] cost;
    int[] memo;

    private int dp(int n) {
        if(n == 0) {
            memo[0] = cost[0];
            return cost[0];
        }
        if(n == 1) {
            memo[0] = cost[0];
            memo[1] = cost[1];
            return memo[1];
        }

        if(memo[n] == -1) {
            memo[n] = Math.min(dp(n - 2) + cost[n], dp(n - 1) + cost[n]);
        }
        return memo[n];
    }

    public int minCostClimbingStairs(int[] cost) {
        if(cost.length == 1) return cost[0];

        this.cost = cost;
        this.memo = new int[cost.length];
        Arrays.fill(memo, -1);
        dp(cost.length - 1);
        return Math.min(memo[cost.length - 2], memo[cost.length - 1]);
    }
}