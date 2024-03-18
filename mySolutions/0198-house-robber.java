import java.util.Arrays;

class Solution {

    private int dp(int[] nums, int n, int[] memo) {
        if(n == 0) {
            return nums[0];
        }
        if(n == 1) {
            return Math.max(nums[0], nums[1]);
        }
        if(memo[n] == -1) {
            memo[n] = Math.max(dp(nums, n - 1, memo), dp(nums, n - 2, memo) + nums[n]);
        }
        return memo[n];
    }

    public int rob(int[] nums) {
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return dp(nums, nums.length - 1, memo);
    }
}
