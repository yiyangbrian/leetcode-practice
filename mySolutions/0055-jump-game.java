class Solution {
    public boolean canJump(int[] nums) {
        int farthest = 0;
        for(int i = 0; i < nums.length; i ++) {
            if(i > farthest) {
                return false;
            } else {
                farthest = Math.max(nums[i] + i, farthest);
            }
        }
        return true;
    }
}
