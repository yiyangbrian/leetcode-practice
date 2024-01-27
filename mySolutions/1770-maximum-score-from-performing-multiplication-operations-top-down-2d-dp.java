class Solution {
    int[] nums;
    int[] multipliers;
    int[][] memo;
    int m;
    int n;

    private int dp(int i, int left) {
        if (i == m)
            return 0;
        int right = n - i + left - 1; // left / right element that has not been picked
        if (memo[i][left] == 0) {
            memo[i][left] = Math.max(multipliers[i] * nums[left] + dp(i + 1, left + 1),
                    multipliers[i] * nums[right] + dp(i + 1, left));
        }
        return memo[i][left];
    }

    public int maximumScore(int[] nums, int[] multipliers) {
        this.nums = nums;
        this.multipliers = multipliers;
        m = multipliers.length;
        n = nums.length;
        memo = new int[m][m];
        return dp(0, 0);
    }
}