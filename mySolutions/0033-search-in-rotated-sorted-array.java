class Solution {
    private int lowIndex(int[] nums) {
        int n = nums.length;
        int left = 0, right = n - 1;

        while(left <= right) {
            int mid = (left + right) / 2;
            if(nums[mid] > nums[n - 1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }


    public int search(int[] nums, int target) {
        int n = nums.length;

        int k = lowIndex(nums);
        System.out.print(k);

        int pivot, left = 0, right = n - 1;

        while(left <= right) {
            pivot = left + (right - left) / 2;
            int index = (pivot + k) % n;
            if(nums[index] == target) {
                return index;
            }
            else if(nums[index] < target) {
                left = pivot + 1;
            }
            else {
                right = pivot - 1;
            }
        }

        return -1;
    }
}
