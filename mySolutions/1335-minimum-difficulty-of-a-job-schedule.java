class Solution {

    int[] jobDifficulty;
    int n;
    int[][] memo;

    private int dp(int i, int d) {
        if(d == 1) {
            int max = 0;
            for(int j = i; j < n; j ++) {
                max = Math.max(max, jobDifficulty[j]);
            }
            memo[i][d] = max;
            return max;
        }
        if(memo[i][d] == -1) {
            int min = Integer.MAX_VALUE;
            int dailyMax = 0;
            for(int j = i; j < n - d + 1; j ++) {
                dailyMax = Math.max(dailyMax, jobDifficulty[j]);
                min = Math.min(min, dailyMax + dp(j + 1, d - 1));
            }
            memo[i][d] = min;
        }
        return memo[i][d];
    }

    public int minDifficulty(int[] jobDifficulty, int d) {
        this.jobDifficulty = jobDifficulty;
        n = jobDifficulty.length;
        if(n < d) return -1;
        memo = new int[n][d + 1];
        for(int i = 0; i < n; i ++) {
            for(int j = 0; j < d + 1; j ++) {
                memo[i][j] = -1;
            }
        }
        return dp(0, d);
    }
}
