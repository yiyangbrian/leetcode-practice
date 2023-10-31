class Solution {
    public int findMin(int[] nums) {

        int left = 0, right = nums.length - 1, pivot;

        while(left <= right) {
            pivot = (left + right) / 2;
            if(nums[pivot] > nums[nums.length - 1]) {
                left = pivot + 1;
            } else {
                right = pivot - 1;
            }
        }

        return nums[left];
    }
}
