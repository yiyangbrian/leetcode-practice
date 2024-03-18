class Solution {
    public void rotate(int[] nums, int k) {
        int length = nums.length;
        int[] output = new int[length];
        int p = 0;
        k = k % length;

        for(int i = length - k; i < length; i ++) {
            output[p ++] = nums[i];
        }

        for(int i = 0; i < length - k; i ++) {
            output[p ++] = nums[i];
        }

        System.arraycopy(output, 0, nums, 0, length);


    }
}
