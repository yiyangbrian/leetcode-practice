import java.util.Arrays;

class Solution {

    private int dp(int n, int[] memo) {
        if(n <= 1) return n;
        if(n == 2) return 1;

        if(memo[n] == -1) {
            memo[n] = dp(n - 1, memo) + dp(n - 2, memo) + dp(n - 3, memo);
        }

        return memo[n];
    }


    public int tribonacci(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return dp(n, memo);
    }
}
