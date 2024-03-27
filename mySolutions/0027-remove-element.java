class Solution {
   public int removeElement(int[] nums, int val) {
      int n = nums.length;
      int left = 0, right = n - 1;

      while(left <= right) {
         while(left <= right && nums[left] != val) {
            left ++;
         }
         while(right >= left && nums[right] == val) {
            right --;
         }
         if(left <= right) {
            nums[left] = nums[right];
            nums[right] = val;
         }
      }
      return left;
   }
}
