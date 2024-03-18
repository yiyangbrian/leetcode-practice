class Solution {
   public List<List<Integer>> threeSum(int[] nums) {
      Arrays.sort(nums);
      List<List<Integer>> res = new ArrayList<>();
      for(int i = 0; i < nums.length - 2; i ++) {
         if(i > 0 && nums[i] == nums[i - 1]) continue;
         int l = i + 1, r = nums.length - 1;
         int target = 0 - nums[i];
         while(l < r) {
            if(nums[l] + nums[r] == target) {
               res.add(Arrays.asList(nums[i], nums[l], nums[r]));
               l ++;
               while(l < r && nums[l] == nums[l - 1]) l ++;
               r --;
               while(r > l && nums[r] == nums[r + 1]) r --;
            } else if(nums[l] + nums[r] < target) {
               l ++;
            } else {
               r --;
            }
         }
      }
      return res;
   }
}
