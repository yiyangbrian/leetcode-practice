class Solution {
    public int[] searchRange(int[] nums, int target) {

        int first = -1, last = -1;
        int left = 0, right = nums.length - 1, pivot;

        while(left <= right) {
            pivot = (left + right) / 2;
            if(nums[pivot] < target) {
                left = pivot + 1;
            } else {
                right = pivot - 1;
            }
        }

        if(left == nums.length || nums[left] != target) {
            return new int[]{first, last};
        }

        first = left;
        right = nums.length - 1;

        while(left <= right) {
            pivot = (left + right) / 2;
            if(nums[pivot] > target) {
                right = pivot - 1;
            } else {
                left = pivot + 1;
            }
        }

        last = right;
        return new int[]{first, last};
    }
}
