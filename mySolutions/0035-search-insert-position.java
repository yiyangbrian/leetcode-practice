class Solution {

    public int searchInsert(int[] nums, int target) {
        int pivot, left = 0, right = nums.length - 1;
        while(left <= right) {
            pivot = left + (right - left) / 2;
            if(nums[pivot] < target) {
                left = pivot + 1;
            } else if(nums[pivot] > target) {
                right = pivot - 1;
            } else {
                return pivot;
            }
        }
        return left;
    }
}
