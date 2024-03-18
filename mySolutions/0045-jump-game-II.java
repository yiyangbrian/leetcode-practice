class Solution {
    public int jump(int[] nums) {
        int count = 0;
        int curEnd = 0;
        int curFar = 0;
        int n = nums.length;


        while(curFar < n - 1) {

            int step = curFar;
            for(int i = curEnd; i <= curFar; i ++) {
                step = Math.max(step, nums[i] + i);
            }
            curEnd = curFar + 1;
            curFar = step;
            count ++;
        }

        return count;
    }
}
