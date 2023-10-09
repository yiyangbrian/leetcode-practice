import java.util.Arrays;

class Solution {
    private int lengthOfLIS(int[] nums, int index, int memo[]) {
        if(index == 0) {
            memo[0] = 1;
            return 1;
        }
        if(memo[index] != -1) return memo[index];
        int longest = 1;
        for(int i = index - 1; i >= 0; i --) {
            if(nums[i] < nums[index]) {
                longest = Math.max(longest, lengthOfLIS(nums, i, memo) + 1);
            }
        }
        lengthOfLIS(nums, index - 1, memo);
        memo[index] = longest;
        return longest;
    }

    public int lengthOfLIS(int[] nums) {
        if(nums.length == 1) return 1;
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        int longest = 0;
        lengthOfLIS(nums, nums.length - 1, memo);
        for(int c : memo) {
            longest = Math.max(longest, c);
        }
        return longest;
    }
}