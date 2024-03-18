class Solution {

    public int maximumScore(int[] nums, int[] multipliers) {
        int m = multipliers.length;
        int n = nums.length;
        int[][] memo = new int[m + 1][m + 1];

        for(int i = m - 1; i >= 0; i --) {
            for(int left = i; left >= 0; left --) {
                int right = n - i + left - 1;
                memo[i][left] = Math.max(multipliers[i] * nums[left] + memo[i + 1][left + 1], multipliers[i] * nums[right] + memo[i + 1][left]);
            }
        }

        return memo[0][0];
    }
}
