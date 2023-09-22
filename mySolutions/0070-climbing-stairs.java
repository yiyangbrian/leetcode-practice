class Solution {
    public int climbStairs(int n) {
        int memo[] = new int[n + 1];
        return climb(0, n, memo);
    }

    private int climb(int step, int n, int[] memo) {
        if(step > n) return 0;
        if(step == n) return 1;
        if(memo[step] > 0) return memo[step];
        memo[step] = climb(step + 1, n, memo) + climb(step + 2, n, memo);
        return memo[step];
    }
}
