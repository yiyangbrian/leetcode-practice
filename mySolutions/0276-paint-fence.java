import java.util.Arrays;

class Solution {
    int[] memo;
    int k;

    private int dp(int i) {
        if(i == 0) {
            memo[i] = k;
            return memo[i];
        }
        if(i == 1) {
            memo[i] = k * k;
            return memo[i];
        }
        if(memo[i] == -1) {
            memo[i] = (k - 1) * (dp(i - 1) + dp(i - 2));
        }
        return memo[i];

    }

    public int numWays(int n, int k) {
        this.k = k;
        memo = new int[n];
        Arrays.fill(memo, -1);
        return dp(n - 1);
    }
}
