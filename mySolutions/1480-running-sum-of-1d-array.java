class Solution {
    public int[] runningSum(int[] nums) {
        for(int i = 1; i < nums.length; i += 1) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }
}