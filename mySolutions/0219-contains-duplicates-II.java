class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        for(int gap = 1; gap <= k; gap ++) {
            int left = 0, right = left + gap;

            while(right < nums.length) {
                if(nums[left] == nums[right]) {
                    return true;
                } else {
                    left ++;
                    right ++;
                }
            }
        }

        return false;
    }
}
